package egy_root;

import java.util.ArrayList;

public class phon_class_parser {
	
public static ArrayList<String> phonparsclass(String CoptWord) {
		
	ArrayList<String> phon_class = new ArrayList<String>();
	
	String CoptWord_mod = CoptWord;
	
	CoptWord_mod = CoptWord_mod.replaceAll("a", "v");
	CoptWord_mod = CoptWord_mod.replaceAll("e", "v");
	CoptWord_mod = CoptWord_mod.replaceAll("o", "v");
	CoptWord_mod = CoptWord_mod.replaceAll("u", "v");
	CoptWord_mod = CoptWord_mod.replaceAll("i", "v");
	CoptWord_mod = CoptWord_mod.replaceAll("I", "v");
	CoptWord_mod = CoptWord_mod.replaceAll("E", "v");
	CoptWord_mod = CoptWord_mod.replaceAll("O", "v");
	CoptWord_mod = CoptWord_mod.replaceAll("U", "v");
	CoptWord_mod = CoptWord_mod.replaceAll("ä", "v");
	CoptWord_mod = CoptWord_mod.replaceAll("ë", "v");
	CoptWord_mod = CoptWord_mod.replaceAll("ï", "v");
		
		for (int i = 0; i < CoptWord_mod.length(); i++){
			
			
			
			if ((CoptWord_mod.substring(i, i+1)).equals("v")){
				
				phon_class.add("V");
				
			}else{
				
				phon_class.add("C");
				
			}
			
			
		}
	
		
		return phon_class;
	}

}
