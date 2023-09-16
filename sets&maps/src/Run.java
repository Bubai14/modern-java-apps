import java.util.Arrays;

public class Run {

    public static void main(String[] args) {

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        for(int i = n, j= 0; j < n; j++) {
            nums1[i++] = nums2[j];
        }
        Arrays.sort(nums1);
        System.out.println(nums1);
    }
}
