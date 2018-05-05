import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class FighterPits
{
    private static final Scanner scanner = new Scanner(System.in);

    static int[] fightingPits(int k, HashMap fightersMap, int[][] queries)
    {
        int[] result   = new int[queries.length];
        int   resutItr = 0;
        for (int querriesRowItr = 0; querriesRowItr < queries.length; querriesRowItr++)
        {
            int queryType = queries[querriesRowItr][0];
            if (queryType == 1)
            {
                fightersMap = addFighter(fightersMap, queries[querriesRowItr][1], queries[querriesRowItr][2]);
            }
            else
            {
                int     firstTeamId  = queries[querriesRowItr][1];
                int     secondTeamId = queries[querriesRowItr][2];
                Fighter team1        = (Fighter) fightersMap.get(firstTeamId);
                Fighter team2        = (Fighter) fightersMap.get(secondTeamId);
                System.out.println("Team 1" + firstTeamId);
                printFighter(team1);
                System.out.println("Team 2" + secondTeamId);
                printFighter(team2);
                result[resutItr] = predictResultForFight(team1, team2, firstTeamId, secondTeamId);
                resutItr++;
            }
        }
        return Arrays.copyOf(result, resutItr);
    }

    public static void main(String[] args) throws IOException
    {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\siva-3133\\Desktop\\output.txt"));

        /*String[] nkq = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nkq[0].trim());

        int k = Integer.parseInt(nkq[1].trim());

        int q = Integer.parseInt(nkq[2].trim());

        HashMap fightersMap=new HashMap();

        int[][] fighters = new int[n][2];

        for (int fightersRowItr = 0; fightersRowItr < n; fightersRowItr++)
        {
            String[] fightersRowItems = scanner.nextLine().split(" ");
            int      teamId           = Integer.parseInt(fightersRowItems[1].trim());
            int      playerStrength   = Integer.parseInt(fightersRowItems[0].trim());

            fightersMap = addFighter(fightersMap, playerStrength, teamId);
        }

        int[][] queries = new int[q][3];

        for (int queriesRowItr = 0; queriesRowItr < q; queriesRowItr++)
        {
            String[] queriesRowItems = scanner.nextLine().split(" ");

            for (int queriesColumnItr = 0; queriesColumnItr < 3; queriesColumnItr++)
            {
                int queriesItem = Integer.parseInt(queriesRowItems[queriesColumnItr].trim());
                queries[queriesRowItr][queriesColumnItr] = queriesItem;
            }
        }*/
        FileReader     fileReader     = new FileReader(new File("C:\\Users\\siva-3133\\Desktop\\input38.txt"));
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        HashMap        fightersMap    = new HashMap();
        String         line;
        int            i              = 0;
        int            n              = 0;
        int            k              = 0;
        int            q              = 0;
        int[][]        queries        = new int[q][3];
        int            queriesRowItr  = 0;
        while ((line = bufferedReader.readLine()) != null)
        {
            if (i == 0)
            {
                String[] nkq = line.split(" ");
                n = Integer.parseInt(nkq[0].trim());
                k = Integer.parseInt(nkq[1].trim());
                q = Integer.parseInt(nkq[2].trim());

            }
            else if (i >= 1 && i <= n)
            {
                String[] fightersRowItems = line.split(" ");
                int      teamId           = Integer.parseInt(fightersRowItems[1].trim());
                int      playerStrength   = Integer.parseInt(fightersRowItems[0].trim());

                fightersMap = addFighter(fightersMap, playerStrength, teamId);
            }
            else if (i > n)
            {
                if (queriesRowItr == 0)
                {
                    queries = new int[q][3];
                }
                String[] queriesRowItems = line.split(" ");
                int      queriesItem     = Integer.parseInt(queriesRowItems[0].trim());
                queries[queriesRowItr][0] = queriesItem;
                queriesItem = Integer.parseInt(queriesRowItems[1].trim());
                queries[queriesRowItr][1] = queriesItem;
                queriesItem = Integer.parseInt(queriesRowItems[2].trim());
                queries[queriesRowItr][2] = queriesItem;
                queriesRowItr++;
            }
            i++;
        }
        int[] result = fightingPits(k, fightersMap, queries);

        for (int resultItr = 0; resultItr < result.length; resultItr++)
        {
            bufferedWriter.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1)
            {
                bufferedWriter.write("\n");
            }
            //System.out.println(result[resultItr]);
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }

    private static void printTeams(HashMap fightersMap)
    {
        Iterator iterator = fightersMap.keySet().iterator();
        while (iterator.hasNext())
        {
            int teamId = (int) iterator.next();

            Fighter fighter = (Fighter) fightersMap.get(teamId);
            System.out.println("Team Id" + teamId);
            System.out.println("Team's Max Strength" + fighter.maxStrength);
            System.out.println("Team's total Strength" + fighter.totalStrength);
            printTeams(fighter.fighters);
        }
    }

    private static void printFighter(Fighter fighter)
    {
        System.out.println("Team's Max Strength" + fighter.maxStrength);
        System.out.println("Team's total Strength" + fighter.totalStrength);
        printTeams(fighter.fighters);
    }

    private static HashMap addFighter(HashMap fightersMap, int playerStrength, int teamId)
    {
        if (fightersMap.get(teamId) == null)
        {
            Fighter fighters = new Fighter();
            fighters.addFighter(playerStrength);
            fightersMap.put(teamId, fighters);
        }
        else
        {
            Fighter fighters = (Fighter) fightersMap.get(teamId);
            fighters.addFighter(playerStrength);
            fightersMap.put(teamId, fighters);
        }
        return fightersMap;
    }

    private static int predictResultForFight(Fighter team1, Fighter team2, int firstTeamId, int secondTeamId)
    {
        return team1.maxStrength >= team2.fighters.size() ? firstTeamId : team1.totalStrength >= team2.totalStrength - team1.maxStrength ? firstTeamId : secondTeamId;
        /*team1.sort(Comparator.naturalOrder());
        team2.sort(Comparator.naturalOrder());
        int i=1;
        while(!team1.isEmpty() && !team2.isEmpty())
        {
            if(i%2!=0)
            {
                int playerStrength= (int) team1.get(team1.size()-1);
                team2= new ArrayList(team2.subList(0,team2.size()-playerStrength));
                while (playerStrength!=0 && !team2.isEmpty())
                {
                    team2.remove(team2.size()-1);
                    playerStrength--;
                }
            }
            else
            {
                int playerStrength= (int) team2.get(team2.size()-1);
                team1= new ArrayList(team1.subList(0,team1.size()-playerStrength));
                while (playerStrength!=0 && !team1.isEmpty())
                {
                    team1.remove(team1.size()-1);
                    playerStrength--;
                }
            }
            i++;
        }
        return team1.isEmpty()?secondTeamId:firstTeamId;*/
    }

    private static void printTeams(ArrayList team)
    {
        System.out.print("Team List: [");
        for (int i = 0; i < team.size(); i++)
        {
            System.out.print("\t" + team.get(i));
        }
        System.out.print("\t ]");
    }

    static class Fighter
    {
        Integer maxStrength, totalStrength = 0;
        ArrayList fighters = new ArrayList();

        public Fighter()
        {
            maxStrength = 0;
            totalStrength = 0;
            fighters = new ArrayList();
        }

        public void addFighter(Integer playerStrength)
        {
            maxStrength = maxStrength > playerStrength ? maxStrength : playerStrength;
            totalStrength += playerStrength;
            fighters.add(playerStrength);
        }
    }
}