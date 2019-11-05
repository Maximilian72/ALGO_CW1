public class SelectionSortArray {

    public static int selectionSort(Integer[] array){

        int numberOfComparisons = 0;
        int numberOfSwaps = 0;

        int arrayLength = array.length;
        for(int i = 0; i <= arrayLength -1; i++){

            int first = i;
            int indexOfCurrentMinimum = first;
            int smallest;

            for(int j = first; j <= arrayLength -1; j++){

                numberOfComparisons++;
                if(array[j] <= array[indexOfCurrentMinimum]){

                    indexOfCurrentMinimum = j;

                }

            }

            smallest = indexOfCurrentMinimum;

            if(array[smallest] < array[i]) {
                swap(array, i, smallest);
                numberOfSwaps++;
            }


        }

//        return numberOfComparisons;
        return numberOfSwaps;

    }

    private static void swap(Integer[] array, int startIndex, int smallestIndex){

        int temp = array[startIndex];
        array[startIndex] = array[smallestIndex];
        array[smallestIndex] = temp;

    }

}
