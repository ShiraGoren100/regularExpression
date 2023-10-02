/*
 * Name: Shira Goren.
 * ID: 207814989
 * ass7
 */

import java.util.ArrayList;
import java.util.List;

/**
 * This is a class representing an appearanceCounter list.
 *
 * @author Shira Goren.
 * @version 1
 * @since 2021-21-16
 */
public class AppearanceCounterList {
    public static final int NOT_FOUND = -1;

    private final List<AppearanceCounter> appearanceCounterList;

    /**
     * This constructor initializes an AppearanceCounter array.
     */
    public AppearanceCounterList() {
        this.appearanceCounterList = new ArrayList<>();
    }

    /**
     * This method returns AppearanceCounter list.
     *
     * @return AppearanceCounter
     */
    public List<AppearanceCounter> getAppearanceCounterList() {
        return this.appearanceCounterList;
    }

    /**
     * This method adds a HAppearanceCounter to the list.
     *
     * @param h AppearanceCounter to add
     */
    public void addAppearanceCounter(AppearanceCounter h) {
        this.appearanceCounterList.add(h);
    }

    /**
     * This method removes a AppearanceCounter to the list.
     *
     * @param h AppearanceCounter to remove
     */
    public void removeAppearanceCounter(AppearanceCounter h) {
        this.appearanceCounterList.remove(h);
    }

    /**
     * This method returns the AppearanceCounter requested if it exists.
     *
     * @param h AppearanceCounter string name to look for
     * @return AppearanceCounter type of h if found, null otherwise
     */
    public AppearanceCounter findAppearanceCounter(String h) {

        /*run through all AppearanceCounter and find if it already exists*/
        for (AppearanceCounter appearanceCounter : this.appearanceCounterList) {
            if (appearanceCounter.getName().equals(h)) {
                return appearanceCounter;
            }
        }

        /*if doesn't exist*/
        return null;
    }

    /**
     * This method returns lists size.
     *
     * @return size of list
     */
    public int getSize() {
        return this.appearanceCounterList.size();
    }

    /**
     * This method puts new AppearanceCounter in list.
     *
     * @param h     AppearanceCounter to put in
     * @param index index in which to put it in
     */
    public void changeAppearanceCounter(AppearanceCounter h, int index) {
        this.appearanceCounterList.remove(index);
        this.appearanceCounterList.add(index, h);
    }
}
