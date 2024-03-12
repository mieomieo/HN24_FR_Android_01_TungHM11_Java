package java_io.exercise1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import java_io.Constant;

public class Exercise1 {
    public static void main(String args[]) throws IOException {
        Set<String> uniqueWords = new HashSet<>();
        String filename = Constant.PROJECT_PATH + "exercise1\\text.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    word = word.toLowerCase();
                    uniqueWords.add(word);
                }
            }
            System.out.println("Số lượng từ duy nhất trong file: "+uniqueWords.size());
        } catch (IOException e) {
            System.err.println("Đã xảy ra lỗi khi đọc tệp: " + e.getMessage());
        }
    }


}
