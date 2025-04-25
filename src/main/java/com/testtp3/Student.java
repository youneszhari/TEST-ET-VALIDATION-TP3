package com.testtp3;

public class Student {
  private String id;
  private String name;
  private double grade;

  public Student(String id, String name, double initialGrade) {
    this.id = id;
    this.name = name;
    this.grade = initialGrade;
  }
  
  public void updateGrade(double newGrade) {
    if (newGrade < 0 || newGrade > 20) {
      throw new IllegalArgumentException("Invalid grade");
    }
    grade = newGrade;
  }

  public double getGrade() {
    return grade;
  }

  public String getName() {
    return name;
  }
}
