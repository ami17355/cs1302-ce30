package cs1302.ce30;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import cs1302.Utility;

/**
 * A class representing a fake social network called MyFace.
 * Contains methods for generating random (fake) users to 
 * test various algorithms.
 */
public class MyFace {
    private List<MyFaceUser> allUsers;
    
    private static List<String> firstNames;
    private static List<String> lastNames;
    private static List<String> messages;

    private static final int USERS = 10000;
    private static final int MAX_FRIENDS = 1000;
    private static final int MAX_MESSAGES = 1000;

    /**
     * Default constructor. Initializes the list of users
     * by calling the {@code genUsers} method to generate
     * random user names, friend lists, and messages for
     * each user. The number of users generated is based
     * on the {@code USERS} constant declared in the class.
     */
    public MyFace() {
        this.genUsers(USERS);
    } // MyFace

    /**
     * Returns the list of users in this network.
     *
     * @return the list of {@code MyFaceUser} objects
     */
    public List<MyFaceUser> getUsers() {
        return allUsers;
    } // getUsers
    
    /**
     * Randomly generates users for this {@code MyFace} network. 
     * The method creates {@code size MyFaceUser} objects and
     * randomly generates friends and messages for the user.
     * This method is intended to be used to test various algorithms
     * on social network data.
     * 
     * @param size the number of users to generate
     */
    private void genUsers(int size) {
        allUsers = new ArrayList<>();

        firstNames = Utility.loadNames("first_names.txt");
        lastNames = Utility.loadNames("last_names.txt");
        messages = Utility.loadMessages("fortunes.txt");

        for(int i = 0; i < size; i++) {
            String userName = Utility.genName(firstNames, lastNames);
            // Random age between 18 and 97
            int userAge = (int)(Math.random() * 80) + 18;
            
            // Generate the messages and friends list for this user
            List<Message> myMessages = genMessages(userName, MAX_MESSAGES);
            List<String> myFriends = genFriends(MAX_FRIENDS);
            
            allUsers.add(new MyFaceUser(userName, userAge, "good",
                                        myFriends, myMessages));
        } // for
    } // genUsers

    /**
     * Generates a random list of friends. The method first chooses
     * a random number of messages between 0 and {@code size}. It then
     * generates a randomly chosen number of friends from a list of
     * possible friends.
     *
     * @param size the limit for the number of friends that 
     * can be generated.
     * @return the list of friend names for the user
     */
    private static List<String> genFriends(int size) {
        int numFriends = (int)(Math.random() * size);
        List<String> myFriends = new ArrayList<>();

        for(int i = 0; i < numFriends; i++) {
            myFriends.add(Utility.genName(firstNames, lastNames));
        } // for

        return myFriends;
    } // genFriends

    /**
     * Generates a random list of messages. The method first chooses
     * a random number of messages between 0 and {@code size}. It then
     * generates a randomly chosen number of messages from a list of
     * possible messages.
     *
     * @param name the user's (recipient) name
     * @param size the limit for the number of messages that 
     * can be generated.
     * @return the list of messages for the user
     */
    private static List<Message> genMessages(String name, int size) {
        int numMessages = (int)(Math.random() * size);
        List<Message> myMessages = new ArrayList<>();
        for(int i = 0; i < numMessages; i++) {
            String contents = Utility.genMessage(messages);
            Message m = new Message(name, Utility.genName(firstNames, lastNames), contents);
            myMessages.add(m);
        } // for

        return myMessages;
    } // genMessages
        
    /**
     * The main entry point for the application
     */
    public static void main(String[] args) {
        MyFace socialNetwork = new MyFace();
            
        for(MyFaceUser m: socialNetwork.getUsers()) {
            System.out.println(m.getName());
//            m.printFriends();
//            m.printMessages();
        } // for
    } // main

} // Main
