/*
 * Name: Shira Goren.
 * ID: 207814989
 * ass7
 */

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;
import java.util.Objects;

/**
 * This is a class representing a HypernymDatabase.
 *
 * @author Shira Goren.
 * @version 1
 * @since 2021-21-16
 */
public class CreateHypernymDatabase {
    private DetectNP detector;

    /**
     * This constructor initializes detector.
     */
    public CreateHypernymDatabase() {
        this.detector = new DetectNP("");
    }

    /**
     * This method finds np's in line.
     *
     * @param line   string to set detector to check
     * @param detect checker of patterns
     */
    public void findNPs(String line, DetectNP detect) {
        detect.setLine(line);
        detect.checkAllPatterns();
    }

    /**
     * This method prints end result to file.
     *
     * @param detect  detector holding map
     * @param outFile file to print to
     */
    public void printToFile(DetectNP detect, String outFile) {
        try {

            OutFormat out = new OutFormat(detect.getMap());
            out.reformatMap();
            //set output stream
            File myFile = new File(outFile);
            PrintStream fileOut = new PrintStream(myFile);
            System.setOut(fileOut);
            boolean firstHypernym = true;

            /*sort each HyponymList in map*/
            for (String key : out.getMap().keySet()) {
                //sort hyponyms
                out.getMap().get(key).quickSortArray(
                        out.getMap().get(key).getSize() - 1, 0);
                if (!firstHypernym) {
                    System.out.println();
                }

                /*print to file*/
                System.out.print(key + ":");
                //create first hyponym flag
                boolean firstHyponym = true;
                //print all hyponyms and how many times they appeared
                for (AppearanceCounter h : out.getMap().
                        get(key).getAppearanceCounterList()) {
                    if (firstHyponym) {
                        System.out.print(" " + h.getName()
                                + " (" + h.getCounter() + ")");
                    } else {
                        System.out.print(", " + h.getName()
                                + " (" + h.getCounter() + ")");
                    }
                    firstHyponym = false;
                }
                firstHypernym = false;
            }
        } catch (IOException e) {
            System.out.println("an error accrued");
        }
    }

    /**
     * This method returns map created.
     *
     * @return map
     */
    public Map<String, QuickSortNumberArray> getMap() {
        return this.detector.getMap();
    }

    /**
     * This method runs through all files and finds NP's.
     *
     * @param file file to run through
     */
    public void runThroughFile(File file) {
        //run through all lines in file
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                // do stuff to each line
                this.findNPs(line, this.detector);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is the main running method.
     *
     * @param args string array with file path ans file output name
     */
    public static void main(String[] args) {

        /*make sure enough arguments were given*/
        if (args.length != 2) {
            return;
        }
        // get argument paths
        String corpus = args[0];
        String output = args[1];
        //create an object of this class
        CreateHypernymDatabase data = new CreateHypernymDatabase();
        // get all files in the folder
        final File folder = new File(corpus);
        final File[] fileList = Objects.requireNonNull(folder.listFiles());

        /*for every file find all NP's*/
        for (File file : fileList) {
            data.runThroughFile(file);
        }

        /*reformat map and print output*/
        data.printToFile(data.detector, output);
    }
}
