package cs1302;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

/**
 * Some handy dandy utility methods for MyFace
 */
public class Utility {

    /**
     * Loads all names from a specified filename. 
     *
     * @param filename the file containing the names
     * @return an {@code ArrayList} of the names
     */
    public static List<String> loadNames(String filename) {
        List<String> names = new ArrayList<>();

        try {
            //Read file containing first names into the List
            Scanner sc = new Scanner(new File("src/main/resources/" + filename));
            while(sc.hasNext()) {
                names.add(sc.next());
            } // while
        } catch (FileNotFoundException fnfe) {
            System.out.println("File Not Found. Can't load first names");
            System.exit(0);
        } // try

        return names;
    } // loadNames

    /**
     * Generate a random message from a list of messages.
     *
     * @param messages a list of messages
     * @return a random message
     */
    public static String genMessage(List<String> messages) {
        int index = (int)(Math.random() * messages.size());
        while(messages.get(index).equals("")) {
            index = (int)(Math.random() * messages.size());
        } // while
        return messages.get(index);
    }

    /**
     * Generate a random name from a list of firstnames and a separate
     * list of lastnames.
     *
     * @param firstNames a list of first names
     * @param lastNames a list of last names
     * @return a random name
     */
    public static String genName (List<String> firstNames, List<String> lastNames) {
        int firstIndex = (int)(Math.random() * firstNames.size());
        int secondIndex = (int)(Math.random() * lastNames.size());

        return firstNames.get(firstIndex) + " " + lastNames.get(secondIndex);
    } // genName

    /**
     * Loads all messages from a specified filename.
     *
     * @param filename the file containing the messages
     * @return an {@code ArrayList} of the messages
     */
    public static List<String> loadMessages(String filename) {
        List<String> messages = new ArrayList<>();
        try {
            //Read file containing first names into the List
            Scanner sc = new Scanner(new File("src/main/resources/" + filename));
            sc.useDelimiter("%");
            while(sc.hasNext()) {
                messages.add(sc.next());
            } // while
        } catch (FileNotFoundException fnfe) {
            System.out.println("File Not Found. Can't load first names");
            System.exit(0);
        } // try

        return messages;
        
    } // loadMessages

    /**
     * Throws a NullPointerException if any values in the
     * varargs parameter, {@code o} are {@code null}. The 
     * method performs no actions if all values in {@code o} 
     * are non-null.
     *
     * @param method the name of the calling method.
     * @param o varargs parameter containing all objects to verify
     * @throws NullPointerException if any element of parameter 
     * {@code o} is null.
     */
    public static void nullCheck(String method, Object ... o) {
        for(Object obj: o) {
            if(o == null) {
                throw new NullPointerException(method +
                                               ": Null Argument Provided");
            } // if
        } // for
    } // checkNull

    /**
     * Throws an IllegalArgumentException if any {@code Strings}
     * in the varargs parameter, {@code s} are empty. The 
     * method performs no actions if all values in {@code s} 
     * are non-null.
     *
     * @param method the name of the calling method.
     * @param s varargs parameter containing all strings to verify
     * @throws IllegalArgumentException if any element of parameter 
     * {@code s} is empty.
     */
    public static void checkEmpty(String method, String ... s) {
        for(String str: s) {
            if(str.equals("")) {
                throw new IllegalArgumentException(method +
                                                   ": Empty String Provided");
            } // if
        } // for
    } // checkEmpty

} // Utility
