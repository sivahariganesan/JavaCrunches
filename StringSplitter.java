import java.util.Scanner;

public class StringSplitter
{
    public static void main(String[] args)
    {
        Scanner  scanner        = new Scanner(System.in);
        int      testCasesCount = scanner.nextInt();
        String[] inputString    = new String[testCasesCount];
        for (int i = 0; i < testCasesCount; i++)
        {
            inputString[i] = scanner.next();
        }
        for (int i = 0; i < testCasesCount; i++)
        {
            char[]       str        = inputString[i].toCharArray();
            StringBuffer oddBuffer  = new StringBuffer();
            StringBuffer evenBuffer = new StringBuffer();
            for (int j = 0; j < str.length; j++)
            {
                if (j == 0 || j % 2 == 0)
                {
                    evenBuffer.append(str[j]);
                }
                else
                {
                    oddBuffer.append(str[j]);
                }
            }
            System.out.println(evenBuffer + " " + oddBuffer);
        }

    }
}
