/*
* 24 Apr 2015
* team_nerd_bank
* 05:09:27
*/
package connect;

import gui.Register;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;

public class SendSMS {

	 public static final String ACCOUNT_SID = "AC76b39add05f8768fc197824909319d64"; 
	 public static final String AUTH_TOKEN = "32021a31444dee3b133f0991bbd2c966"; 
	 
	 public static void sendVerification() throws TwilioRestException {
		 
		TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN); 
	 
		 // Build the parameters 
		 List<NameValuePair> params = new ArrayList<NameValuePair>();
		 params.add(new BasicNameValuePair("Body", "Here is your generated code " + Register.getAutoPin()+ ".\nPlease take note of this code and keep in a safe place."));
		 params.add(new BasicNameValuePair("To", "+353868781879"));
		 params.add(new BasicNameValuePair("From", "+12018841923"));    
	 
		 MessageFactory messageFactory = client.getAccount().getMessageFactory(); 
		 Message message = messageFactory.create(params);
	 } 
}
