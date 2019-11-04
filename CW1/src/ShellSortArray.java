public class ShellSortArray {

    public static int shellSort(Integer[] array){

        int arrayLength = array.length;
        int start = 0;
        int end = arrayLength -1;
        int interval = ((end - start) + 1)/2;
        int numberOfComparisons = 0;
        int numberOfSwaps = 0;

        while(interval > 0) {

            for (int i = start; i < (start + interval); i++) {

                int index;

                for (int j = start + interval; j <= end; j += interval) {

                    int nextToInsert = array[j];

                    index = j - interval;

                    numberOfComparisons++;

                    while ((index >= start) && (nextToInsert < array[index])){
                        numberOfSwaps++;
                        array[index + interval] = array[index];

                        index = index - interval;

                        ArrayUtil.displayArrayContent(array);
                    }

                    array[index + interval] = nextToInsert;
                }

            }

            interval = interval/2;

        }

//        return numberOfComparisons;
        return numberOfSwaps;

    }

}
