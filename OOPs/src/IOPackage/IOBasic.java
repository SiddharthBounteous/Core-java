package IOPackage;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

public class IOBasic {
    public static void main(String[] args) throws IOException {
        Path inputPath=Path.of("input.txt");

        //we converting it to characters
        try{
            Files.writeString(inputPath,"This is line1\nThis is line2.\n", StandardCharsets.UTF_8);
        }
        catch(FileAlreadyExistsException ex){
            System.out.println("File already Exists");
        }
        String content=Files.readString(inputPath,StandardCharsets.UTF_8);
        System.out.println("File content\n"+content);

        Path outputPath=Path.of("output.txt");
        Files.writeString(outputPath,content.toUpperCase(),StandardCharsets.UTF_8);
    }
}
