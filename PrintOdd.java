import java.util.ArrayList;

public class PrintOdd
{
    /*
     * Complete the function below.
     */

    static int[] findNumber(int start, int end)
    {
        if (start % 2 == 0)
        {
            start = start + 1;
        }
        if (end % 2 == 0)
        {
            end = end - 1;
        }


        ArrayList arrayList = new ArrayList();
        int       i         = start;

        while (i <= end)
        {
            arrayList.add(i);
            i = i + 2;
        }

        int[] arr = new int[arrayList.size()];
        for (i = 0; i < arrayList.size(); i++)
        {
            arr[i] = (int) arrayList.get(i);
        }
        return arr;
    }

    public static void main(String[] args)
    {

        System.out.println(findNumber(3, 9));
        System.out.println(findNumber(2, 10));

    }


}
