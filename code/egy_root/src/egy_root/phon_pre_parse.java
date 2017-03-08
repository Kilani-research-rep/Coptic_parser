package egy_root;

import java.util.ArrayList;

public class phon_pre_parse {
	
public static String phonpars(String CoptWord, String gender) {
		
	ArrayList<String> phonemes = new ArrayList<String>();
	ArrayList<String> phonemes_vow = new ArrayList<String>();
	
	String basic_word = CoptWord;
	String word_res = "";
	
	//------
	
		int len = basic_word.length();
		
		basic_word = basic_word.replaceAll("ou", "W");
		basic_word = basic_word.replaceAll("ei", "J");
		
		basic_word = basic_word.replaceAll("i", "J");
		basic_word = basic_word.replaceAll("u", "w");
		
		String basic_word_vow = basic_word;
		
		basic_word_vow = basic_word_vow.replaceAll("a", "V");
		basic_word_vow = basic_word_vow.replaceAll("e", "V");
		basic_word_vow = basic_word_vow.replaceAll("o", "V");
		basic_word_vow = basic_word_vow.replaceAll("u", "V");
		basic_word_vow = basic_word_vow.replaceAll("i", "V");
		basic_word_vow = basic_word_vow.replaceAll("I", "V");
		basic_word_vow = basic_word_vow.replaceAll("E", "V");
		basic_word_vow = basic_word_vow.replaceAll("O", "V");
		basic_word_vow = basic_word_vow.replaceAll("U", "V");
		basic_word_vow = basic_word_vow.replaceAll("ä", "v");
		basic_word_vow = basic_word_vow.replaceAll("ë", "v");
		basic_word_vow = basic_word_vow.replaceAll("ï", "v");
		
		basic_word_vow = basic_word_vow.replaceAll("W", "W");
		basic_word_vow = basic_word_vow.replaceAll("J", "J");
		
		
		
		//------pre-parsing
		
		
		
		
		//----
		
	int nr_vow = 0;
	
	for (int i = 0; i < basic_word_vow.length(); i++){
		
		if(basic_word_vow.substring(i, i+1).equals("V") 
				|| basic_word_vow.substring(i, i+1).equals("v")
				|| basic_word_vow.substring(i, i+1).equals("W")
				|| basic_word_vow.substring(i, i+1).equals("J")){
			
			nr_vow++;
			
		}
		
	}
	
	//--- case in which there is only one vowel
	
	if (nr_vow == 1){
		basic_word = basic_word.replaceAll("i", "I");
		basic_word = basic_word.replaceAll("J", "I");
		basic_word_vow = basic_word_vow.replaceAll("J", "V");
		basic_word = basic_word.replaceAll("W", "O");
		basic_word_vow = basic_word_vow.replaceAll("W", "V");
		word_res = basic_word ;
	}else{
	
	
	//--- fem ending
	
	if (gender.equals("f") 
			&& nr_vow > 1
			&& basic_word.substring(basic_word.length()-1, basic_word.length()).equals("e")){
				
				char[] stringChars = basic_word.toCharArray();
				stringChars[basic_word.length()-1] = 'ë';
				basic_word = String.valueOf(stringChars) + "t";
				basic_word_vow = basic_word_vow + "t";
				
	}
	
	//---- general replacements
	
	//------ create arrays
	
	for (int i = 0; i < basic_word.length(); i++){

			phonemes.add(basic_word.substring(i, i+1));
		
	}
	
	for (int i = 0; i < basic_word_vow.length(); i++){
		if ((basic_word_vow.substring(i, i+1)).equals("V")){
			
			phonemes_vow.add("V");
			
		}else if((basic_word_vow.substring(i, i+1)).equals("v")){
			
			phonemes_vow.add("v");
			
		}else if((basic_word_vow.substring(i, i+1)).equals("J")){
			
			phonemes_vow.add("J");
			
		}else if((basic_word_vow.substring(i, i+1)).equals("W")){
			
			phonemes_vow.add("W");
			
		}else{
			
			phonemes_vow.add("C");
			
		}	
	}
	
	//------
	
	//--- replace aliph
	
	for (int i = 0; i < phonemes_vow.size()-1; i++){
		
		//-- if (e)i(e)i -> II
		if(phonemes_vow.get(i).equals("J") 
				&& phonemes_vow.get(i).equals(phonemes_vow.get(i+1))
				&& phonemes.get(i).equals(phonemes.get(i+1))){
			
			phonemes.set(i, "I");
			phonemes.set(i+1, "I");
			phonemes_vow.set(i, "V");
			phonemes_vow.set(i+1, "V");		
		}
		
		//-- if ouou -> OO
		if(phonemes_vow.get(i).equals("W") 
				&& phonemes_vow.get(i).equals(phonemes_vow.get(i+1))
				&& phonemes.get(i).equals(phonemes.get(i+1))){
			
			phonemes.set(i, "O");
			phonemes.set(i+1, "O");
			phonemes_vow.set(i, "V");
			phonemes_vow.set(i+1, "V");		
		}
		
		
	}
	
	for (int i = 0; i < phonemes_vow.size()-1; i++){
		
		if(phonemes_vow.get(i).equals("V") 
				&& phonemes_vow.get(i).equals(phonemes_vow.get(i+1))
				&& phonemes.get(i).equals(phonemes.get(i+1))){
			
			phonemes.set(i+1, "ʔ");
			phonemes_vow.set(i+1, "C");
			
			//-- turning all the J/W into semivows, and all the a/e into ä/ë
			for (int n = 0; n < phonemes.size(); n++){
				
				if (n != i){
					
					if (phonemes.get(n).equals("a")){
						phonemes.set(n, "ä");
						phonemes_vow.set(n, "v");	
					}
					if (phonemes.get(n).equals("e")){
						phonemes.set(n, "ë");
						phonemes_vow.set(n, "v");	
					}
					if (phonemes.get(n).equals("J")){
						phonemes.set(n, "j");
						phonemes_vow.set(n, "C");	
					}					
					if (phonemes.get(n).equals("W")){
						phonemes.set(n, "w");
						phonemes_vow.set(n, "C");	
					}
					
				}
			}
			
		}
		
	}
	

	
	//--------
	//------
	
	for (int i = 0; i < phonemes_vow.size(); i++){
	
		//-- replace VJ -> Vj
		if (phonemes_vow.get(i).equals("J") &&
				i != 0 && 
				phonemes_vow.get(i-1).equals("V")){
					phonemes_vow.set(i, "C");
					phonemes.set(i, "j");
		}
		if (phonemes_vow.get(i).equals("J") &&
				i != phonemes_vow.size()-1 && 
				phonemes_vow.get(i+1).equals("V")){
					phonemes_vow.set(i, "C");
					phonemes.set(i, "j");
		}
		
		//-- replace VW -> Vw
		if (phonemes_vow.get(i).equals("W") &&
				i != 0 && 
				phonemes_vow.get(i-1).equals("V")){
					phonemes_vow.set(i, "C");
					phonemes.set(i, "w");
		}
		if (phonemes_vow.get(i).equals("W") &&
				i != phonemes_vow.size()-1 && 
				phonemes_vow.get(i+1).equals("V")){
					phonemes_vow.set(i, "C");
					phonemes.set(i, "w");
		}		
		
	}
	

	//-- if last vowel = a, then turning all previous J/W into semivows, and all the a/e into ä/ë 
	
	for (int i = phonemes_vow.size()-1; i > -1 ; i--){
		
		if(phonemes_vow.get(i).equals("V")){
			
			if(phonemes.get(i).equals("a")){
				
				//-- turning all the other J/W into semivows, and all the a/e into ä/ë
				for (int n = 0; n < phonemes.size(); n++){
					
					if (n != i){
						
						if (phonemes.get(n).equals("a")){
							phonemes.set(n, "ä");
							phonemes_vow.set(n, "v");	
						}
						if (phonemes.get(n).equals("e")){
							phonemes.set(n, "ë");
							phonemes_vow.set(n, "v");	
						}
						if (phonemes.get(n).equals("J")){
							phonemes.set(n, "j");
							phonemes_vow.set(n, "C");	
						}					
						if (phonemes.get(n).equals("W")){
							phonemes.set(n, "w");
							phonemes_vow.set(n, "C");	
						}
						
					}
				}	
				
				break;
				
			}else{
				break;
			}
			
			
		}
		
	}
	
	
	
	//------
	
	//-- if more than one a, then all a -> ä but last 
	
	for (int i = phonemes_vow.size()-1; i > -1 ; i--){
		
		if(phonemes_vow.get(i).equals("V")){
			
			if(phonemes.get(i).equals("a")){
				
				//-- turning all the other J/W into semivows, and all the a/e into ä/ë
				for (int n = 0; n < phonemes.size(); n++){
					
					if (n != i){
						
						if (phonemes.get(n).equals("a")){
							phonemes.set(n, "ä");
							phonemes_vow.set(n, "v");	
						}
					}
				}	
				
				break;
				
			}
		}	
	}
	



	
	// if there is o, O or E then any any a -> ä, any e -> ë, i -> j
	
	for (int i = 0; i < phonemes.size(); i++){
		
		word_res = word_res + phonemes.get(i);
		
	}

	if(word_res.indexOf("o") != -1 || word_res.indexOf("O") != -1 || word_res.indexOf("E") != -1){
		
		word_res = word_res.replaceAll("a", "ä");
		word_res = word_res.replaceAll("e", "ë");
		word_res = word_res.replaceAll("W", "w");
		word_res = word_res.replaceAll("J", "j");
		
	}else{
		
		
		//--- replace cWc and cJc -> cOc and cIc
		
		if (phonemes_vow.size() > 2){
		
		for (int i = 1; i < phonemes_vow.size()-1; i++){
			
			if((phonemes_vow.get(i).equals("W") || phonemes_vow.get(i).equals("J"))
					&& phonemes_vow.get(i-1).equals("C")
					&& phonemes_vow.get(i+1).equals("C")){
				
				if(phonemes_vow.get(i).equals("W")){
					phonemes_vow.set(i, "V");
					phonemes.set(i, "O");
				}
				if(phonemes_vow.get(i).equals("J")){
					phonemes_vow.set(i, "V");
					phonemes.set(i, "I");
				}
				
				//-- turning all the other J/W into semivows, and all the a/e into ä/ë
				for (int n = 0; n < phonemes.size(); n++){
					
					if (n != i){
						
						if (phonemes.get(n).equals("a")){
							phonemes.set(n, "ä");
							phonemes_vow.set(n, "v");	
						}
						if (phonemes.get(n).equals("e")){
							phonemes.set(n, "ë");
							phonemes_vow.set(n, "v");	
						}
						if (phonemes.get(n).equals("J")){
							phonemes.set(n, "j");
							phonemes_vow.set(n, "C");	
						}					
						if (phonemes.get(n).equals("W")){
							phonemes.set(n, "w");
							phonemes_vow.set(n, "C");	
						}
						
					}
				}	
				
				
			}
			
			
		}
		
		}
		
		
		
		
		
		word_res = "";
		for (int i = 0; i < phonemes.size(); i++){
			
			word_res = word_res + phonemes.get(i);
			
		}
		
	}
			
//------ convert into vowels the J and W that remains
	

	word_res = word_res.replaceAll("W", "O");
	word_res = word_res.replaceAll("U", "O");
	word_res = word_res.replaceAll("J", "I");
	word_res = word_res.replaceAll("i", "I");

	}
	
	//--- postparsing
	// last syllable -CV:
			String last_char = word_res.substring(word_res.length()-1, word_res.length());
			
			if (last_char.equals("I") ||
				last_char.equals("E") ||
				last_char.equals("O") ||
				last_char.equals("U") 
					){
				word_res = word_res + "ʔvʔ";
			}
	
		return word_res;
	}

}
