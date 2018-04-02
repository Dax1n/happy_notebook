import java.util.Arrays;
import java.util.Random;

public class QC {

	public static void main(String[] args) {
		Random rn = new Random();
		for (int i = 0; i < 10; i++) {
			int[] nums = new int[10];
			for (int j = 0; j < 10; j++) {
				nums[j] = rn.nextInt(100);
			}

			System.out.println(Arrays.toString(nums));
			sort(nums, 0, nums.length - 1);
			System.out.println(Arrays.toString(nums));
			System.out.println("===========================================");
		}
	}

	public static int partition(int[] array, int lo, int hi) {
		// 固定的切分方式
		int key = array[lo];
		while (lo < hi) {
			while (array[hi] >= key && hi > lo) {// 从后半部分向前扫描
				hi--;
			}
			array[lo] = array[hi];
			while (array[lo] <= key && hi > lo) {// 从前半部分向后扫描
				lo++;
			}
			array[hi] = array[lo];
		}
		array[hi] = key;
		return hi;
	}

	public static void sort(int[] array, int lo, int hi) {
		if (lo >= hi) {
			return;
		}
		int index = partition(array, lo, hi);
		sort(array, lo, index - 1);
		sort(array, index + 1, hi);
	}
}
