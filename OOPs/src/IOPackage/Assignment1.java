package IOPackage;

import java.io.FileWriter;
import java.io.IOException;

public class Assignment1 {
    public static void main(String[] args) throws IOException,InterruptedException {
        try{
            FileWriter writer = new FileWriter("input.txt");
            for(int i=0;i<100;i++){
                writer.write("This is what i am writing\n");
                Thread.sleep(50);
            }

            System.out.println("The file2 writing operation completed!");
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
