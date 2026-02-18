package IOPackage;

import java.io.FileReader;
import java.io.IOException;

public class FileRead {
    public static void main(String[] args) throws IOException {
        FileReader fd=new FileReader("output.txt");

        int ch;
        StringBuilder sb=new StringBuilder();

        while((ch=fd.read())!=-1){
            sb.append((char)ch);
        }
        String text= sb.toString();
        text=text.replaceAll("[^a-zA-Z ]", "");
        String[] tokens=text.split("\\s+");


        int count=0;

        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("java")){
                count++;
            }
        }
        System.out.println(count);
    }
}
