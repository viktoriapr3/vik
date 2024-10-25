package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BattleLogger {

    private static final String FILE_NAME = "battle_log.txt"; // Назва файлу для запису боїв

    public static void logBattle(List<String> battleSteps) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) { // Додаємо до файлу
            for (String step : battleSteps) {
                writer.write(step); // Записуємо кожен крок бою
                writer.newLine();
            }
            writer.write("-----"); // Розділення між боями
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Помилка запису бою: " + e.getMessage()); // Повідомлення про помилку
        }
    }

    public static List<String> readBattleLog() {
        List<String> logs = new ArrayList<>(); // Ініціалізація списку для зберігання записів
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) { // Читаємо файл
            String line;
            while ((line = reader.readLine()) != null) {
                logs.add(line); // Додаємо рядки до списку
            }
        } catch (IOException e) {
            System.out.println("Помилка читання журналу боїв: " + e.getMessage()); // Повідомлення про помилку
        }
        return logs; // Повертаємо список записів
    }
}
