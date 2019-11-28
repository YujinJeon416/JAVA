package com.minkj1992.thinkdast;

import java.util.Arrays;

public class SelectionSort {

    // index i,j swap
    public static void swapElements(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static int indexLowest(int[] array, int start) {
        int lowIndex = start;
        for (int i = start + 1; i < array.length; i++) {
            if (array[i] < array[lowIndex]) {
                lowIndex = i;
            }
        }
        return lowIndex;
    }

    public static void selectionSort(int[] array){
        for (int i=0;i<array.length;i++) {
            int lowIndex = indexLowest(array,i);
            swapElements(array,i,lowIndex);
        }
    }

    public static void main(String[] args) {
        int [] array = {5,1,3,5,8};
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }
}
