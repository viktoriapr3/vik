import java.util.Scanner;

// Клас для роботи з числами Фібоначчі
class FibonacciNumber {
    private int index;  // Номер числа Фібоначчі
    private int value;  // Значення числа Фібоначчі

    // Конструктор
    public FibonacciNumber(int index) {
        this.index = index;
        this.value = calculateFibonacci(index);
    }

    // Метод для розрахунку числа Фібоначчі за номером
    private int calculateFibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }

    // Метод для отримання значення числа Фібоначчі
    public int getValue() {
        return value;
    }

    // Метод для отримання індексу числа Фібоначчі
    public int getIndex() {
        return index;
    }
}

public class Main {

    // Метод для підрахунку суми квадратів перших N чисел Фібоначчі
    public static int sumOfSquares(int N) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            FibonacciNumber fibNum = new FibonacciNumber(i);
            sum += fibNum.getValue() * fibNum.getValue();
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Перевірка наявності аргументів командного рядка
        int N = 0;
        if (args.length > 0) {
            try {
                N = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Неправильний формат числа в аргументах командного рядка.");
                return;
            }
        } else {
            System.out.print("Введіть кількість чисел Фібоначчі: ");
            N = scanner.nextInt();
        }

        if (N <= 0) {
            System.out.println("Число повинно бути більшим за 0.");
            return;
        }

        // Виведення перших N чисел Фібоначчі
        System.out.println("Перші " + N + " числа Фібоначчі:");
        for (int i = 0; i < N; i++) {
            FibonacciNumber fibNum = new FibonacciNumber(i);
            System.out.println("Число Фібоначчі №" + (i+1) + " = " + fibNum.getValue());
        }

        // Обчислення суми квадратів
        int sumSquares = sumOfSquares(N);
        System.out.println("Сума квадратів перших " + N + " чисел Фібоначчі = " + sumSquares);
    }
}
