class Convertation {

    static String convert_result_to_Roman(int arab) {
        /*
        Конвертируем арабское число обратно в римское для отображения ответа
         */
        return Checking.roman[arab];
    }


    static byte convert_rim_to_arabic(String rimNum) {
        /*
        Конвертируем римское число  в арабскоее для подсчета ответа
         */
        return switch (rimNum) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> 0;
        };

    }
}
