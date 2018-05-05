import java.util.Scanner;

public class BallonBurst
{
    static Ballon root = new Ballon();

    public static void main(String[] args)
    {
        System.out.println("Enter the Number of Arr:");
        Scanner in     = new Scanner(System.in);
        int     number = in.nextInt();
        for (int i = 0; i < number; i++)
        {
            int points = in.nextInt();
            if (i == 0)
            {
                root = new Ballon(points);
            }
            else
            {
                Ballon.insert(root, new Ballon(points));
            }
        }
        calculateBurst(root);
        //printBallonPoints(root);
        //System.out.println("----");
        int size       = number;
        int burstValue = 0;
        for (int i = 0; i < number - 1; i++)
        {
            burstValue += burstBallon(size, root);
            calculateBurst(root);
            //printBallonPoints(root);
            //System.out.println("----");
            size--;
        }
        burstValue += root.burstValue;
        System.out.println("Total Burst Value:" + burstValue);
    }

    public static Ballon calculateBurst(Ballon ballon)
    {
        int leftVal  = ballon.left != null ? ballon.left.points : -1;
        int rightVal = ballon.right != null ? ballon.right.points : -1;
        //System.out.println("Calculating Bursts for:"+ballon.points+" With Left:"+leftVal+" With Right as:"+rightVal);

        if (ballon.right != null && ballon.left != null)
        {
            ballon.burstValue = ballon.left.points * ballon.right.points;
        }
        else if (ballon.left != null || ballon.right != null)
        {
            if (ballon.left != null)
            {
                ballon.burstValue = ballon.left.points;
            }
            else
            {
                ballon.burstValue = ballon.right.points;
            }
        }
        else if (ballon.left == null && ballon.right == null)
        {
            ballon.burstValue = ballon.points;
        }
        if (ballon.right != null)
        {
            calculateBurst(ballon.right);
        }
        return ballon;
    }

    public static void printBallonPoints(Ballon ballon)
    {
        System.out.println(ballon.points + " " + ballon.burstValue);
        if (ballon.right != null)
        {
            printBallonPoints(ballon.right);
        }
    }

    public static int burstBallon(int number, Ballon ballon)
    {
        int midTerm         = (number / 2);
        int midTerm2        = (number / 2) + 1;
        int i               = 1;
        int totalBurstValue = 0;
        //System.out.println("Midterm"+midTerm+" Midterm2"+midTerm2);
        while (ballon != null)
        {
            if (i == midTerm)
            {
                if (midTerm != midTerm2)
                {
                    int midTermBurst  = ballon.burstValue;
                    int midTerm2Burst = ballon.right != null ? ballon.right.burstValue : -1;
                    if (midTermBurst >= midTerm2Burst)
                    {
                        //System.out.println("Bursting"+ballon.points +"at Index:"+i);
                        totalBurstValue += ballon.burstValue;
                        if (ballon.left != null)
                        {
                            ballon.left.right = ballon.right;
                        }
                        if (ballon.right != null)
                        {
                            ballon.right.left = ballon.left;
                        }
                        if (root.equals(ballon))
                        {
                            //System.out.println("Root to be bursted");
                            root = ballon.right;
                        }
                    }
                    else
                    {
                        //System.out.println("Bursting"+ballon.right.points+" At index"+i);
                        totalBurstValue += ballon.right.burstValue;
                        ballon.right = ballon.right.right;
                        ballon.right.left = ballon;
                    }
                    break;
                }
            }
            ballon = ballon.right;
            i++;
        }
        //System.out.println("Current Burst Value:"+totalBurstValue);
        return totalBurstValue;
    }

    public static class Ballon
    {
        int    points;
        int    burstValue;
        Ballon left, right;

        public Ballon(int points)
        {
            this.points = points;
            burstValue = 0;
            left = right = null;
        }

        public Ballon()
        {
            new Ballon(0);
        }

        public static void insert(Ballon root, Ballon ballon)
        {
            if (root.right != null)
            {
                insert(root.right, ballon);
            }
            else
            {
                ballon.left = root;
                root.right = ballon;
            }
        }
    }

}
