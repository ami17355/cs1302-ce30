package cs1302.ce30;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import cs1302.Utility;

public class MyFace {
    private static List<MyFaceUser> allUsers;
    
    private static List<String> firstNames;
    private static List<String> lastNames;
    private static List<String> messages;

    private static final int USERS = 10000;
    private static final int MAX_FRIENDS = 1000;
    private static final int MAX_MESSAGES = 1000;
    
    public static void main(String[] args) {
        firstNames = Utility.loadNames("first_names.txt");
        lastNames = Utility.loadNames("last_names.txt");
        messages = Utility.loadMessages("fortunes.txt");

        allUsers = genUsers(USERS);
    
        for(MyFaceUser m: allUsers) {
            System.out.println(m.getName());
//            m.printFriends();
//            m.printMessages();
        } // for
    } // main

    private static List<MyFaceUser> genUsers(int size) {
        List<MyFaceUser> allUsers = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            String userName = Utility.genName(firstNames, lastNames);
            //Generate the messages for this user
            List<Message> myMessages = genMessages(userName, MAX_MESSAGES);
            List<String> myFriends = genFriends(MAX_FRIENDS);
            allUsers.add(new MyFaceUser(userName, "good", myFriends, myMessages));
        } // for

        return allUsers;
    } // genUsers
    
    private static List<String> genFriends(int size) {
        int numFriends = (int)(Math.random() * size);
        List<String> myFriends = new ArrayList<>();

        for(int i = 0; i < numFriends; i++) {
            myFriends.add(Utility.genName(firstNames, lastNames));
        } // for

        return myFriends;
    } // genFriends
    
    private static List<Message> genMessages(String name, int size) {
        int numMessages = (int)(Math.random() * size);
        List<Message> myMessages = new ArrayList<>();
        for(int i = 0; i < numMessages; i++) {
            String contents = Utility.genMessage(messages);
//            System.out.println("**********" + contents);
            Message m = new Message(name, Utility.genName(firstNames, lastNames), contents);
            myMessages.add(m);
        } // for
        return myMessages;
    } // genMessages
        
    private static void printNames(List<String> names) {
        for(String s: names) {
            System.out.println(s);
        } // for
    }
} // Main
