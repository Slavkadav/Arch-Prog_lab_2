package ru.bstu.vt41.davydov;

import java.io.IOException;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {

        TextFileParser parser = new TextFileParser();

        parser.parseApartment("/home/dev/IdeaProjects/lab2/src/main/assets/lab_2_v1.txt");

    }

}
