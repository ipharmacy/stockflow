/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;
// Install the Java helper library from twilio.com/docs/libraries/java
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SmsSender {
    // Find your Account Sid and Auth Token at twilio.com/console
    public static final String ACCOUNT_SID =
            "AC05e372d344e7c393c57ef9a854e1ceb9";
    public static final String AUTH_TOKEN =
            "218204d75b243e4885c0c2b35344b9c8";

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message
                .creator(new PhoneNumber("+21655340453"), // to
                        new PhoneNumber("+18312285377"), // from
                        "Where's Wallace?")
                .create();

        System.out.println(message.getSid());
    }
}
