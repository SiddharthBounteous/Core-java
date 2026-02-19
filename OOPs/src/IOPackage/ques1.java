package IOPackage;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;


public class ques1 {
    public static void main(String[] args) throws IOException {
        Path inputPath=Path.of("src/IOPackage/log.txt");
        Path errorFile=Path.of("error.log");
        Path summaryFile=Path.of("summary.txt");

        String content1=Files.readString(inputPath,StandardCharsets.UTF_8);
        String[] lines = content1.split("\\R" );

        for(String line:lines){
            if(line.contains("ERROR")){
                Files.writeString(errorFile,line+"\n",StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            }
        }

        String content= Files.readString(inputPath, StandardCharsets.UTF_8);
        content=content.replaceAll("[^a-zA-Z ]", "");
        String [] text=content.split("\\s+");


        int infoCount=0;
        int warnCount=0;
        int errorCount=0;
        for(int i=0;i<text.length;i++){
            if(text[i].equals("INFO")){
                infoCount++;
            }
            else if(text[i].equals("ERROR")){
                errorCount++;
            }
            else if(text[i].equals("WARN")){
                warnCount++;
            }
        }

        try{
            Files.writeString(summaryFile,"Error Count = "+errorCount+"\n"+"Warn Count = "+warnCount+"\n"+"Info Count = "+infoCount,StandardCharsets.UTF_8);
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }


    }
}
