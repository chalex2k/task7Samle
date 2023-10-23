/*
Найти максимальный по длине интервал в массиве, не содержащий простых чисел, но расположенный между простыми числами. Вывести индекс первого элемента этого интервала и длину интервала.
Если существует несколько интервалов с максимальной длиной, вывести первый. Если не существует ни одного интервала вывести -1, -1.
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        testIsPrime();
        int[] arr = inputIntArray();
        Interval ans = findMaxInterval(arr);
        printAnswer(ans);
    }

    public static int[] inputIntArray() {
        // return int[]{1, 2, 3, 4, 5}

        System.out.print("Введите массив (в одну строку через пробел): ");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        // Считывание массива из строки чисел через пробел
        String[] lineArray = line.split(" ");
        int[] numbers = new int[lineArray.length];
        for (int i = 0; i < lineArray.length; i++) {
            numbers[i] = Integer.parseInt(lineArray[i]);
        }

        // то же самое через стрим
        // int[] numbers2 = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();

        return numbers;
    }

    public static Interval findMaxInterval(int[] arr) {
        Interval ans = Interval.defaultInterval();
        int prevPrimeIndex = -1;  // -1 пока не нашли ни одного простого числа
        for (int i = 0; i < arr.length; i++) {
            if (isPrime(arr[i])) {
                if (prevPrimeIndex != -1) {  // раньше уже было простое число
                    ans = tryUpdateAns(ans, prevPrimeIndex, i);
                }
                prevPrimeIndex = i;
            }
        }

        return ans;
    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int d = 2; d * d <= n; d++) {
            if (n % d == 0) {
                return false;
            }
        }

        return true;
    }

    public static void testIsPrime() {
        assert isPrime(2);
        assert isPrime(3);
        assert isPrime(7);
        assert isPrime(19);
        assert isPrime(983);

        assert !isPrime(0);
        assert !isPrime(1);
        assert !isPrime(10);
        assert !isPrime(2);
        assert !isPrime(4);
        assert !isPrime(25);
    }

    // Проверяет интервал (start; stop). Если новый интервал больше currAns, возвращает новый интервал. Иначе возвращает currInt.
    public static Interval tryUpdateAns(Interval currInt, int start, int stop) {
        Interval newInt = new Interval(start + 1, stop - start - 1);
        if (newInt.length > currInt.length) {
            return newInt;
        }

        return currInt;
    }

    public static void printAnswer(Interval ans) {
        System.out.printf("индекс 1 эл-та: %d\nдлина интервала: %d\n", ans.firstIndex, ans.length);
    }

}