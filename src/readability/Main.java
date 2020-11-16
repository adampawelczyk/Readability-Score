package readability;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String pathToFile = args[0];
        File file = new File(pathToFile);
        String fileContent = "";
        Scanner scanner = new Scanner(System.in);

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNext()) {
                fileContent = fileScanner.nextLine();
            }

            int words = fileContent.split(" ").length;
            int sentences = fileContent.split("[.!?]").length;
            int characters = fileContent.replaceAll("\\s", "").split("").length;
            int syllables = fileContent.split("[aeiouy]+[^$e]").length;
            int polysyllables = fileContent.split("([aeiouy]+[^$e]){3,}").length;

            System.out.println("The text is:");
            System.out.println(fileContent);
            System.out.println("\nWords: " + words);
            System.out.println("Sentences: " + sentences);
            System.out.println("Characters: " + characters);
            System.out.println("Syllables: " + syllables);
            System.out.println("Polysyllables: " + polysyllables);

            System.out.print("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "all" -> {
                    double scoreARI = calculateARI(characters, words, sentences);
                    double scoreFK = calculateFK(words, sentences, syllables);
                    double scoreSMOG = calculateSMOG(polysyllables, sentences);
                    double scoreCL = calculateCL(characters, words, sentences);

                    int ageARI = calculateAge(scoreARI);
                    int ageFK = calculateAge(scoreFK);
                    int ageSMOG = calculateAge(scoreSMOG);
                    int ageCL = calculateAge(scoreCL);

                    double averageAge = (ageARI + ageFK + ageSMOG + ageCL) / 4.0;

                    System.out.println("\nAutomated Readability Index: " + String.format("%.2f", scoreARI) + " (about " + calculateAge(scoreARI) + " year olds).");
                    System.out.println("Flesch–Kincaid readability tests: " + String.format("%.2f", scoreFK) + " (about " + calculateAge(scoreFK) + " year olds).");
                    System.out.println("Simple Measure of Gobbledygook: " + String.format("%.2f", scoreSMOG) + " (about " + calculateAge(scoreSMOG) + " year olds).");
                    System.out.println("Coleman–Liau index: " + String.format("%.2f", scoreCL) + " (about " + calculateAge(scoreCL) + " year olds).");
                    System.out.println("\nThis text should be understood in average by " + String.format("%.2f", averageAge) + " year olds.");
                }
                case "ARI" -> {
                    double scoreARI = calculateARI(characters, words, sentences);
                    System.out.println("\nAutomated Readability Index: " + String.format("%.2f", scoreARI) + " (about " + calculateAge(scoreARI) + " year olds).");
                }
                case "FK" -> {
                    double scoreFK = calculateFK(words, sentences, syllables);
                    System.out.println("\nFlesch–Kincaid readability tests: " + String.format("%.2f", scoreFK) + " (about " + calculateAge(scoreFK) + " year olds).");
                }
                case "SMOG" -> {
                    double scoreSMOG = calculateSMOG(polysyllables, sentences);
                    System.out.println("\nSimple Measure of Gobbledygook: " + String.format("%.2f", scoreSMOG) + " (about " + calculateAge(scoreSMOG) + " year olds).");
                }
                case "CL" -> {
                    double scoreCL = calculateCL(characters, words, sentences);
                    System.out.println("\nColeman–Liau index: " + String.format("%.2f", scoreCL) + " (about " + calculateAge(scoreCL) + " year olds).");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + pathToFile);
        }
    }

    static int calculateAge(double score) {
        String[] ageGroups = new String[] {"6", "7", "9", "10", "11", "12", "13", "14",
                "15", "16", "17", "18", "24", "25"};
        int level = (int) Math.ceil(score) - 1;

        return Integer.parseInt(ageGroups[Math.min(level, 13)]);
    }

    static double calculateARI(int characters, int words, int sentences) {
        return 4.71 * characters / words + 0.5 * words / sentences - 21.43;
    }

    static double calculateFK(int words, int sentences, int syllables) {
        return 0.39 * words / sentences + 11.8 * syllables / words - 15.59;
    }

    static double calculateSMOG(int polysyllables, int sentences) {
        return 1.043 * Math.sqrt(polysyllables * 30.0 / sentences) + 3.1291;
    }

    static double calculateCL(int characters, int words, int sentences) {
        return 0.0588 * ((double) characters / words * 100.0) - 0.296 * ((double) sentences / words * 100 ) - 15.8;
    }
}