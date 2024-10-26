import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CryptoManagerTestStudent {
	CryptoManager cryptoManager; // copied from CryptoManagerTestPublic

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testIsStringInBounds() {
		// fail("Not yet implemented");
		assertTrue(CryptoManager.isStringInBounds("WHAT IS WRONG")); // has to UPPERCASE - checks right
		//assertTrue(CryptoManager.isStringInBounds("WHAT iswrong")); // part lower case - checks wrong
		
		assertFalse(CryptoManager.isStringInBounds("java"));
		// False is OK since string is in lowercase
		
	}

	@Test
	void testCaesarEncryption() {
		// fail("Not yet implemented");
		// caesarEncryption(String plainText, int key)
		assertEquals("DEF", CryptoManager.caesarEncryption("ABC", 3));
		//			desired output						passed string, key = 3						
		assertEquals("UWY", CryptoManager.caesarEncryption("ACE", 20));
		
		assertEquals("SPDLWJMMF", CryptoManager.caesarEncryption("ROCKVILLE", 1));
	}

	@Test
	void testBellasoEncryption() {
		// fail("Not yet implemented");
		// bellasoEncryption (String plainText, String bellasoStr)
		assertEquals("UJ^^((HT^X[YYM\"", CryptoManager.bellasoEncryption("MERRY CHRISTMAS", "HELLO"));
		// 			encrypted string									plainText		bellaso string (key)
		assertEquals("IGMNP", CryptoManager.bellasoEncryption("HELLO", "AB"));
		
		assertEquals("H'NR0TTR]", CryptoManager.bellasoEncryption("COME HOME", "EXAMPLE"));
	}

	@Test
	void testCaesarDecryption() {
		// fail("Not yet implemented");
		// caesarDecryption (String encryptedText, int key)
		assertEquals("TESTING", CryptoManager.caesarDecryption("UFTUJOH", 1));
		// 		dexcrypted string							encrypted string : key 
		assertEquals("ROCKVILLE", CryptoManager.caesarDecryption("SPDLWJMMF", 1));
		
		assertEquals("ACE", CryptoManager.caesarDecryption("UWY", 20));
	}

	@Test
	void testBellasoDecryption() {
		// fail("Not yet implemented");
		assertEquals("MERRY CHRISTMAS", CryptoManager.bellasoDecryption("UJ^^((HT^X[YYM\"", "HELLO"));
		//			Decrypted string									plainText		key 
		
		assertEquals("HELLO", CryptoManager.bellasoDecryption("IGMNP", "AB"));
		
		assertEquals("COME HOME", CryptoManager.bellasoDecryption("H'NR0TTR]", "EXAMPLE"));
	}

}
