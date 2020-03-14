package com.bhanu;

public class BinarySearch {

    static int binarySearch(int arr[],int k){

        int l=0,r = arr.length-1;
        while(l<=r){
            int m = l + (r-l)/2;
            if (arr[m]==k){
                return  m;
            }
            //if k is greater ignore left half
            if (arr[m]<k){
                l = m+1;
            }else{
                l = m-1;
            }
        }
        return -1;
    }

    //finding longest increasing sub array
    static void longestIncArray(int arr[],int n){

        int max=1,len=1,maxIndex=0;

        for (int i=1;i<n;i++){

            if (arr[i]> arr[i-1]){
                len++;
            }else{
                if (max<len){
                    max = len;
                    maxIndex = i-max;
                }
                len= 1;
            }
        }

        if (max<len){
            max = len;
            maxIndex = n-max;
        }

        for (int i=maxIndex;i<max+maxIndex;i++){
            System.out.print(arr[i]+" ");
        }
    }

    static void countNumber(int N,int S){
        int countElements = 0;
        int currentSum = 0;

        while ((currentSum<=S)){
            currentSum+=N;
            N--;
            countElements++;
        }
        System.out.println("total elements: "+countElements);
    }
    // length of longest sub array with same elements in at most k increments
    static void longestSubArray(){

    }

    static void smallestSubArray(int start,int end,int N,int S){
        
    }
}
