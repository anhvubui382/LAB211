import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Dictionary {
    private HashMap<String, String> dictionary;
    private final String filename = "dictionary.txt";

    public Dictionary() {
        dictionary = new HashMap<>();
        loadData();  // Load dictionary from file if exists
    }

    // Function to load data from file to HashMap
    private void loadData() {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    dictionary.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            System.out.println("No dictionary data found. Starting with an empty dictionary.");
        }
    }

    // Function to update the file database
    private void updateDatabase() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            for (Map.Entry<String, String> entry : dictionary.entrySet()) {
                pw.println(entry.getKey() + "=" + entry.getValue());
            }
        } catch (IOException e) {
            System.out.println("Error updating the database.");
        }
    }

    // Add a word to the dictionary
    public boolean addWord(String eng, String vi) {
        if (dictionary.containsKey(eng)) {
            System.out.println("Word already exists. Do you want to update it? (yes/no): ");
            Scanner sc = new Scanner(System.in);
            String choice = sc.nextLine();
            if (!choice.equalsIgnoreCase("yes")) {
                return false;
            }
        }
        dictionary.put(eng, vi);
        updateDatabase();
        System.out.println("Word added/updated successfully.");
        return true;
    }

    // Remove a word from the dictionary
    public boolean removeWord(String eng) {
        if (!dictionary.containsKey(eng)) {
            System.out.println("Word not found.");
            return false;
        }
        dictionary.remove(eng);
        updateDatabase();
        System.out.println("Word removed successfully.");
        return true;
    }

    // Translate an English word to Vietnamese
    public String translate(String eng) {
        return dictionary.getOrDefault(eng, "Word not found.");
    }
}
