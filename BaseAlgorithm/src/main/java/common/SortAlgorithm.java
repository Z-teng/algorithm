package common;

/**
 * @author cennavi_zt
 * @title: SortAlgorithm
 * @projectName algorithm
 * @description: TODO
 * @date 2021/9/511:11
 */
public class SortAlgorithm {
    /**
     * 冒泡排序
     * @param arr
     * @return
     */
    public static void BubbleSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    /**
     * 选择排序
     * @param arr
     */
    public static void SelectSort(int[] arr) {

    }
}
