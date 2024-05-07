package DisjointSet;

public class Main {
    public static void main(String[] args) {
//        DisjointSet ds = new DisjointSet(7);
//        ds.unionByRank(1, 2);
//        ds.unionByRank(2, 3);
//        ds.unionByRank(4, 5);
//        ds.unionByRank(6, 7);
//        ds.unionByRank(5, 6);
//
//        // if 3 and 7 same or not
//        if (ds.ultimateParent(3) == ds.ultimateParent(7)) {
//            System.out.println("Same");
//        } else
//            System.out.println("Not Same");
//
//        ds.unionByRank(3, 7);
//        if (ds.ultimateParent(3) == ds.ultimateParent(7)) {
//            System.out.println("Same");
//        } else
//            System.out.println("Not Same");

        DisjointSet ds = new DisjointSet(7);
        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);
        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);
        ds.unionBySize(5, 6);


        if (ds.ultimateParent(5) == ds.ultimateParent(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");
        // if 3 and 7 same or not
//        if (ds.ultimateParent(3) == ds.ultimateParent(7)) {
//            System.out.println("Same");
//        } else
//            System.out.println("Not Same");
//
//        ds.unionBySize(3, 7);
//        if (ds.ultimateParent(3) == ds.ultimateParent(7)) {
//            System.out.println("Same");
//        } else
//            System.out.println("Not Same");
    }
}
