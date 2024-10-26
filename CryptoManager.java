import static org.junit.Assert.assertEquals;

/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. The first approach is called the Caesar Cipher and is a
 * simple �substitution cipher� where characters in a message are replaced by a
 * substitute character. The second approach, due to Giovan Battista Bellaso,
 * uses a key word, where each character in the word specifies the offset for
 * the corresponding character in the message, with the key word wrapping around
 * as needed.
 * 
 * @author Farnaz Eivazi
 * @version 7/16/2022
 */
/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: This class manages static methods to encrypt and decrypt text 
 * according to Caesar and Bellaso methods.
 * Due: 10/25/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Chandra S. Krishnan
*/
public class CryptoManager {
	
	private static final char LOWER_RANGE = ' '; // this is SPACE - corresponds to 32 ASCII
	private static final char UPPER_RANGE = '_'; // corresponds to 95 ASCII
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1; // RANGE = 64 based on this calculation

	/** JAVADOC Style
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds (String plainText) {
		// throw new RuntimeException("method not implemented");  
		// "static" method is static when ???
		//for ex. we don't need to create a object in this case
		// ERROR - "UNREACHABLE CODE" changed after "throw new .." was removed
		for (int i = 0; i < plainText.length(); i++)
		{
			char ch = plainText.charAt(i);
			if (ch < LOWER_RANGE || ch > UPPER_RANGE) // checks if it is between 32 and 95
				{
					return false;
				}
		}	
		return true;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption(String plainText, int key) {
		// throw new RuntimeException("method not implemented");	
		//	If the plainText is not in bounds, the method returns: 
		// o The selected string is not in bounds, Try again.
				if(!isStringInBounds(plainText)) 
				{
					// Note: LOWER AND UPPER ASCII VALUES ARE 64 TO 95 AND SET TO FINAL
					return "The selected string is not in bounds, Try again.";
					// it is failing this test in "CryptoManagerTestPublic"
					// assertEquals("The selected string is not in bounds, Try again.", 
					// CryptoManager.caesarEncryption("bye", 3));
					// problem is "missing period" after "Try again" - unforgiving :)
				}
				
				String encryptedString = "";
				// variable key is assigned the remainder of the division of key by RANGE
				key = key % RANGE;
				int length = plainText.length();
				for (int i = 0; i < length; i++) 
				{
					int c = (int)plainText.charAt(i) + key;
					while(c > UPPER_RANGE) 
						{
							c -= RANGE;
						}
					encryptedString += (char)c;
				}
				return encryptedString;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption (String plainText, String bellasoStr) {
		// throw new RuntimeException("method not implemented");
		String encryptedString = "";
		int size = plainText.length();
		
		for (int i = 0; i < size; i++) {
			int b = i % bellasoStr.length();
			int c = plainText.charAt(i) + bellasoStr.charAt(b);
			
			while (c > UPPER_RANGE) 
				{
					c -= RANGE;
				}
			encryptedString += (char)c;
		}
		return encryptedString;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String caesarDecryption (String encryptedText, int key) {
		// throw new RuntimeException("method not implemented");
		
		String stringDecrypted = "";
		key = key % RANGE;
		int size = encryptedText.length();
		for (int i = 0; i < size; i++) 
		{
			int c = (char)(encryptedText.charAt(i) - key);
			while (c < LOWER_RANGE) 
				{
					c += RANGE;
				}
			stringDecrypted += (char)c;
		}
		return stringDecrypted;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced 
	 * by the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
		// throw new RuntimeException("method not implemented");
		
		String stringDecrypted = "";
		int size = encryptedText.length();
		
		for (int i = 0; i < size; i++) 
		{
			int b = i % bellasoStr.length();
			int c = encryptedText.charAt(i) - bellasoStr.charAt(b);
			
			while (c < LOWER_RANGE) 
				{
					c += RANGE;
				}
			stringDecrypted +=(char)c;
		}
		return stringDecrypted;
	}
}
