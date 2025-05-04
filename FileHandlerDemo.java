package com.tap;

import java.io.*;
import java.util.Scanner;

/**
 * FileHandlerDemo
 * Demonstrates basic file operations in Java:
 * 1. Writing to a file
 * 2. Reading from a file
 * 3. Modifying a file
 * 
 * This script is part of a deliverable for demonstrating Java File Handling Utility.
 * Organization: CODTECH Internship
 */
public class FileHandlerDemo {

    static final String FILE_NAME = "internship_data.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Write to file
        writeToFile("COMPLETION CERTIFICATE WILL BE ISSUED ON YOUR INTERNSHIP END DATE.\n");

        // Step 2: Read from file
        System.out.println("Reading File Content:");
        readFromFile();

        // Step 3: Modify file content
        System.out.println("\nModifying File Content...");
        System.out.print("Enter new text to append to the file: ");
        String newText = scanner.nextLine();

        appendToFile(newText + "\n");

        System.out.println("Updated File Content:");
        readFromFile();

        scanner.close();
    }

    /**
     * Writes initial content to the file.
     * If the file exists, it will be overwritten.
     */
    public static void writeToFile(String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write(content);
            writer.write("FILE HANDLING UTILITY DEMONSTRATION\n");
            writer.write("DELIVERABLE: A SCRIPT DEMONSTRATING FILE OPERATIONS\n");
            writer.write("ORGANIZATION: CODTECH\n");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    /**
     * Reads and prints content from the file.
     */
    public static void readFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }

    /**
     * Appends new content to the existing file.
     */
    public static void appendToFile(String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(content);
        } catch (IOException e) {
            System.out.println("Error appending to file: " + e.getMessage());
        }
    }
}

