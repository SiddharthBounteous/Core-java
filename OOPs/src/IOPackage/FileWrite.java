package IOPackage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
class MyFileNotFoundException extends Exception{
    public MyFileNotFoundException(String message){
        super(message);
    }
}
public class FileWrite {
        public static void main(String[] args) throws IOException, MyFileNotFoundException {
            //Path inputPath=Path.of("new.txt");
//            System.out.println("Enter the file characters");
            File file = new File("input.txt");

//            if(file.exists()){
//                throw new FileAlreadyExistsException("File already exists");
//            }
            if(file.exists()){
                throw new MyFileNotFoundException("File Does not exist");
            }

            FileWriter fw=new FileWriter("input.txt");
            fw.write("This is my file");
            fw.close();

//            String content=Files.readString(inputPath,StandardCharsets.UTF_8);
//            System.out.println("File content\n"+content);
//
//            Path outputPath=Path.of("output.txt");
//            Files.writeString(outputPath,content.toUpperCase(),StandardCharsets.UTF_8);
        }
}
