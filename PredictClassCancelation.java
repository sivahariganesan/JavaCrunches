import java.util.Scanner;

public class PredictClassCancelation
{
    public static void main(String[] args)
    {
        Scanner in             = new Scanner(System.in);
        int     testCasesCount = in.nextInt();
        for (int i = 0; i < testCasesCount; i++)
        {
            String   input           = in.next();
            int      studCount       = Integer.parseInt(input.split(" ")[0]);
            int      cancelThreshold = Integer.parseInt(input.split(" ")[1]);
            String   inputArrTime    = in.next();
            String[] arrTime         = inputArrTime.split(" ");
            int      arrivedCount    = 0;
            for (int j = 0; j < studCount; j++)
            {
                if (Integer.parseInt(arrTime[j]) <= 0)
                {
                    arrivedCount++;
                }
                if (arrivedCount == cancelThreshold)
                {
                    System.out.println("NO");
                    return;
                }
            }

        }
    }
}
