import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.junit.Test;


public class TestN2Opcodes {

	HashMap<String, String> opcodes;
	
	@Test 
	public void testGetICodeFromHexReturnsForBytes() {
		opcodes = new HashMap<String, String>();
		opcodes.put("3C", "xorhi"); // Valid
		opcodes.put("3F", ""); // Non-exist
		opcodes.put("FF", null); // OOB+
		opcodes.put("-1", null); // OOB-
		String opCode = null;
		for (String hex : opcodes.keySet()) {
			opCode = N2Opcodes.getICodeFromHex(hex);
			assertTrue(hex + " byte lookup returned " + opCode + " not " + 
					opcodes.get(hex), opCode==opcodes.get(hex));	
		}
	}
	
	@Test 
	public void testGetICodeFromHexReturnsForWordsAndNull() {
		opcodes = new HashMap<String, String>();
		opcodes.put("0000001C", "xori"); // Valid
		opcodes.put("0000003F", ""); // Non-exist
		opcodes.put("000000FF", null); // OOB+
		opcodes.put("-1", null); // OOB-
		String opCode = N2Opcodes.getICodeFromHex(null); // Null
		assertTrue("Null word lookup returned " + opCode + " not null", 
				opCode==null);
		for (String hex : opcodes.keySet()) {
			opCode = N2Opcodes.getICodeFromHex(hex);
			assertTrue(hex + " word lookup returned " + opCode + " not " + 
					opcodes.get(hex), opCode==opcodes.get(hex));	
		}
	}
	
	@Test 
	public void testGetICodeFromBinReturnsForBytesAndNull() {
		opcodes = new HashMap<String, String>();
		opcodes.put("00000011", "ldbu"); // Valid
		opcodes.put("00000010", ""); // Non-exist
		opcodes.put("11111111", null); // OOB+
		opcodes.put("-1", null); // OOB-
		String opCode = N2Opcodes.getICodeFromBin(null); // Null
		assertTrue("Null byte lookup returned " + opCode + " not null", 
				opCode==null);
		for (String bin : opcodes.keySet()) {
			opCode = N2Opcodes.getICodeFromBin(bin);
			assertTrue(bin + " byte lookup returned " + opCode + " not " + 
					opcodes.get(bin), opCode==opcodes.get(bin));	
		}
	}
	
	
	// --- R-type function tests
	
	
	@Test 
	public void testGetRCodeFromHexReturnsForWordsAndNull() {
		opcodes = new HashMap<String, String>();
		opcodes.put("0000001C", "nextpc"); // Valid
		opcodes.put("00000022", ""); // Non-exist
		opcodes.put("000000FF", null); // OOB+
		opcodes.put("-2", null); // OOB-
		String opCode = N2Opcodes.getRCodeFromHex(null); // Null
		assertTrue("Null word lookup returned " + opCode + " not null", 
				opCode==null);
		for (String hex : opcodes.keySet()) {
			opCode = N2Opcodes.getRCodeFromHex(hex);
			assertTrue(hex + " word lookup returned " + opCode + " not " + 
					opcodes.get(hex), opCode==opcodes.get(hex));	
		}
			
	}
	
	@Test 
	public void testGetRCodeFromHexReturnsForBytes() {
		opcodes = new HashMap<String, String>();
		opcodes.put("36", "sync"); // Valid
		opcodes.put("22", ""); // Non-exist
		opcodes.put("FF", null); // OOB+
		opcodes.put("-2", null); // OOB-
		String opCode = null;
		for (String hex : opcodes.keySet()) {
			opCode = N2Opcodes.getRCodeFromHex(hex);
			assertTrue(hex + " byte lookup returned " + opCode + " not " + 
					opcodes.get(hex), opCode==opcodes.get(hex));	
		}
	}
	
	@Test 
	public void testGetRCodeFromBinReturnsForBytes() {
		opcodes = new HashMap<String, String>();
		opcodes.put("00000001", "eret"); // Valid
		opcodes.put("00111100", ""); // Non-exist
		opcodes.put("11111111", null); // OOB+
		opcodes.put("-1", null); // OOB-
		String opCode = N2Opcodes.getRCodeFromBin(null); // Null
		assertTrue("Null byte lookup returned " + opCode + " not null", 
				opCode==null);
		for (String bin : opcodes.keySet()) {
			opCode = N2Opcodes.getRCodeFromBin(bin);
			assertTrue(bin + " byte lookup returned " + opCode + " not " + 
					opcodes.get(bin), opCode==opcodes.get(bin));	
		}
	}
	
	@Test 
	public void isRTypeInstructionFromHex() {
		HashMap<String, Boolean> ropcodes = new HashMap<String, Boolean>();
		ropcodes.put("1A02D03A", true); // True
		ropcodes.put("00F1A100", false); // False
		ropcodes.put("000000FF", false); // OOB+
		ropcodes.put("-1", false); // OOB-
		boolean opCode = N2Opcodes.isRTypeInstructionFromHex(null); // Null
		assertTrue("Null word lookup returned true not false", 
				opCode==false);
		for (String hex : ropcodes.keySet()) {
			opCode = N2Opcodes.isRTypeInstructionFromHex(hex);
			assertTrue(hex + " word lookup returned " + opCode + " not " + 
					ropcodes.get(hex), opCode==ropcodes.get(hex));	
		}
	}


}
