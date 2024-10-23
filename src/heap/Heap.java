package heap;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Heap {

    List<Integer> heap;

    public Heap() {
        heap = new ArrayList<>();
    }


    public int leftChild(int index) {

        return 2 * index + 1;
    }

    public int rightChild(int index) {

        return 2 * index + 2;

    }

    public int parent(int index) {

        return (index - 1) / 2;
    }

    public void swap(int index1, int index2) {

        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    public void insert(int value) {
        heap.add(value);
        int current = heap.size() - 1;
        while (current > 0 && heap.get(current) > heap.get(parent(current))) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public Integer remove() {

        if (heap == null) return null;
        if (heap.size() == 1) return heap.remove(0);

        int maxNum = heap.get(0);
        heap.set(0, heap.remove(heap.size() - 1));
        sinkDown(0);
        return maxNum;

    }

    private void sinkDown(int index) {

        int maxIndex = index;
        while (true) {
            int rightIndex = rightChild(index);
            int leftIndex = leftChild(index);
            if (rightIndex < heap.size() && heap.get(rightIndex) > heap.get(maxIndex)) {
                maxIndex = rightIndex;
            }
            if (leftIndex< heap.size() && heap.get(leftIndex) > heap.get(maxIndex)) {
                maxIndex = leftIndex;
            }

            if(maxIndex!=index){
                swap(index, maxIndex);
                index = maxIndex;
            }
            else {
                return;
            }
        }


    }


    public static void main(String[] args) {


        Heap heap1 = new Heap();
        heap1.insert(10);
        heap1.insert(2);
        heap1.insert(5);
        heap1.insert(20);
        heap1.insert(50);
//        heap1.insert(60);
//        heap1.insert(50);
//        heap1.insert(65);
        System.out.println(heap1.heap);
        System.out.println(heap1.remove());
        System.out.println(heap1.remove());
        System.out.println(heap1.heap);
        // System.out.println(factorial(0));
    }

    public static int factorial(int n){
        if(n==0) return 1;
        if(n==1) return 1;
        n = n*factorial(n-1);
        return n;
    }


}
