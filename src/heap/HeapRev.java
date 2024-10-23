package heap;

import java.util.ArrayList;
import java.util.List;

public class HeapRev {

    List<Integer> heap;


    public HeapRev() {
        heap = new ArrayList<>();
    }

    public int parentIndex(int index) {
        return (index - 1) / 2;

    }

    public int rightChildIndex(int index) {

        return (2 * index + 2);

    }

    public int leftChildIndex(int index) {

        return (2 * index + 1);

    }

    public void swap(int index1, int index2) {

        int index1Value = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, index1Value);
    }

//    public void insert(int value) {
//        heap.add(value);
//        int current = heap.size() - 1;
//        while (current>0 && heap.get(current)> heap.get(parentIndex(current))) {
//                swap(parentIndex(current), current);
//               current = parentIndex(current);
//        }
//    }

    public void insert(int value) {
        heap.add(value);
        int current = heap.size() - 1;
        while (current > 0 && heap.get(current) > heap.get(parentIndex(current))) {
            swap(parentIndex(current), current);
            current = parentIndex(current);

        }

    }

    public Integer remove(){

        if(heap==null) return null;

        if(heap.size()==1) return heap.remove(0);


        int maxNum = heap.get(0);
        heap.set(0, heap.remove(heap.size()-1));
        sinkDown(0);
        return maxNum;
    }

    public void sinkDown(int index){
        int maxIndex = index;
        while (true){
            int rightIndex = rightChildIndex(index);
            int leftIndex = leftChildIndex(index);

            if(rightIndex<heap.size() && heap.get(maxIndex) < heap.get(rightIndex)){
                maxIndex=rightIndex;
            }
            if(leftIndex<heap.size() && heap.get(maxIndex) < heap.get(leftIndex)){
                maxIndex=leftIndex;
            }
            if(maxIndex!=index){
                swap(index, maxIndex);
                index = maxIndex;
            }
            else return;
        }

    }


        public static void main(String[] args) {

        HeapRev heapRev = new HeapRev();
        heapRev.insert(10);
        heapRev.insert(2);
        heapRev.insert(5);
        heapRev.insert(20);
        System.out.println(heapRev.heap);
        heapRev.insert(50);
        System.out.println(heapRev.heap);
        System.out.println(heapRev.remove());
        System.out.println(heapRev.remove());

    }

}