/*11 Mar 2015
team_nerd_bank
10:08:44
*/

package security;

public class Test {
    
    public static void main(String[] args) throws Exception {
 
        AES d = new AES();
             
        System.out.println("Encrypted string:" + d.encrypt("Hello"));          
        String encryptedText = d.encrypt("Hello");
        System.out.println("Decrypted string:" + d.decrypt(encryptedText));      
 
    }
}