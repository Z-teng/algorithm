package demo;

import common.SortAlgorithm;

import java.util.Arrays;

/**
 * @author cennavi_zt
 * @title: SortDemo
 * @projectName algorithm
 * @description: TODO
 * @date 2021/9/511:10
 */
public class SortDemo {
    public static void main(String[] args) {
        int[] arr = {4, 8, 2, 9, 6, 3, 7, 0, 1, 5};
//        SortAlgorithm.BubbleSort(arr);
        SortAlgorithm.SelectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
