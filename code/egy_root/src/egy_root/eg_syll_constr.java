package egy_root;

import java.util.ArrayList;



public class eg_syll_constr {
	
	
	
public static ArrayList<ArrayList<String>>  egsyllconstr(ArrayList<ArrayList<String>> coptic_vow_syllables, ArrayList<String> phonemes, ArrayList<String> phon_class) {
		
	ArrayList<String> eg_phonemes = new ArrayList<String>();
	ArrayList<String> eg_phon_class = new ArrayList<String>();
	
	ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
	
	/*class Results {
	    public ArrayList<String> eg_phons = new ArrayList<String>();
	    public ArrayList<String> eg_phon_class = new ArrayList<String>();
	    //constructor
	    public Results(ArrayList<String> eg_phonemes, ArrayList<String> eg_phon_class) {
	    	eg_phons = eg_phonemes;
	    	eg_phon_class = eg_phon_class;
	    }
	}*/
	
		for (int i = 0; i < coptic_vow_syllables.size(); i++){
			
			int index_vow = Integer.valueOf(coptic_vow_syllables.get(i).get(0));
			
			if((coptic_vow_syllables.get(i).get(4)).equals("s")){
			
			
			//if ccvcc and s-c -> closed syllable CVCvCCV(j) 
			if ((coptic_vow_syllables.get(i).get(2)).equals("s") && (coptic_vow_syllables.get(i).get(3)).equals("c")
					&& coptic_vow_syllables.size() == 1 && index_vow == 2 && index_vow + 3 == phonemes.size()){
				
				eg_phonemes.add(phonemes.get(index_vow-2));
				eg_phonemes.add("v");
				eg_phonemes.add(".");
				eg_phonemes.add(phonemes.get(index_vow-1));
				eg_phonemes.add(phonemes.get(index_vow));
				eg_phonemes.add(phonemes.get(index_vow+1));
				eg_phonemes.add(".");
				eg_phonemes.add(phonemes.get(index_vow+2));
				eg_phonemes.add("v");
				eg_phonemes.add("ʔ");
				eg_phonemes.add(".");
				
				eg_phon_class.add("C");
				eg_phon_class.add("V");
				eg_phon_class.add(".");
				eg_phon_class.add("C");
				eg_phon_class.add("V");
				eg_phon_class.add("C");
				eg_phon_class.add(".");
				eg_phon_class.add("C");
				eg_phon_class.add("V");
				eg_phon_class.add("C");
				eg_phon_class.add(".");
				
			}else //if ccVcc and l-c -> open syllable CVCV:CVC 
			if ((coptic_vow_syllables.get(i).get(2)).equals("l") && (coptic_vow_syllables.get(i).get(3)).equals("c")
					&& coptic_vow_syllables.size() == 1 && index_vow == 2 && index_vow + 3 == phonemes.size()){
					
				eg_phonemes.add(phonemes.get(index_vow-2));
				eg_phonemes.add("v");
				eg_phonemes.add(".");
				eg_phonemes.add(phonemes.get(index_vow-1));
				eg_phonemes.add(phonemes.get(index_vow));
				eg_phonemes.add(":");
				eg_phonemes.add(".");
				eg_phonemes.add(phonemes.get(index_vow+1));
				eg_phonemes.add("v");
				eg_phonemes.add(phonemes.get(index_vow+2));
					
				eg_phon_class.add("C");
				eg_phon_class.add("V");
				eg_phon_class.add(".");
				eg_phon_class.add("C");
				eg_phon_class.add("V");
				eg_phon_class.add(":");
				eg_phon_class.add(".");
				eg_phon_class.add("C");
				eg_phon_class.add("V");
				eg_phon_class.add("C");
				eg_phon_class.add(".");
					
			} else //if cvcc and s-c -> closed syllable CvCCV(j) 
			if ((coptic_vow_syllables.get(i).get(2)).equals("s") && (coptic_vow_syllables.get(i).get(3)).equals("c")
					&& index_vow + 3 == phonemes.size()){
					
				
				eg_phonemes.add(phonemes.get(index_vow-1));
				eg_phonemes.add(phonemes.get(index_vow));
				eg_phonemes.add(phonemes.get(index_vow+1));
				eg_phonemes.add(".");
				eg_phonemes.add(phonemes.get(index_vow+2));
				eg_phonemes.add("v");
				eg_phonemes.add("ʔ");
				eg_phonemes.add(".");
				
				
				eg_phon_class.add("C");
				eg_phon_class.add("V");
				eg_phon_class.add("C");
				eg_phon_class.add(".");
				eg_phon_class.add("C");
				eg_phon_class.add("V");
				eg_phon_class.add("C");
				eg_phon_class.add(".");
					
			} else  //if cvcc and l-c -> open syllable CV:.CVC 
			if ((coptic_vow_syllables.get(i).get(2)).equals("l") && (coptic_vow_syllables.get(i).get(3)).equals("c")
					&& index_vow + 3 == phonemes.size()){
				
				eg_phonemes.add(phonemes.get(index_vow-1));
				eg_phonemes.add(phonemes.get(index_vow));
				eg_phonemes.add(":");
				eg_phonemes.add(".");
				eg_phonemes.add(phonemes.get(index_vow+1));
				eg_phonemes.add("v");
				eg_phonemes.add(phonemes.get(index_vow+2));
				eg_phonemes.add(".");
				
				eg_phon_class.add("C");
				eg_phon_class.add("V");
				eg_phon_class.add(":");
				eg_phon_class.add(".");
				eg_phon_class.add("C");
				eg_phon_class.add("V");
				eg_phon_class.add("C");
				eg_phon_class.add(".");
				
			} else //if ccvc and s-c -> closed syllable CV.CVC 
			if ((coptic_vow_syllables.get(i).get(2)).equals("s") && (coptic_vow_syllables.get(i).get(3)).equals("c")
					&& index_vow == 2 ){
				
				eg_phonemes.add(phonemes.get(index_vow-2));
				eg_phonemes.add("v");
				eg_phonemes.add(".");
				eg_phonemes.add(phonemes.get(index_vow-1));
				eg_phonemes.add(phonemes.get(index_vow));
				eg_phonemes.add(phonemes.get(index_vow+1));
				eg_phonemes.add(".");
				
				eg_phon_class.add("C");
				eg_phon_class.add("V");
				eg_phon_class.add(".");
				eg_phon_class.add("C");
				eg_phon_class.add("V");
				eg_phon_class.add("C");
				eg_phon_class.add(".");
				
			} else //if ccvc and l-c -> open syllable CV.CV:.CV(J)
			
			
			if ((coptic_vow_syllables.get(i).get(2)).equals("l") && (coptic_vow_syllables.get(i).get(3)).equals("c")
					&& index_vow == 2 ){
				
				eg_phonemes.add(phonemes.get(index_vow-2));
				eg_phonemes.add("v");
				eg_phonemes.add(".");
				eg_phonemes.add(phonemes.get(index_vow-1));
				eg_phonemes.add(phonemes.get(index_vow));
				eg_phonemes.add(":");
				eg_phonemes.add(".");
				eg_phonemes.add(phonemes.get(index_vow+1));
				eg_phonemes.add("v");
				eg_phonemes.add("ʔ");
				eg_phonemes.add(".");
				
				eg_phon_class.add("C");
				eg_phon_class.add("V");
				eg_phon_class.add(".");
				eg_phon_class.add("C");
				eg_phon_class.add("V");
				eg_phon_class.add(":");
				eg_phon_class.add(".");
				eg_phon_class.add("C");
				eg_phon_class.add("V");
				eg_phon_class.add("C");
				eg_phon_class.add(".");
				
			} else //if ccv and s-o -> closed syllable CV.CVC 
			if ((coptic_vow_syllables.get(i).get(2)).equals("s") && (coptic_vow_syllables.get(i).get(3)).equals("o")
					&& index_vow == 2 ){
				
				eg_phonemes.add(phonemes.get(index_vow-2));
				eg_phonemes.add("v");
				eg_phonemes.add(".");
				eg_phonemes.add(phonemes.get(index_vow-1));
				eg_phonemes.add(phonemes.get(index_vow));
				eg_phonemes.add("ʔ");
				eg_phonemes.add(".");
				
				eg_phon_class.add("C");
				eg_phon_class.add("V");
				eg_phon_class.add(".");
				eg_phon_class.add("C");
				eg_phon_class.add("V");
				eg_phon_class.add("C");
				eg_phon_class.add(".");
				
			} else //if ccv and l-c -> open syllable CV.CV:
			if ((coptic_vow_syllables.get(i).get(2)).equals("l") && (coptic_vow_syllables.get(i).get(3)).equals("c")
					&& index_vow == 2 ){
				
				eg_phonemes.add(phonemes.get(index_vow-2));
				eg_phonemes.add("v");
				eg_phonemes.add(".");
				eg_phonemes.add(phonemes.get(index_vow-1));
				eg_phonemes.add(phonemes.get(index_vow));
				eg_phonemes.add(":");
				eg_phonemes.add(".");
				
				eg_phon_class.add("C");
				eg_phon_class.add("V");
				eg_phon_class.add(".");
				eg_phon_class.add("C");
				eg_phon_class.add("V");
				eg_phon_class.add(":");
				eg_phon_class.add(".");
				
			}else	//if s-c -> closed syllable CVC
			if ((coptic_vow_syllables.get(i).get(2)).equals("s") && (coptic_vow_syllables.get(i).get(3)).equals("c")){
				
				eg_phonemes.add(phonemes.get(index_vow-1));
				eg_phonemes.add(phonemes.get(index_vow));
				eg_phonemes.add(phonemes.get(index_vow+1));
				eg_phonemes.add(".");
				
				eg_phon_class.add("C");
				eg_phon_class.add("V");
				eg_phon_class.add("C");
				eg_phon_class.add(".");
				
			}else //if if l-o -> long syllable CV:
			if ((coptic_vow_syllables.get(i).get(2)).equals("l") && (coptic_vow_syllables.get(i).get(3)).equals("o")){
				
				eg_phonemes.add(phonemes.get(index_vow-1));
				eg_phonemes.add(phonemes.get(index_vow));
				eg_phonemes.add(":");
				eg_phonemes.add(".");
				
				eg_phon_class.add("C");
				eg_phon_class.add("V");
				eg_phon_class.add(":");
				eg_phon_class.add(".");
				
			}else //if l-c -> two syllables CV:.ʔvC
			if ((coptic_vow_syllables.get(i).get(2)).equals("l") && (coptic_vow_syllables.get(i).get(3)).equals("c")){
				
				eg_phonemes.add(phonemes.get(index_vow-1));
				eg_phonemes.add(phonemes.get(index_vow));
				eg_phonemes.add(":");
				eg_phonemes.add(".");
				eg_phonemes.add(phonemes.get(index_vow+1));
				eg_phonemes.add("v");
				eg_phonemes.add("ʔ");
				eg_phonemes.add(".");
				
				eg_phon_class.add("C");
				eg_phon_class.add("V");
				eg_phon_class.add(":");
				eg_phon_class.add(".");
				eg_phon_class.add("C");
				eg_phon_class.add("V");
				eg_phon_class.add("C");
				eg_phon_class.add(".");
				
			}else //if s-o -> CVJ
			if ((coptic_vow_syllables.get(i).get(2)).equals("s") && (coptic_vow_syllables.get(i).get(3)).equals("o")){
				
				eg_phonemes.add(phonemes.get(index_vow-1));
				eg_phonemes.add(phonemes.get(index_vow));
				eg_phonemes.add("ʔ");
				eg_phonemes.add(".");
				
				eg_phon_class.add("C");
				eg_phon_class.add("V");
				eg_phon_class.add("C");
				eg_phon_class.add(".");
				
			}
			}else{
				
				//if s-c and ccvc- -> closed syllable CV.CVC-
				if ((coptic_vow_syllables.get(i).get(2)).equals("s") && (coptic_vow_syllables.get(i).get(3)).equals("c")
						&& index_vow == 2 && (phon_class.get(index_vow-1)).equals("C") && (phon_class.get(index_vow-2)).equals("C")){
					
					
					eg_phonemes.add(phonemes.get(index_vow-2));
					eg_phonemes.add(phonemes.get(index_vow));
					eg_phonemes.add(".");
					eg_phonemes.add(phonemes.get(index_vow-1));
					eg_phonemes.add(phonemes.get(index_vow));
					eg_phonemes.add(phonemes.get(index_vow+1));
					eg_phonemes.add(".");
					
					eg_phon_class.add("C");
					eg_phon_class.add("V");
					eg_phon_class.add(".");
					eg_phon_class.add("C");
					eg_phon_class.add("V");
					eg_phon_class.add("C");
					eg_phon_class.add(".");
					
				}else		//if s-o and ccv- -> closed syllable CV.CV-
				if ((coptic_vow_syllables.get(i).get(2)).equals("s") && (coptic_vow_syllables.get(i).get(3)).equals("o")
						&& index_vow == 2 && (phon_class.get(index_vow-1)).equals("C") && (phon_class.get(index_vow-2)).equals("C")){
					
					
					eg_phonemes.add(phonemes.get(index_vow-2));
					eg_phonemes.add(phonemes.get(index_vow));
					eg_phonemes.add(".");
					eg_phonemes.add(phonemes.get(index_vow-1));
					eg_phonemes.add(phonemes.get(index_vow));
					eg_phonemes.add(".");
					
					eg_phon_class.add("C");
					eg_phon_class.add("V");
					eg_phon_class.add(".");
					eg_phon_class.add("C");
					eg_phon_class.add("V");
					eg_phon_class.add(".");
					
				}else //if s-c -> closed syllable CVC
				if ((coptic_vow_syllables.get(i).get(2)).equals("s") && (coptic_vow_syllables.get(i).get(3)).equals("c")){
					
					eg_phonemes.add(phonemes.get(index_vow-1));
					eg_phonemes.add(phonemes.get(index_vow));
					eg_phonemes.add(phonemes.get(index_vow+1));
					eg_phonemes.add(".");
					
					eg_phon_class.add("C");
					eg_phon_class.add("V");
					eg_phon_class.add("C");
					eg_phon_class.add(".");
					
				}else //if s-o and not end of word -> -CV
				if ((coptic_vow_syllables.get(i).get(2)).equals("s") && (coptic_vow_syllables.get(i).get(3)).equals("o")
						&& index_vow < phonemes.size()-1){
					
					eg_phonemes.add(phonemes.get(index_vow-1));
					eg_phonemes.add(phonemes.get(index_vow));
					eg_phonemes.add(".");
					
					eg_phon_class.add("C");
					eg_phon_class.add("V");
					eg_phon_class.add(".");
					
				}
				if ((coptic_vow_syllables.get(i).get(2)).equals("s") && (coptic_vow_syllables.get(i).get(3)).equals("o")
						&& index_vow == phonemes.size()-1){
					
					eg_phonemes.add(phonemes.get(index_vow-1));
					eg_phonemes.add(phonemes.get(index_vow));
					eg_phonemes.add("ʔ");
					eg_phonemes.add(".");
					
					eg_phon_class.add("C");
					eg_phon_class.add("V");
					eg_phon_class.add("C");
					eg_phon_class.add(".");
					
				}
				
				
			}
			
			
		}
		

	
		results.add(eg_phonemes);
		results.add(eg_phon_class);
		

		
		return results;
	}

}
