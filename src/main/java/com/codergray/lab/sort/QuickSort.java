package com.codergray.lab.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args){
        int[] arr = new int[]{1, 5, 2, 9, 3, -1, 19, 222, 12, 999, 0, 89};
        quickSort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach((n)->{
            System.out.print(n+ " ");
        });
    }
    
//    private static void quickSort(int[] arr, int start, int end){
//        int pivot = arr[(start + end) / 2];
//        int left = start, right = end;
//        System.out.println("Pivot "+pivot+" Start "+ start+ " End "+ end);
//        Arrays.stream(arr).forEach((n)->{
//            System.out.print(n+ " ");
//        });
//        System.out.println();
//        while(left <= right){
//            while(arr[left] < pivot){
//                left++;
//            }
//            while(arr[right] > pivot){
//                right--;
//            }
//            if(left <= right){
//                int tmp = arr[left];
//                arr[left] = arr[right];
//                arr[right] = tmp;
//                left++;
//                right--;
//            }
//        }
//        if(left < end){
//            quickSort(arr, left, end);
//        }
//        if(start < right){
//            quickSort(arr, start, right);
//        }
//    }

    public static void quickSort(int arr[], int begin, int end)
    {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            // Recursively sort elements of the 2 sub-arrays
            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }

    private static int partition(int arr[], int begin, int end)
    {
        int pivot = arr[end];
        int i = (begin-1);

        for (int j=begin; j<end; j++)
        {
            if (arr[j] <= pivot) {
                i++;
                if(i!=j) {
                    int swapTemp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = swapTemp;
                    System.out.println("Pivot is: "+ pivot);
                    Arrays.stream(arr).forEach((n)->{
                        System.out.print(n+ " ");
                    });
                    System.out.println();
                }
            }
        }

        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;
        System.out.println("Pivot is: "+ pivot);
        Arrays.stream(arr).forEach((n)->{
            System.out.print(n+ " ");
        });
        System.out.println();
        return i+1;
    }
}
