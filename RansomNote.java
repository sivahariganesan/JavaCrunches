import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;

public class RansomNote
{
    public static void main(String[] args)
    {
        Scanner   in       = new Scanner(System.in);
        int       m        = in.nextInt();
        int       n        = in.nextInt();
        Hashtable magazine = new Hashtable();
        Hashtable ransom   = new Hashtable();

        for (int i = 0; i < m; i++)
        {
            String  word      = in.next();
            Integer wordCount = (Integer) magazine.get(word);
            wordCount = wordCount == null ? 1 : wordCount + 1;
            magazine.put(word, wordCount);
        }

        for (int i = 0; i < n; i++)
        {
            String  word      = in.next();
            Integer wordCount = (Integer) ransom.get(word);
            wordCount = wordCount == null ? 1 : wordCount + 1;
            ransom.put(word, wordCount);
        }
        /*in.nextLine();
        String  magazineStr = in.nextLine();
        String  ransomStr   = in.nextLine();*/
        if (n > m)
        {
            System.out.println("No");
        }
        else
        {
            String canReplicate = canReplicateMagazine(magazine, ransom) ? "Yes" : "No";
            System.out.println(canReplicate);
        }
    }

    public static boolean canReplicateMagazine(Hashtable magazine, Hashtable ransom)
    {
        Iterator itr = ransom.keySet().iterator();
        while (itr.hasNext())
        {
            String  word          = (String) itr.next();
            Integer ransomCount   = (Integer) ransom.get(word);
            Integer magazineCount = (Integer) magazine.get(word);
            System.out.println(word + " RansomCount : " + ransomCount + " Magazine Count : " + magazineCount);
            if (magazineCount == null)
            {
                return false;
            }
            else if (magazineCount - ransomCount < 0)
            {
                return false;
            }
        }
        return true;
    }
    /*
    public static boolean canReplicateMagazine(String magazineStr,String ransomStr,int ransomWordCount)
    {
        System.out.println("Entered");
        Hashtable ransomOccurance =new Hashtable();
        String[] ransomArr = ransomStr.split(" ");
        System.out.println(System.currentTimeMillis());
        int nonRepeatCount = 0;
        for(int i=0;i<ransomWordCount;i++)
        {
            String ransomWord=ransomArr[i];
            String  regex     = "(" + ransomWord + ")";
            Pattern pattern   = Pattern.compile(regex);
            Matcher matcher   = pattern.matcher(ransomStr);
            if(ransomOccurance.get(ransomWord)==null)
            {
                nonRepeatCount++;
                int ransomFrequency   = 0;
                int magazineFrequency = 0;
                while(matcher.find())
                {
                    ransomFrequency++;
                }
                ransomOccurance.put(ransomWord,ransomFrequency);
                matcher = pattern.matcher(magazineStr);
                while (matcher.find())
                {
                    magazineFrequency++;
                }
                if(magazineFrequency-ransomFrequency<0)
                {
                    return false;
                }
            }
        }
        System.out.println(System.currentTimeMillis());
        System.out.println(nonRepeatCount);
        return true;
    }*/
}