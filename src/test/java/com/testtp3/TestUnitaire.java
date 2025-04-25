package com.testtp3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

public class TestUnitaire {
  @Test
  public void testCreationEtudiant() {
      try {
          Student student = new Student("S1", "KHADIJA", 14.0);
          double expected = 14.0;
          double actual = student.getGrade();

          System.out.println("Test 1 : Création d'un étudiant");
          System.out.println("Note attendue : " + expected + ", Note obtenue : " + actual);
          assertEquals(expected, actual);
      } catch (Exception e) {
          fail("Erreur inattendue lors de la création : " + e.getMessage());
      }
  }

  @Test
  public void testMiseAJourNoteValide() {
      try {
          Student student = new Student("002", "Sara", 12.0);
          student.updateGrade(17.5);
          double expected = 17.5;
          double actual = student.getGrade();

          System.out.println("Test 2 : Mise à jour avec une note valide");
          System.out.println("Note attendue : " + expected + ", Note obtenue : " + actual);
          assertEquals(expected, actual);
      } catch (Exception e) {
          fail("Erreur inattendue lors de la mise à jour : " + e.getMessage());
      }
  }

  @Test
  public void testMiseAJourNoteInvalide() {
      try {
          Student student = new Student("003", "Karim", 10.0);
          student.updateGrade(25.0);

          fail("Test 3 : Une exception devait être levée pour une note invalide (> 20)");
      } catch (IllegalArgumentException e) {
          System.out.println("Test 3 : Mise à jour avec une note invalide (> 20)");
          System.out.println("Exception attendue : " + e.getMessage());
          assertTrue(true); // le test passe car l’exception est attendue
      } catch (Exception e) {
          fail("Exception inattendue : " + e.getMessage());
      }
  }
}

