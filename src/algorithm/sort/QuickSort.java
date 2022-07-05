package algorithm.sort;


/*
* 기준이 되는 특정값을 구하고
* 그 값보다 큰 값과 작은값으 그룹을 나눠 정렬한다.
* 나눈 그룹에서도 기준이 되는 값을 정하여 그룹을 나누는 걸 반복한다.
* 선택, 삽입, 버블 정렬 보다 보통 효율이 좋다.
*
* 이미 정렬이 되어있을 경우 분할 정복의 장점을 살라지 못하고 속도 저하된다.
* O(n^2)
* */

public class QuickSort {
    public static void main(String[] args) {
        int[] data = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};

        quickSort2(data, 0, data.length-1);
        printArray(data);
    }

    private static void printArray(int[] data) {
        for ( int element : data) {
            System.out.print(element + " ");
        }
    }

    static void quickSort2(int[] data, int start, int end) {
        if (start >= end ) {
            return;
        }

        int i = start + 1;
        int key = start;
        int j = end;
        int temp;

        while ( i <= j ) {
            //asc
            //while ( i <= end && data[i] <= data[key]) {
            //desc
            while ( i <= end && data[i] >= data[key]) {
                i++;
            }
            //asc
            //while ( j > start && data[j] >= data[key] ) {
            while ( j > start && data[j] <= data[key] ) {
                j--;
            }
            if ( i > j ) {
                temp = data[key];
                data[key] = data[j];
                data[j] = temp;
            } else {
                temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
        }

        quickSort2(data, start ,j-1);
        quickSort2(data, j+1, end);
    }

}
