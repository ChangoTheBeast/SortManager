package com.sparta.reece.utilities;

import com.sparta.reece.logger.Log;
import com.sparta.reece.view.Printer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class RandomStringGenerator {

    public static String[] getStrings(int size) {
        String[] strings = new String[size];
        try (Scanner scanner = new Scanner(new File("resources/words.txt"))) {
            int count = 0;
            Random random = new Random();
            while (scanner.hasNext()) {
                String line = scanner.nextLine().toLowerCase();
                count++;
                int randomIndex = random.nextInt(count);
                if (count <= size) {
                    strings[count-1] = line;
                } else if (randomIndex < size) {
                    strings[randomIndex] = line;
                }
            }
            return strings;
        } catch (FileNotFoundException e) {
            Log log = new Log();
            log.logException(e);
            Printer.printError(e);
        }
        return strings;
    }
}
