import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BinaryRep
{
    public static void main(String[] args)
    {
        Scanner in           = new Scanner(System.in);
        Long    inputNumber  = in.nextLong();
        String  binaryFormat = Long.toBinaryString(inputNumber);
        String  regex        = "([1]{1,})";
        Pattern pattern      = Pattern.compile(regex);
        Matcher matcher      = pattern.matcher(binaryFormat);
        int     max          = 0;
        while (matcher.find())
        {
            for (int i = 0; i < matcher.groupCount(); i++)
            {
                int length = matcher.group(i).length();
                max = max > length ? max : length;
            }
        }
        System.out.println(max);
    }
}
