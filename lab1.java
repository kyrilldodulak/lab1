import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        NumberExample example = new NumberExample();
        example.populateList();  // Заповнення списку
        example.printNumbers();  // Виведення чисел
        example.printAsIntegers();  // Виведення у форматі цілих чисел
        example.printAsDecimals();  // Виведення у форматі дробних чисел з двома знаками після коми
        example.sortNumbersByType();  // Розділення чисел за типами
        example.printNumbersAsBigDecimal();  // Виведення у форматі BigDecimal
    }
}

class NumberExample {

    // Основний список для зберігання різних типів чисел
    private List<Number> numberList = new ArrayList<>();

    // Окремі списки для кожного типу чисел
    private List<Integer> integerList = new ArrayList<>();
    private List<Double> doubleList = new ArrayList<>();
    private List<Float> floatList = new ArrayList<>();

    // Генератор випадкових чисел
    private Random random = new Random();

    // Метод для заповнення списку числами різних типів
    public void populateList() {
        // Генерація випадкових чисел
        numberList.add(random.nextInt(100));        // Integer
        numberList.add(random.nextDouble() * 100);  // Double
        numberList.add(random.nextFloat() * 100);   // Float
    }

    // Метод для виведення всіх чисел у оригінальному вигляді
    public void printNumbers() {
        System.out.println("Original Numbers:");
        System.out.println(formatListAsString(numberList));
    }

    // Метод для виведення чисел у форматі цілих чисел
    public void printAsIntegers() {
        System.out.println("Numbers as Integers:");
        List<Integer> integerFormattedList = new ArrayList<>();
        for (Number number : numberList) {
            // Перевіряємо, чи є число цілим
            if (number instanceof Integer) {
                integerFormattedList.add((Integer) number);
            } else if (number instanceof Double || number instanceof Float) {
                // Округляємо дробове число і додаємо як ціле
                integerFormattedList.add(Math.round(number.floatValue()));
            }
        }
        System.out.println(formatListAsString(integerFormattedList));
    }

    // Метод для виведення чисел у форматі дробних з двома знаками після коми
    public void printAsDecimals() {
        System.out.println("Numbers as Decimals (2 decimal places):");
        List<String> decimalFormattedList = new ArrayList<>();
        for (Number number : numberList) {
            decimalFormattedList.add(String.format("%.2f", number.doubleValue()));
        }
        System.out.println(formatListAsString(decimalFormattedList));
    }

    // Метод для розділення чисел за типами
    public void sortNumbersByType() {
        for (Number number : numberList) {
            if (number instanceof Integer) {
                integerList.add((Integer) number);
            } else if (number instanceof Double) {
                doubleList.add((Double) number);
            } else if (number instanceof Float) {
                floatList.add((Float) number);
            }
        }
        System.out.println("Sorted numbers by type:");
        System.out.println("Integers: " + formatListAsString(integerList));
        System.out.println("Doubles: " + formatListAsString(doubleList));
        System.out.println("Floats: " + formatListAsString(floatList));
    }

    // Метод для виведення всіх чисел у форматі BigDecimal
    public void printNumbersAsBigDecimal() {
        System.out.println("Numbers as BigDecimal:");
        List<BigDecimal> bigDecimalFormattedList = new ArrayList<>();
        for (Number number : numberList) {
            // Створення BigDecimal з числа
            BigDecimal bigDecimal = new BigDecimal(number.toString());
            bigDecimalFormattedList.add(bigDecimal);
        }
        System.out.println(formatListAsString(bigDecimalFormattedList));
    }

    // Допоміжний метод для форматування списку у рядок [x1, x2, x3, ...]
    private <T> String formatListAsString(List<T> list) {
        return list.toString();
    }
}
