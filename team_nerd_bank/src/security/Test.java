/*11 Mar 2015
team_nerd_bank
10:08:44
*/

package security;

import java.util.ArrayList;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;
import com.sun.org.apache.xml.internal.security.encryption.EncryptedData;

import connect.Query;

public class Test {
    
    public static void main(String[] args) throws Exception {
 
        
      Query test = new Query();
      
      test.getLogin(703809876);
      
      ArrayList<String> pinPass = test.getLogin(703809876);
      
      String pinString = new String(pinPass.get(0));
      String pasString = new String(pinPass.get(1));
      
      AES encAes = new AES();
      encAes.encryptPinPass(pinString, pasString);
    }
}