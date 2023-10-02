/*
 * Name: Shira Goren.
 * ID: 207814989
 * ass7
 */

import java.io.File;
import java.util.Objects;

/**
 *  This is a class representing a HypernymDiscoverer.
 * @author Shira Goren.
 * @version 1
 * @since 2021-21-16
 */
public class DiscoverHypernym {

    /**
     * This method prints end result.
     * @param data data with map of hypernyms
     * @param lemma hyponym to find for each hypernym
     * */
    public void printToFile(CreateHypernymDatabase data, String lemma) {
        OutFormat out = new OutFormat(data.getMap());
        out.createLemmaMap(lemma); // reduce map to hypernyms with lemma hyponym
        // create hypernym with counter of lemma
        QuickSortNumberArray hypernymList = out.createHypernymCounterList(lemma);

        /*print each hypernym and counter*/
        for (AppearanceCounter hyper : hypernymList.getAppearanceCounterList()) {
            //print num of times lemma appeared for hyper
            System.out.println(hyper.getName() + ": (" + hyper.getCounter() + ")");
        }
    }

    /**
     * This method is the main running method.
     * @param args string array with file path ans file output name
     * */
    public static void main(String[] args) {

        /*make sure enough arguments were given*/
        if (args.length < 2) {
            return;
        }
        // get argument paths
        String corpus = args[0];
        String lemma = "";
        //collect lemma
        for (int i = 1; i < args.length; i++) {
            lemma += args[i];
        }
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
        DiscoverHypernym discoverer = new DiscoverHypernym();
        discoverer.printToFile(data, lemma);
    }
}
