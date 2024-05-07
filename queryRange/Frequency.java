package queryRange;

import java.util.HashMap;

public class Frequency {
    int[] arr;
    HashMap<Integer, HashMap<Integer, Integer>> map;

    public Frequency(int[] _arr){
        this.arr = _arr;
        this.map = new HashMap<>();

        map.put(0, this.buidTree(0, arr.length-1, 0));
    }

    private HashMap<Integer, Integer> buidTree(int start, int end, int ci) {
        if(start == end){
            HashMap<Integer, Integer> m = new HashMap<>();
            m.put(arr[start], 1);
            return m;
        }
        int mid = start + (end - start) / 2;
        map.put(2*ci+1,buidTree(start, mid, 2*ci+1));
        map.put(2*ci+2, buidTree(mid+1, end, 2*ci+2));

        return merge(map.get(2*ci+1), map.get(2*ci+2));
    }
    private HashMap merge(HashMap<Integer, Integer> a, HashMap<Integer, Integer> b){

        HashMap<Integer, Integer> mergerMap = new HashMap<>();

        for(int data: a.keySet()){
            mergerMap.put(data, mergerMap.getOrDefault(data, 0) + a.get(data));
        }
        for(int data: b.keySet()){
            mergerMap.put(data, mergerMap.getOrDefault(data, 0) + b.get(data));
        }

        return mergerMap;
    }


    public int query(int si, int ei){
        HashMap<Integer,Integer> q =  query(si, ei, 0, arr.length-1, 0);
        int max = 0;
        for(int data: q.keySet()){
            max = Math.max(max, q.get(data));
        }

        return max;
    }

    private HashMap query(int qsi, int qei, int start, int end, int ci){
        if(start >= qsi && end <= qei){
            return map.get(ci);
        } else if(end < qsi || start > qei){
            return new HashMap();
        }else {
            int mid = start + (end - start)/2;
            HashMap left = query(qsi, qei, start, mid, 2*ci+1);
            HashMap right = query(qsi, qei, mid+1, end, 2*ci+2);
            return merge(left, right);
        }
    }
}
