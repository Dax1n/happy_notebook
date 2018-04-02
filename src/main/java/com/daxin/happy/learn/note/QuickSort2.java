package com.daxin.happy.learn.note;

import java.util.Arrays;
import java.util.Random;

public class QuickSort2 {

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
//		int[] nums = { 86, 16, 6, 15, 80, 29, 41, 22, 13, 78 };
//		 recursion(nums, 0, 9);

	}

	public static void recursion(int[] nums, int start, int end) {

		if (start >= end) {
            return;
        }

        int boundary = sort(nums, start, end);

        sort(nums, start, boundary - 1);
        sort(nums, boundary + 1, end);
	}
	


	public static int sort(int[] arr, int start, int end) {

		int value = arr[start];
		while (start < end) {

			while (start < end && arr[end] >= value) {
				end--;
			}

			arr[start] = arr[end];

			while (start < end && arr[start] <= value) {
				start++;
			}

			arr[end] = arr[start];

		}
		arr[end] = value;
		return end;

	}

}
