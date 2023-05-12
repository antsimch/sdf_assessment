package sg.edu.nus.iss;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
   
            while ((line = br.readLine()) != null) {
   
                // remove punctuation and convert to lower case and add to list

                String[] lineArray = line.toLowerCase().replaceAll("\\p{Punct}", "").split("\\s+");

                System.out.println("after " + line);

                for (String s : lineArray) {
                    text.add(s);
                }
            }

            br.close();
            fr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void compute() {
        
        // map the ArrayList of words into a Hashmap<HashMap<String, Double>>
        for (int i = 0; i < text.size() - 1; i++) {

            words.computeIfAbsent(text.get(i), k -> new HashMap<String, Double>());
            words.get(text.get(i)).computeIfPresent(text.get(i + 1), (k, v) -> v + 1);
            words.get(text.get(i)).computeIfAbsent(text.get(i + 1), k -> 1.0);
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

    public void print() {

        for (String key : words.keySet()) {

            System.out.println(key);

            for (String keyInnerMap : words.get(key).keySet()) {

                System.out.printf("\t\t%s\t\t%f\n", keyInnerMap, words.get(key).get(keyInnerMap));
            }
        }
    }
}
