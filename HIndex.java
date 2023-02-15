// this is the introduction problem on page 1 - H-index
// using the binary search method to narrow down the answer
import java.util.Collections;
import java.util.Arrays;
import java.util.List;
public class HIndex {
    public static void main(String[] args){
        Integer[] nums = new Integer[]{1, 4, 1, 4, 2, 1, 3, 5, 6};
        System.out.println(BinarySearch(nums));
    }

    public static boolean isValid(int tar, List<Integer> nums){
        int cnt = 0;
        for(int i = 0; i < nums.size(); i++){
            if(tar <= nums.get(i)) cnt ++;
        }
        // System.out.println(tar);
        // System.out.println("----");
        // System.out.println(cnt);
        return cnt >= tar;
    }

    public static int BinarySearch(Integer[] nums){
        int left = 0;
        int right =Collections.max(Arrays.asList(nums));
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if (isValid(mid, Arrays.asList(nums))) left = mid;
            else right = mid;
        }
        if (isValid(right, Arrays.asList(nums))) return right;
        return left;
    }
}
	
