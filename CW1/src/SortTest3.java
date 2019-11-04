import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class SortTest3 {

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

        int bubbleTot       = 0;
        int selectionTot    = 0;
        int shellTot        = 0;

        long bubbleSwaps = 0;
        long selectionSwaps = 0;
        long shellSwaps = 0;

        int loopCounter = 0;


        loopCounter++;

        initialData         = ArrayUtil.generateRandomArray(10);
        bubbleSortData      = ArrayUtil.duplicateArray(initialData);
        selectionSortData   = ArrayUtil.duplicateArray(initialData);
        shellSortData       = ArrayUtil.duplicateArray(initialData);

        System.out.println("Test No.: " + loopCounter);
        System.out.println("Array Length: " + 10);
        System.out.println();

        for(int j = 0; j <= 10; j++) {

            bubbleSwaps = bubbleSwaps + BubbleSortArray.bubbleSort(bubbleSortData);
            System.out.println(bubbleSwaps);

        }
        bubbleSwaps = bubbleSwaps / 10;

        for(int j = 0; j <= 10; j++) {

            selectionSwaps = selectionSwaps + SelectionSortArray.selectionSort(selectionSortData);
            System.out.println(selectionSwaps);

        }
        selectionSwaps = selectionSwaps / 10;

        for(int j = 0; j <= 10; j++) {

            shellSwaps = shellSwaps + ShellSortArray.shellSort(shellSortData);

        }
        shellSwaps = shellSwaps / 10;

        System.out.println("Bubble Swaps: " + bubbleSwaps);
        System.out.println("Selection Swaps: " + selectionSwaps);
        System.out.println("Shell Swaps: " + shellSwaps);
        System.out.println();

        builder.append(bubbleSwaps + "," + selectionSwaps + "," + shellSwaps + "\n");

        pw.write(builder.toString());
        pw.close();

    }

}
