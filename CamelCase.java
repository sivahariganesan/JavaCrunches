import java.util.Scanner;

public class CamelCase
{
    public static void main(String[] args)
    {
        Scanner in    = new Scanner(System.in);
        String  input = in.next();
        String  regex = "([A-Z])";
        System.out.println(input.split(regex).length);
    }
}
