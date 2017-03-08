package egy_root;

import java.util.ArrayList;

public class phon_parser {
	
public static ArrayList<String> phonpars(String CoptWord) {
		
	ArrayList<String> phonemes = new ArrayList<String>();
	
	String CoptWord_mod = CoptWord;
	
		
		for (int i = 0; i < CoptWord_mod.length(); i++){
			
				phonemes.add(CoptWord_mod.substring(i, i+1));
			
		}
	
		
		return phonemes;
	}

}
