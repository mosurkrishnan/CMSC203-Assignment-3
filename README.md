# CMSC203-Assignment-3
A Java program to encrypt and decrypt a phrase using two similar approaches, each insecure by modern standards.  
The first approach is called the Caesar Cipher and is a simple “substitution cipher” where characters in a message are replaced by a substitute character.

The second approach, due to Giovan Battista Bellaso (b 1505, d 1581), uses a key word, where each character in the word specifies the offset for the corresponding character in the message, with the key word wrapping around as needed.  
Data Manager class – CryptoManager
•	Implement each of the methods specified in this file.  This version as provided will print error messages in the console, because they are just skeletons.
Each of the methods are static, so there is no need to create an instance of the Data Manager. 
The methods are described below.
o	public static boolean isStringInBounds (String plainText)
	This method determines if a string is within the allowable bounds of ASCII codes according to the LOWER_RANGE and UPPER_RANGE characters.  
	The parameter plainText is the string to be encrypted.  
	The method returns true if all characters are within the allowable bounds, false if any character is outside.
o	public static String caesarEncryption (String plainText, int key)
	This method encrypts a string according to the Caesar Cipher.  
	The parameter plainText is an uppercase string to be encrypted. 
	The parameter integer key specifies an offset and each character in plainText is replaced by the character the specified distance away from it.  
	The method returns the encrypted string.
	If the plainText is not in bounds, the method returns: 
o	The selected string is not in bounds, Try again.
o	public static String caesarDecryption (String encryptedText, int key)
	This method decrypts a string according to the Caesar Cipher. 
	This is the inverse of the caesarEncryption method.  
	The parameter encryptedText is the encrypted string to be decrypted, and key is the integer used to encrypt the original text. 
	The integer key specifies an offset and each character in encryptedText is replaced by the character "offset" characters before it.  
	The method returns the original plain text string.
o	public static String bellasoDecryption (String plainText, String bellasoStr)
	This method encrypts a string according to the Bellaso Cipher.  
	Each character in plainText is offset according to the ASCII value of the corresponding character in bellasoStr, which is repeated to correspond to the length of plaintext. The method returns the encrypted string.
o	public static String bellasoDecryption(String encryptedText, String bellasoStr)
	This method decrypts a string according to the Bellaso Cipher.  
	Each character in encryptedText is replaced by the character corresponding to the character in bellasoStr, which is repeated to correspond to the length of plainText.
	This is the inverse of the bellasoDecryption method. 
	The parameter encryptedText is the encrypted string to be decrypted, 
	The parameter bellasoStr is the string used to encrypt the original text.  
	The method returns the original plain text string.
Add additional methods if you wish to make your logic easier to follow.

GUI Driver class – FXDriver and FXMainPane 
A Graphical User Interface (GUI) is provided.  Be sure that the GUI will compile and run with your methods. The GUI will not compile if your method headers in CryptoManager.java are not exactly in the format specified.  When you first run the application, your methods will all throw exceptions, which will be caught by the GUI and printed out in the console. 
The GUI takes care of capitalizing your input strings.
Do not modify the GUI. 

JUnit Test
Two JUnit test files have been provided; CryptoManagerGFATest and CryptoManagerTestPublic.
Once your methods are implemented, run each JUnit test.  Ensure that the JUnit tests all succeed.
You must create another JUnit test file, named CryptoManagerTestStudent to test every public method of the CryptoManager class, except setUp and tearDown methods. 
 
 You can take a look at provided CryptoManagerTestPublic and create similar test cases, however your test string values must be different. 
