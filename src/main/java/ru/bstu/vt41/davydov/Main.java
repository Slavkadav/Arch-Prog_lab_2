package ru.bstu.vt41.davydov;

import ru.bstu.vt41.davydov.Utils.TextFileParser;

import java.io.IOException;
import java.nio.file.Paths;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {

        TextFileParser parser = new TextFileParser(Paths.get("/home/dev/IdeaProjects/lab2/src/main/assets/lab_2_v3.txt"));

        parser.parsePerson();

    }

}
