package sg.edu.nus.iss;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        String dirPath = args[0];
        
        File directory = new File(dirPath);

        File[] directories = directory.listFiles();
        File[] files;
        
        List<String> texts = new ArrayList<>();

        for (int i = 0; i < directories.length; i++) {

            System.out.println(directories[i].getName());
            files = directories[i].listFiles();

            for (int j = 0; j < files.length; j++) {

                System.out.println(files[j].getName());
                CorpusToText myTxt = new CorpusToText(files[j]);

            }
        }       
    }
}
