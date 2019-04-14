package cs1302.ce30;

import java.time.LocalDate;
import cs1302.Utility;

/** 
 * Represents a Message in the MyFace system.
 *
 * @author Brad Barnes
 * @version 1.1; Apr 14 2019
 */
public class Message {
    /** Name of the recipient */
    private String recipient;
    /** Name of the sender */
    private String sender;
    /** Contents of the Email message */
    private String contents;

    /**
     * Constructs a new {@code Message} object.  All parameters must be specified
     * and non-null. {@code java.lang.String} parameters must not be empty.   
     *
     * @throws NullPointerException if any argument is {@code null}.
     * @throws IllegalArgumentException if any of the {@code java.lang.String}
     * arguments are empty.
     * @param recipient name of the recipient.
     * @param sender name of the sender.
     * @param contents the message contents (message body).
     */
    public Message(String recipient, String sender,
                   String contents) {
        Utility.nullCheck("Message Constructor", contents, recipient, sender);
        Utility.checkEmpty("Message Constructor", recipient, sender, contents);
	
        this.sender = sender;
        this.recipient = recipient;
        this.contents = contents;
    } // Message
    
    /**
     * Returns the name of the recipient as a 
     * {@code java.lang.String}.
     * @return the name of the recipient of this
     * {@code Message} object.
     */
    public String getRecipient() {
        return recipient;
    } // getRecipient

    /**
     * Returns the name of the sender as a 
     * {@code java.lang.String}.
     * @return the name of the sender of this
     * {@code Message} object.
     */
    public String getSender() {
        return sender;
    } // getSender

    /**
     * Returns the contents of this {@code Message} as a 
     * {@code java.lang.String}.
     * @return the contents of this {@code Message} object.
     */
    public String getContents() {
        return contents;
    } // getSender

} // Message
