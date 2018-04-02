package com.daxin.happy.learn.note;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

	public static void main(String[] args) {

		Random rn = new Random();
		for (int i = 0; i < 10; i++) {
			int[] nums = new int[10];
			for (int j = 0; j < 10; j++) {
				nums[j] = rn.nextInt(100);
			}

			System.out.println(Arrays.toString(nums));
			recursion(nums, 0, nums.length - 1);
			System.out.println(Arrays.toString(nums));
			System.out.println("===========================================");
		}

		// int []nums = {1,1};
		// recursion(nums, 0, 1);
	}

	public static void recursion(int[] nums, int start, int end) {

		if (start >= end) {
			return;
		}
		if (start >= end) {
			return;
		}
		int index = sort(nums, start, end);
		sort(nums, start, index - 1);
		sort(nums, index + 1, end);
	}

	public static int sort(int[] arr, int start, int end) {

		int value = arr[start];
		int index = 0;
		while (start < end) {

			while (arr[end] > value) {
				end--;
			}

			arr[start] = arr[end];
			arr[end] = value;
			index = end;
			start++;
			while (arr[start] < value) {
				start++;
			}

			arr[end] = arr[start];
			arr[start] = value;
			index = start;
			end--;

		}

		return index;

	}

}
