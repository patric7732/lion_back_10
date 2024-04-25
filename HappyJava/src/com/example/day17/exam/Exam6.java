package com.example.day17.exam;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Student {
    private String name;
    private int age;
    private int score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public int getScore() {
        return score;
    }

    
}

public class Exam6 {
    public static void main(String[] args) {
        //6. 나이대별 평균 점수 계산
        List<Student> students = Arrays.asList(
                new Student("Alice", 14, 88),
                new Student("Bob", 23, 82),
                new Student("Charlie", 17, 95),
                new Student("David", 21, 73)
        );

        Map<Integer, Double> averageScoresByAgeGroup = students.stream()
                .collect(Collectors.groupingBy(
                        student -> (student.getAge() / 10) * 10,
                        Collectors.averagingInt(Student::getScore)
                ));

        averageScoresByAgeGroup.forEach((ageGroup, avgScore) ->
                System.out.println(ageGroup + "s: " + avgScore)
        );
    }
}
