package sg.edu.nus.iss;
import java.io.File;

public class Main {
    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("args[0]: directory");
            System.exit(1);
        }

        String dirPath = args[0];
        File directory = new File(dirPath);

        if (!directory.exists()) {
            System.out.println("directory does not exist");
            System.exit(2);
        }

        File[] directories = directory.listFiles();
        File[] files;

        for (int i = 0; i < directories.length; i++) {

            System.out.println(directories[i].getName());
            files = directories[i].listFiles();

            for (int j = 0; j < files.length; j++) {

                System.out.println();
                System.out.println(files[j].getName());
                CorpusToText myText = new CorpusToText(files[j]);

                myText.scanToText();
                myText.compute();
                myText.print();
            }
        }       
    }
}
