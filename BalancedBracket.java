import java.util.Scanner;
import java.util.Stack;

public class BalancedBracket
{
    static Stack stack = new Stack();

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int     n  = in.nextInt();
        in.nextLine();
        for (int i = 0; i < n; i++)
        {
            String expression = in.nextLine();
            System.out.println(isBalanced(expression));
        }
    }

    public static boolean isBalanced(String expression)
    {
        stack = new Stack();
        char[] expr = expression.toCharArray();
        for (char brace : expr)
        {
            if (brace == '{' || brace == '[' || brace == '(')
            {
                stack.push(brace);
            }
            else
            {
                if (!stack.isEmpty())
                {
                    char peekedChar = (char) stack.peek();
                    if ((peekedChar == '{' && brace == '}') || (peekedChar == '(' && brace == ')') || (peekedChar == '[' && brace == ']'))
                    {
                        stack.pop();
                    }
                    else
                    {
                        return false;
                    }
                }
                else
                {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
