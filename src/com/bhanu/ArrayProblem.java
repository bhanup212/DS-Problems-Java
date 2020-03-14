package com.bhanu;

import java.util.HashMap;

public class ArrayProblem {

    static void subArraySum(int[] arr, int n, int sum) {
        int cur_sum = 0;
        int start = 0;
        int end = -1;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            cur_sum += arr[i];

            if (cur_sum - sum == 0) {
                start = 0;
                end = i;
                break;
            }

            if (hashMap.containsKey(cur_sum - sum)) {
                start = hashMap.get(cur_sum - sum) + 1;
                end = i;
                break;
            }

            hashMap.put(cur_sum, i);
        }

        if (end == -1) {
            System.out.println("No subarray with current sum exists");
        } else {
            System.out.println("sum found between " + start + " and " + end);
        }
    }

    static void longestSubArray(int[] arr, int n) {

        int res = 0;
        for (int i = 0; i < n; i++) {
            int current_count = 0;
            while (i < n && arr[i] >= 0) {
                current_count++;
                i++;
            }
            res = Math.max(res, current_count);
        }
        System.out.println("longest sub array is: " + res);
    }

    static void maxArraySum(int[] arr, int n) {

        //{1,2,-3,5,6,-17,8,-10,0}

        int max_so_far = Integer.MIN_VALUE, max_end_here = 0;
        for (int i = 0; i < n; i++) {
            max_end_here += arr[i];
            if (max_so_far < max_end_here) {
                max_so_far = max_end_here;
            }
            if (max_end_here < 0) {
                max_end_here = 0;
            }
        }
        System.out.println("max so far: " + max_so_far);
    }

    //smallest sum contiguous subarray
    static void smallestSumArray(int[] arr, int n) {
        int min_ending_here = Integer.MAX_VALUE, min_so_far = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (min_ending_here > 0) {
                min_ending_here = arr[i];
            } else {
                min_ending_here += arr[i];
            }

            min_so_far = Math.min(min_so_far, min_ending_here);
        }
        System.out.println("minimum so far: " + min_so_far);
    }

    //length of sub array containing atleast one duplicate
    static void subArrayLength(int[] arr, int n) {
        int minLen = Integer.MAX_VALUE;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (hashMap.containsKey(arr[i]) && hashMap.get(arr[i]) != -1) {
                minLen = Math.min(minLen, i - hashMap.get(arr[i]) + 2);
            }
            hashMap.put(arr[i], i + 1);
        }
        System.out.println("Minimum subarray length: " + minLen);
    }

    static void longestSubArrayMaxSum(int[] arr, int n) {

    }

    static void arrayPalindrome(int[] arr) {
        int flag = 0;
        for (int i = 0; i < arr.length / 2 && arr.length != 0; i++) {
            if (arr[i] != arr[arr.length - i - 1]) {
                flag = 1;
                break;
            }
        }

        if (flag == 1) {
            System.out.println("Array is not palindrome");
        } else {
            System.out.println("Array is palindrome");
        }
    }

    static void arrayBitonic(int[] arr) {
        int i, j;
        for (i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                continue;
            } else {
                break;
            }
        }
        if (i == arr.length - 1) {
            System.out.println("YES");
            return;
        }
        for (j = i + 1; j < arr.length; j++) {
            if (arr[j] < arr[j - 1]) {
                continue;
            } else {
                break;
            }
        }
        i = j;
        if (i == arr.length) {
            System.out.println("bitonic");
        } else {
            System.out.println("not bitonic");
        }
    }

    //find array sorted or not using recursive callback
    static void arraySortedOrNot(int[] arr, int n) {

        if (n == 1 || n == 0) {
            System.out.println("Array is sorted");
            return;
        }

        if (arr[n - 1] < arr[n - 2]) {
            System.out.println("Array is not sorted");
            return;
        }
        arraySortedOrNot(arr, n - 1);
    }

    //find array is sorted or not without recursive callback
    static void arraySorted(int[] arr, int n) {
        if (n == 0 || n == 1) {
            System.out.println("Array is sorted");
            return;
        }

        for (int i = 1; i < n; i++) {
            if (arr[i - 1] > arr[i]) {
                System.out.println("array is not sorted");
                return;
            }
        }
        System.out.println("Array is sorted");
    }

    //find average of array by using recursive callback
    static void arrayAverageRecursive(int[] arr, int n) {

    }
    /**
     *  find the closest pair from two sorted arrays
     */
    static void closestPair(int[] arr1,int[] arr2,int x){
        int i = 0;
        int j = arr1.length-1;

        while (i<j){
            //if (arr1[])
        }
    }
}
