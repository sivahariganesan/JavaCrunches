import java.util.Scanner;

public class ReducedString
{
    public static void main(String[] args)
    {
        Scanner scanner       = new Scanner(System.in);
        String  actualString  = scanner.next();
        String  trimmedString = reducedString(actualString);
        System.out.println(trimmedString.isEmpty() ? "Empty String" : trimmedString);
    }

    private static String reducedString(String actualString)
    {
        String patternStr = "(\\w)(\\1)";
        String trimmedStr = actualString.replaceAll(patternStr, "");
        if (trimmedStr.equalsIgnoreCase(actualString))
        {
            return trimmedStr;
        }
        else
        {
            return reducedString(trimmedStr);
        }
    }
}
