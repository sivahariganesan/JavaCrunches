import java.util.Arrays;

public class FindNumber
{
    /*
     * Complete the function below.
     */

    static String findNumber(int[] arr, int k)
    {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] == k)
            {
                return "true";
            }
            else if (arr[i] > k)
            {
                return "false";
            }
        }
        return "false";

    }

    public static void main(String[] args)
    {
        int[] arr = {1, 5, 3, 4, 6, 7, 8};
        System.out.println(findNumber(arr, 5));
        System.out.println(findNumber(arr, 2));

    }


}
