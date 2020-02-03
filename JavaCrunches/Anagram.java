import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Anagram
{
    /** Comments Added **/
    /**Test Comment**/
    public static int numberNeeded(String first, String second)
    {
        char[] charArray = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        int[]  diffChars = new int[26];
        int    result    = 0;
        for (int i = 0; i < charArray.length; i++)
        {
            String  regex           = "(" + charArray[i] + ")";
            Pattern pattern         = Pattern.compile(regex);
            Matcher matcher         = pattern.matcher(first);
            int     firstOccurance  = 0;
            int     secondOccurance = 0;
            while (matcher.find())
            {
                firstOccurance++;
            }
            matcher = pattern.matcher(second);
            while (matcher.find())
            {
                secondOccurance++;
            }
            diffChars[charArray[i] - 'a'] = Math.abs(firstOccurance - secondOccurance);
        }
        for (int i = 0; i < diffChars.length; i++)
        {
            result = result + diffChars[i];
        }
        return result;
    }


    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String  a  = in.next();
        String  b  = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
