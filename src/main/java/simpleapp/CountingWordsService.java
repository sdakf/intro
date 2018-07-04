package simpleapp;

import com.google.common.collect.Maps;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class CountingWordsService {

    public static void main(String[] args) {
        String poem = "Not vinegar. Not acid. Not\n" +
                "sugarcane pressed to mortar by\n" +
                "fist, but salt: salt, the home taste; salt,\n" +
                "the tide; salt, the blood. Not Holy\n" +
                "\n" +
                "Ghost, but a saint of coral come\n" +
                "to life in the night crossing a\n" +
                "field of brambles and thorns, the camps\n" +
                "of pirates beat back to the bay\n" +
                "\n" +
                "with hornets. Not Santo Niño.\n" +
                "And not a belt of storms, but this:\n" +
                "girls singing, an avocado\n" +
                "in each open palm, courting doves;\n" +
                "\n" +
                "a moth drawn to the light of our\n" +
                "room you take to be your father.";


        String[] words = poem.split("[^a-zA-Z]+");
        countWordsInForLoop(words);
        countWordsInStream(words);

    }

    public static Map<String, Long> countWordsInStream(String[] poem) {
        return Arrays.stream(poem).collect(Collectors.groupingBy(e -> e, Collectors.counting()));
    }

    public static Map<String, Long> countWordsInForLoop(String[] words) {
        System.out.println();

        Map<String, Long> result = Maps.newHashMap();
        for (String word : words) {
            if (result.containsKey(word)) {
                result.put(word, result.get(word) + 1);
            } else {
                result.put(word, 1L);
            }
        }
        return result;
    }

}
