import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите числовую операцию: ");

        String input = scanner.nextLine();


        String result = Calculator.calc(input);
        System.out.println("Результат вычислений " + result);


    }
}