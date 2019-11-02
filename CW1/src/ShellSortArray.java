public class ShellSortArray {

    public static int shellSort(Integer[] array){

        int arrayLength = array.length;
        int start = 0;
        int end = arrayLength -1;
        int interval = (end - start) + 1;
        int numberOfComparisons = 0;

        while(interval > 0) {

            for (int i = start; i < (start + interval); i++) {

                int index;

                for (int j = start + interval; j <= end; j += interval) {

                    Integer nextToInsert = array[j];

                    index = j - interval;

                    while ((index >= start) && (nextToInsert.compareTo(array[index]) == -1)){

                        numberOfComparisons++;

                        array[index + interval] = array[index];

                        index = index - interval;
                    }

                    array[index + interval] = nextToInsert;
                }

            }

            interval = interval/2;

        }

        return numberOfComparisons;

    }

}
