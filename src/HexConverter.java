import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class HexConverter {

	/**
	 * Enter a 6 number hex value ex. 10c40004
	 * Currently it does not check for what type of instruction it is
	 * so it just translates it into all 3 types and prints out the values
	 */
	public static void main(String[] args) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
		String hex;
		try {
			hex = in.readLine();
			int i = Integer.parseInt(hex, 16);
		    String Bin = Integer.toBinaryString(i);

		    System.out.print(Bin);
		    System.out.print(" <- Most significant bit\n");
		    char[] bits = Bin.toCharArray();
		    for(int i1 = 0; i1 < bits.length / 2; i1++){
		       char temp = bits[i1];
		       bits[i1] = bits[bits.length - i1 - 1];
		       bits[bits.length - i1 - 1] = temp;
		    }
		    String Bits = new String(bits);
		    while(Bits.length()<=31){
		    Bits=Bits+("0");
		    }
		   // System.out.print(Bits+"\n");
		    
		    System.out.print("I-Type\n");
			Itype(Bits);
		    System.out.print("R-Type\n");
			Rtype(Bits);
		    System.out.print("J-Type\n");
			Jtype(Bits);

		} catch (IOException e) {
			System.out.print("Not a valid hex entry.");
			e.printStackTrace();
		}

	}
	
	public static void Itype(String Binary){
		char[] bits = Binary.toCharArray();
		System.out.print("Opcode\n");
		for(int j=5;j>=0;j--){
    	System.out.print(bits[j]);
    	}
		System.out.print("\nIMM\n");
		for(int j=21;j>=7;j--){
	    System.out.print(bits[j]);
	    }
		System.out.print("\nrB\n");
		for(int j=26;j>=22;j--){
	    System.out.print(bits[j]);
	    }
		System.out.print("\nrA\n");
		for(int j=31;j>=27;j--){
	    System.out.print(bits[j]);
	    }
	}
	
	public static void Rtype(String Binary){
		char[] bits = Binary.toCharArray();
		System.out.print("Opcode\n");
		for(int j=5;j>=0;j--){
    	System.out.print(bits[j]);
    	}
		System.out.print("\nIMM\n");
		for(int j=16;j>=7;j--){
	    System.out.print(bits[j]);
	    }
		System.out.print("\nrC\n");
		for(int j=21;j>=17;j--){
	    System.out.print(bits[j]);
	    }
		System.out.print("\nrB\n");
		for(int j=26;j>=22;j--){
	    System.out.print(bits[j]);
	    }
		System.out.print("\nrA\n");
		for(int j=31;j>=27;j--){
	    System.out.print(bits[j]);
		}
	}

	public static void Jtype(String Binary){
		char[] bits = Binary.toCharArray();
		System.out.print("Opcode\n");
		for(int j=5;j>=0;j--){
    	System.out.print(bits[j]);
    	}
		System.out.print("\nIMM26\n");
		for(int j=31;j>=7;j--){
	    System.out.print(bits[j]);
	    }
	}

}
