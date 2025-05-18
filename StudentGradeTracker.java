import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> grades = new ArrayList<>();

        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();

        // Input grades
        for (int i = 0; i < n; i++) {
            System.out.print("Enter grade for student " + (i + 1) + ": ");
            int grade = scanner.nextInt();
            grades.add(grade);
        }

        // Calculate average, highest, and lowest
        int sum = 0, highest = Integer.MIN_VALUE, lowest = Integer.MAX_VALUE;
        for (int grade : grades) {
            sum += grade;
            if (grade > highest)
                highest = grade;
            if (grade < lowest)
                lowest = grade;
        }
        double average = (double) sum / grades.size();

        // Output results
        System.out.println("Average grade: " + average);
        System.out.println("Highest grade: " + highest);
        System.out.println("Lowest grade: " + lowest);

        scanner.close();
    }
}
