package Translator;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class Translator {
	private static String languageChoice = "English"; // Default language choice
	public static void main(String[] args) {
		
		
		// Initialize the list to store words
        List<Map<String, String>> wordList = new ArrayList<>();

        // Populate the list with 10 words and their translations
        addWord(wordList, "Hello", "Hola", "Ciao", "Hej");
        addWord(wordList, "Goodbye", "Adiós", "Arrivederci", "Adjö");
        addWord(wordList, "Thank you", "Gracias", "Grazie", "Tack");
    	addWord(wordList, "Yes", "Sí", "Sì", "Ja");
    	addWord(wordList, "No", "No", "No", "Nej");
    	addWord(wordList, "Cat", "Gato", "Gatto", "Katt");
    	addWord(wordList, "Dog", "Perro", "Cane", "Hund");
    	addWord(wordList, "House", "Casa", "Casa", "Hus");
    	addWord(wordList, "Car", "Coche", "Auto", "Bil");
    	addWord(wordList, "Computer", "Computadora", "Computer", "Dator");
        // Add more words as needed..
		
		
		
		
		
		System.out.println(""
				+ "   ____   _   _   ___ \r\n"
				+ "  / ___| | | | | |_ _|\r\n"
				+ " | |  _  | | | |  | | \r\n"
				+ " | |_| | | |_| |  | | \r\n"
				+ "  \\____|  \\___/  |___|\r\n"
				+ "                      "
				+ "");
		
		
		
		
		
		//Creates a window / frame
		JFrame f = new JFrame();

		
		//Creates text area for print
		final TextField print_txt = new TextField();
		print_txt.setBounds(175,80,150,20); //x, y, w, h 
		
		//Creates text area for input 
		final TextField input_txt = new TextField();
		input_txt.setBounds(175, 20, 150, 20); //x, y, w, h
		input_txt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				print_txt.setText(null);
				String store_word_input = input_txt.getText();
				String translation = getTranslation(wordList, store_word_input, languageChoice);
				print_txt.setText(translation);
				System.out.println("Translation: " + translation);	// debug
				input_txt.setText(null);
				}
			});
		
		//Creates button for translation
		Button translate_btn = new Button("Translate");
		translate_btn.setBounds(150, 120, 200, 65); //x, y, w, h
		translate_btn.addActionListener(new ActionListener() 
		{
		public void actionPerformed(ActionEvent e) {
			print_txt.setText(null);
			String store_word_input = input_txt.getText();
			String translation = getTranslation(wordList, store_word_input, languageChoice);
			print_txt.setText(translation);
			System.out.println("Translation: " + translation);	// debug
					
			}
		});
		
		
		//Creates button for English translation
		Button english_btn = new Button("English");
		english_btn.setBounds(20, 200, 100, 60); //x, y, w, h
		english_btn.addActionListener(new ActionListener() 
		{
		public void actionPerformed(ActionEvent e) {
			print_txt.setText(null);
			String store_word_input = input_txt.getText();
			String translation = getTranslation(wordList, store_word_input, "English");
			print_txt.setText(translation);
			System.out.println("Translation: " + translation); //debug
			}
		});
		
		//Creates button for Spanish translation
		Button spanish_btn = new Button("Spanish");
		spanish_btn.setBounds(380, 200, 100, 60); //x, y, w, h
		spanish_btn.addActionListener(new ActionListener() 
		{
		public void actionPerformed(ActionEvent e) {
			print_txt.setText(null);
			String store_word_input = input_txt.getText();
			String translation = getTranslation(wordList, store_word_input, "Spanish");
			print_txt.setText(translation);
			System.out.println("Translation: " + translation); //debug
			}
		});
		
		
		//Creates button for Italian translation
		Button italian_btn = new Button("Italian");
		italian_btn.setBounds(260, 200, 100, 60); //x, y, w, h
		italian_btn.addActionListener(new ActionListener() 
		{
		public void actionPerformed(ActionEvent e) {
			print_txt.setText(null);
			String store_word_input = input_txt.getText();
			String translation = getTranslation(wordList, store_word_input, "Italian");
			print_txt.setText(translation);
			System.out.println("Translation: " + translation); //debug
					
			}
		});
		
		//Creates button for Swedish translation
		Button swedish_btn = new Button("Swedish");
		swedish_btn.setBounds(140, 200, 100, 60); //x, y, w, h
		swedish_btn.addActionListener(new ActionListener() 
		{
		public void actionPerformed(ActionEvent e) {
			print_txt.setText(null);
			String store_word_input = input_txt.getText();
			String translation = getTranslation(wordList, store_word_input, "Swedish");
			print_txt.setText(translation);
			System.out.println("Translation: " + translation); //debug
			
					
			}
		});
				
		
		
        f.add(english_btn);
		f.add(spanish_btn);
		f.add(italian_btn);
		f.add(swedish_btn);	
		f.add(input_txt);
		f.add(translate_btn);
		f.add(print_txt);
		f.setSize(515, 500);
		f.setLayout(null);
		f.setVisible(true);
		
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
