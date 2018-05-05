import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class MyComparator implements java.util.Comparator
{

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int     n    = scan.nextInt();

        Player[]     player  = new Player[n];
        MyComparator checker = new MyComparator();

        for (int i = 0; i < n; i++)
        {
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for (int i = 0; i < player.length; i++)
        {
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }

    @Override
    public int compare(Object o1, Object o2)
    {
        Player player1 = (Player) o1;
        Player player2 = (Player) o2;
        //System.out.println("Player 1 Score: "+player1.score+" Nme: "+player1.name);
        //System.out.println("Player 2 Score: "+player2.score+" Nme: "+player2.name);
        if (player1.score > player2.score)
        {
            //System.out.println("Player 1's Score is greater returning 1");
            return -1;
        }
        else if (player1.score < player2.score)
        {
            //System.out.println("Player 2's Score is greater returning -1");
            return 1;
        }
        else
        {
            //System.out.println("Alphabaticall comparison"+player2.name.compareTo(player1.name));
            return player1.name.compareTo(player2.name);
        }
    }

    @Override
    public Comparator reversed()
    {
        return null;
    }

    @Override
    public Comparator thenComparing(Comparator other)
    {
        return null;
    }

    @Override
    public Comparator thenComparingInt(ToIntFunction keyExtractor)
    {
        return null;
    }

    @Override
    public Comparator thenComparingLong(ToLongFunction keyExtractor)
    {
        return null;
    }

    @Override
    public Comparator thenComparing(Function keyExtractor)
    {
        return null;
    }

    @Override
    public Comparator thenComparing(Function keyExtractor, Comparator keyComparator)
    {
        return null;
    }

    @Override
    public Comparator thenComparingDouble(ToDoubleFunction keyExtractor)
    {
        return null;
    }
}

class Player
{
    String name;
    int    score;

    Player(String name, int score)
    {
        this.name = name;
        this.score = score;
    }

}
