package P10DisjointSetUnion.Q4AccountsMerge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/accounts-merge/

class DisjointSet {
  List<Integer> parent;
  List<Integer> size;

  DisjointSet(int n) {
    parent = new ArrayList<>();
    size = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      parent.add(i);
      size.add(1);
    }
  }

  public int findUltimateParent(int x) {
    if (parent.get(x) != x) {
      parent.set(x, findUltimateParent(parent.get(x)));
    }
    return parent.get(x);
  }

  public void unionBySize(int x, int y) {
    int ultimateParentOfX = findUltimateParent(x);
    int ultimateParentOfY = findUltimateParent(y);
    if (ultimateParentOfX == ultimateParentOfY) {
      return;
    }

    if (size.get(ultimateParentOfX) >= size.get(ultimateParentOfY)) {
      parent.set(ultimateParentOfY, ultimateParentOfX);
      size.set(ultimateParentOfX, size.get(ultimateParentOfX) + size.get(ultimateParentOfY));
    }
    else {
      parent.set(ultimateParentOfX, ultimateParentOfY);
      size.set(ultimateParentOfY, size.get(ultimateParentOfX) + size.get(ultimateParentOfY));
    }
  }

}


public class AccountsMerge {
  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    Map<String, Integer> emailToId = new HashMap<>();
    Map<String, String> emailToName = new HashMap<>();
    int idCount = 0;
    for (List<String> account : accounts) {
      for (int i = 1; i < account.size(); i++) {
        if (!emailToId.containsKey(account.get(i))) {
          emailToId.put(account.get(i), idCount++);
          emailToName.put(account.get(i), account.get(0));
        }
      }
    }

    DisjointSet disjointSet = new DisjointSet(idCount);

    for (List<String> account : accounts) {
      if (account.size() < 2) {
        continue;
      }
      String base = account.get(1);
      for (int i = 2; i < account.size(); i++) {
        disjointSet.unionBySize(emailToId.get(base), emailToId.get(account.get(i)));
      }
    }

    Map<Integer, List<String>> parentEmailIdToEmail = new HashMap<>();
    for (String email : emailToId.keySet()) {
      int parentEmailId = disjointSet.findUltimateParent(emailToId.get(email));
      parentEmailIdToEmail.computeIfAbsent(parentEmailId, k -> new ArrayList<>()).add(email);
    }

    List<List<String>> results = new ArrayList<>();
    List<String> result;
    for (List<String> groupEmails : parentEmailIdToEmail.values()) {
      result = new ArrayList<>();
      result.add(emailToName.get(groupEmails.get(0)));
      Collections.sort(groupEmails);
      result.addAll(groupEmails);
      results.add(result);
    }

    return results;
  }

  public static void main(String[] args) {
    List<List<String>> accounts = Arrays.asList(
      Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
      Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
      Arrays.asList("Mary", "mary@mail.com"),
      Arrays.asList("John", "johnnybravo@mail.com")
    );

    AccountsMerge accountsMerge = new AccountsMerge();
    accountsMerge.accountsMerge(accounts).forEach(System.out::println);

  }
}
