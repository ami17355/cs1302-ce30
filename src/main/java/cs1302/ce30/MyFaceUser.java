package cs1302.ce30;

import cs1302.Utility;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * A class representing a MyFace User. Each MyFace user has an associated 
 * name, status, message list, and a list of friends.
 */
public class MyFaceUser {

    private String        name;
    private int           age;
    private String        status;
    private List<String>  friends;
    private List<Message> messages;

    /**
     * Constructs an {@code MyFaceUser} object.
     *
     * @param name the name of the employee.
     * @param status the current status of the user
     * @param friends a list containing the names of this user's friends
     * @param messages a list containing the messages in this user's inbox
     * @throws NullPointerException if {@code deductions} is null.
     */
    public MyFaceUser(String name, String status, List<String> friends, List<Message> messages) {
        Utility.nullCheck("MyFaceUser Constructor", name, status, friends, messages);

        //Random age between 18 and 97
        this.age = (int) (Math.random() * 80) + 18;
        this.name = name;
        this.status = status;
        this.friends = friends;
        this.messages = messages;
    } // MyFaceUser

    /**
     * Adds a name to this user's friends list. 
     *
     * @throws NullPointerException if the name is null
     * @throws IllegalArgumentException if the name is empty
     * @param name the name of the new friend
     */
    public void addFriend(String name) {
        Utility.nullCheck("MyFaceUser addFriend", name);
        Utility.checkEmpty("MyFaceUser addFriend", name);
        
        this.friends.add(name);
    } // addFriend

    /**
     * Returns the age of this user
     * @return the age of the user
     */
    public int getAge() {
        return age;
    } // getAge
    
    /**
     * Adds a message to this user's inbox.
     *
     * @throws NullPointerException if the message is null
     * @param message the message to add.
     */
    public void addMessage(Message message) {
        Utility.nullCheck("MyFaceUser addMessage", message);

        this.messages.add(message);
    } // addMessage

    
    /**
     * Returns the name of this {@code MyFaceUser}
     *
     * @return the name of the user.
     */
    public String getName() {
        return name;
    } // getName

    /**
     * Returns the status of this {@code MyFaceUser}
     *
     * @return the status of the user.
     */
    public String getStatus() {
        return status;
    } // getStatus

    /**
     * Print this user's friends.
     */
    public void printFriends() {
        System.out.println("\nFriends:");
        for(String name: friends) {
            System.out.println(name);
        } // for
    } // printFriends

    /**
     * Print this user's messages.
     */
    public void printMessages() {
        System.out.println("\nMessages:");
        for(Message m: messages) {
            System.out.println("From: " + m.getSender());
            System.out.println(m.getContents());
        } // for
    }
    
} // MyFaceUser
