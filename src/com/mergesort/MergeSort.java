package com.mergesort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MergeSort {
	static void merge(List<Integer> arr, int left, int right, int mid) {
		int sizeLeft = mid - left + 1;
		int sizeRight = right - mid;
		List<Integer> arrLeft = new ArrayList<>();
		List<Integer> arrRight = new ArrayList<>();
		int i = 0, j = 0;
		for (; i < sizeLeft; i++)
			arrLeft.add(arr.get(left + i));
		for (; j < sizeRight; j++)
			arrRight.add(arr.get(mid + 1 + j));
		i = 0;
		j = 0;
		int k = left;// Initial index of merged subarray array
		while (i < arrLeft.size() && j < arrRight.size()) {
			if (arrLeft.get(i) <= arrRight.get(j)) {
				arr.set(k, arrLeft.get(i));
				i++;
			} else {
				arr.set(k, arrRight.get(j));
				j++;
			}
			k++;
		}
		while (i < arrLeft.size()) {
			arr.set(k, arrLeft.get(i));
			i++;
			k++;
		}
		while (j < arrRight.size()) {
			arr.set(k, arrRight.get(j));
			j++;
			k++;
		}

	}

	static void sort(List<Integer> arr, int left, int right) {
		if (left < right) {
			int mid = (right + left) / 2;
			sort(arr, left, mid);
			sort(arr, mid + 1, right);
			merge(arr, left, right, mid);
		}
	}

	static void mergeSort(List<Integer> arr) {
		sort(arr, 0, arr.size() - 1);
	}

	/**
	 * @param arr : array to add
	 * @param maxLength : the number of elements you want to add to the array
	 */
	static void initValue(List<Integer> arr, int maxLength) {
		for (int i = 0; i < maxLength; i++) {
			arr.add(new Random().nextInt());
		}
	}
	static void showList(List<Integer> arr) {
		for(int i=0;i<arr.size();i++) {
			System.out.println(arr.get(i));
		}
	}
	public static void main(String[] args) {
		List<Integer> arr = new ArrayList<>();
		initValue(arr, 10000);
		arr.size();
		long startTime = System.currentTimeMillis();
		mergeSort(arr);
		long endTime = System.currentTimeMillis();
		showList(arr);
		System.out.println("total time: " + (endTime - startTime) / 1000);
	}
}
