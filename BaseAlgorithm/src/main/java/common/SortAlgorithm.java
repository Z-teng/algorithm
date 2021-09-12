package common;

import java.util.*;

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
    public static void bubbleSort(int[] arr) {
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
    public static void selectSort(int[] arr) {
        int len = arr.length;
        int minIndex;
        int temp;
        for (int i = 0; i < len -1; i++) {
            minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    /**
     * 插入排序，
     * @param arr
     */
    public static void insertSort(int[] arr) {
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            int min = arr[i];

            // for循环方式
            int preIndex= 0;
            for (int j = i - 1; j >= 0; j--) {
                preIndex = j;
                if (min < arr[j]){
                    arr[j+ 1] = arr[j];
                    if (preIndex == 0){
                        preIndex = -1;
                    }
                    continue;
                }
                break;
            }
            arr[preIndex + 1] = min;
        }
    }

    /**
     * 希尔排序
     * @param arr
     */
    public static void shellSort(int[] arr) {
        int len = arr.length;
        for (int gap = (int)Math.floor(len / 2); gap > 0; gap=(int)Math.floor(gap/2)) {
            for (int i = gap; i < len; i++) {
                int current = arr[i];
                int j = i;
                while (j - gap >= 0 && current < arr[j - gap]){
                    arr[j] = arr[j - gap];
                    arr[j - gap] = current;
                    j = j -gap;
                }
            }
        }
    }

    /**
     * 归并排序
     * @param arr
     */
    public static int[] mergeSort(int[] arr) {
        int len = arr.length;
        if (len < 2){
            return arr;
        }

        int middle = (int)Math.floor(len / 2);
        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, len);
        return Merge(mergeSort(left), mergeSort(right));
    }

    private static int[] Merge(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int resIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length && resIndex < res.length){
            int leftValue = left[leftIndex];
            int rightValue = right[rightIndex];
            if (leftValue <= rightValue){
                res[resIndex] = leftValue;
                leftIndex++;
                resIndex++;
            }else {
                res[resIndex] = rightValue;
                rightIndex++;
                resIndex++;
            }
        }

        for (int i = leftIndex; i < left.length; i++) {
            res[resIndex] = left[leftIndex];
            leftIndex++;
            resIndex++;
        }

        for (int i = rightIndex; i < right.length; i++) {
            res[resIndex] = right[rightIndex];
            rightIndex++;
            resIndex++;
        }
        return res;
    }

    /**
     * 快速排序
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int[] arr, int left, int right) {
        if (left < right){
            int partitionIndex = partition(arr, left, right);
            quickSort(arr,left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = left; // 设定基准值
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]){
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index -1);
        return index -1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 堆排序
     * @param arr
     */
    public static void heapSort(int[] arr) {
        buildMaxHeap(arr);// [9, 8, 7, 4, 6, 3, 2, 0, 1, 5]

        int len = arr.length;
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, --len);
        }
    }

    /**
     * 创建最大堆
     * @param arr
     */
    private static void buildMaxHeap(int[] arr) {
        int len = arr.length;
        for (int i = (int) Math.floor(len / 2);i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    /**
     * 堆调整,建立最大堆
     * 参考：https://www.jianshu.com/p/6b526aa481b1
     * @param arr
     * @param i
     */
    private static void heapify(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < len && arr[left] > arr[largest]){
            largest = left;
        }

        if (right < len && arr[right] > arr[largest]){
            largest = right;
        }

        if (largest != i){
            swap(arr, largest, i);
            heapify(arr,largest, len);
        }
    }

    /**
     * 计数排序
     * @param arr
     */
    public static void countSort(int[] arr) {
        int max = getMaxValue(arr);
        int[] bucket = new int[max + 1];
        int len = arr.length;
        int sortedIndex = 0;

        for (int i = 0; i < len; i++) {
            bucket[arr[i]]++;
        }

        int bucketLen = bucket.length;
        for (int i = 0; i < bucketLen; i++) {
            while (bucket[i] > 0){
                arr[sortedIndex++] = i;
                bucket[i]--;
            }
        }
    }

    private static int getMaxValue(int[] arr) {
        int maxValue = arr[0];
        for (int v : arr) {
            if (v > maxValue){
                maxValue = v;
            }
        }
        return maxValue;
    }

    /**
     * 桶排序
     * 桶：应该为List类，
     * @param arr
     */
    public static void bucketSort(int[] arr, int bucketSize) {
        if (arr.length == 0){
            return;
        }
        int minValue = arr[0];
        int maxValue = arr[0];

        for (int v : arr) {
            if (v < minValue){
                minValue = v;
            }
            if (v> maxValue){
                maxValue = v;
            }
        }

        // 桶的初始化
        int DEFAULT_BUCKET_SIZE = 5;
        bucketSize = bucketSize == 0 ? DEFAULT_BUCKET_SIZE:bucketSize;
        int bucketCount = (int)Math.floor((maxValue - minValue) / bucketSize) + 1;
        List<List<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<Integer>());
        }


        // 利用映射关系将数据分到各个桶中
        for (int i = 0; i < arr.length; i++) {
            List<Integer> bucket = buckets.get((int)Math.floor((arr[i] - minValue) / bucketSize));
            bucket.add(arr[i]);
        }
        int index = 0;
        for (int i = 0; i < buckets.size(); i++) {
            List<Integer> bucket = buckets.get(i);
            // 插入排序
            insertSort(bucket);
            for (int j = 0; j < bucket.size(); j++) {
                arr[index] = buckets.get(i).get(j);
                index++;
            }
        }
    }

    /**
     * 插入排序List
     * @param bucket
     */
    private static void insertSort(List<Integer> bucket) {
        int[] arr = new int[bucket.size()];
        for (int i = 0; i < bucket.size(); i++) {
            arr[i] = bucket.get(i);
        }
        insertSort(arr);
        for (int i = 0; i < bucket.size(); i++) {
            bucket.set(i, arr[i]);
        }
    }

    /**
     * 基数排序
     * @param arr
     */
    public static void RadixSort(int[] arr) {
        int maxValue = getMaxValue(arr);

        int mod = 10;
        int dev = 1;
        Map<Integer, LinkedList<Integer>> counter = new HashMap<>();

        for (int i = 0; i < maxValue; i++, dev *= 10, mod *= 10) {
            for (int j = 0; j < arr.length; j++) {
                int bucket = (int)Math.floor((arr[j] % mod) / dev);

                if (counter.get(bucket)== null){
                    counter.put(bucket, new LinkedList<>());
                }

                counter.get(bucket).add(arr[j]);
            }

            int pos = 0;
            for (int j = 0; j < counter.size(); j++) {
                Integer value = null;
                if (counter.get(j) != null){
                    while ((value = counter.get(j).poll()) != null){
                        arr[pos++] = value;
                    }
                }
            }
        }
    }
}
