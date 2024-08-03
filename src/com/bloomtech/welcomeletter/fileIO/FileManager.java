package com.bloomtech.welcomeletter.fileIO;

import java.io.*;
import java.util.Scanner;

public class FileManager {
    public FileManager() {
    }

    public String getTextFromFile(String filename) {
        String returnString = "";
        try {
            File file = new File("src/resources/" + filename + ".txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);


            String line = bufferedReader.readLine();
            while (line != null) {
                returnString += line + "\n";
                line = bufferedReader.readLine();
            }

            bufferedReader.close();

        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return returnString;
    }

    public void writeTextToFile(String outFileName, String text) {
        try {
            File file = new File("src/resources/" + outFileName + ".txt");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(text);

            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}