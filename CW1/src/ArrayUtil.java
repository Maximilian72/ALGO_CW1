import java.util.Random;

public class ArrayUtil {

    public static void displayArrayContent(Object [] data)
    {
        System.out.println(getString(data));
    }

    private static String getString(Object [] data)
    {
        String resultString = new String("[ ");

        for(int i = 0; i< data.length; i++) {
            resultString = resultString + data[i].toString() + " ";
        }
        resultString = resultString + "]";

        return resultString;
    }

    public static Integer[] generateRandomArray(int size)
    {
        Integer resultArray[] = new Integer[size];
        Random generator = new Random();

        for(int i = 0; i< size; i++) {
            int value = generator.nextInt(size);
            resultArray[i] = value;
        }
        return resultArray;
    }

    public static Integer[] duplicateArray(Object [] orig)
    {
        int size = orig.length;
        Integer resultArray[] = new Integer[size];

        for(int i = 0; i< size; i++) {
            resultArray[i] = (Integer) orig[i];
        }
        return resultArray;
    }
}
