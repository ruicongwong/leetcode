package sort;

public class HeapSort {
}

class Solution912_heap {
    public int[] sortArray(int[] nums) {
        return heap_sort(nums, nums.length);
    }
    public int[] heap_sort(int[] arr, int n){
        //初始化，i从最后一个父节点开始调整
        for (int i = n / 2 - 1; i >= 0 ; i--) {
            heapify(arr, n, i);
        }
        //先将第一个元素和已排好元素前一位做交换，再从新调整，直到排序完毕
        for (int i = n - 1; i > 0 ; i--) {
            swap(arr, i, 0);
            heapify(arr, i ,0);
        }
        return arr;
    }
    public void heapify(int[] arr, int n, int i){
        int largest = i; // 假设最大的为父节点
        int lson = i * 2 + 1;
        int rson = i * 2 + 2;
        // 找出父节点和子节点的最大值的下标
        if(lson < n && arr[largest] < arr[lson]) largest = lson;
        if(rson < n && arr[largest] < arr[rson]) largest = rson;
        if (largest != i){
            swap(arr, largest, i);
            heapify(arr, n, largest);
        }
    }
    public void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
