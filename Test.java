import java.util.HashSet;
import java.util.Scanner;

public class Test
{
    public static void main(String[] args)
    {
        Scanner in   = new Scanner(System.in);
        int     n    = in.nextInt();
        int     a[]  = new int[n];
        HashSet test = new HashSet();
        test.size();
        test.iterator();

        for (int a_i = 0; a_i < n; a_i++)
        {
            a[a_i] = in.nextInt();
        }
        int numberOfSwaps = sort(a, n, 0);
        System.out.println("Array is sorted in " + numberOfSwaps + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[n - 1]);
    }

    public static int sort(int[] a, int n, int numberOfSwaps)
    {
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n - 1; j++)
            {
                if (a[j] > a[j + 1])
                {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    numberOfSwaps++;
                }
            }
        }
        return numberOfSwaps;
    }
}
