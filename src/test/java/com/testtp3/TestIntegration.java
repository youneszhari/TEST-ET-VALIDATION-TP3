package com.testtp3;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestIntegration {
    @Test
    public void testInscriptionEtudiant() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        Student student = new Student("S2", "HAMID", 18);
        Course course = new Course("Dev Frontend", "SAID");
        NotificationService notifier = new NotificationService();
        EnrollmentService service = new EnrollmentService(notifier);

        service.enroll(student, course);

        String expectedMessage = "Notification: HAMID has enrolled in Dev Frontend taught by professor SAID";
        String actualMessage = output.toString();

        System.setOut(System.out);

        System.out.println("Test d’intégration : Vérifier le message de notification");
        System.out.println("Message attendu : " + expectedMessage);
        System.out.println("Message obtenu  : " + actualMessage);

        assertEquals(expectedMessage.trim(), actualMessage.trim());
    }
}

