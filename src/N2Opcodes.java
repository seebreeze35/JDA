/**
 * Nios II Opcodes Reference Class
 * @author Chris Coykendall
 *
 */
public class N2Opcodes {

	public static String[] ITypes={
		"call",
		"jmpi",
		"",
		"ldbu",
		"addi",
		"stb",
		"br",
		"ldb",
		"cmpgei",
		"",
		"",
		"ldhu",
		"andi",
		"sth",
		"bge",
		"ldh",
		"cmplti",
		"",
		"",
		"initda",
		"ori",
		"stw",
		"blt",
		"ldw",
		"cmpnei",
		"",
		"",
		"flushda",
		"xori",
		"",
		"bne",
		"",
		"cmpeqi",
		"",
		"",
		"ldbuio",
		"muli",
		"stbio",
		"beq",
		"ldbio",
		"cmpgeui",
		"",
		"",
		"ldhuio",
		"andhi",
		"sthio",
		"bgeu",
		"ldhio",
		"cmpltui",
		"",
		"custom",
		"initd",
		"orhi",
		"stwio",
		"bltu",
		"ldwio",
		"rdprs",
		"",
		"R-type",
		"flushd",
		"xorhi",
		"",
		"",
		""
	};
	
	public static String[] RTypes={
		"",
		"eret",
		"roli",
		"rol",
		"flushp",
		"ret",
		"nor",
		"mulxuu",
		"cmpge",
		"bret",
		"",
		"ror",
		"flushi",
		"jmp",
		"and",
		"",
		"cmplt",
		"",
		"slli",
		"sll",
		"wrprs",
		"",
		"or",
		"mulxsu",
		"cmpne",
		"",
		"srli",
		"srl",
		"nextpc",
		"callr",
		"xor",
		"mulxss",
		"cmpeq",
		"",
		"",
		"",
		"divu",
		"div",
		"rdctl",
		"mul",
		"cmpgeu",
		"initi",
		"",
		"",
		"",
		"trap",
		"wrctl",
		"",
		"cmpltu",
		"add",
		"",
		"",
		"break",
		"",
		"sync",
		"",
		"",
		"sub",
		"srai",
		"sra",
		"",
		"",
		"",
		""
	};
	
	/**
	 * Get immediate instruction by hex value
	 * @param hex the hex opcode
	 * @return the string instruction represented
	 */
	public static String getICodeFromHex(String hex) {
		if (hex==null) return null;
		if (hex.length()<2) 
			return null;
		int dec = Integer.parseInt(
				hex.substring(hex.length()-2, hex.length())
				, 16);
		if (dec>-1 && dec<ITypes.length)	return ITypes[dec];
		else return null;
	}
	
	/**
	 * Get immediate instruction by binary value
	 * @param bin the binary opcode byte string
	 * @return the string instruction represented. null if not 8 binary digits
	 */
	public static String getICodeFromBin(String bin) {
		if (bin==null) return null;
		if (bin.length()!=8) 
			return null;
		int dec = Integer.parseInt(
				bin.substring(bin.length()-8,bin.length())
				, 2);
		if (dec>-1 && dec<ITypes.length)	return ITypes[dec];
		else return null;
	}
	
	/**
	 * Get register instruction by hex value
	 * @param hex the hex opcode
	 * @return the string instruction represented
	 */
	public static String getRCodeFromHex(String hex) {
		if (hex==null) return null;
		if (hex.length()<2) 
			return null;
		int dec = Integer.parseInt(
				hex.substring(hex.length()-2, hex.length())
				, 16);
		if (dec>-1 && dec<RTypes.length)	return RTypes[dec];
		else return null;
	}
	
	/**
	 * Get register instruction by binary value
	 * @param bin the binary opcode byte string
	 * @return the string instruction represented. null if not 8 binary digits
	 */
	public static String getRCodeFromBin(String bin) {
		if (bin==null) return null;
		if (bin.length()!=8) 
			return null;
		int dec = Integer.parseInt(
				bin.substring(bin.length()-8,bin.length())
				, 2);
		if (dec>-1 && dec<RTypes.length)	return RTypes[dec];
		else return null;
	}
	
	/**
	 * Checks if least significant byte is 3A, indicating an R-type
	 * instruction
	 * @param hex the least significant byte
	 * @return true if it is an R-type (==3A)
	 */
	public static boolean isRTypeInstructionFromHex(String hex) {
		// TODO Need function to check 3A R-type in I-type, then R-type
		if (hex==null) return false;
		if (hex.length()<2) 
			return false;
		int dec = Integer.parseInt(
				hex.substring(hex.length()-2, hex.length())
				, 16);
		if (dec==0x3A) return true;
		else return false;
	}
	
}
