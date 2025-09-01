package SAIKETINTERN;
import java.io.*;
import java.util.*;

public class TextFileAnalyzer 
{

    public static void main(String[] args) 
    {
       
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Text File Analyzer!");
        System.out.print("Enter the full path of the text file to analyze: ");
        String filePath = sc.nextLine();

        // Variables to store the counts.
        int wordCount = 0;
        int lineCount = 0;
        int characterCount = 0;

        try {
            // Create a File object from the user's input.
            File file = new File(filePath);

            // Create a Scanner to read from the file.
            Scanner fileScanner = new Scanner(file);

            // Loop through each line of the file.
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                lineCount++;

                // Add the characters in the current line to the total count.
                // We add 1 for the newline character that nextLine() removes.
                characterCount += line.length() + 1;

                // Split the line into words using spaces as a separator.
                // A regular expression is used to handle multiple spaces.
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }

            // Close the file scanner to release resources.
            fileScanner.close();

            // Display the analysis results.
            System.out.println("\n--- File Analysis Report ---");
            System.out.println("Lines: " + lineCount);
            System.out.println("Words: " + wordCount);
            System.out.println("Characters: " + characterCount);

        
            System.out.println("\n--- Word Search ---");
            System.out.print("Enter a word to search for: ");
            String wordToSearch = sc.nextLine().toLowerCase();
            
            // Re-create the file scanner to start from the beginning.
            Scanner searchScanner = new Scanner(file);
            int occurrences = 0;

            while (searchScanner.hasNext()) {
                String word = searchScanner.next().toLowerCase();
                if (word.contains(wordToSearch)) {
                    occurrences++;
                }
            }

            // Display the search results.
            System.out.println("The word '" + wordToSearch + "' appeared " + occurrences + " time(s).");
            searchScanner.close();

        } catch (FileNotFoundException e) {
            
            System.out.println("Error: The file could not be found. Please check the file path.");
        } catch (Exception e) {
            // A general catch block for any other unexpected errors.
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            // This block will always run, whether there's an error or not.
            
            sc.close();
        }
    }
}