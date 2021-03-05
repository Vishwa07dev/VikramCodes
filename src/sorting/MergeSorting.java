package sorting;

public class MergeSorting {

  /**
   * This method will sort the array from start index to end index
   * @param arr
   * @param start
   * @param end
   */
  public void mergeSort(int[] arr, int start, int end) {

    // Base condition
    /**
     * {}
     * {7}  -- We don't need to sort
     */
    if (start >= end) {
      return;
    }

    // We divide the array into two parts
    int mid = (start + end) / 2;
    mergeSort(arr, start, mid); // This will sort the array from start till mid
    mergeSort(arr, mid + 1, end); // This will sort the array from mid+1 till end
    //  [2,4,6,8 ,1,3,5,7] --> [ 1,2,3,4,5,6,7,8 ]
    merge(arr, start, mid, end);
  }

  /**
   * This method will contain the logic to merged to sorted parts of the array
   * Ex : [2,4,6,8 ,1,3,5,7] --> [ 1,2,3,4,5,6,7,8 ]
   * @param arr
   * @param start
   * @param mid
   * @param end
   *
   * start -> mid : sorted
   * mid+1 -> end : sorted
   *
   *
   * sort it from start -> end
   */
  private void merge(int[] arr, int start, int mid, int end) {

    int[] temp = new int[arr.length];

    int index = start;

    int start1 = start;
    int end1 = mid;

    int start2 = mid + 1;
    int end2 = end;

    while (start1 <= end1 && start2 <= end2) {
      //Comparing the elements from the two parts
      if (arr[start1] < arr[start2]) {
        temp[index] = arr[start1];
        index++;
        start1++;
      } else {
        temp[index] = arr[start2];
        index++;
        start2++;
      }
    }

    while(start1 <= end1){
      temp[index] = arr[start1];
      start1++ ;
      index++ ;
    }

    while(start2 <= end2){
      temp[index] = arr[start2];
      start1++ ;
      index++ ;
    }

    // temp array will contain the element in the sorted manner

    for(int j=start; j <=end ; j++){
      arr[j] = temp[j];
    }
  }
}
