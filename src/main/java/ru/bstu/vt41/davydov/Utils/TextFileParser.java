package ru.bstu.vt41.davydov.Utils;

import ru.bstu.vt41.davydov.Entities.Apartment;
import ru.bstu.vt41.davydov.Entities.Person;
import ru.bstu.vt41.davydov.Entities.VolleyBall;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Date;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextFileParser {

    private BufferedReader reader;
    private NumberFormat numberFormat;

    public TextFileParser(Path filePath) throws IOException {
        reader = Files.newBufferedReader(filePath);
        numberFormat = NumberFormat.getInstance(Locale.FRANCE);
    }

    public ArrayList<Apartment> parseApartment() throws IOException, ParseException {
        //Переменные - поля будущего экземпляра класса
        //
        Date buildDate = null;
        String material = "";
        double square;

        ArrayList<Apartment> apartments = new ArrayList<>();

        Pattern pattern = Pattern.compile(
                ".*\"builddate\" : \"(\\S+)\"" +
                        "|.*\"material\" : \"(\\S+)\"" +
                        "|.*\"square\" : \"(\\S+)\""
        );


        String str;
        while ((str = reader.readLine()) != null) {
            Matcher matcher = pattern.matcher(str);
            if (matcher.matches()) {
                if (matcher.group(1) != null) {
                    buildDate = Date.valueOf(matcher.group(1));
                } else if (matcher.group(2) != null) {
                    material = matcher.group(2);
                } else if (matcher.group(3) != null) {
                    square = numberFormat.parse(matcher.group(3)).doubleValue();
                    apartments.add(new Apartment(buildDate, material, square));
                    System.out.println("created");
                }

            }
        }
        reader.close();

        return apartments;
    }

    public ArrayList<VolleyBall> parseVolleyBall() throws IOException, ParseException {
        String material = "";
        double weight;

        Pattern pattern = Pattern.compile
                (
                        "\\W*\"material\":\"(\\S+)\"|.*\"weight\":\"(\\S+)\""
                );

        ArrayList<VolleyBall> volleyBalls = new ArrayList<>();

        String str;

        while ((str = reader.readLine()) != null) {
            Matcher matcher = pattern.matcher(str);
            if (matcher.matches()) {
                if (matcher.group(1) != null) {
                    material = (matcher.group(1));
                } else if (matcher.group(2) != null) {
                    weight = numberFormat.parse(matcher.group(2)).doubleValue();
                    volleyBalls.add(new VolleyBall(material, weight));
                    System.out.println("created");
                }

            }
        }
        reader.close();
        return volleyBalls;
    }

    public ArrayList<Person> parsePerson() throws IOException, ParseException {
        int bookNumber = 0;
        String certificate;

        ArrayList<Person> persons = new ArrayList<>();

        Pattern pattern = Pattern.compile(
                ".*<property name=\"bookNumber\">(\\S+)</property>.*" +
                        "<property name=\"certificat\">([^<]*)</property>.*"
        );


        String str;
        while ((str = reader.readLine()) != null) {
            Matcher matcher = pattern.matcher(str);
            if (matcher.matches()) {
                if (matcher.group(1) != null) {
                    bookNumber = Integer.parseInt(matcher.group(1));
                }
                if (matcher.group(2) != null) {
                    certificate = matcher.group(2);
                    persons.add(new Person(bookNumber, certificate));
                }

            }
        }
        reader.close();


        return persons;
    }

}
