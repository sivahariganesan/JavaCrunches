import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class IceCream
{
    private static class Flavour
    {
        int flavourId;
        Long price;
        Flavour(int flavourId,Long price)
        {
            this.flavourId=flavourId;
            this.price=price;
        }

        @Override
        public boolean equals(Object obj)
        {
            Flavour nextFlavour= (Flavour) obj;
            return this.price.equals(nextFlavour.price);
        }
    }
    static void solve(ArrayList<Flavour> flavourList,Long availableMoney)
    {
        //System.out.println("Going to find Complement for Flavours of size: "+flavourList.size());
        for (int i = 0; i < flavourList.size(); i++)
        {
            //System.out.println("Iteration- "+i+" starts at"+System.currentTimeMillis());
            Flavour thisFlavour         = flavourList.get(i);
            Flavour complementFlavour   = new Flavour(-1, availableMoney - thisFlavour.price);

            int     complementFlavourId = getComplement(complementFlavour, new ArrayList<Flavour>(flavourList.subList(i,flavourList.size())));
            if (complementFlavourId!=-1)
            {
                if(thisFlavour.flavourId<complementFlavourId)
                {
                    System.out.println(thisFlavour.flavourId + " " + complementFlavourId);
                }
                else
                {
                    System.out.println(complementFlavourId + " " + thisFlavour.flavourId);
                }
                return;
            }
        }
    }
    private static int getComplement(Flavour complementFlavour,ArrayList<Flavour> flavourList)
    {
        //System.out.println("Get Complement starts at: "+System.currentTimeMillis()+" For list size: "+flavourList.size());
        //System.out.println("Mid Point: "+ flavourList.size()/2);
        ArrayList<Flavour> menuCard =new ArrayList(flavourList);
        while(!menuCard.isEmpty())
        {
            int     size       = menuCard.size();
            //System.out.println("Size "+ size);
            int     midPoint   = size/2;
            //System.out.println("MidPoint"+midPoint);
            Flavour midFlavour = menuCard.get(midPoint);
            //System.out.println(midFlavour.price);
            //System.out.println(complementFlavour.price);
            if(size == 1 && !midFlavour.price.equals(complementFlavour.price))
            {
                return -1;
            }
            else if(midFlavour.price<complementFlavour.price)
            {
                menuCard=new ArrayList<>(menuCard.subList(midPoint,size));
            }
            else if(midFlavour.price > complementFlavour.price)
            {
                menuCard = new ArrayList<Flavour>(menuCard.subList(0, midPoint));
            }
            else if(midFlavour.price.equals(complementFlavour.price))
            {
                return midFlavour.flavourId;
            }
        }
        return -1;
    }
    public static void main(String[] args)
    {
        try
        {
            FileReader     fileReader     = new FileReader(new File("C:\\Users\\siva-3133\\Desktop\\input.txt"));
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            int  i     = 0, moneyIndex = 1, inputIndex = 3;
            Long money = 0l;
            System.out.println(System.currentTimeMillis());
            while ((line = bufferedReader.readLine()) != null)
            {
                if (i == moneyIndex)
                {
                    money = Long.parseLong(line);
                    //System.out.println("Got the Total Amount"+money);
                    moneyIndex += 3;
                }
                else if(i == inputIndex)
                {
                    ArrayList<Flavour> menuCard  = new ArrayList();
                    String[]           priceList = line.split(" ");
                    //System.out.println("Total Amount"+money);
                    //System.out.println("Price List Size"+priceList.length);
                    for (int flavourId = 0; flavourId < priceList.length; flavourId++)
                    {
                        Long flavourPrice = Long.valueOf(priceList[flavourId]);
                        Long difference   = money - flavourPrice;
                        if (difference > 0)
                        {
                            menuCard.add(new Flavour(flavourId+1, flavourPrice));
                        }
                    }
                    //System.out.println("Going to sort at: "+System.currentTimeMillis());
                    menuCard.sort(new FlavourComparator());
                    //System.out.println("Finished sort at: "+System.currentTimeMillis());
                    solve(menuCard, money);
                    //System.out.println("Finished solving at: "+System.currentTimeMillis());
                    inputIndex += 3;
                }
                i++;
            }
            System.out.println(System.currentTimeMillis());
        }
        catch (Exception ex)
        {

        }
    }
    private static class FlavourComparator implements Comparator
    {

        @Override
        public int compare(Object object1, Object object2)
        {
            Flavour firstFlavour  = (Flavour) object1;
            Flavour secondFlavour = (Flavour) object2;
            int     returnValue   = (firstFlavour.price.equals(secondFlavour.price)) ? 0 : firstFlavour.price > secondFlavour.price ? 1 : -1;
            return returnValue;
        }
    }
}
