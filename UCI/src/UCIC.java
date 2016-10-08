import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import UCI.UCICompiler;

public class UCIC {
	
	
	public static void main(String[] args) {	
		
		if (args.length == 0) {
			System.out.println("Missing filename as argument");
			return;
		}
				
		UCICompiler compiler = new UCICompiler();
		
		try {
			List<String> assembly = compiler.compileFile(args[0]);
			compiler.saveProgram(assembly, args[0].split("\\.")[0] + ".asm");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace(System.out);
		}
	}
}