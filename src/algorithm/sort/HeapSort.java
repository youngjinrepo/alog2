package algorithm.sort;

/*
* Heap은 최댓값 최솟값 Heap으로 나뉘어진다.
* 제일 큰(혹은 작은)값을 Root로 유지할려는 성질을 이용하여
* 정렬된 힙의 Root값을 마지막으로 보내고 마지막 노드를 제외하고 Heap 정렬을 한다.
* 이를 반복하여 정렬을 만들어 낸다.
* O(n*logN)의 시간 복잡도를 가진다.
* 2진트리기 때문에 logN 모든 노드를 한번 돌기 때문에 N
* */
public class HeapSort {

    public static void main(String[] args) {
        int[] data = {7, 6, 5, 8, 3, 5, 9, 1, 6};

        heap(data);

        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]+" ");
        }
    }

    public static void heap(int[] arr) {

        for (int i = 1; i < arr.length; i++ ) {
            int c = i;
            do {
                int root = (c - 1) / 2;
                if (arr[root] < arr[c]) {
                    int tmp = arr[root];
                    arr[root] = arr[c];
                    arr[c] = tmp;
                }
                c = root;
            } while (c != 0);
        }
        int temp;
        for (int i = arr.length-1; i >= 0; i-- ) {
            temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            int root = 0, c;
            do {
                c = 2 * root + 1;
                if (c < i - 1  && arr[c] < arr[c + 1]) {
                    c++;
                }
                if (c < i  && arr[root] < arr[c]) {
                    temp = arr[root];
                    arr[root] = arr[c];
                    arr[c] = temp;
                }
                root = c;
            } while ( c < i );
        }
    }
}
