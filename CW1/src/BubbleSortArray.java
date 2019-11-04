public class BubbleSortArray {

    public static int bubbleSort(Integer[] array){

        int numberOfComparisons = 0;
        int numberOfSwaps = 0;

        int arrayLength = array.length;
        for(int i = 0; i <= arrayLength; i++){

            for(int j = 1; j <= (arrayLength -1); j++) {

                int left    = array[j-1];
                int right   = array[j];

                numberOfComparisons++;
                if (array[j-1] > array[j]) {

                    numberOfSwaps++;
                    Integer temp    = array[j];
                    array[j]        = array[j-1];
                    array[j-1]      = temp;

                }

            }

        }

//        return numberOfComparisons;
        return numberOfSwaps;

    }

}
