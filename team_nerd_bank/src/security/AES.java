package security;

import javax.crypto.Cipher;

import java.security.spec.KeySpec;

import javax.crypto.spec.PBEKeySpec;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.SecretKeyFactory;

import java.security.AlgorithmParameters;

import javax.crypto.spec.IvParameterSpec;

import java.util.concurrent.AbstractExecutorService;

public class AES {
	Cipher dcipher;

	private byte[] salt = new String("TheBestSaltEver").getBytes();
	private int iterationCount = 1024;
	private int keyStrength = 128;
	private SecretKey key;
	private byte[] iv;
	private byte[] decryptedData;
	private byte[] utf8;

	void Encryption(String passPhrase) throws Exception {
		SecretKeyFactory factory = SecretKeyFactory
				.getInstance("PBKDF2WithHmacSHA1");

		KeySpec spec = new PBEKeySpec(passPhrase.toCharArray(), salt,
				iterationCount, keyStrength);
		SecretKey tmp = factory.generateSecret(spec);
		key = new SecretKeySpec(tmp.getEncoded(), "AES");
		dcipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	}

	public String encrypt(String data) throws Exception {
		dcipher.init(Cipher.ENCRYPT_MODE, key);
		AlgorithmParameters params = dcipher.getParameters();
		iv = params.getParameterSpec(IvParameterSpec.class).getIV();
		byte[] utf8EncryptedData = dcipher.doFinal(data.getBytes());
		String base64EncryptedData = new sun.misc.BASE64Encoder()
				.encodeBuffer(utf8EncryptedData);

		System.out.println("IV "
				+ new sun.misc.BASE64Encoder().encodeBuffer(iv));
		System.out.println("Encrypted Data " + base64EncryptedData);
		return base64EncryptedData;
	}

	public String decrypt(String base64EncryptedData) throws Exception {
		dcipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(iv));
		decryptedData = new sun.misc.BASE64Decoder()
				.decodeBuffer(base64EncryptedData);
		utf8 = dcipher.doFinal(decryptedData);
		return new String(utf8, "UTF8");
	}
	
	public static void getPinPass(String pinIn, String passIn)
	{
		
	}

}