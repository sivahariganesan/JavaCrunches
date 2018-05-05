import java.util.Scanner;

public class EvenTree
{
    public static void main(String[] args)
    {
        Scanner  in             = new Scanner(System.in);
        String[] treeNodesEdges = in.nextLine().split(" ");
        int      treeNodes      = Integer.parseInt(treeNodesEdges[0].trim());
        int      treeEdges      = Integer.parseInt(treeNodesEdges[1].trim());
        int[][]  tree           = new int[treeNodes][treeNodes];
        int[]    childCount     = new int[treeNodes];
        for (int i = 0; i < treeEdges; i++)
        {
            String[] treeFromTo = in.nextLine().split(" ");
            int      from       = Integer.parseInt(treeFromTo[0].trim());
            int      to         = Integer.parseInt(treeFromTo[1].trim());
            tree[from][to] = 1;
        }
        for (int colItr = 0; colItr < treeNodes; colItr++)
        {
            for (int rowItr = 0; rowItr < treeNodes; colItr++)
            {
                childCount[colItr] += tree[rowItr][colItr] == 1 ? 1 : 0;
            }
        }
        int removableNodes = 0;
        for (int i = 0; i < treeNodes; i++)
        {
            removableNodes += childCount[i] % 2 == 0 ? 1 : 0;
        }
        System.out.println(removableNodes);
    }

}
