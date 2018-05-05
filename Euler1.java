import java.util.Scanner;

public class Euler1
{

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int     t  = in.nextInt();
        for (int a0 = 0; a0 < t; a0++)
        {
            Long n                    = in.nextLong();
            Long nthTermForThree      = calculateNthTerm(3, n);
            Long nthTermForFive       = calculateNthTerm(5, n);
            Long nthTermForFifteen    = calculateNthTerm(15, n);
            Long iterationsForThree   = calculateIterations(3, 3, nthTermForThree);
            Long iterationsForFive    = calculateIterations(5, 5, nthTermForFive);
            Long iterationsForFifteen = calculateIterations(15, 15, nthTermForFifteen);
            Long thirMultipleSum      = calculateArithmaticSum(3, 3, iterationsForThree);
            Long fithMultipleSum      = calculateArithmaticSum(5, 5, iterationsForFive);
            Long fifteenthMultipleSum = calculateArithmaticSum(15, 15, iterationsForFifteen);
            System.out.println(thirMultipleSum + fithMultipleSum - fifteenthMultipleSum);
        }
    }

    private static Long calculateArithmaticSum(int startValue, int difference, Long iterations)
    {
        return (iterations * startValue) + ((iterations * (iterations - 1) * difference) / 2);
    }

    private static Long calculateNthTerm(int difference, Long maxLimit)
    {
        return maxLimit - (maxLimit % difference == 0 ? difference : maxLimit % difference);
    }

    private static Long calculateIterations(int startValue, int difference, Long nthTerm)
    {
        /**
         * nthTerm      = a + (n-1) * d
         * nthTerm - a  = (n-1)*d
         * n = ((nth Term - a)/d)+1
         *
         */
        return ((nthTerm - startValue) / difference) + 1;

    }
}