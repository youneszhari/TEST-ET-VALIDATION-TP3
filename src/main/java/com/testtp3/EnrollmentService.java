package com.testtp3;

public class EnrollmentService {
  private NotificationService notifier;

  public EnrollmentService(NotificationService notifier) {
    this.notifier = notifier;
  }

  public void enroll(Student student, Course course) {
    notifier.send(student.getName() + " has enrolled in " + course.getCourseName() + " taught by " + course.getTeacher());
  }
}
