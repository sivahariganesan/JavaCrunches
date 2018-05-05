import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class IceCream
{
    static void solve(Hashtable iceCreamMenu, Long money, ArrayList flavourList)
    {
        // Complete this function
        for (int i = 0; i < flavourList.size() - 1; i++)
        {
            System.out.println("Value of i: " + i);
            for (int j = i + 1; j < flavourList.size(); j++)
            {
                System.out.println("Value of j: " + j);
                int  flavourId1    = (int) flavourList.get(i);
                int  flavourId2    = (int) flavourList.get(j);
                Long flavourPrice1 = (Long) iceCreamMenu.get(flavourId1);
                Long flavourPrice2 = (Long) iceCreamMenu.get(flavourId2);
                System.out.println("Flavour Price1: " + flavourPrice1);
                System.out.println("Flavour Price2: " + flavourPrice2);
                if (flavourPrice1 + flavourPrice2 == money)
                {
                    System.out.println(flavourId1 + " " + flavourId2);
                    return;
                }
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int     t  = in.nextInt();
        for (int a0 = 0; a0 < t; a0++)
        {
            Long      money        = in.nextLong();
            Long      n            = in.nextLong();
            Hashtable iceCreamMenu = new Hashtable();
            ArrayList flavourList  = new ArrayList();

            for (int arr_i = 1; arr_i <= n; arr_i++)
            {
                Long flavourPrice = in.nextLong();
                Long difference   = money - flavourPrice;
                if (difference > 0)
                {
                    iceCreamMenu.put(arr_i, difference);
                    flavourList.add(arr_i);
                }
            }
            System.out.println("Flavours Added,going to solve");
            solve(iceCreamMenu, money, flavourList);
        }
        in.close();
    }
}
