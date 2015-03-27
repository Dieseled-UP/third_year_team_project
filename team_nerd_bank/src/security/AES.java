package security;

import java.security.AlgorithmParameters;
import java.security.spec.KeySpec;
import java.util.ArrayList;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;

import connect.Query;

public class AES {

	private static int pin;
	private static ArrayList<String> details;
	private static ArrayList<String> encryptedList = new ArrayList<>();
	private static ArrayList<String> uncryptedArrayList = new ArrayList<>();

	private Cipher dcipher;
	private final byte[] SALT = new String("TheBestSaltEver").getBytes();
	private int iterationCount = 1024;
	private int keyStrength = 128;
	private SecretKey key;
	private byte[] iv;
	private byte[] decryptedData;
	private byte[] utf8;
	private final String MAGIC = new String("ABCDEFGHIJKL");

	public static void getAutoPin(String item) {

		pin = Integer.parseInt(item);
		details = Query.getLogin(pin);
	}

	public AES() throws Exception {
		
		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

		KeySpec spec = new PBEKeySpec(MAGIC.toCharArray(), SALT, iterationCount, keyStrength);
		SecretKey tmp = factory.generateSecret(spec);
		key = new SecretKeySpec(tmp.getEncoded(), "AES");
		dcipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	}

	public String encrypt(String data) throws Exception {
		
		dcipher.init(Cipher.ENCRYPT_MODE, key);
		AlgorithmParameters params = dcipher.getParameters();
		iv = params.getParameterSpec(IvParameterSpec.class).getIV();
		byte[] utf8EncryptedData = dcipher.doFinal(data.getBytes());
		String base64EncryptedData = new sun.misc.BASE64Encoder().encodeBuffer(utf8EncryptedData);

		// System.out.println("IV "
		// + new sun.misc.BASE64Encoder().encodeBuffer(iv));
		// System.out.println("Encrypted Data " + base64EncryptedData);
		return base64EncryptedData;
	}

	public String decrypt(String base64EncryptedData) throws Exception {
		
		dcipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(iv));
		decryptedData = new sun.misc.BASE64Decoder().decodeBuffer(base64EncryptedData);
		utf8 = dcipher.doFinal(decryptedData);
		return new String(utf8, "UTF8");
	}

	/**
	 * Method to take data and encrypt it then send to database
	 * @param auto
	 * @param pinIn
	 * @param passIn
	 * @param num
	 */
	public void encryptPinPass(String auto, String pinIn, String passIn, int num) {
		
		try {

			// For testing
			System.out.println(auto + " " + pinIn + " " + passIn + " " + num);
			
			// Encrypt pin and password
			String pinString = encrypt(pinIn);
			String passString = encrypt(passIn);
			
			// Add to ArrayList
			encryptedList.add(auto);
			encryptedList.add(pinString);
			encryptedList.add(passString);

			// Send data to the database
			if (Query.setPinPass(encryptedList, num)) {
				
				JOptionPane.showMessageDialog(null, "Your registation has been complete");
				
			} else {

				JOptionPane.showMessageDialog(null, "Sorry an error has occured");
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	/**
	 * Method to decrypt the data from the database
	 * @return ArrayList uncryptedArrayList
	 */
	public ArrayList<String> decryptedPinPass() {

		try {

			uncryptedArrayList.add(decrypt(details.get(0)));
			uncryptedArrayList.add(decrypt(details.get(1)));
		} catch (Exception e) {

			e.printStackTrace();
		}

		return uncryptedArrayList;
	}

	public String getKey() {
		return MAGIC;
	}
}