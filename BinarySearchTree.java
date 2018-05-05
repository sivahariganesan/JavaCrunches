public class BinarySearchTree
{

}

class BinaryNode
{
    int        data;
    BinaryNode left, right;

    BinaryNode(int data)
    {
        new BinaryNode(data, null, null);
    }

    BinaryNode(int data, BinaryNode left, BinaryNode right)
    {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public void insert(BinaryNode root, int data)
    {
        if (root.data > data)
        {
            if (root.left != null)
            {
                insert(root.left, data);
            }
            else
            {
                root.left = new BinaryNode(data);
            }
        }
        else
        {
            if (root.right != null)
            {
                insert(root.right, data);
            }
            else
            {
                root.right = new BinaryNode(data);
            }
        }
    }

    public void printTree(BinaryNode root)
    {
        System.out.println(root.data);
        if (root.left != null)
        {
            System.out.println(root.left.data);
        }
        if (root.right != null)
        {
            System.out.println(root.right.data);
        }
        printTree(root.left);
        printTree(root.right);
    }
    //public void printLeftTree()
}
