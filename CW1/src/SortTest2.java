import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class SortTest2 {

    public static void main(String args[]){

        PrintWriter pw = null;

        try {
            pw = new PrintWriter(new File("TimeData.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        StringBuilder builder = new StringBuilder();
        String ColumnNamesList = "Array Length,Bubble Time,Selection Time,Shell Time";
        builder.append(ColumnNamesList +"\n");

        Integer initialData[];
        Integer bubbleSortData[];
        Integer selectionSortData[];
        Integer shellSortData[];

        int bubbleTot       = 0;
        int selectionTot    = 0;
        int shellTot        = 0;

        long bubbleTime = 0;
        long selectionTime = 0;
        long shellTime = 0;

        long startTime;
        long endTime;

        int loopCounter = 0;

        for(int i = 25; i <= 5000; i += 25){

            loopCounter++;

            initialData         = ArrayUtil.generateRandomArray(i);
            bubbleSortData      = ArrayUtil.duplicateArray(initialData);
            selectionSortData   = ArrayUtil.duplicateArray(initialData);
            shellSortData       = ArrayUtil.duplicateArray(initialData);

            System.out.println("Test No.: " + loopCounter);
            System.out.println("Array Length: " + i);
            System.out.println();

            for(int j = 0; j <= 10; j++) {
                startTime = System.nanoTime();
                BubbleSortArray.bubbleSort(bubbleSortData);
                endTime = System.nanoTime();
                bubbleTime = bubbleTime + (endTime - startTime);
            }
            bubbleTime = bubbleTime / 10;

            for(int j = 0; j <= 10; j++) {
                startTime = System.nanoTime();
                SelectionSortArray.selectionSort(selectionSortData);
                endTime = System.nanoTime();
                selectionTime = endTime - startTime;
            }
            selectionTime = selectionTime / 10;

            for(int j = 0; j <= 10; j++) {
                startTime = System.nanoTime();
                ShellSortArray.shellSort(shellSortData);
                endTime = System.nanoTime();
                shellTime = endTime - startTime;
            }
            shellTime = shellTime / 10;

            System.out.println("Bubble Time: " + bubbleTime);
            System.out.println("Selection Time: " + selectionTime);
            System.out.println("Shell Time: " + shellTime);
            System.out.println();

            builder.append(i + "," + bubbleTime + "," + selectionTime + "," + shellTime + "\n");

        }

        pw.write(builder.toString());
        pw.close();

    }

}
