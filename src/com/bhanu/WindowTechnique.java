package com.bhanu;

public class WindowTechnique {

    //window technique is reducing nested for loops into single loop.
    // time complexity is O(n)
    static void maxSubArraySum(int arr[],int k,int n){
        int max_sum = 0;
        for (int i=0;i<k;i++){
            max_sum+=arr[i];
        }
        /*
          * compute sum of remaining windows by removing first element of
          * previous window and adding last element of current window
         */
        int window_sum = max_sum;
        for (int i=k;i<n;i++){
            window_sum+=arr[i]-arr[i-k];
            max_sum = Math.max(max_sum,window_sum);
        }
        System.out.println("Max sum is: "+max_sum);
    }
    static void median(){

    }
}
