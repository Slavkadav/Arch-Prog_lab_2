package ru.bstu.vt41.davydov;

import ru.bstu.vt41.davydov.Entities.Person;
import ru.bstu.vt41.davydov.Utils.TextFileParser;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class Main {

    private static final String FILE_PATH = "src/main/resource/lab_2_v3.xml";

    public static void main(String[] args) throws IOException, ParseException {

        ArrayList<Person> people = new TextFileParser(FILE_PATH).parsePerson();

        people.stream().map(Object::toString).forEach(System.out::println);

    }

}
