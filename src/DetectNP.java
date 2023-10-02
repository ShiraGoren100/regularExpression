/*
 * Name: Shira Goren.
 * ID: 207814989
 * ass7
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This is a class representing a NP detector.
 *
 * @author Shira Goren.
 * @version 1
 * @since 2021-21-16
 */
public class DetectNP {
    private String line;
    private boolean isFirst;
    private final Map<String, QuickSortNumberArray> hypernymToHyponymMap;
    private String hypernym;
    private List<String> patterns;

    /**
     * This constructor saves line to detect.
     *
     * @param l line to save
     */
    public DetectNP(String l) {
        this.line = l;
        this.isFirst = true;
        this.hypernymToHyponymMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        this.initializePatterns();
    }

    /**
     * This method creates map of hypernym to hyponyms.
     *
     * @param toSplit string that fots a pattern
     */
    public void createMap(String toSplit) {

        /*separate hypernyms and hyponyms into sub groups*/
        Matcher m = Pattern.compile("<+n+p\\>.*?" + "\\<").
                matcher(toSplit);

        /*find hypernym and its hyponyms in line*/
        while (m.find()) {
            CharSequence group = m.group().subSequence(4,
                    m.group().length() - 1);

            /*check if is hypernym*/
            if (this.isFirst) {
                this.hypernym = (String) group;
                //add to map if doesn't exist
                if (!this.hypernymToHyponymMap.containsKey(this.hypernym)) {
                    this.hypernymToHyponymMap.put(this.hypernym,
                            new QuickSortNumberArray()); // create new key in map
                }
                this.isFirst = false; // change flag
            } else {
                //if this is a hyponym
                AppearanceCounter hypo = this.hypernymToHyponymMap.get(
                        this.hypernym).findAppearanceCounter((String) group);
                if (hypo == null) {
                    //create new hyponym
                    hypo = new AppearanceCounter((String) group, 1);
                    // add to hyponym list
                    this.hypernymToHyponymMap.get(
                            this.hypernym).addAppearanceCounter(hypo);
                } else {
                    //add 1 to counter of num of appearances
                    hypo.increaseCounter(1);
                }
            }
        }
    }

    /**
     * This method finds pattern given.
     *
     * @param patternGiven pattern to look for.
     */
    public void checkForPattern(String patternGiven) {
        Pattern pattern = Pattern.compile(patternGiven);
        Matcher matcher = pattern.matcher(this.line);

        /*find pattern in line*/
        while (matcher.find()) {
            this.isFirst = true;
            String toSplit = this.line.substring(matcher.start(),
                    matcher.end());
            this.createMap(toSplit);
        }
    }

    /**
     * This method initializes the patterns.
     */
    public void initializePatterns() {
        this.patterns = new ArrayList<>();
        //create pattern 1
        String patternOne = this.patternOne();
        this.patterns.add(patternOne); // add pattern to list
        // create pattern two
        String patternTwo = this.patternTwo();
        this.patterns.add(patternTwo); // add pattern to list
        // create pattern three
        String patternThree = this.patternThree();
        this.patterns.add(patternThree); // add pattern to list
        // create pattern four
        String patternFour = this.patternFour();
        this.patterns.add(patternFour); // add pattern to list
    }

    /**
     * This method checks all patterns in line.
     */
    public void checkAllPatterns() {
        for (String pattern : this.patterns) {
            this.checkForPattern(pattern);
        }

        /*add also fourth pattern*/
        this.patternFive();
    }

    /**
     * This method returns pattern 1.
     *
     * @return pattern 1
     */
    public String patternOne() {
        //create pattern 1
        return "<np>[^<]*</np> (, )?such as <np>[^<]*</np>( (, )"
                + "?<np>[^<]*</np>)*( ,)?(( and| or) <np>[^<]*</np>)?";
    }

    /**
     * This method returns second pattern.
     *
     * @return pattern 2
     */
    public String patternTwo() {
        // create pattern two
        return "such <np>[^<]*</np> as <np>[^<]*</np>( (, )?<np>"
                + "[^<]*</np>)*( ,)?(( and| or) <np>[^<]*</np>)?";
    }

    /**
     * This method returns third pattern.
     *
     * @return pattern 3
     */
    public String patternThree() {
        // create pattern three
        return "<np>[^<]*</np> (, )?including <np>[^<]*</np>"
                + "( (, )?<np>[^<]*</np>)*( ,)?(( and| or) <np>[^<]*</np>)?";
    }

    /**
     * This method returns fourth pattern.
     *
     * @return pattern 4
     */
    public String patternFour() {
        // create pattern four
        return "<np>[^<]*</np> (,+ )?especially <np>[^<]*</np>"
                + "( (, )?<np>[^<]*</np>)*( ,)?(( and| or) <np>[^<]*</np>)?";
    }

    /**
     * This method checks for forth pattern, and adds to map.
     */
    public void patternFive() {
        this.isFirst = true;
        String hypo = null; // create hyponym flag
        // create pattern four
        String patternFive = "<np>[^<]*</np> (,+ )?which is "
                + "(an example |a kind |a class )?(of )?<np>[^<]*</np>";
        Pattern pattern = Pattern.compile(patternFive);
        Matcher matcher = pattern.matcher(this.line);

        /*find pattern in line*/
        while (matcher.find()) {
            String toSplit = this.line.substring(matcher.start(),
                    matcher.end());
            Matcher m = Pattern.compile("<+n+p\\>.*?" + "\\<").
                    matcher(toSplit);

            /*find hypernym and its hyponyms in line*/
            while (m.find()) {
                CharSequence group = m.group().subSequence(4,
                        m.group().length() - 1);

                /*check if is hypernym*/
                if (this.isFirst) {
                    hypo = (String) group;
                    this.isFirst = false; // change flag
                } else {
                    //if this is a hyponym
                    this.hypernym = (String) group;
                    //add to map if doesn't exist
                    if (!this.hypernymToHyponymMap.containsKey(this.hypernym)) {
                        // create new key in map
                        this.hypernymToHyponymMap.put(this.hypernym,
                                new QuickSortNumberArray());
                    }
                }
            }

            /*add to map*/
            AppearanceCounter h = this.hypernymToHyponymMap.
                    get(this.hypernym).findAppearanceCounter(hypo);
            // make sure we got the hyponym
            if (hypo != null) {
                if (h == null) {
                    //create new hyponym
                    h = new AppearanceCounter(hypo, 1);
                    // add to hyponym list
                    this.hypernymToHyponymMap.
                            get(this.hypernym).addAppearanceCounter(h);
                } else {
                    //add 1 to counter of num of appearances
                    h.increaseCounter(1);
                }
            }
        }
    }

    /**
     * This method returns map created.
     *
     * @return map
     */
    public Map<String, QuickSortNumberArray> getMap() {
        return this.hypernymToHyponymMap;
    }

    /**
     * This method changes line.
     *
     * @param l new line
     */
    public void setLine(String l) {
        this.line = l;
    }
}
