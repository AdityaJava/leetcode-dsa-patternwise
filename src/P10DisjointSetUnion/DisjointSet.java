package P10DisjointSetUnion;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
    List<Integer> parent;
    List<Integer> size;

    public DisjointSet(int n) {
        parent = new ArrayList<>();
        size = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            parent.set(i, i);
            size.set(i, 1);
        }
    }

    public int findUltimateParent(int n) {
        if (parent.get(n) != n) {
            parent.set(n, findUltimateParent(parent.get(n)));
        }
        return parent.get(n);
    }

    public void unionBySize(int x, int y) {
        int ultimateParentOfX = findUltimateParent(x);
        int ultimateParentOfY = findUltimateParent(y);
        if (size.get(ultimateParentOfX) < size.get(ultimateParentOfY)) {
            parent.set(ultimateParentOfX, ultimateParentOfY);
            size.set(ultimateParentOfY, size.get(ultimateParentOfY) + size.get(ultimateParentOfX));
        } else {
            parent.set(ultimateParentOfY, ultimateParentOfX);
            size.set(ultimateParentOfX, size.get(ultimateParentOfX) + size.get(ultimateParentOfY));
        }
    }

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7);
        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);
        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);
        ds.unionBySize(5, 6);
        // if 3 and 7 same or not
        if (ds.findUltimateParent(3) == ds.findUltimateParent(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not Same");
        }
        ds.unionBySize(3, 7);
        if (ds.findUltimateParent(3) == ds.findUltimateParent(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not Same");
        }
    }
}
