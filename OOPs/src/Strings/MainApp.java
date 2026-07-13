package Strings;
import java.util.StringTokenizer;

public class MainApp
{
    public static void main(String[] args)
    {
        StringTokenizer st = new StringTokenizer("Java,Python,C++", ",");
        
        while(st.hasMoreTokens())
        {
            System.out.println(st.nextToken());
        }
    }
}