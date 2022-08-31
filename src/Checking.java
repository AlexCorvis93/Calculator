import java.io.IOException;

class Checking {
     static String[] roman = new String[]{"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX",
            "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
            "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
            "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

     static boolean isRoman(String num1, String num2) {
         //Если строки совпадают с значениями из массива roman
        for (String s : roman) {
            for (String x : roman) {
                if (s.equals(num1) && x.equals(num2)) {
                    return true;
                }
            }
        }
        return false;
    }


    static boolean checkOperation(char[] userInput, char[] oper ){
         //Проверяем есть ли символ в массиве разрешенных операций
        for(Character x: userInput) {
            for (Character y : oper) {
                if (x.equals(y)) {
                    return false;
                }
            }
        }
        return true;
    }

   static boolean checkOperand(String[] get_numbers){
         /*
        Проверяем чтобы операндов было небольше двух
        возращаем истину если больше двух для исключения
         */
        if(get_numbers.length > 2)
            return true;
        return false;
    }



    static boolean isArabic(String num1, String num2) throws NumberFormatException, IOException {
        /*
        Проверяем если числа арабские,
        проверяем на операнды из разных систем счисления
         */
        try {
            Integer.parseInt(num1);
            Integer.parseInt(num2);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Недопустимые или разные системы счисления");
            return false;
        }
    }

   static boolean checkRange(int number1, int number2){
        /*
        Проверяем диапазон задаваемых юзером значений от 1 до 10.
        Если выходит за рамки, выбрасываем исключение.
         */
        if(number1 < 1 || number1 > 10 || number2 < 1 || number2 > 10){
            try {
                throw new IOException();
            }catch (IOException e){
                System.out.println("Операнды должны быть заданы в диапазоне значений от 1 до 10 включительно");
                return true;
            }
        }
        return false;
    }
}
