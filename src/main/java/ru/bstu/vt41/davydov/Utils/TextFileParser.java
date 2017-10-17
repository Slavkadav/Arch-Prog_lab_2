package ru.bstu.vt41.davydov.Utils;

import ru.bstu.vt41.davydov.Entities.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextFileParser {

    private BufferedReader reader;

    private final Pattern bookNumberPattern = Pattern.compile(".*<property name=\"bookNumber\">(\\S+)</property>.*");
    private final Pattern certificatePattern = Pattern.compile(".*<property name=\"certificat\">([^<]*)</property>.*");


    public TextFileParser(String filePath) throws IOException {
        reader = Files.newBufferedReader(Paths.get(filePath));
    }


    public ArrayList<Person> parsePerson() throws IOException, ParseException {

        int bookNumber = -1;
        String certificate = "";

        ArrayList<Person> persons = new ArrayList<>();



        String str;
        while ((str = reader.readLine()) != null) {

            Matcher bookNumberMatcher = bookNumberPattern.matcher(str);
            Matcher certificateMatcher = certificatePattern.matcher(str);
            if (bookNumberMatcher.matches()) {
                bookNumber = Integer.parseInt(bookNumberMatcher.group(1));
            }
            if (certificateMatcher.matches()) {
                certificate = certificateMatcher.group(1);
            }

            if (bookNumber != -1 && !certificate.isEmpty()) {
                persons.add(new Person(bookNumber, certificate));
                //Сброс параметров наверняка не самое лучшее решение
                bookNumber = -1;
                certificate = "";
            }

        }
        reader.close();


        return persons;
    }

}
