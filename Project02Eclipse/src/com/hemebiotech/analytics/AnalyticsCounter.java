package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class AnalyticsCounter {
	private static int headacheCount = 0;	// initialize to 0
	private static int rashCount = 0;		// initialize to 0
	private static int pupilCount = 0;		// initialize to 0
	
	public static void main(String args[]) throws Exception {

		//Première étape:on déclare une hashmap (de type (string,integer))
		//On lit le fichier symptoms.txt(voir bufferedreader)
		//On parcourt le fichier symptoms.txt en comptant les symptomes dans la map(voir la boucle while et les conditions)
		//on range dans l'ordre alphabétique les symptomes utiliser la méthode Collections.sort
		//On écrit dans le fichier result.out


        String []disease;
        disease= new String[101];

	    // first get input
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();


		int i = 0;	// set i to 0
		int headCount = 0;	// counts headaches
        disease[i]=line;
		while (line != null) {
			i++;	// increment i
			/*System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headCount++;
				System.out.println("number of headaches: " + headCount);
			}
			else if (line.equals("rush")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}
			System.out.println("i:"+i);*/

			line = reader.readLine();	// get another symptom
            disease[i]=line;
		}
		i=0;
		for(int j=0;j<=98;j++) {
		    for(int k=(j+1);k<=99;k++){
		        if(disease[j].equals(disease[k])){
                    i++;
                    disease[k] = ("rien");
                }
            }
		    if(i==0){i++;}
		    if(disease[j].equals("rien")){

            }else{System.out.println(disease[j]+":"+i);}
		    i=0;
        }
		
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
}
