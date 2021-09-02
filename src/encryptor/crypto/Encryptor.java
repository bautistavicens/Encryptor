package encryptor.crypto;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

/**
 * @author Bautista Vicens.
 *
 */
	
public class Encryptor {;
	private static final String unicodeFormat = "UTF-8";
	private static final String encryptionAlgorithm = "AES";
	
    // Suppresses default constructor, ensuring non-instantiability.
	private Encryptor() {
		
	}
	
	//Use this method to generate a Cipher.
	public static Cipher cipherGen() {
	
		try {
			//Generates a Cipher using "AES" algorithm.  
			return Cipher.getInstance(encryptionAlgorithm);
			
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			
			e.printStackTrace();
			return null;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}

	}
	
	
	//Use this method to generate a SecretKey.
	public static SecretKey keyGen() throws NoSuchAlgorithmException, NullPointerException, Exception {
		try {
			//Generates a key with "AES" algorithm
			KeyGenerator generatedKey  = KeyGenerator.getInstance(encryptionAlgorithm);
		
			SecretKey finalKey = generatedKey.generateKey();

			return finalKey;
		
		} catch (NoSuchAlgorithmException  | NullPointerException e) {
			
			e.printStackTrace();
			return null;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
			
		}
	}
	private static byte[] toBytes(char[] chars) {
		  CharBuffer charBuffer = CharBuffer.wrap(chars);
		  ByteBuffer byteBuffer = Charset.forName(unicodeFormat).encode(charBuffer);
		  byte[] bytes = Arrays.copyOfRange(byteBuffer.array(),
		            byteBuffer.position(), byteBuffer.limit());
		  Arrays.fill(byteBuffer.array(), (byte) 0); // clear sensitive data
		  return bytes;
	}
	
	public static byte[] encryptData(char[] dataToEncrypt, SecretKey key, Cipher cipher) {
		try {
			
			byte[] dataB = toBytes(dataToEncrypt);
			
			cipher.init(Cipher.ENCRYPT_MODE, key);
			
			byte[] dataEncrypted = cipher.doFinal(dataB);
			
			return dataEncrypted;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static char[] decryptData(byte[] dataToDecrypt, SecretKey key, Cipher cipher) {
		try {
			cipher.init(Cipher.DECRYPT_MODE, key);
			
			byte[] dataDecrypted = cipher.doFinal(dataToDecrypt);
		
			String dataString = new String(dataDecrypted) ;
			
			char[] dataChar = dataString.toCharArray();
			
			return dataChar; 
		
		} catch (Exception e) {
			return null;
		}
	}
}
