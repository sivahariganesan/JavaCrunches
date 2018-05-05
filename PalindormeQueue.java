import java.util.Scanner;
import java.util.Stack;

public class PalindormeQueue
{
    Stack   stack = new Stack();
    MyQueue root  = null;

    public static void main(String[] args)
    {
        Scanner scan  = new Scanner(System.in);
        String  input = scan.nextLine();
        scan.close();

        // Convert input String to an array of characters:
        char[] s = input.toCharArray();

        // Create a Solution object:
        PalindormeQueue p = new PalindormeQueue();

        // Enqueue/Push all chars to their respective data structures:
        for (char c : s)
        {
            p.pushCharacter(c);
            p.enqueueCharacter(c);
        }

        // Pop/Dequeue the chars at the head of both data structures and compare them:
        boolean isPalindrome = true;
        for (int i = 0; i < s.length / 2; i++)
        {
            if (p.popCharacter() != p.dequeueCharacter())
            {
                isPalindrome = false;
                break;
            }
        }

        //Finally, print whether string s is palindrome or not.
        System.out.println("The word, " + input + ", is "
                + ((!isPalindrome) ? "not a palindrome." : "a palindrome."));
    }

    public void pushCharacter(char c)
    {
        stack.push(c);
    }

    public void enqueueCharacter(char c)
    {
        if (root == null)
        {
            root = new MyQueue(c);
        }
        else
        {
            addDataToQueue(root, c);
        }
    }

    public void addDataToQueue(MyQueue queue, char c)
    {
        if (queue.nextElement == null)
        {
            MyQueue nextElement = new MyQueue(c);
            queue.nextElement = nextElement;
        }
        else
        {
            addDataToQueue(queue.nextElement, c);
        }
    }

    public char popCharacter()
    {
        return (char) stack.pop();
    }

    public void peekQueue(MyQueue queue)
    {
        if (queue.nextElement != null)
        {
            peekQueue(queue.nextElement);
        }
    }

    public char dequeueCharacter()
    {
        char data = root.data;
        root = root.nextElement;
        return data;
    }

}

class MyQueue
{
    char    data;
    MyQueue nextElement;

    MyQueue(char data)
    {
        this.data = data;
        nextElement = null;
    }
}