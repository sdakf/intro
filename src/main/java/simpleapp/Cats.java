package simpleapp;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cats {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Cat kot = new Cat();

        System.out.print("Podaj imie kota ");
        kot.setImie(getUserInput());

        System.out.print("Podaj opiekuna ");
        kot.setImieOpiekuna(getUserInput());

        System.out.print("podaj date urodzenia ");
        kot.setDob(getUserInputData());

        System.out.print("podaj wagę kota ");
        kot.setWaga(getUserInputWaga());

        System.out.print("Dziekuje, wiem wszystko");
        kot.przedstawSie();
    }

    public static String getUserInput() {
        return sc.nextLine();
    }


    public static Date getUserInputData() {
        SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");

        Date date = null;
        do {
            String nextLine = sc.nextLine();
            try {
                date = sfd.parse(getUserInputDateRegex(nextLine));
            } catch (Exception pe) {
                System.out.print("cos jest nie tak z formatem daty");
            } finally {
                System.out.println("podaj date w formacie yyyy.mm.dd ");
            }
        } while (date == null);

        return date;
    }


    //zapisywanie wagi kota
    public static Float getUserInputWaga() {
        //konstruktor klasy float, który przyjmuje String

        Float waga = null;
        do {
            try {
                waga = Float.valueOf(getUserInput());
            } catch (NumberFormatException e) {
                System.out.print("zły format daty");
            } finally {
                System.out.print("podaj liczne ");
            }
        } while (waga == null);

        return waga;
    }
//pobieranie daty z wyrażeniami regularnymi

    public static String getUserInputDateRegex(String data) {
        Pattern pattern = Pattern.compile("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)");
        Matcher matcher = pattern.matcher(data);
        boolean match = matcher.matches();
        if (match == false) {
            System.out.println("podaj datę w formacie 30/11/2010");
            throw new IllegalArgumentException("zła data");
        } else {
            System.out.println("dziekuje");
        }
        return data;
    }
}