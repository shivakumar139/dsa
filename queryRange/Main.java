package queryRange;

public class Main {
    public static void main(String[] args) {
        int[] arr = {12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56};
        RangeFreqQuery fq = new RangeFreqQuery(arr);
        System.out.println(fq.query(1,2, 4));
    }
}
