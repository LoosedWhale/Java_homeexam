package Translator;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class Translator {
	// Sets a default language 
	private static String languageChoice = "English";
	public static void main(String[] args) {
		
		// Initialize the list to store words
        List<Map<String, String>> wordList = new ArrayList<>();
        initializeWordList(wordList);	
		
		//Creates a window / frame
		JFrame f = new JFrame("Top notch translator 3000");
		f.getContentPane().setBackground(new Color(0, 100, 255));
		
		//Creates text area for print and label
		final TextField print_txt = new TextField();
		print_txt.setBounds(175,80,150,20);  
		print_txt.setEditable(false);
		
		Label print_txtLabel = new Label("Translated word");
		print_txtLabel.setBounds(175,60,150,20); 
		print_txtLabel.setFont(new Font("Arial", Font.PLAIN, 12));

		
		//Creates text area for input and label
		final TextField input_txt = new TextField();
		input_txt.setBounds(175, 20, 150, 20); 
		input_txt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				print_txt.setText(null);
				String store_word_input = input_txt.getText();
				String translation = getTranslation(wordList, store_word_input, languageChoice);
				print_txt.setText(translation);
				input_txt.setText(null);
				}
			});
		
		Label input_txtLabel = new Label("Input the word you want to translate");
		input_txtLabel.setBounds(155, 0, 200, 20);
		input_txtLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		
		//Creates button for translation
		Button translate_btn = new Button("Translate");
		translate_btn.setBounds(150, 120, 200, 65);
		translate_btn.addActionListener(new ActionListener() 
		{
		public void actionPerformed(ActionEvent e) {
			print_txt.setText(null);
			String store_word_input = input_txt.getText();
			String translation = getTranslation(wordList, store_word_input, languageChoice);
			print_txt.setText(translation);
			}
		});
				
		// Creates translation language buttons
        createTranslationButtons(f, wordList, input_txt, print_txt);
	
        f.add(input_txt);
        f.add(input_txtLabel);
        f.add(translate_btn);
        f.add(print_txt);
        f.add(print_txtLabel);
        f.setSize(515, 500);
        f.setLayout(null);
        f.setVisible(true);
		
	}
	
	
	// Method to create translation language buttons
    private static void createTranslationButtons(JFrame frame, List<Map<String, String>> wordList, TextField input_txt, TextField print_txt) {
        String[] languages = {"English", "Spanish", "Italian", "Swedish"};

        for (int i = 0; i < languages.length; i++) {
            String language = languages[i];
            Button languageBtn = new Button(language);
            languageBtn.setBounds(20 + i * 120, 200, 100, 60);
            languageBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    print_txt.setText(null);
                    String store_word_input = input_txt.getText();
                    String translation = getTranslation(wordList, store_word_input, language);
                    print_txt.setText(translation);
                }
            });

            frame.add(languageBtn);
        }
    }

	
	// Method to add a word and its translations to the list via looping trough a bunch
    private static void initializeWordList(List<Map<String, String>> wordList) {
        String[] englishWords = {"Hello", "Goodbye", "Thank you", "Yes", "No", "Cat", "Dog", "House", "Car", "Computer"};
        String[] spanishWords = {"Hola", "Adiós", "Gracias", "Sí", "No", "Gato", "Perro", "Casa", "Coche", "Computadora"};
        String[] italianWords = {"Ciao", "Arrivederci", "Grazie", "Sì", "No", "Gatto", "Cane", "Casa", "Auto", "Computer"};
        String[] swedishWords = {"Hej", "Adjö", "Tack", "Ja", "Nej", "Katt", "Hund", "Hus", "Bil", "Dator"};

        for (int i = 0; i < englishWords.length; i++) {
            addWord(wordList, englishWords[i], spanishWords[i], italianWords[i], swedishWords[i]);
        }
    }
	
    // Method to add a word and its translations to the list
    private static void addWord(List<Map<String, String>> wordList, String english, String spanish, String italian, String swedish) {
    	Map<String, String> wordMap = new HashMap<>();
        wordMap.put("English", english);
        wordMap.put("Spanish", spanish);
        wordMap.put("Italian", italian);
        wordMap.put("Swedish", swedish);
        wordList.add(wordMap);
    }
    
    // Method to get the translation based on user input
    private static String getTranslation(List<Map<String, String>> wordList, String store_word_input, String languageChoice) {
    	 if (store_word_input.trim().isEmpty()) {
    	        return "Please enter a word";
    	    }

    	    for (Map<String, String> wordMap : wordList) {
    	        // Iterate over translations for the current word
    	        for (Map.Entry<String, String> entry : wordMap.entrySet()) {
    	            // Check if the input word is found in any language
    	            if (entry.getValue().equalsIgnoreCase(store_word_input)) {
    	                // Return the translation based on the target language
    	                String translation = wordMap.get(languageChoice);
    	                return (translation != null) ? translation.toLowerCase() : "Translation not found";
    	            }
    	        }
    	    }

    	return "Word not found";

    }

	
}
