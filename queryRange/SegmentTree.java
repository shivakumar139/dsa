package queryRange;

public class SegmentTree {
    private static class Node{
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;

        public Node(int _startInterval, int _endInterval){
            startInterval = _startInterval;
            endInterval = _endInterval;
        }
    }

    Node root;

    public SegmentTree(int[] arr){
        root = constructTree(arr, 0, arr.length-1);
    }

    private Node constructTree(int[] arr, int start, int end) {
        if(start == end){
            Node leaf = new Node(start, end);
            leaf.data = arr[start];

            return leaf;
        }
        Node node = new Node(start, end);
        int mid = (start + end)/2;
        node.left = constructTree(arr, start, mid);
        node.right = constructTree(arr, mid+1, end);
        node.data = node.left.data + node.right.data;

        return node;
    }

    public int querySum(int queryStartIndex, int queryEndIndex){
        return query(root, queryStartIndex, queryEndIndex);
    }

    private int query(Node node, int queryStartIndex, int queryEndIndex) {
        if(node.startInterval >= queryStartIndex && node.endInterval <= queryEndIndex){
            return node.data;
        } else if(node.startInterval > queryEndIndex ||  node.endInterval < queryStartIndex){
            return 0;
        } else{
            return query(node.left, queryStartIndex, queryEndIndex) + query(node.right, queryStartIndex, queryEndIndex);
        }
    }

    public void update(int index, int value){
        update(root, index, value);
    }

    private int update(Node node, int index, int value){
        if(index >= node.startInterval && index <= node.endInterval){
            if(index == node.startInterval && index == node.endInterval) {
                node.data = value;
                return node.data;
            }else{
                int leftAns = update(node.left, index, value);
                int rightAns = update(node.right, index, value);
                node.data = leftAns + rightAns;
                return node.data;
            }
        }

        return node.data;
    }
}
