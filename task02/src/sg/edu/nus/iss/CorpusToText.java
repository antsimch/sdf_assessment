package sg.edu.nus.iss;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CorpusToText {

    private File filePath;
    private List<String> text = new ArrayList<>();
    private Map<String, Map<String, Double>> words = new HashMap<>();

    public CorpusToText(File filePath) {
        this.filePath = filePath;
    }

    public void scanToText() {

        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);
            
            String line = "";

            Scanner scan = new Scanner(line);
   
            while ((line = br.readLine()) != null) {
   
                line = line.replaceAll("\\p{Punct}", "");

                text.add(scan.next());                    
            }

            scan.close();
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void compute(List<String> text) {
        
        // map the text into a Hashmap<HashMap<String, Double>>
        for (int i = 0; i < text.size() - 1; i++) {

            words.computeIfAbsent(text.get(i), v -> new HashMap<String, Double>());
            words.get(text.get(i)).put(text.get(i + 1), (words.get(text.get(i)).get(text.get(i + 1)) + 1));
        }

        // compute probability
        for (String key : words.keySet()) {

            double sumOfOccurences = 0;
            double probability = 0;

            for (String keyInnerMap : words.get(key).keySet()) {
                sumOfOccurences += words.get(key).get(keyInnerMap);
            }

            for (String keyInnerMap : words.get(key).keySet()) {
                probability = words.get(key).get(keyInnerMap) / sumOfOccurences;
                words.get(key).put(keyInnerMap, probability);
            }
        }
    }


        // while (scanFast.hasNext()) {
            
        //     String wordFirst = scanSlow.next();
        //     String wordSecond = scanFast.next();
            

        // }

}
