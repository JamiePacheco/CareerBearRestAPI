package com.careerrbear.CareerBear.quiz.model.results;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Converter
public class StringToListConverter implements AttributeConverter<List<String>, String> {
    @Override
    public String convertToDatabaseColumn(List<String> stringList) {
        if (stringList == null) return "";
        return String.join(",", stringList);
    }

    @Override
    public List<String> convertToEntityAttribute(String s) {
        if (s == null) return new ArrayList<>();
        return new ArrayList<>(Arrays.asList(s.split(",")));
    }
}
