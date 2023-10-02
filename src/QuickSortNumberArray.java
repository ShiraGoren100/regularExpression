/*
 * Name: Shira Goren.
 * ID: 207814989
 * ass7
 */

/**
 *  This is a class representing a quick sort of an AppearanceCounterList by
 *  the value of the AppearanceCounters.
 * @author Shira Goren.
 * @version 1
 * @since 2021-06-21
 */
public class QuickSortNumberArray extends AppearanceCounterList {
    public static final int ZERO = 0;

    /**
     * This constructor calls AppearanceCounterList constructor.
     * */
    public QuickSortNumberArray() {
        super();
    }

    /**
     * this method swaps two objects given in the array.
     * @param arr - AppearanceCounterList
     * @param i - index to switch.
     * @param j - index to switch.
     */
    public static void swapInArray(AppearanceCounterList arr, int i, int j) {

        /*
         * save object from this index and switch
         *  the  two objects places in the array.
         * */
        AppearanceCounter temp = arr.getAppearanceCounterList().get(i);
        arr.changeAppearanceCounter(arr.getAppearanceCounterList().get(j), i);
        arr.changeAppearanceCounter(temp, j);
    }

    /**
     * this method finds a pivot to sort all objects in array up to it.
     * @param arr - HAppearanceCounterList.
     * @param high - last index of arr.
     * @param low - first index of arr.
     * @return i - pivot after switching around some objects in arr.
     */
    public static int findPivot(AppearanceCounterList arr, int high, int low) {

        /*set pivot to last object in arr.*/
        int pivot = arr.getAppearanceCounterList().get(high).getCounter();

        /*set i to before first index of arr.*/
        int i = low - 1;

        /*
         * while our j index is in range of arr,
         * check if the abject at j index is larger
         * than object in pivot. if so -switch them
         * and increase i counter.
         * */
        for (int j = low; j <= high; j++) {
            if (arr.getAppearanceCounterList().get(j).getCounter() > pivot) {
                i++;
                swapInArray(arr, i, j);
            }
        }

        /*increase the i counter and swap it with the last object in arr.*/
        i++;
        swapInArray(arr, i, high);

        /*return the i counter.*/
        return i;
    }

    /**
     * this method quickSorts the integer array given.
     * @param high - last index of arr.
     * @param low - first index of arr.
     */
    public void quickSortArray(int high, int low) {

        /*check array indexes given are possible.*/
        if (high > low) {

            /*
             * find pivot, then quick sort array until pivot,
             * and quick sort the array from pivot until end of array.
             * */
            int pivot = findPivot(this, high, low);
            quickSortArray(pivot - 1, low);
            quickSortArray(high, pivot + 1);
        }
    }
}
