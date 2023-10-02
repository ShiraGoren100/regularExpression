/*
 * Name: Shira Goren.
 * ID: 207814989
 * ass7
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This is a class representing a hypernym and Hyponym formatted for output.
 *
 * @author Shira Goren.
 * @version 1
 * @since 2021-21-16
 */
public class OutFormat extends AppearanceCounterList {
    public static final int MINIMUM = 3;
    private final Map<String, QuickSortNumberArray> hypernymToHyponymMap;

    /**
     * This constructor initializes the map.
     *
     * @param map map of hypernym and ayponyms
     */
    public OutFormat(Map<String, QuickSortNumberArray> map) {
        this.hypernymToHyponymMap = map;
    }

    /**
     * This method removes hypernyms without MINIMUM hyponyms.
     */
    public void reformatMap() {
        List<String> toRemove = new ArrayList<>();

        /*make sure all hypernyms have MINIMUM hypomyms*/
        for (String key : this.hypernymToHyponymMap.keySet()) {
            if (this.hypernymToHyponymMap.get(key).getSize() < MINIMUM) {
                toRemove.add(key);
            }
        }

        /*remove from map*/
        for (String key : toRemove) {
            this.hypernymToHyponymMap.remove(key);
        }
    }

    /**
     * This method returns map.
     *
     * @return map
     */
    public Map<String, QuickSortNumberArray> getMap() {
        return this.hypernymToHyponymMap;
    }

    /**
     * This method removes hypernyms that lemma is not their hyponym.
     *
     * @param lemma hyponym to find in every hypernym
     */
    public void createLemmaMap(String lemma) {
        List<String> toRemove = new ArrayList<>();

        /*add key to remove list if lemma is not a hyponym of key*/
        for (String key : this.hypernymToHyponymMap.keySet()) {
            if (this.hypernymToHyponymMap.get(key).findAppearanceCounter(lemma)
                    == null) {
                toRemove.add(key);
            }
        }

        /*remove from map*/
        for (String key : toRemove) {
            this.hypernymToHyponymMap.remove(key);
        }
    }

    /**
     * This method creates an AppearanceCounterList for hypernyms
     * in map, with counter of the lemma- and sorts it by counter.
     *
     * @param lemma hyponym to find count of
     * @return the sorted AppearanceCounterList
     */
    public QuickSortNumberArray createHypernymCounterList(String lemma) {
        QuickSortNumberArray hypernymCounterList = new QuickSortNumberArray();

        /*add new Appearance counter of hypernym and num of times lemma is in it*/
        for (String key : this.hypernymToHyponymMap.keySet()) {
            AppearanceCounter hyper = new AppearanceCounter(key,
                    this.hypernymToHyponymMap.get(key).
                            findAppearanceCounter(lemma).getCounter());
            hypernymCounterList.addAppearanceCounter(hyper);
        }

        /*sort by counter*/
        hypernymCounterList.quickSortArray(
                hypernymCounterList.getSize() - 1, 0);
        return hypernymCounterList;
    }
}
