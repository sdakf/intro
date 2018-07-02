import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class App {

    private static List<String> animals = Arrays.asList("cat", "dog", "mouse", "  rat", " pig ", "rabbit ", "hamster", "parrot"); // Tradycyjna pętla

    public static void main(String[] args) {
        simplePrintFirstElementFromInput(args[0]);
        displayTextFromInputWithCommas(animals);
        displayTextFromInputWithCommasAndWithoutWhiteSpacesAndWithUppercase(animals);
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
