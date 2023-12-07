//interface and inherantace just fucked me over so I stopped working on that lol


//ChatGPT generat pga fastnade 
//prompten använd 
//help me make a java program that can take 10 words and store them in a list. these words should have a English, spanish, itanlian and swedish version so that I can enter the word and choice which version of that word I want
//Kommer med stor sanoolikhet använda bitar av denna koden men inte allt då den inte behövs :)


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MultilingualDictionary {
    public static void main(String[] args) {
        // Initialize the list to store words
        List<Map<String, String>> wordList = new ArrayList<>();

        // Populate the list with 10 words and their translations
        addWord(wordList, "Hello", "Hola", "Ciao", "Hej");
        addWord(wordList, "Goodbye", "Adiós", "Arrivederci", "Adjö");
        addWord(wordList, "Thank you", "Gracias", "Grazie", "Tack");
        // Add more words as needed...

        // Get user input for word and language choice
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a word:");
        String userWord = scanner.nextLine();

        System.out.println("Choose a language (1: English, 2: Spanish, 3: Italian, 4: Swedish):");
        int languageChoice = scanner.nextInt();

        // Display the translation based on user input
        String translation = getTranslation(wordList, userWord, languageChoice);
        System.out.println("Translation: " + translation);
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
    private static String getTranslation(List<Map<String, String>> wordList, String userWord, int languageChoice) {
        // Ensure languageChoice is within valid range
        if (languageChoice < 1 || languageChoice > 4) {
            return "Invalid language choice";
        }

        // Adjusting for 0-based index
        int index = languageChoice - 1;

        for (Map<String, String> wordMap : wordList) {
            // Check if the word exists in the English version
            if (wordMap.get("English").equalsIgnoreCase(userWord)) {
                // Return the translation based on the language choice
                return wordMap.values().toArray()[index].toString();
            }
        }

        return "Word not found in the dictionary";
    }
}

