package egy_root;

import java.util.ArrayList;



public class eg_phon_constr {
	
	
	
public static ArrayList<String>  egphonconstr(ArrayList<String> eg_phonemes, ArrayList<String> eg_phon_class, String gender, boolean metathesis_aliph) {
		
	
	
		for (int i = 0; i < eg_phonemes.size(); i++){
			
			if (eg_phon_class.get(i).equals("V")){
				
				//long stressed
				if (eg_phonemes.get(i).equals("I")){
					
					eg_phonemes.set(i, "i/u"); //inserire proxmity etc
					eg_phonemes.set(i-1, eg_phonemes.get(i-1));
					eg_phonemes.add(i-1, "'");
					eg_phon_class.add(i-1, "'");
					i++;
				} else
				if (eg_phonemes.get(i).equals("E")){
					
					eg_phonemes.set(i, "i/u");
					eg_phonemes.set(i-1, eg_phonemes.get(i-1));
					eg_phonemes.add(i-1, "'");
					eg_phon_class.add(i-1, "'");
					i++;
				} else
				if (eg_phonemes.get(i).equals("O")){
					
					eg_phonemes.set(i, "a");
					eg_phonemes.set(i-1, eg_phonemes.get(i-1));
					eg_phonemes.add(i-1, "'");
					eg_phon_class.add(i-1, "'");
					i++;
				} else
				if (eg_phonemes.get(i).equals("U")){
					
					eg_phonemes.set(i, "a");
					eg_phonemes.set(i-1, eg_phonemes.get(i-1));
					eg_phonemes.add(i-1, "'");
					eg_phon_class.add(i-1, "'");
					i++;
				}//-----
				//short stressed
				else
				if (eg_phonemes.get(i).equals("a")){
					
					eg_phonemes.set(i, "v"); //inserire proxmity etc
					eg_phonemes.set(i-1, eg_phonemes.get(i-1));
					eg_phonemes.add(i-1, "'");
					eg_phon_class.add(i-1, "'");
					i++;
				}else
				if (eg_phonemes.get(i).equals("o")){
					
					eg_phonemes.set(i, "a"); //inserire proxmity etc
					eg_phonemes.set(i-1, eg_phonemes.get(i-1));
					eg_phonemes.add(i-1, "'");
					eg_phon_class.add(i-1, "'");
					i++;
				}else
				if (eg_phonemes.get(i).equals("e")){
					
					eg_phonemes.set(i, "i/u"); //inserire proxmity etc
					eg_phonemes.set(i-1, eg_phonemes.get(i-1));
					eg_phonemes.add(i-1, "'");
					eg_phon_class.add(i-1, "'");
					i++;
				}
				//-----
				//short unstressed
				else
				if (eg_phonemes.get(i).equals("ä")){
					
					eg_phonemes.set(i, "v"); //inserire proxmity etc
				}else
				if (eg_phonemes.get(i).equals("ë")){
					
					eg_phonemes.set(i, "v"); //inserire proxmity etc
				}else
				if (eg_phonemes.get(i).equals("ï")){
					
					eg_phonemes.set(i, "v"); //inserire proxmity etc
				}
			
			
			}else if (eg_phon_class.get(i).equals("C")){
				
				//fem ending -t
				if (eg_phonemes.get(i).equals("ʔ")
						&& gender.equals("f")
						&& i == eg_phonemes.size()-2){
					eg_phonemes.set(i, "t"); //inserire proxmity etc
				}
				
				
			}
			
		}
		
		//feminine nowns with stress on the last vowel -> -Vʔ -> -Vt
		
		int last_phon = eg_phonemes.size()-2;
		
		if (gender.equals("f") 
				&& eg_phonemes.get(last_phon).equals("ʔ")
				&& eg_phon_class.get(last_phon-1).equals("V")){
			
			eg_phonemes.set(last_phon, "t");
			
		}
		
		
		//postparsing
		//metathesis aliph-cons
		
		if (metathesis_aliph == true){
		for (int i = 1; i < eg_phonemes.size()-2; i++){
			
			if (eg_phon_class.get(i-1).equals("V")
				&& eg_phonemes.get(i).equals("ʔ")
				&& eg_phon_class.get(i+1).equals(".")
				&& eg_phon_class.get(i+2).equals("C")
					){
				eg_phon_class.set(i, eg_phon_class.get(i+2));
				eg_phon_class.set(i+2, "ʔ");
				
				eg_phonemes.set(i, eg_phonemes.get(i+2));
				eg_phonemes.set(i+2, "ʔ");
			}
			
		}
		}
	
		
		return eg_phonemes;
	}

}
