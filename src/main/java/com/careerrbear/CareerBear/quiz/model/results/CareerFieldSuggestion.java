package com.careerrbear.CareerBear.quiz.model.results;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "CAREER_FIELD_SUGGESTION")
public class CareerFieldSuggestion {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "CAREER_FIELD")
    private String careerField;

    @Column(name = "CAREER_FIELD_DESCRIPTION", length = 400)
    private String careerFieldDescription;

    @Column(name = "CAREER_FIELD_LOGIC", length = 400)
    private String careerFieldLogic;

    //Converts list of jobs into string of jobs joined by ","
    @Column(name = "CAREER_FIELD_JOBS", length = 400)
    @Convert(converter = StringToListConverter.class)
    private List<String> careerFieldJobs;

}
