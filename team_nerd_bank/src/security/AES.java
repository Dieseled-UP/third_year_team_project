package security;

import gui.Details;
import gui.Login;

import javax.crypto.Cipher;

import java.security.spec.KeySpec;

import javax.crypto.spec.PBEKeySpec;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.SecretKeyFactory;

import java.security.AlgorithmParameters;

import javax.crypto.spec.IvParameterSpec;
import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardEndHandler;

import com.sun.istack.internal.FinalArrayList;

import connect.Query;

import java.util.ArrayList;
import java.util.concurrent.AbstractExecutorService;

public class AES {
	
	private static int pin = Integer.parseInt(Login.gitAutoPin());
	private static ArrayList<String> details = Query.getLogin(pin);
	private static ArrayList<String> uncryptedArrayList = new ArrayList<>();
	
	private static Cipher dcipher;
	private final byte[] SALT = new String("TheBestSaltEver").getBytes();
	private int iterationCount = 1024;
	private int keyStrength = 128;
	private static SecretKey key;
	private static byte[] iv;
	private static byte[] decryptedData;
	private static byte[] utf8;
	private final String MAGIC = new String("ABCDEFGHIJKL");
	
	public AES() throws Exception {
		SecretKeyFactory factory = SecretKeyFactory
				.getInstance("PBKDF2WithHmacSHA1");

		KeySpec spec = new PBEKeySpec(MAGIC.toCharArray(), SALT,
				iterationCount, keyStrength);
		SecretKey tmp = factory.generateSecret(spec);
		key = new SecretKeySpec(tmp.getEncoded(), "AES");
		dcipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	}

	public static String encrypt(String data) throws Exception {
		dcipher.init(Cipher.ENCRYPT_MODE, key);
		AlgorithmParameters params = dcipher.getParameters();
		iv = params.getParameterSpec(IvParameterSpec.class).getIV();
		byte[] utf8EncryptedData = dcipher.doFinal(data.getBytes());
		String base64EncryptedData = new sun.misc.BASE64Encoder()
				.encodeBuffer(utf8EncryptedData);

	//	System.out.println("IV "
		//		+ new sun.misc.BASE64Encoder().encodeBuffer(iv));
	//	System.out.println("Encrypted Data " + base64EncryptedData);
		return base64EncryptedData;
	}

	public static String decrypt(String base64EncryptedData) throws Exception {
		dcipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(iv));
		decryptedData = new sun.misc.BASE64Decoder()
				.decodeBuffer(base64EncryptedData);
		utf8 = dcipher.doFinal(decryptedData);
		return new String(utf8, "UTF8");
	}
	
	public static void encryptPinPass(String pinIn, String passIn)
	{
		try {
			
			 String encryptedPin = encrypt(pinIn);
			 String encryptedPass = encrypt(passIn);
			 
			 System.out.println("pin: " + pinIn);
			 System.out.println("encrypted pin: " + encryptedPin);
			 System.out.println("pass: " + passIn);
			 System.out.println("encrypted pass: " + encryptedPass);

		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static ArrayList<String> decryptedPinPass() {
		
		try {
			
			uncryptedArrayList.add(decrypt(details.get(0)));
			uncryptedArrayList.add(decrypt(details.get(1)));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return uncryptedArrayList;
	}
	
	public String getKey()
	{
		return MAGIC;
	}
}