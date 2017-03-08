package egy_root;

import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JToggleButton;

public class mainwin {
	
	String coptic = "";
	String egyptian = "";

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainwin window = new mainwin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mainwin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		textField = new JTextField();
		textField.setBounds(43, 67, 134, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(254, 67, 134, 28);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		final JRadioButton rdbtnMetathesiscvc = new JRadioButton("Metathesis 'cvʔ.c- -> 'cvc.ʔ-");
		rdbtnMetathesiscvc.setBounds(53, 133, 256, 23);
		frame.getContentPane().add(rdbtnMetathesiscvc);
		
		final JRadioButton rdbtnMasc = new JRadioButton("Masc./no gender");
		rdbtnMasc.setSelected(true);
		rdbtnMasc.setBounds(117, 94, 141, 23);
		frame.getContentPane().add(rdbtnMasc);
		
		final JRadioButton rdbtnFemm = new JRadioButton("Femm.");
		rdbtnFemm.setBounds(270, 94, 141, 23);
		frame.getContentPane().add(rdbtnFemm);
		
	     ButtonGroup bG = new ButtonGroup();
	     bG.add(rdbtnMasc);
	     bG.add(rdbtnFemm);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setBounds(43, 98, 61, 16);
		frame.getContentPane().add(lblGender);
		
		JLabel lblInputsahidic = new JLabel("Input (Sahidic)");
		lblInputsahidic.setBounds(43, 26, 134, 29);
		frame.getContentPane().add(lblInputsahidic);
		
		JLabel lblOutputmiddleEg = new JLabel("Output (Middle Eg.)");
		lblOutputmiddleEg.setBounds(254, 26, 165, 29);
		frame.getContentPane().add(lblOutputmiddleEg);
		
		JButton btnNewButton_1 = new JButton("Read me");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "The program generates the prototypical Middle Egyptian "
						+ "syllabic patterns and vocalisations for Sahidic Coptic forms, as\n"
						+ "they can be recostructed on the basis of the rules "
						+ "presented in the works of Vychicl, Loprieno, etc.\n"
						+ "See \"spelling rules\" for the format of the input. "
						+ "Forms can be transcribed as they appear in Coptic\n"
						+ "without any preliminary analysis by using the basic "
						+ "spelling rules. In that case, the software will \n"
						+ "automatically analyse the form and the various vowels, "
						+ "trying to identify the position of the stress, etc.\n"
						+ "In most cases the process is straightworward and "
						+ "unambigous, and the software will be able to perform it\n"
						+ "automatically. There are cases, however, where more than"
						+ "one interpretation is possible. For instance, in a word\n"
						+ "like ⲃⲉⲕⲉ the stress could fall on either syllables, and"
						+ "its position cannot be internally predicted. In such a\n"
						+ "case the program will display a warnign message suggesting "
						+ "possible options. In these ambigous cases if could be\n"
						+ "useful to use a more complex system of transcription, that "
						+ "implies some preliminary analyses of the Coptic form and\n"
						+ "allows, for isntance, to explicitely indicate which vowel "
						+ "are unstressed. For such a system of transcription see\n"
						+ "\"Spelling rules - advanced\".\n"
						+ "As for the output, v stands for a vowel which cannot\n"
						+ "be reconstructed with certainty, while ʔ stands for both "
						+ "glottal stops and possible glides (on the question of\n"
						+ "glides and their likelihood at the end of words see "
						+ "Loprieno, 1995, 36).\n"
						+ "Note that the reconstructions are based *exclusively* "
						+ "on the Sahidic forms. No data from other dialects, no\n"
						+ "Akkadian transcriptions, no data from hirogliphic "
						+ "Middle Egyptian words are taken into consideration.\n"
						+ "Such data could indeed be integrated into the "
						+ "current algorithm. Perhaps I'll do that in the future.\n"
						+ "In the meantime, feel free to play and try by yourself "
						+ "to modify it, if you wish so.\n"
						+ "Since reconstructions are based exclusively on Sahidic "
						+ "data, obviously features that are not preserved or \n"
						+ "distinguishable in Sahidic cannot and will not be "
						+ "reconstructed.\n"
						+ "Finally, at the moment the program focuses only on"
						+ "the vocalization, but it does not try to reconstruct\n"
						+ "the Middle Egyptian ancestors of the Coptic consonats."
						+ "Therefore, the consonants dispalyed in the output are\n"
						+ "those of the Sahidic form rather than those of the corresponding "
						+ "Middle Egyptian form. Such a feature could be\n"
						+ "added in the future, but it is not my priority right now, "
						+ "also because reconstructing them is usually relatively easy.\n"
						+ "\n"
						+ "Finally, if you want to refer to this software, cite it as:\n"
						+ "Automatic Coptic Parser 1.0, beta version, Marwan Kilani, 2017.");
				
			}
		});
		btnNewButton_1.setBounds(43, 221, 117, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnSpellingRules = new JButton("Spelling rules - basic");
		btnSpellingRules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, 
						"Basic transcription:\n"
						+ "\n"
						+ "ⲁ -> a      ⲟ -> o\n"
						+ "ⲉ -> e      ⲱ -> O\n"
						+ "ⲓ -> i        ⲩ -> U\n"
						+ "ⲏ -> E      jinkim (Ⲻ) -> e\n"
						+ "\n"
						+ "ⲃ -> b        ⲅ -> g\n"
						+ "ⲇ -> d        ⲍ -> z\n"
						+ "ⲑ -> th       ⲕ -> k\n"
						+ "ⲗ -> l         ⲙ -> m\n"
						+ "ⲛ -> n        ⲝ -> ks\n"
						+ "ⲡ -> p        ⲣ -> r\n"
						+ "ⲥ -> s        ⲧ -> t\n"
						+ "ⲫ -> ph      ⲭ -> kh\n"
						+ "ⲯ -> ps      ϣ -> S\n"
						+ "ϥ -> f        ϩ -> h\n"
						+ "ϫ -> G       ϭ -> Q\n"
						+ "ϯ -> ti\n");	
				
			
			}
		});
		btnSpellingRules.setBounds(254, 196, 190, 28);
		frame.getContentPane().add(btnSpellingRules);
		
		JButton btnNewButton = new JButton("Parse");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				coptic = textField.getText();

				boolean metathesis_aliph = false;
				
				if (rdbtnMetathesiscvc.isSelected()){
					metathesis_aliph = true;
				}else{
					metathesis_aliph = false;
				}
				
				
				String gender = "";
				
				if (rdbtnMasc.isSelected()){
					gender = "m";
				}else if (rdbtnFemm.isSelected()){
					gender = "f";
				}
				
				//gender = textField_2.getText();
				
				String pre_parsed = phon_pre_parse.phonpars(coptic, gender);
				
				//-> mettere qui errore due vocali
				
				ArrayList<String> phonemes = phon_parser.phonpars(pre_parsed);
				
				ArrayList<String> phon_class = phon_class_parser.phonparsclass(pre_parsed);
				
				//-- poi da mettere in un metodo
				
				int nr_vow = 0;
				ArrayList<Integer> vow_index = new ArrayList<Integer>();
				ArrayList<String> variants_list = new ArrayList<String>();
				
				for (int i = 0; i < phon_class.size(); i++){					
					if (phon_class.get(i).equals("V") && !phonemes.get(i).equals("ë") && !phonemes.get(i).equals("ä")){
					nr_vow++;
					vow_index.add(i);
					}				
				}
				
				if (nr_vow > 1){
					
					for (int i =0; i < vow_index.size(); i++){
						String variant = "";
						for (int n = 0; n < phonemes.size(); n++){
							
							
							if (n != vow_index.get(i) && phon_class.get(n).equals("V")){
								variant = variant + "ë";

							}else{
								variant = variant + phonemes.get(n);
							}
						}
						

						variants_list.add(variant);
						
					}
					
					if (vow_index.size() > 1){
					for(int i = 1; i < vow_index.size(); i++){
					phonemes.set(vow_index.get(i), "ë");
					}
					}

					
					String variants_stress = "";
					
					if (variants_list.size() > 1){
						variants_stress = variants_list.get(0);
						for (int n = 1; n < variants_list.size(); n++){
							
							variants_stress = variants_stress + " or "+ variants_list.get(n);
						}
						
					}
					
					JOptionPane.showMessageDialog(null, "It seems there are more than one possible stressed vowels, "
							+ "and I cannot identify the correct one. \n"
							+ "The options are the following: \n\n"
							+ variants_stress + "\n\n"
							+ "By default, I will use the first of these variants.\n"
							+ "If you this is wrong, try to analyse one of the other variants\n"
							+ "or a more precise trascription indicatign the unstressed vowels.");
					
				}
				
				
				
				
				//-> mettere qui errore per 3 consonati
				
				ArrayList<ArrayList<String>> coptic_vow_syllables = syllable_parser.syllpars(phonemes, phon_class);
				
				
				ArrayList<ArrayList<String>> eg_phon_syll_patterns = eg_syll_constr.egsyllconstr(coptic_vow_syllables, phonemes, phon_class);
				
				ArrayList<String> eg_phonemes = eg_phon_syll_patterns.get(0);
				ArrayList<String> eg_phon_class = eg_phon_syll_patterns.get(1);
				
				
				ArrayList<String> eg_phonemes_res = eg_phon_constr.egphonconstr(eg_phonemes, eg_phon_class, gender, metathesis_aliph);
				
				String eg_reconstructed = "";
				for (int i = 0; i < eg_phonemes_res.size(); i++){
					
					eg_reconstructed = eg_reconstructed + eg_phonemes_res.get(i);
					
				}

				textField_1.setText(eg_reconstructed);
				
				//JOptionPane.showMessageDialog(null, coptic);

				
				
				
			}
		});
		btnNewButton.setBounds(159, 168, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnSpellingRules_1 = new JButton("Spelling rules - advanced");
		btnSpellingRules_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, 
						"Advanced transcription:\n"
						+ "\n"
						+ "VOWELS\n"
						+ "Stressed/not-known:\n"
						+ "\n"
						+ "ⲁ -> a           ⲟ -> o\n"
						+ "ⲉ -> e           ⲱ -> O\n"
						+ "ⲓ -> i             ⲩ -> U\n"
						+ "ⲏ -> E           jinkim (Ⲻ) -> e\n"
						+ "\n"
						+ "if the nature of ⲟⲩ, ⲉⲓ and ⲓ\n"
						+ "is known:\n"	
						+ "ⲟⲩ = ū -> O        ⲟⲩ = w -> w\n"
						+ "ⲓ = ī -> I              ⲓ = j -> j\n"
						+ "ⲉⲓ = ī -> I            ⲉⲓ = j -> j\n"
						+ "\n"
						+ "if the nature of ⲟⲩ, ⲉⲓ and ⲓ\n"
						+ "is unknown:\n"	
						+ "ⲟⲩ = ū/w -> ou         ⲓ = ī/j -> i \n"
						+ "ⲉⲓ = ī/j -> ei\n"
						+ "\n"
						+ "Unstressed:\n"
						+ "\n"
						+ "ⲁ -> ä           ⲉ -> ë\n"
						+ "jinkim (Ⲻ) -> ë\n"
						+ "\n"
						+ "\n"
						+ "CONSONANTS\n"
						+ "see Spelling rules - basic");	
				
			
			}
		});
		btnSpellingRules_1.setBounds(254, 236, 190, 28);
		frame.getContentPane().add(btnSpellingRules_1);
		

	}
}
