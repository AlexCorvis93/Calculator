
import java.io.IOException;
import java.util.Scanner;


class Main {
    static char operation;//
    static String num1; //
    static String num2;//
    static byte number1, number2;
    static int result;
    static char[] oper = {'+', '-', '/', '*'};

    public static void main(String[] Input) throws IOException {
        //Принимаем строку от пользователя
        System.out.println("Введите выражение формата a (+ - * /) b, числа могут быть как арабскими так и римскими, нажмите Enter ");
        Scanner scanner = new Scanner(System.in);
        String users_input = scanner.nextLine();
        //Проверяем если пользователь не дописал математическое выражение
        if(users_input.length() <=3){
            try {
                throw new IOException();
            }catch (IOException e){
                System.out.println("строка не является математической операцией ");
                return;
            }
        }
        char[] result_input = new char[10];//массив для хранения данных с ввода
        for (byte i = 0; i < users_input.length(); i++) {
            result_input[i] = users_input.charAt(i);//вставляем символы из ввода данных в массив
        }
        /*Если знак операции с ввода совпадает с разрешенными операциями,
        то добавляем значение в переменную.
         */
        for (Character x : oper) {
            for (Character y : result_input) {
                if (x.equals(y))
                    operation = y;
            }
        }
        //Если пользователь ввел недопустимы знак операции, выбрасываем исключение.
        if(Checking.checkOperation(result_input, oper)) {
            try {
                throw new ArithmeticException();
            } catch (ArithmeticException e) {
                System.out.println("Недопустимая операция");
                return;
            }
        }
        String numbers = String.valueOf(result_input).trim();//Преобразуем массив в строку  по умолчанию
        String[] get_numbers = numbers.split("[+-/*]");//Убираем символы операции из массива
        num1 = get_numbers[0].trim();// Из массива извлекаем первое число и удаляем пробелы до и после
        num2 = get_numbers[1].trim();//Извлекаем второе и удаляем пробелы до и после
        //
        if (Checking.checkOperand(get_numbers)){
            try {
                throw new IOException();
            }catch (IOException e){
                System.out.println("Нельзя задавать больше двух операндов");
                return;
            }

        }
        //Если числа Римские
        if (Checking.isRoman(num1, num2)) {
            number1 = Convertation.convert_rim_to_arabic(num1);
            number2 = Convertation.convert_rim_to_arabic(num2);
            //Проверяем чтобы операнды были в допустимом диапазоне
            if (Checking.checkRange(number1, number2)) {
                return;
            }
            result = calculate(number1, number2, operation);
            // Если результат отрицательный, выдаем исключение
            if (result < 1) {
                try {
                    throw new ArithmeticException();
                } catch (ArithmeticException e) {
                    System.out.println("В римской системе счисления нет отрицательных чисел");
                    return;
                }
            }
            String rome_res = Convertation.convert_result_to_Roman(result);
            System.out.println(rome_res);
            return;
        }

        //Если числа Арабские
        if(Checking.isArabic(num1, num2)){
            number1 = Byte.parseByte(num1);
            number2 = Byte.parseByte(num2);
            //Проверяем чтобы операнды были в допустимом диапазоне
            if(Checking.checkRange(number1, number2)){
                return;
            }
            result = calculate(number1, number2, operation);
            System.out.println(result);
        }

    }


   static int calculate(int a, int b, char operation) {
        int res = switch (operation) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> a / b;
            default -> 0;
        };
       return res;
    }

}

