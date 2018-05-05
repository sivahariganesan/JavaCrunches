import java.util.Scanner;

public class LinkedList
{
    public static void main(String[] args)
    {
        System.out.println("Enter Number of Inputs:");
        Scanner in   = new Scanner(System.in);
        int     n    = in.nextInt();
        Node    root = null;
        /*for(int i=0;i<n;i++)
        {
            if(i==0)
            {
                root=new Node(in.nextInt());
            }
            else
            {
                root.insert(root,in.nextInt());
            }
        }*/
        root = new Node(1);
        Node secondElement = new Node(2);
        Node thirdElement  = new Node(3);
        thirdElement.next = root;
        secondElement.next = thirdElement;
        root.next = secondElement;
        System.out.println("Has Cycle?for testcase 2: " + root.hasCycle(root));
    }
}

class Node
{
    int  data;
    Node next;

    Node(int data)
    {
        this.data = data;
        next = null;
    }

    public void insert(Node root, int data)
    {
        if (root.next != null)
        {
            insert(root, data);
        }
        else
        {
            root.next = new Node(data);
        }
    }

    public boolean hasCycle(Node head)
    {
        if (head != null && head.next != null)
        {
            Node slow = head;
            Node fast = head.next.next;
            while (slow != null && fast != null && slow != fast)
            {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow == fast;
            /*Node secondNext=head.next.next;
            System.out.println("Head: "+head);
            System.out.println("Next: "+head.next);
            System.out.println("secondNext: "+secondNext);
            if((secondNext!=null && secondNext==head)|| (secondNext==head.next))
            {
                return true;
            }
            else
            {
                return hasCycle(head.next);
            }*/
        }
        return false;
    }
}
