package algorithm.sort;

/*
* 배열을 분할하여 정렬 후 합치며 합치는 단계마다 정렬을 하는 정렬 방식
* O(N*lonN)의 수행속도를 보장한다.
* Quick Sort 방식은 이미 정렬된 데이터를 정렬할 경우 O(N^2)까지 늘어날 수 있는데 이와 달리 속도를 보장한다.
* 대신 정렬을 위한 여분의 저장공간이 필요하다.
* ex)
* 배열의 길이가 16일 경우 2^4로 표현 할 수 있다.
* 이 말은 4번의 분할 과 정렬을 통해 정렬을 할 수 있다는 말이다.
* 길이가 16인 배열을 4(=log(2)16) 번의 정렬을 수행하기 떄문에 16*log(2)16 의 수행 속도가 나온다.
* */

public class MergeSort {
     private static final int MAX_LENGTH = 8;
     private static int[] stored = new int[MAX_LENGTH];

     public static void main(String[] args) {
          int[] data = {7,6,5,8,3,5,9,1};
          mergeSort(data, 0, MAX_LENGTH-1);

          for (int idx = 0; idx < MAX_LENGTH; idx++) {
               System.out.print(data[idx] + " ");
          }
     }
     public static void mergeSort(int a[], int m, int n) {
          if ( m < n ) {
               int middle = (m+n)/2;
               mergeSort(a, m, middle );
               mergeSort(a, middle + 1, n);
               merge(a, m, middle, n);
          }
     }

     public static void merge(int[] a, int m, int middle, int n) {
          int i = m;
          int j = middle + 1;
          int k = m;

          while ( i <= middle && j <= n) {
               if ( a[i] <= a[j]) {
                    stored[k] = a[i];
                    i++;
               } else  {
                    stored[k] = a[j];
                    j++;
               }
               k++;
          }

          if ( i > middle ) {
               for ( int idx = j ; idx <= n; idx++ ) {
                    stored[k] = a[idx];
                    k++;
               }
          } else {
               for ( int idx = i ; idx <= middle; idx++ ) {
                    stored[k] = a[idx];
                    k++;
               }
          }

          for (int idx = m; idx <= n; idx++) {
               a[idx] = stored[idx];
          }
     }

}
