package ru.bstu.vt41.davydov.Entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Person {
    int bookNumber;
    String certificate;
}
