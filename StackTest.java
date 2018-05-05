import java.util.HashMap;
import java.util.Stack;

public class StackTest
{

    static String[] braces(String[] values)
    {
        Stack    stack  = new Stack();
        String[] result = new String[values.length];
        HashMap  braces = new HashMap();
        braces.put(")", "(");
        braces.put("]", "[");
        braces.put("}", "{");
        for (int i = 0; i < values.length; i++)
        {
            String[] individualStr = values[i].split("");
            result[i] = "NO";
            for (int j = 0; j < individualStr.length; j++)
            {
                if (individualStr[j].equals("(") || individualStr[j].equals("[") || individualStr[j].equals("{"))
                {
                    stack.push(individualStr[j]);
                }
                else if (individualStr[j].equals(")") || individualStr[j].equals("]") || individualStr[j].equals("}"))
                {
                    if (!stack.isEmpty())
                    {
                        String poppedElement = (String) stack.pop();
                        if (!braces.get(individualStr[j]).equals(poppedElement))
                        {

                            result[i] = "NO";
                        }
                    }
                    else
                    {

                        result[i] = "NO";
                    }
                }
                if (individualStr.length - 1 == j && stack.isEmpty())
                {

                    result[i] = "YES";
                }
            }

        }
        return result;
    }

    public static void main(String args[])
    {
        String[] test   = {"{}[]()", "{()[]}", "{{{{"};
        String[] result = braces(test);
        for (String res : result)
        {
            System.out.println(res);
        }
    }
}
