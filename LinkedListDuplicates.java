import java.util.HashSet;
import java.util.Scanner;

public class LinkedListDuplicates
{
    public static Node removeDuplicates(Node head)
    {
        //Write your code here
        HashSet set      = new HashSet();
        Node    node     = head;
        Node    previous = head;
        int     i        = 0;
        while (node != null)
        {
            if (set.contains(node.data))
            {
                System.out.println("Duplicate found: " + i);
                previous.next = node.next;
            }
            else
            {
                System.out.println("Duplicate not found: " + i);
                set.add(node.data);
                previous = node;
            }
            node = node.next;
            i++;
        }
        return head;
    }

    public static Node insert(Node head, int data)
    {
        Node p = new Node(data);
        if (head == null)
            head = p;
        else if (head.next == null)
            head.next = p;
        else
        {
            Node start = head;
            while (start.next != null)
                start = start.next;
            start.next = p;

        }
        return head;
    }

    public static void display(Node head)
    {
        Node start = head;
        while (start != null)
        {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static void main(String args[])
    {
        Scanner sc   = new Scanner(System.in);
        Node    head = null;
        int     T    = sc.nextInt();
        while (T-- > 0)
        {
            int ele = sc.nextInt();
            head = insert(head, ele);
        }
        head = removeDuplicates(head);
        display(head);

    }

    static class Node
    {
        int  data;
        Node next;

        Node(int d)
        {
            data = d;
            next = null;
        }

    }
}
