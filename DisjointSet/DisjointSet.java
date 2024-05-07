package DisjointSet;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
    private List<Integer> parent;
    private List<Integer> size;
    private List<Integer> rank;

    public DisjointSet(int n){
        parent = new ArrayList<>();
        size = new ArrayList<>();
        rank = new ArrayList<>();

        for(int i=0; i<=n; i++){
            size.add(1);
            rank.add(0);
            parent.add(i);
        }
    }

    public int ultimateParent(int node){
        if(node == parent.get(node)){
            return node;
        }

        int ulp = ultimateParent(parent.get(node));
        parent.set(node, ulp);
        return ulp;
    }

    public void unionBySize(int u, int v){
        int up_u = ultimateParent(u);
        int up_v = ultimateParent(v);

        if(up_u == up_v) return;

        if(size.get(up_u) < size.get(up_v)) {
            parent.set(up_u, up_v);
            size.set(up_v, size.get(up_u) + size.get(up_v));
        }else{
            parent.set(up_v, up_u);
            size.set(up_u, size.get(up_u) + size.get(up_v));
        }
    }

    public void unionByRank(int u, int v){
        int up_u = ultimateParent(u);
        int up_v = ultimateParent(v);

        if(up_u == up_v) return;

        if(rank.get(up_u) < rank.get(up_v)) {
            parent.set(up_u, up_v);
        }else if(rank.get(up_v) < rank.get(up_u)){
            parent.set(up_v, up_u);
        }else{
            parent.set(up_v, up_u);
            int uRank = rank.get(up_u);
            rank.set(up_u, uRank+1);
        }
    }
}
