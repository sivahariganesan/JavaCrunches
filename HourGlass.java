import java.util.Scanner;

public class HourGlass
{
    public static void main(String[] args)
    {
        Scanner in            = new Scanner(System.in);
        int     arr[][]       = new int[6][6];
        int     maxHrGlassSum = -2147483648;
        for (int i = 0; i < 6; i++)
        {
            for (int j = 0; j < 6; j++)
            {
                arr[i][j] = in.nextInt();
            }
        }
        for (int rowItr = 0; rowItr < 4; rowItr++)
        {
            int hourGlassSum = 0;
            for (int colItr = 0; colItr < 4; colItr++)
            {
                hourGlassSum = 0;
                hourGlassSum += arr[rowItr][colItr] + arr[rowItr][colItr + 1] + arr[rowItr][colItr + 2] + arr[rowItr + 1][colItr + 1];
                hourGlassSum += arr[rowItr + 2][colItr] + arr[rowItr + 2][colItr + 1] + arr[rowItr + 2][colItr + 2];
                maxHrGlassSum = maxHrGlassSum < hourGlassSum ? hourGlassSum : maxHrGlassSum;
            }
        }
        System.out.println(maxHrGlassSum);
    }
}
