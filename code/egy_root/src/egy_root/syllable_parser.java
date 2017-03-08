package egy_root;

import java.util.ArrayList;

public class syllable_parser {
	
public static ArrayList<ArrayList<String>> syllpars(ArrayList<String> phonemes, ArrayList<String> phon_class) {
		
	ArrayList<ArrayList<String>> vowels = new ArrayList<ArrayList<String>>();
	
	String test = "";
	
	//--- preparse
	
	//CCV- -> CVCV-
	
	if(phon_class.get(0).equals("C") && phon_class.get(1).equals("C") && phon_class.get(2).equals("V")){
		
		phon_class.add(1, "V");
		phonemes.add(1, "ë");
		
	}
	
	// VCC- -> CVC-
	
	if(phon_class.get(0).equals("V") && phon_class.get(1).equals("C") && phon_class.get(2).equals("C")
			&& (phonemes.get(0).equals("ë"))){
		
		phon_class.set(0, "C");
		phon_class.set(1, "V");
		
		String prov_vow = phonemes.get(0);
		
		phonemes.set(0, phonemes.get(1));
		phonemes.set(1, prov_vow);
		
	}
	
	// V- -> ʔV-
	
	if(phon_class.get(0).equals("V")){
		
		phon_class.add(0, "C");
		phonemes.add(0, "ʔ");
		
	}
	
	// -CCC -> -CCVC
	
	int nr_phon = phon_class.size()-1;
	
	if(phon_class.get(nr_phon).equals("C")
		&& phon_class.get(nr_phon-1).equals("C")
		&& phon_class.get(nr_phon-2).equals("C")
			){
		
		phon_class.add(nr_phon, "V");
		phonemes.add(nr_phon, "ë");
		
	}
	
	// CCC- -> CVCC-
	
	
	if(phon_class.get(0).equals("C")
		&& phon_class.get(1).equals("C")
		&& phon_class.get(2).equals("C")
			){
		
		phon_class.add(1, "V");
		phonemes.add(1, "ë");
		
	}
	
	//-------
	
	for (int i = 0; i < phon_class.size(); i++){
		
		ArrayList<String> vow_data = new ArrayList<String>();
		
		if ((phon_class.get(i)).equals("V")){
			
			vow_data.add(Integer.toString(i));
			vow_data.add(phonemes.get(i));
			
			if(phonemes.get(i).equals("I") || phonemes.get(i).equals("E") || phonemes.get(i).equals("O") || phonemes.get(i).equals("U") ){
				
				vow_data.add("l");
				
			}else{
				
				vow_data.add("s");
			}
			
			vow_data.add("");
			
			if(phonemes.get(i).equals("ä") || phonemes.get(i).equals("ë") || phonemes.get(i).equals("ï") ){
				
				vow_data.add("u");
				
			}else{
				
				vow_data.add("s");
			}
			
			vowels.add(vow_data);
			
		}
	}

	//----------
	
	for (int i = 0; i < vowels.size(); i++){
		
		int index_vow = Integer.valueOf(vowels.get(i).get(0));
		
		//-- if the vowel is the last letter of the word
		if(index_vow == phon_class.size()-1){
			
			vowels.get(i).set(3, "o"); //syllable is o-pen
			test = test + "o";
			
		}else{
			//-- if the vowel is the second last letter of the word
			if(index_vow == phon_class.size()-2){
				
				//-- if following letter is consonant
				if (phon_class.get(index_vow + 1).equals("C")){
				
				vowels.get(i).set(3, "c"); // syllable is c-losed
				test = test + "c";
				
				}else{
					
					//error
				}
				//-- if the vowel is before the second last letter of the word, i.e. it is not the last vowel
			}else{
				
				//-- if following letter is consonant
				if (phon_class.get(index_vow + 1).equals("C")){
				
					//-- if vowel followed by two consonants
					if (phon_class.get(index_vow + 2).equals("C")){
						
						vowels.get(i).set(3, "c"); // syllable is c-losed
						test = test + "c";
						
						//-- if vowel followed by a consonant and a vowel
						}else{
							
							vowels.get(i).set(3, "o"); //syllable is o-pen
							test = test + "o";
						}
				
				}else{
					
					//error
				}	
			}
		}
	}
	
	//----------------
		
		return vowels;
	}

}
