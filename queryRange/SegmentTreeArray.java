package queryRange;

import java.util.Arrays;

class SegmentTreeArray {
    private int[] arr;
    private int[] segmentTree;

    public SegmentTreeArray(int[] nums){
        this.segmentTree = new int[nums.length*4];
        this.arr = Arrays.copyOf(nums, nums.length);

        this.buildTree(0, 0, arr.length-1);
    }

    private int buildTree(int currentIndex, int start, int end) {
        if(start == end){
            return arr[start];
        }
        int mid = start + (end - start)/2;
//        int mid = (start + end)/2;

        segmentTree[currentIndex * 2 + 1] = buildTree(currentIndex*2+1, start, mid);
        segmentTree[currentIndex * 2 + 2] = buildTree(currentIndex*2+2, mid+1, end);

        segmentTree[currentIndex] = segmentTree[currentIndex * 2 + 1] + segmentTree[currentIndex * 2 + 2];

        return segmentTree[currentIndex];
    }

    public int querySum(int start, int end){
        return querySum(start, end, 0, this.arr.length-1, 0);
    }

    private int querySum(int qsi, int qei, int start, int end, int currentIndex) {
        if(start >= qsi && end <= qei){
            return segmentTree[currentIndex];
        } else if(start > qei || end < qsi){
            return 0;
        } else{
            int mid = start + (end - start)/2;
            return querySum(qsi, qei, start, mid, currentIndex*2+1) +
                    querySum(qsi, qei, mid+1, end, currentIndex*2+2);
        }
    }


    public void update(int index, int value){
        update(index, value, 0, arr.length-1, 0);
        arr[index] = value;
    }

    private int update(int qi, int qv, int start, int end, int currentIndex){
        if(qi >= start && qi <= end){
            if(start == qi && end == qi){
                segmentTree[currentIndex] = qv;
                return qv;
            }else {
                int mid = start + (end - start) / 2;

                segmentTree[currentIndex * 2 + 1] = update(qi, qv, start, mid, currentIndex * 2 + 1);
                segmentTree[currentIndex * 2 + 2] = update(qi, qv, mid + 1, end, currentIndex * 2 + 2);
                segmentTree[currentIndex] = segmentTree[currentIndex * 2 + 1] + segmentTree[currentIndex * 2 + 2];
                return segmentTree[currentIndex];
            }
        }
        return segmentTree[currentIndex];

    }
}

