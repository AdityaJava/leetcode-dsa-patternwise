package P10DisjointSetUnion.Q3RedundantConnection;

import java.util.ArrayList;
import java.util.List;

class DisjointSet {
    List<Integer> parent;
    List<Integer> size;

    DisjointSet(int n) {
        parent = new ArrayList<>();
        size = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
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

    public boolean unionBySize(int x, int y) {
        int ultimateParentOfX = findUltimateParent(x);
        int ultimateParentOfY = findUltimateParent(y);

        if (ultimateParentOfX == ultimateParentOfY) {
            return false;
        }
        if (size.get(ultimateParentOfX) >= size.get(ultimateParentOfY)) {
            parent.set(ultimateParentOfY, ultimateParentOfX);
            size.set(ultimateParentOfX, size.get(ultimateParentOfX) + size.get(ultimateParentOfY));
        } else {
            parent.set(ultimateParentOfX, ultimateParentOfY);
            size.set(ultimateParentOfY, size.get(ultimateParentOfX) + size.get(ultimateParentOfY));
        }
        return true;
    }

}

public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        DisjointSet disjointSet = new DisjointSet(edges.length);
        for (int[] edge : edges) {
            if (!disjointSet.unionBySize(edge[0], edge[1])) {
                return new int[]{edge[0], edge[1]};
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[][] edges = {
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 4},
                {1, 5}
        };

        RedundantConnection redundantConnection = new RedundantConnection();
        for (int e : redundantConnection.findRedundantConnection(edges)) {
            System.out.println(e);
        }
    }
}
