package main;

import Battle.Battle;
import droids.AttackDroid;
import droids.Droid;
import droids.SupportDroid;
import utils.BattleLogger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DroidBattleGame {
    private static ArrayList<Droid> droidList = new ArrayList<>(); // Список дроїдів
    private static List<String> battleSteps = new ArrayList<>(); // Список кроків бою

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("1. Створити дроїда");
            System.out.println("2. Показати список дроїдів");
            System.out.println("3. Запустити бій 1 на 1");
            System.out.println("4. Запустити бій команда на команду");
            System.out.println("5. Записати бій у файл");
            System.out.println("6. Відтворити бій зі збереженого файлу");
            System.out.println("7. Вийти з програми");
            System.out.print("Ваш вибір: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createDroid(scanner);
                    break;
                case 2:
                    showDroids();
                    break;
                case 3:
                    startOneOnOneBattle(scanner);
                    break;
                case 4:
                    startTeamBattle(scanner);
                    break;
                case 5:
                    logBattle(); // Зберегти бої у файл
                    break;
                case 6:
                    readBattleLog();
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Невірний вибір, спробуйте ще раз.");
            }
        }
        scanner.close();
    }

    private static void createDroid(Scanner scanner) {
        System.out.println("Оберіть тип дроїда:");
        System.out.println("1. Attack Droid");
        System.out.println("2. Support Droid");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Спожити новий рядок

        System.out.print("Введіть ім'я дроїда: ");
        String name = scanner.nextLine();

        Droid droid = null;
        switch (choice) {
            case 1:
                droid = new AttackDroid(name);
                break;
            case 2:
                droid = new SupportDroid(name);
                break;
            default:
                System.out.println("Невірний вибір.");
                return;
        }
        droidList.add(droid);
        System.out.println("Дроїд " + droid.getName() + " створений.");
    }

    private static void showDroids() {
        if (droidList.isEmpty()) {
            System.out.println("Дроїдів ще не створено.");
        } else {
            for (int i = 0; i < droidList.size(); i++) {
                System.out.println((i + 1) + ". " + droidList.get(i));
            }
        }
    }

    private static void startOneOnOneBattle(Scanner scanner) {
        if (droidList.size() < 2) {
            System.out.println("Недостатньо дроїдів для бою 1 на 1.");
            return;
        }

        System.out.println("Оберіть перший дроїд (1-" + droidList.size() + "):");
        int firstDroidIndex = scanner.nextInt() - 1;

        System.out.println("Оберіть другий дроїд (1-" + droidList.size() + "):");
        int secondDroidIndex = scanner.nextInt() - 1;

        if (firstDroidIndex < 0 || firstDroidIndex >= droidList.size() ||
                secondDroidIndex < 0 || secondDroidIndex >= droidList.size() ||
                firstDroidIndex == secondDroidIndex) {
            System.out.println("Невірний вибір дроїдів.");
            return;
        }

        Droid droid1 = droidList.get(firstDroidIndex);
        Droid droid2 = droidList.get(secondDroidIndex);

        Battle.oneOnOne(droid1, droid2, battleSteps);
    }

    private static void startTeamBattle(Scanner scanner) {
        System.out.println("Введіть кількість гравців у кожній команді:");
        int teamSize = scanner.nextInt();

        List<Droid> team1 = new ArrayList<>();
        List<Droid> team2 = new ArrayList<>();

        System.out.println("Оберіть дроїдів для команди 1:");
        for (int i = 0; i < teamSize; i++) {
            System.out.println("Оберіть дроїд " + (i + 1) + " (1-" + droidList.size() + "):");
            int droidIndex = scanner.nextInt() - 1;

            if (droidIndex < 0 || droidIndex >= droidList.size()) {
                System.out.println("Невірний вибір дроїда.");
                return;
            }
            team1.add(droidList.get(droidIndex));
        }

        System.out.println("Оберіть дроїдів для команди 2:");
        for (int i = 0; i < teamSize; i++) {
            System.out.println("Оберіть дроїд " + (i + 1) + " (1-" + droidList.size() + "):");
            int droidIndex = scanner.nextInt() - 1;

            if (droidIndex < 0 || droidIndex >= droidList.size()) {
                System.out.println("Невірний вибір дроїда.");
                return;
            }
            team2.add(droidList.get(droidIndex));
        }

        Battle.teamBattle(team1, team2, battleSteps);
    }

    private static void logBattle() {
        if (!battleSteps.isEmpty()) {
            BattleLogger.logBattle(battleSteps);
            System.out.println("Бій записано у файл.");
            battleSteps.clear(); // Очищуємо список після запису
        } else {
            System.out.println("Немає записів бою для збереження.");
        }
    }

    private static void readBattleLog() {
        System.out.println("Записані бої:");
        List<String> logs = BattleLogger.readBattleLog();
        if (logs.isEmpty()) {
            System.out.println("Немає записів боїв.");
        } else {
            for (String log : logs) {
                if (!log.equals("-----")) {  // Ігноруємо розділення
                    System.out.println(log);
                } else {
                    System.out.println();  // Порожній рядок для розділення боїв
                }
            }
        }
    }
}

