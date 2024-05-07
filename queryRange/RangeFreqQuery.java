package queryRange;

import java.util.HashMap;

public class RangeFreqQuery {

    HashMap<Integer, HashMap<Integer,Integer>> map;
    int n;
    int[] arr;
    public RangeFreqQuery(int[] _arr) {
        this.arr = _arr;
        map = new HashMap();
        map.put(0, buildST(0, arr.length-1, 0));

        System.out.println("ST: " + map);

    }
    private HashMap buildST(int start, int end, int ci){
        if(start == end){
            HashMap<Integer, Integer> m = new HashMap<>();
            m.put(arr[start], 1);
            return m;
        }
        int mid = start + (end - start) / 2;
        map.put(2*ci+1,buildST(start, mid, 2*ci+1));
        map.put(2*ci+2, buildST(mid+1, end, 2*ci+2));

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

    public int query(int l, int r, int element) {
        return query(l, r, 0, arr.length-1, 0, element);
    }
    private int query(int qsi, int qei, int start, int end, int ci, int element){
        if(start >= qsi && end <= qei){

            return map.get(ci).containsKey(element) == true? map.get(ci).get(element): 0;
        } else if(end < qsi || start > qei){
            return 0;
        }else {
            int mid = start + (end - start)/2;
            int left = query(qsi, qei, start, mid, 2*ci+1, element);
            int right = query(qsi, qei, mid+1, end, 2*ci+2, element);
            return left + right;
        }
    }
}

