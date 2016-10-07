import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class UCIC {
	
	private static Map<String, String> conversions = new HashMap<String, String>();
	
	
	public static void main(String[] args) {
		conversions.put("ADD",   "000");
		conversions.put("AND",   "001");
		conversions.put("SUB",   "010");
		conversions.put("ADDI",  "011");
		conversions.put("SRI",   "100");
		conversions.put("STORE", "101");
		conversions.put("LOAD",  "110");
		conversions.put("JMP",   "111");
		
		conversions.put("R0",   "000");
		conversions.put("R1",   "001");
		conversions.put("R2",   "010");
		conversions.put("R3",  "011");
		conversions.put("R4",   "100");
		conversions.put("R5", "101");
		conversions.put("R6",  "110");
		conversions.put("R7",   "111");
		
		try {
			List<String> allLines = Files.readAllLines(Paths.get(args[0]));
			List<String> wholeProgram = new ArrayList<String>();
			
			int index = 0;
			for (String line : allLines) {
				String[] commands = line.split(" ");
				int cmdLength = 32;
				String correctCommand = "";
				for (String command : commands) {
					if (command.matches("\\d*")) {
						correctCommand += String.format("%0" + cmdLength + "d", Integer.valueOf(Integer.toBinaryString(Integer.valueOf(command))));
						cmdLength = 0;
					} else if (conversions.containsKey(command)) {
						correctCommand += conversions.get(command);
						cmdLength -= conversions.get(command).length();
					} else {
						throw new Exception("command " + command + " in line " + line + " is wrong");
					}
				}
				if (cmdLength > 0)
				{
					correctCommand += String.format("%0" + cmdLength + "d", 0);
				}
				
				BigInteger b = new BigInteger(correctCommand, 2);
				
				wholeProgram.add(index + " " + b.toString(16));
				index++;
			}
			
			Path file = Paths.get(args[0].split("\\.")[0] + ".UCI");
			Files.write(file, wholeProgram, Charset.forName("UTF-8"));
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
