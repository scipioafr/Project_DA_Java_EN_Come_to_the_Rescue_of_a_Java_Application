package com.hemebiotech.analytics;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;


public class AnalyticsCounter {
    private static int headacheCount = 0;    // initialize to 0
    private static int rashCount = 0;        // initialize to 0
    private static int pupilCount = 0;        // initialize to 0

    public static void main(String args[]) throws Exception {

        //Première étape:on déclare une hashmap (de type (string,integer))
        //On lit le fichier symptoms.txt(voir bufferedreader)
        //On parcourt le fichier symptoms.txt en comptant les symptomes dans la map(voir la boucle while et les conditions)
        //on range dans l'ordre alphabétique les symptomes utiliser la méthode Collections.sort
        //On écrit dans le fichier result.out


        Map<String, Integer> disease = new HashMap<String, Integer>();

        // first get input
        BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"));
        String line = reader.readLine();

        int i = 0;    // set i to 0
        while (line != null) {
            //i++;	// increment i


            if (disease.containsKey(line)) {
                i = disease.get(line) + 1;
                disease.put(line, i);
            } else {
                disease.put(line, 1);
            }
            line = reader.readLine();    // get another symptom

        }
        List<String> symptoms= new ArrayList<>(disease.keySet());
        Collections.sort(symptoms);


        for (Map.Entry<String, Integer> maladie : disease.entrySet()) {
            System.out.println(maladie.getKey() + ":" + maladie.getValue());
        }


        // next generate output
        FileWriter writer = new FileWriter("result.out");

        for (String maladie:symptoms) {
            writer.write(maladie + ":" + disease.get(maladie) + "\n");
        }
        writer.close();
    }
}
