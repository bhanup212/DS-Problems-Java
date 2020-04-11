package com.bhanu.sorting;

import java.util.Arrays;

public class InsertionSort {

    static void insertionSort(int[] arr){

        // 14
        Arrays.sort(arr);
        for (int i=1;i<arr.length-1;i++){
            for (int j=i;j>=1;j--){
                if (arr[j]<arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
        for (int i=0;i<arr.length;i++) {
            System.out.print(" " + arr[i]);
        }
    }
    static void evenOddInsertionSort(int[] arr){

        for (int i = 2;i<arr.length;i++){

            int j = i-2;
            int temp = arr[i];

            if (((i+1) & 1) == 1){

            }
        }
    }
}
