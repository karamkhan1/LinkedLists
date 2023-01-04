import java.util.Arrays;
import java.util.Random;

/**
 * An array-based demonstration for FIFO and LIFO operations
 * @version 202210181100
 */

public class SimpleXIFO {

    /**
     * An array that stores strings added to it either on a first-available
     * basis (using the addLast method); or inserted as the first element
     * (using the addFirst method).
     */
    private String[] xifo;


    /**
     * A counter that tells us when the xifo array is full or empty
     */
    private int usage;


    /**
     * Default size for the array if someone calls the default constructor
     */
    private static final int DEFAULT_SIZE = 4;


    /**
     * Default constructor. Passes the default size value to the basic constructor.
     * <p>
     * DO NOT MODIFY THIS CONSTRUCTOR
     */
    public SimpleXIFO() {
        this(DEFAULT_SIZE);
    }  // Default constructor ... DO NOT MODIFY


    /**
     * Basic constructor. Initializes an array with the specified size and sets
     * its usage to 0.
     *
     * @param size int value of size for the xifo array.
     *             <p>
     *             DO NOT MODIFY THIS CONSTRUCTOR
     */
    public SimpleXIFO(int size) {
        this.xifo = new String[size];
        this.usage = 0;
    }  // Basic constructor ... DO NOT MODIFY


    /**
     * Last-in.
     * <p>
     * Method adds a string to the first available position in the array, if there
     * is room in the array. Note that the method does not add elements at the
     * last position in the array but at the first available. As more elements
     * are added, they move closer and closer to the end of the array.
     *
     * @param string String value to the end of the array
     *               <p>
     *               DO NOT MODIFY THIS METHOD
     */
    public void addLast(String string) {
        // Check that there is room in the array
        if (this.usage < this.xifo.length) {
            this.xifo[usage] = string;
            // Update usage
            this.usage++;
        }
    }  // method addLast ... DO NOT MODIFY


    /**
     * First out.
     *
     * Method removes the first element of the array.
     *
     * @return String with the value of the first element in the array.
     */
    public String removeFirst() {
        // variable to return
        String removed = null;
        // variable for search index
        int search = 0;
        // runs until it finds an element
        while(this.xifo[search] == null) {
            search++;
        }
        // assigns element removed to the removed string
        removed = this.xifo[search];
        // marks the element as null (removes)
        this.xifo[search] = null;
        if (this.usage > 0) {
            // usage has decreased
            this.usage--;
        }
        // return the removed element
        return removed;
    }  // method removeFirst


    /**
     * First in
     *
     * Adds an element at the beginning of the array, if there is room in the
     * array. The method must ensure that existing elements in the array are not
     * lost. For example, consider the array ["C", "B", "A", null]. If we use
     * addFirst("D"), the array must become ["D", "C", "B", "A"].
     *
     * @param string String value to add to the beginning of the array.
     */
    public void addFirst(String string) {
        // variable for length of array
        int length = this.xifo.length;
        // variable for gap index
        int spaceMark = 0;
        // checks if there is space in the array
        if (this.usage < length) {
            //finds the gap in the array
            while(this.xifo[spaceMark] != null) {
                spaceMark++;
            }
            //if the gap is in the front assign the element to the front
            if(spaceMark == 0)
            {
                this.xifo[0] = string;
            }
            //if not then traverse backwards and shift all elements to the right until there is space in the front
            else {
                for(int i = spaceMark; i > 0 ; i--) {
                    this.xifo[i] = this.xifo[i-1];
                }
                this.xifo[0] = string;
            }
            // usage has been increased
            this.usage++;
        }
    }  // method addFirst


    /**
     * FOR TESTING PURPOSES ONLY. DO NOT MODIFY THIS METHOD
     */
    public String[] getXifo() {
        return this.xifo;
    }  // method getXifo ... DO NOT MODIFY


    /**
     * FOR TESTING PURPOSES ONLY. DO NOT MODIFY THIS METHOD
     */
    public String toString() {
        return Arrays.toString(this.xifo);
    }  // method toString ... DO NOT MODIFY


    /**
     * TEST CODE. DO NOT MOFIFY THE MAIN METHOD BUT USE IT TO TEST IF YOUR
     * CODE WORKS AS EXPECTED.
     */
    public static void main(String[] args) {
        int testSize = 1024;
        int ascii_A = (int) 'A';
        int letters = 26;
        Random rng = new Random();
        SimpleXIFO fifo = new SimpleXIFO(testSize);
        SimpleXIFO lifo = new SimpleXIFO(testSize);
        for (int i = 0; i < testSize; i++) {
            String dataToAdd = String.valueOf((char) (ascii_A + rng.nextInt(letters)));
            fifo.addFirst(dataToAdd);
            lifo.addLast(dataToAdd);
        }
        String[] ofif = fifo.getXifo().clone();
        String[] ofil = lifo.getXifo().clone();
        boolean fifoTest = true;
        boolean lifoTest = true;
        for (int i = 0; i < testSize; i++) {
            fifoTest = fifoTest && fifo.removeFirst().equals(ofif[i]);
            lifoTest = lifoTest && lifo.removeFirst().equals(ofil[i]);
        }
        boolean symmetry = true;
        for (int i = 0; i < testSize; i++) {
            symmetry = symmetry && ofil[i].equals(ofif[ofif.length - 1 - i]);
        }
        if (symmetry && fifoTest && lifoTest) {
            System.out.printf("\nYour code seems to be working as expected.\n");
        } else if (!symmetry) {
            System.out.printf("\nYour addFirst method is not quite there yet.\n");
        } else {
            System.out.printf("\nYour removeFirst method is not quite there yet.\n");
        }
    }  // method main ... DO NOT MODIFY
}