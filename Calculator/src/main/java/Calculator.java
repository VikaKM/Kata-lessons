public class Calculator {
    private static boolean isRoman = false;

    public static String calc(String input) throws Exception {
        int result;
        StringBuffer znaks = new StringBuffer();

        char[] chars = input.toCharArray();
        for (char c : chars) {
            if ((c == '+') || (c == '-') || (c == '*') || (c == '/')) {
                znaks.append(c);
            }
        }
        validate(znaks.toString());

        String[] temp = input.split("[+\\-*/]");


        String firstNumber = temp[0];
        String secondNumber = temp[1];

        int[] numbers = validateNumbers(firstNumber, secondNumber);
        int x = numbers[0];
        int y = numbers[1];

        switch (znaks.toString()) {
            case "+" -> result = x + y;
            case "-" -> result = x - y;
            case "*" -> result = x * y;
            case "/" -> result = x / y;
            default -> throw new Exception();
        }


        return (isRoman) ? (Transform.transformToRoman(result)) : (String.valueOf(result));
    }

    private static void validate(String znaks) throws Exception {
        if (znaks.isEmpty()) {
            System.out.println("Не является математической операцией");
            throw new Exception();
        }

        if (znaks.length() > 1) {
            System.out.println("Может использоваться только 1 оператор");
            throw new Exception();
        }
        char operation = znaks.charAt(0);
        if ((operation != '+') && (operation != '-') && (operation != '*') && (operation != '/')) {
            System.out.println("Могут использоваться только следующие операторы: +, -, *, /");
            throw new Exception();
        }
    }

    private static int[] validateNumbers(String number1, String number2) throws Exception {
        int[] numbers = new int[2];
        try {
            numbers[0] = Integer.parseInt(number1);
            numbers[1] = Integer.parseInt(number2);
        } catch (NumberFormatException exception) {
            numbers[0] = checkRomanNumber(number1);
            numbers[1] = checkRomanNumber(number2);
            isRoman = true;
        }

        validate(numbers[0]);
        validate(numbers[1]);

        return numbers;
    }

    private static int checkRomanNumber(String number) throws Exception {
        int n;
        switch (number) {
            case "I" -> n = RomanNumber.I.getValue();
            case "II" -> n = RomanNumber.II.getValue();
            case "III" -> n = RomanNumber.III.getValue();
            case "IV" -> n = RomanNumber.IV.getValue();
            case "V" -> n = RomanNumber.V.getValue();
            case "VI" -> n = RomanNumber.VI.getValue();
            case "VII" -> n = RomanNumber.VII.getValue();
            case "VIII" -> n = RomanNumber.VIII.getValue();
            case "IX" -> n = RomanNumber.IX.getValue();
            case "X" -> n = RomanNumber.X.getValue();
            default -> {
                try {
                    Integer.parseInt(number);
                } catch (NumberFormatException e) {
                    System.out.println("Могут использоваться только арабские или римские цифры");
                    throw new Exception();
                }
                System.out.println("Одновременно может использоваться только одна система исчисления");
                throw new Exception();
            }
        }

        return n;
    }

    private static void validate(int n) throws Exception {
        if (n < 1 || n > 10) {
            System.out.println("Могут использоваться только числа от 1 до 10");
            throw new Exception();
        }
    }
}