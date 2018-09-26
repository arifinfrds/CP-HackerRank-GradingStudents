import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    scanner.nextLine();

    if (!isNValid(n)) {
      return;
    }

    int[] grades = new int[n];
    for (int i = 0; i < n; i++) {
      grades[i] = scanner.nextInt();
    }

    if (!isGradesValid(grades)) {
      return;
    }

    for (int value : gradingStudents(grades)) {
      System.out.println(value);
    }
  }

  private static Boolean isNValid(int value) {
    return value >= 1 && value <= 100;
  }

  private static Boolean isGradesValid(int[] grades) {
    for (int i = 0; i < grades.length; i++) {
      return grades[i] >= 0 && grades[i] <= 100;
    }
    return false;
  }

  /*
   * Complete the gradingStudents function below.
   */

  private static ArrayList<Integer> gradingStudents(int[] grades) {
    ArrayList<Integer> roundedGrades = new ArrayList<>();

    for (int i = 0; i < grades.length; i++) {
      int grade = grades[i];
      if (grade < 38) {
        roundedGrades.add(grade);
      } else {
        if (grade % 5 == 4) {
          int newValue = grade += 1;
          roundedGrades.add(newValue);
        } else if (grade % 5 == 3) {
          int newValue = grade += 2;
          roundedGrades.add(newValue);
        } else {
          roundedGrades.add(grade);
        }
      }
    }
    return roundedGrades;
  }
}
