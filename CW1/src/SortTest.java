import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class SortTest {

    public static void main(String args[]){

        final int MAX_ARR_LEN = 1000;

        PrintWriter pw = null;

        try {
            pw = new PrintWriter(new File("SortData.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        StringBuilder builder = new StringBuilder();
        String ColumnNamesList = "Array Length,Bubble,Selection,Shell";
        builder.append(ColumnNamesList +"\n");

        Integer initialData[];
        Integer bubbleSortData[];
        Integer selectionSortData[];
        Integer shellSortData[];

        int bubbleTot       = 0;
        int selectionTot    = 0;
        int shellTot        = 0;

        int loopCounter = 0;
        for(int i = 25; i <= MAX_ARR_LEN; i += 25){

            loopCounter++;

            initialData         = ArrayUtil.generateRandomArray(i);
            bubbleSortData      = ArrayUtil.duplicateArray(initialData);
            selectionSortData   = ArrayUtil.duplicateArray(initialData);
            shellSortData       = ArrayUtil.duplicateArray(initialData);

            System.out.println("Test No.: " + loopCounter);
            System.out.println("Array Length: " + i);

            int bubbleComparisons       = BubbleSortArray.bubbleSort(bubbleSortData);
            bubbleTot += bubbleComparisons;
            int selectionComparisons    = SelectionSortArray.selectionSort(selectionSortData);
            selectionTot += selectionComparisons;
            int shellComparisons        = ShellSortArray.shellSort(shellSortData);
            shellTot += shellComparisons;

            System.out.println("Bubble Comparisons: " + bubbleComparisons);
            System.out.println("Selection Comparisons: " + selectionComparisons);
            System.out.println("Shell Comparisons: " + shellComparisons);
            System.out.println();

            builder.append(i + "," + bubbleComparisons + "," + selectionComparisons + "," + shellComparisons +"\n");

        }

        // Averages
        int bubbleAvg       = bubbleTot / loopCounter;
        int selectionAvg    = selectionTot / loopCounter;
        int shellAvg        = shellTot/ loopCounter;
        System.out.println("Bubble Average: " + bubbleAvg);
        System.out.println("Selection Average: " + selectionAvg);
        System.out.println("Shell Average: " + shellAvg);

        pw.write(builder.toString());
        pw.close();

    }

}
