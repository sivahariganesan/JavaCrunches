import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class StackedQueue
{
    static Stack firstStack  = new Stack();
    static Stack secondStack = new Stack();

    public static void enqueue(Object value)
    {
        firstStack.push(value);
        secondStack.add(0, value);
       /* System.out.println("First Stack");
        print(firstStack);
        System.out.println("Second Stack");
        print(secondStack);*/
    }

    public static Object dequeue()
    {
        /*secondStack=new Stack();
        Iterator iterator = firstStack.iterator();
        while(iterator.hasNext())
        {
            Object nextElement=iterator.next();
            secondStack.push(nextElement);
        }
        Object poppedElement = null;
        if(!secondStack.isEmpty())
        {
            poppedElement=secondStack.pop();
            firstStack.remove(poppedElement);
        }*/
        /*System.out.println("Going to Pop");
        System.out.println("First Stack");
        print(firstStack);
        System.out.println("Second Stack");
        print(secondStack);*/
        Object poppedElement = secondStack.pop();
        firstStack.remove(poppedElement);
        return poppedElement;
    }

    public static Object peek()
    {
        /*secondStack=new Stack();

        Iterator iterator = firstStack.iterator();
        while(iterator.hasNext())
        {
            Object nextElement=iterator.next();
            secondStack.push(nextElement);
        }*/
        /*System.out.println("Going to Peek");
        System.out.println("First Stack");
        print(firstStack);
        System.out.println("Second Stack");
        print(secondStack);*/
        return !secondStack.isEmpty() ? secondStack.peek() : null;
    }

    public static void print(Stack stack)
    {
        Iterator iterator = stack.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next() + "->");
        }
    }

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int     n    = scan.nextInt();

        for (int i = 0; i < n; i++)
        {
            int operation = scan.nextInt();
            if (operation == 1)
            {
                // enqueue
                enqueue(scan.nextInt());
            }
            else if (operation == 2)
            {
                // dequeue
                dequeue();
            }
            else if (operation == 3)
            {
                // print/peek
                System.out.println(peek());
            }
        }
        scan.close();
    }
}
