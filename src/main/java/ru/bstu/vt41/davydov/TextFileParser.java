package ru.bstu.vt41.davydov;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TextFileParser {

    Apartment parseApartment(String path) throws IOException, ParseException {
        BufferedReader reader = Files.newBufferedReader(Paths.get(path));
        Stack<Apartment> apartments = new Stack<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        dateFormat.setDateFormatSymbols(DateFormatSymbols.getInstance(Locale.ENGLISH));
        Pattern pattern = Pattern.compile
                (".*builddate.*\"(.+)\"|.*material.*\"(.+)\"|.*square.*\"(.+)\"");
        StringBuilder paramsBuilder = new StringBuilder();
        reader.lines()
                .filter(Pattern.compile("(builddate|material|square)").asPredicate())
                .forEach(s->{
                    Matcher matcher = pattern.matcher(s);
                    if(matcher.matches()){
                        if(matcher.group(1)!=null){
                            apartments.add(new Apartment());
                            try {
                                System.out.println(matcher.group(1));
                                apartments.peek().setBuildDate(dateFormat.parse(matcher.group(1)));
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                        }else if(matcher.group(2)!=null){
                            apartments.peek().setMaterial(matcher.group(2));
                        }
                        else{
                            apartments.peek().setSquare(Double.parseDouble(matcher.group(3)));
                        }
                    }
                });


        return null;
    }

}
