package security;

import java.io.UnsupportedEncodingException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.KeySpec;
import java.util.ArrayList;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;

import org.apache.commons.codec.binary.Base64;

import connect.Query;

public class AES {

	private static ArrayList<String> uncryptedArrayList = new ArrayList<>();
	private static String pinString;
	
	private SecretKeyFactory factory;
	private KeySpec spec;
	private SecretKey tmp;
	private Cipher dcipher;
	private final byte[] SALT = new String("TheBestSaltEvers").getBytes();
	private int iterationCount = 1024;
	private int keyStrength = 128;
	private SecretKey key;
	private byte[] iv;
	private byte[] decodedData;
	private byte[] decryptedData;
	private byte[] pin;
	private byte[] pass;
	private byte[] encryptedData;
	private byte[] encodedData;
	private final String MAGIC = new String("ABCDEFGHIJKLMNOP");
	private AlgorithmParameters params;

	public AES() {

		try {
			
			factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			spec = new PBEKeySpec(MAGIC.toCharArray(), SALT, iterationCount, keyStrength);
			tmp = factory.generateSecret(spec);
			key = new SecretKeySpec(tmp.getEncoded(), "AES");
			dcipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			params = dcipher.getParameters();
			iv = params.getParameterSpec(IvParameterSpec.class).getIV();
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidParameterSpecException e) {
			e.printStackTrace();
		}
	}

	public byte[] encrypt(String data) {

		try {
			
			dcipher.init(Cipher.ENCRYPT_MODE, key);
			encryptedData = dcipher.doFinal(data.getBytes("UTF8"));
			encodedData = new Base64().encode(encryptedData);
			
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return encodedData;
	}

	public String decrypt(byte[] data) {

		// For testing purpose please remove
		System.out.println(new String(data) + " In decrypt method");
		
		String result = null;
		
		try {
			
			dcipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(iv));
			decodedData = new Base64().decode(data);
			decryptedData = dcipher.doFinal(decodedData);
			
			result = new String(decryptedData, "UTF8");
			
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		// For testing purpose please remove
		System.out.println(result);
				
		return result;
	}

	/**
	 * Method to take data and encrypt it then send to database
	 * 
	 * @param auto
	 * @param pinIn
	 * @param passIn
	 * @param num
	 */
	public void encryptPinPass(String auto, String pinIn, String passIn, int num) {

		try {

			// For testing purpose please remove
			System.out.println(auto + " " + pinIn + " " + passIn + " " + num);

			// Encrypt pin and password
			byte[] pinString = encrypt(pinIn);
			byte[] passString = encrypt(passIn);

			// Send data to the database
			if (Query.setPinPass(auto, pinString, passString, num)) {

				// Let user know the registration as been successful
				JOptionPane.showMessageDialog(null, "Your registration has been complete");

			} else {

				// Let user know a problem has occurred
				JOptionPane.showMessageDialog(null, "Sorry an error has occurred");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Method to decrypt the data from the database
	 * 
	 * @return ArrayList uncryptedArrayList
	 */
	public ArrayList<String> decryptedPinPass() {

		try {

			// For testing purpose please remove
			System.out.println(pinString + " AES class");

			// Get pin and password from database
			pin = Query.getDBPin(pinString);
			pass = Query.getDBPass(pinString);

			// For testing purpose please remove
			System.out.println(new String(pin) + " " + new String(pass) + " In decryted PinPass method");

			// Add decrypted data to List
			uncryptedArrayList.add(decrypt(pin));
			uncryptedArrayList.add(decrypt(pass));

		} catch (Exception e) {

			e.printStackTrace();
		}

		// For testing purpose please remove
		System.out.println(uncryptedArrayList.get(0) + " " + uncryptedArrayList.get(1));

		// Return the List
		return uncryptedArrayList;
	}

	public static void getAutoPin(String autoPin) {

		pinString = autoPin;
	}
}