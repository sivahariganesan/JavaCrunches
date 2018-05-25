import java.util.HashSet;
import java.util.Queue;

public class CheckForBST
{

    boolean checkBST(Node root)
    {
        int  rootData = root == null ? 0 : root.data;
        Node left     = root == null ? null : root.left;
        Node right    = root == null ? null : root.right;
        return checkBST(root, rootData, false) && checkForDuplicates(root) && isValidLeftTree(left, rootData) && isValidRightTree(right, rootData);
    }

    boolean checkBST(Node root, int rootData, boolean isRecursive)
    {
        if (root != null)
        {
            int     rootData2         = root == null ? 0 : root.data;
            boolean hasValidRightTree = checkRightTree(root, rootData, isRecursive);
            boolean hasValidLeftTree  = checkLeftTree(root, rootData, isRecursive);
            return hasValidRightTree && hasValidLeftTree && isValidLeftTree(root.left, rootData2) && isValidRightTree(root.right, rootData2);
        }
        return true;
    }

    boolean isValidLeftTree(Node leftRoot, int rootData)
    {
        Queue<Node> queue = (Queue<Node>) new LinkedList();
        if (leftRoot != null)
        {
            queue.add(leftRoot);
            while (!queue.isEmpty())
            {
                Node current = queue.remove();
                if (current.data < rootData)
                {
                    if (current.left != null)
                    {
                        queue.add(current.left);
                    }
                    if (current.right != null)
                    {
                        queue.add(current.right);
                    }
                }
                else
                {
                    return false;
                }
            }
        }
        return true;
    }

    boolean isValidRightTree(Node rightRoot, int rootData)
    {
        Queue<Node> queue = (Queue<Node>) new LinkedList();
        if (rightRoot != null)
        {
            queue.add(rightRoot);
            while (!queue.isEmpty())
            {
                Node current = queue.remove();
                if (current.data > rootData)
                {
                    if (current.left != null)
                    {
                        queue.add(current.left);
                    }
                    if (current.right != null)
                    {
                        queue.add(current.right);
                    }
                }
                else
                {
                    return false;
                }
            }
        }
        return true;
    }

    boolean checkRightTree(Node root, int rootData, boolean isRecursive)
    {
        if (root != null && root.right != null)
        {

            if (root.data < root.right.data)
            {
                return checkBST(root.right, rootData, true);
            }
            else
            {
                return false;
            }
        }
        return true;
    }

    boolean checkLeftTree(Node root, int rootData, boolean isRecursive)
    {
        if (root != null && root.left != null)
        {
            if (root.data > root.left.data)
            {
                return checkBST(root.left, rootData, true);
            }
            else
            {
                return false;
            }
        }
        return true;
    }

    boolean checkForDuplicates(Node root)
    {
        Queue<Node> queue = (Queue<Node>) new LinkedList();
        HashSet     set   = new HashSet();
        queue.add(root);
        while (!queue.isEmpty())
        {
            Node current = queue.remove();
            //System.out.print(current.data+" ");
            if (!set.contains(current.data))
            {
                set.add(current.data);
            }
            else
            {
                return false;
            }
            if (current.left != null)
            {
                queue.add(current.left);
            }
            if (current.right != null)
            {
                queue.add(current.right);
            }
        }
        return true;
    }

    class Node
    {
        int  data;
        Node left;
        Node right;
    }

}
