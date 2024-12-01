package com.walking.intensive.chapter2.task10;

/**
 * Реализуйте метод isPalindrome(), который проверяет, является ли строка палиндромом.
 *
 * <p>Метод должен игнорировать пунктуацию, пробелы и регистр.
 *
 * <p>P.S. Мой любимый палиндром: Муза! Ранясь шилом опыта, ты помолишься на разум.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task10 {
    public static void main(String[] args) {
//        Для собственных проверок можете делать любые изменения в этом методе
        System.out.println(isPalindrome("ара"));
    }

    static boolean isPalindrome(String inputString) {
        if (null == inputString || inputString.length() < 3){
            return false;
        }

        inputString = inputString.replaceAll("(?U)[\\pP\\s]", "");
        StringBuilder flipString = new StringBuilder(inputString);
        flipString.reverse();

        return new String(flipString).equalsIgnoreCase(inputString);
    }
}
