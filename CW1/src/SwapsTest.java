import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class SwapsTest {

    public static void main(String args[]){

        PrintWriter pw = null;

        try {
            pw = new PrintWriter(new File("SwapsData.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        StringBuilder builder = new StringBuilder();
        String ColumnNamesList = "Array Length,Bubble Swaps,Selection Swaps,Shell Swaps";
        builder.append(ColumnNamesList +"\n");

        Integer initialData[];
        Integer bubbleSortData[];
        Integer selectionSortData[];
        Integer shellSortData[];
        Integer ordered[] = new Integer[100];
        Integer reverse[] = new Integer[100];


        long bubbleSwaps = 0;
        long selectionSwaps = 0;
        long shellSwaps = 0;
        int bubbleMin = 0;
        int selectionMin = 0;
        int shellMin = 0;
        int shellMax = 0;
        int bubbleMax = 0;
        int selectionMax = 0;

        for(int i = 0; i<=99; i++){

            ordered[i] = i;
            reverse[i] = 100 -i;

        }

        for(int j = 0; j <= 99; j++) {

//            initialData         = ArrayUtil.generateRandomArray(100);
//            bubbleSortData      = ArrayUtil.duplicateArray(initialData);
//            bubbleSortData = ordered;
            bubbleSortData = reverse;

            int returnVal = BubbleSortArray.bubbleSort(bubbleSortData);

            bubbleSwaps = bubbleSwaps + returnVal;

            if(j == 0) {

                bubbleMin = returnVal;

            }

            if(returnVal >= bubbleMax){

                bubbleMax = returnVal;

            } else if(returnVal <= bubbleMin){

                bubbleMin = returnVal;

            }

        }
        bubbleSwaps = bubbleSwaps / 100;

        for(int j = 0; j <= 99; j++) {
//            initialData         = ArrayUtil.generateRandomArray(100);
//            selectionSortData      = ArrayUtil.duplicateArray(initialData);
//            selectionSortData = ordered;
            selectionSortData = reverse;

            int returnVal = SelectionSortArray.selectionSort(selectionSortData);

            selectionSwaps = selectionSwaps + returnVal;

            if(j == 0) {

                selectionMin = returnVal;

            }

            if(returnVal >= selectionMax){

                selectionMax = returnVal;

            } else if(returnVal <= selectionMin){

                selectionMin = returnVal;

            }

        }
        selectionSwaps = selectionSwaps / 100;

        for(int j = 0; j <= 99; j++) {

//            initialData         = ArrayUtil.generateRandomArray(100);
//            shellSortData      = ArrayUtil.duplicateArray(initialData);
//            shellSortData = ordered;
            shellSortData = reverse;

            int returnVal = ShellSortArray.shellSort(shellSortData);

            shellSwaps = shellSwaps + returnVal;

            if(j == 0) {

                shellMin = returnVal;

            }

            if(returnVal >= shellMax){

                shellMax = returnVal;

            } else if(returnVal <= shellMin){

                shellMin = returnVal;

            }

        }
        shellSwaps = shellSwaps / 100;

        System.out.println("Bubble Swaps: " + bubbleSwaps);
        System.out.println("Bubble Min: " + bubbleMin);
        System.out.println("Bubble Max: " + bubbleMax);
        System.out.println();

        System.out.println("Selection Swaps: " + selectionSwaps);
        System.out.println("Selection Min: " + selectionMin);
        System.out.println("Selection Max: " + selectionMax);
        System.out.println();

        System.out.println("Shell Swaps: " + shellSwaps);
        System.out.println("Shell Min: " + shellMin);
        System.out.println("Shell Max: " + shellMax);
        System.out.println();

        builder.append(bubbleSwaps + "," + selectionSwaps + "," + shellSwaps + "\n");

        pw.write(builder.toString());
        pw.close();

    }

}
