/*
 * Name: Shira Goren.
 * ID: 207814989
 * ass7
 */

/**
 * This is a class representing a HypernymDatabase.
 *
 * @author Shira Goren.
 * @version 1
 * @since 2021-21-16
 */
public class AppearanceCounter {
    private final String name;
    private int counter;

    /**
     * This constructor initializes hyponym and how many
     * times hyponym was found.
     *
     * @param object name of hyponym
     */
    public AppearanceCounter(String object) {
        this.name = object;
        this.counter = 0;
    }

    /**
     * This constructor initializes hyponym and how many
     * times hyponym was found.
     *
     * @param name  name of hyponym
     * @param start num of times hypony was found before
     */
    public AppearanceCounter(String name, int start) {
        this.name = name;
        this.counter = start;
    }

    /**
     * This method adds num to counter.
     *
     * @param add num to add to counter
     */
    public void increaseCounter(int add) {
        this.counter += add;
    }

    /**
     * This method returns hyponym name.
     *
     * @return hyponym name
     */
    public String getName() {
        return this.name;
    }

    /**
     * This method returns counter.
     *
     * @return counter
     */
    public int getCounter() {
        return this.counter;
    }
}
