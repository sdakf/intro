import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {

    private static List<String> animals = Arrays.asList("cat", "dog", "mouse", "  rat", " pig ", "rabbit ", "hamster", "parrot"); // Tradycyjna pętla

    public static void main(String[] args) {
        simplePrintFirstElementFromInput(args[0]);
        displayTextFromInputWithCommas(animals);
        displayTextFromInputWithCommasAndWithoutWhiteSpacesAndWithUppercase(animals);
        calculateUserInput();
    }

    private static void calculateUserInput() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj pierwszą liczbę");
        int a = scanner.nextInt();
        System.out.println("Podaj drugą liczbę");
        int b = scanner.nextInt();
        System.out.println("Podaj operację");
        String operation = scanner.next();
        String result = CalculatorService.calculate(a, b, operation);
        System.out.println("Wynik to: " + result);
    }

    private static void displayTextFromInputWithCommasAndWithoutWhiteSpacesAndWithUppercase(List<String> collection) {
        int i = 1;
        for (String element : collection) {
            System.out.print(element.toUpperCase().trim() + (i > element.length() ? "" : ","));
            i++;
        }
        System.out.println();
        System.out.println(collection.stream().map(e->e.toUpperCase().trim()).collect(Collectors.joining(",")));
    }

    private static void displayTextFromInputWithCommas(Collection<String> collection) {
        int i = 1;
        for (String element : collection) {
            System.out.print(element + (i > element.length() ? "" : ","));
            i++;
        }
        System.out.println();
        System.out.println(String.join(",", collection));
    }


    private static void simplePrintFirstElementFromInput(String arg) {
        System.out.println(arg);
    }
}
