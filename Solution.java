import java.util.Scanner;

public class Solution
{

    private static Node insert(Node node, int data)
    {
        if (node == null)
        {
            node = new Node(data);
        }
        else
        {
            if (data <= node.data)
            {
                node.left = insert(node.left, data);
            }
            else
            {
                node.right = insert(node.right, data);
            }
        }
        return (node);
    }

    public static void main(String[] args)
    {
        Scanner in     = new Scanner(System.in);
        Node    _root;
        int     root_i = 0, root_cnt = 0, root_num = 0;
        root_cnt = in.nextInt();
        _root = null;
        for (root_i = 0; root_i < root_cnt; root_i++)
        {
            root_num = in.nextInt();
            if (root_i == 0)
                _root = new Node(root_num);
            else
                insert(_root, root_num);
        }

        int q = in.nextInt();

        for (int i = 0; i < q; i++)
        {
            int _x = in.nextInt();
            System.out.println(isPresent(_root, _x));
        }

        return;
    }

    private static int isPresent(Node root, int val)
    {
        if (root.data == val)
        {
            return 1;
        }
        if (root.data < val && root.left != null)
        {
            System.out.println("Left Node Traversal" + root.left.data);
            return isPresent(root.left, val);
        }
        else if (root.data > val && root.right != null)
        {
            System.out.println("Left Node Traversal" + root.right.data);
            return isPresent(root.right, val);
        }
        else
        {
            System.out.println("Exiting as no match");
            return 0;
        }
/* For your reference
class Node {
		Node left, right;
		int data;
                Node(int newData) {
			left = right = null;
			data = newData;
		}
	}
*/
    }

    private static class Node
    {
        Node left, right;
        int data;

        Node(int newData)
        {
            left = right = null;
            data = newData;
        }
    }
}