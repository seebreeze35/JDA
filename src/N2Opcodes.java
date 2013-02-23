/*
 * Nios II Opcodes Reference Class
 * by Chris Coykendall
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
	
	public static String getICodeFromHex(String hex) {
		if (hex.length()<2) 
			return null;
		int dec = Integer.parseInt(
				hex.substring(hex.length()-2, hex.length())
				, 16);
		return ITypes[dec];
	}
	
	public static String getICodeFromBin(String bin) {
		if (bin.length()<8) 
			return null;
		int dec = Integer.parseInt(
				bin.substring(bin.length()-8,bin.length())
				, 2);
		return ITypes[dec];
	}
	
	
	public static String getRCodeFromHex(String hex) {
		if (hex.length()<2) 
			return null;
		int dec = Integer.parseInt(
				hex.substring(hex.length()-2, hex.length())
				, 16);
		return RTypes[dec];
	}
	
	public static String getRCodeFromBin(String bin) {
		if (bin.length()<8) 
			return null;
		int dec = Integer.parseInt(
				bin.substring(bin.length()-8,bin.length())
				, 2);
		return RTypes[dec];
	}
	
	// TODO Need function to check 3A R-type in I-type, then R-type 
	
	public static void main(String[] args) {
		
		// Test call opcode (decimal 0)
		System.out.println(ITypes[0]);
		
		// Test getICodeFromHex
		System.out.println(getICodeFromHex("3A")); // r-type
		System.out.println(getICodeFromHex("00")); // call
		System.out.println(getICodeFromHex("0000001C")); // xori
		System.out.println(getICodeFromHex("3C")); // xorhi
		System.out.println(getICodeFromHex("3F")); // undef
		
		// Test getICodeFromBin
		System.out.println(getICodeFromBin("00000000")); // call
		System.out.println(getICodeFromBin("00010000")); // cmplti
		System.out.println(getICodeFromBin("00111010")); // R-type
		
		// Test getRCodeFromHex
		System.out.println(getRCodeFromHex("1C")); // nextpc
		
		// Test getRCodeFromBin
		System.out.println(getRCodeFromBin("00000001")); // eret
		System.out.println(getRCodeFromBin("00111011")); // sra
		
		
	}
	
	
}
