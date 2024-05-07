package queryRange;

public class GCDQuery {
    int[] arr;
    int[] segmentTree;

    public GCDQuery(int[] _arr){
        this.arr = _arr;
        this.segmentTree = new int[_arr.length*4];

        this.buidTree(0, arr.length-1, 0);
    }

    private int buidTree(int start, int end, int ci) {
        if(start == end){
            return arr[start];
        }
        int mid = start + (end - start) / 2;
        segmentTree[2*ci+1] = buidTree(start, mid, 2*ci+1);
        segmentTree[2*ci+2] = buidTree(mid+1, end, 2*ci+2);

        return segmentTree[ci] = gcd(segmentTree[2*ci+1], segmentTree[2*ci+2]);
    }

    private int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b, a%b);
    }

    public int query(int si, int ei){
        return query(si, ei, 0, arr.length-1, 0);
    }

    private int query(int qsi, int qei, int start, int end, int ci){
        if(start >= qsi && end <= qei){
            return segmentTree[ci];
        } else if(end < qsi || start > qei){
            return 0;
        }else {
            int mid = start + (end - start)/2;
            int left = query(qsi, qei, start, mid, 2*ci+1);
            int right = query(qsi, qei, mid+1, end, 2*ci+2);
            return gcd(left, right);
        }
    }
}
