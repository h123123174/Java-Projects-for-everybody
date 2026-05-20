import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();

        List<String> studentNames = new ArrayList<>();
        List<Double> studentGrades = new ArrayList<>();

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.print("Enter the name of student " + (i + 1) + ": ");
            String name = scanner.next();
            studentNames.add(name);

            System.out.print("Enter the grade of student " + (i + 1) + ": ");
            double grade = scanner.nextDouble();
            
            // 输入校验
            if (grade < 0 || grade > 100) {
                System.out.println("Invalid grade! Please enter a grade between 0 and 100.");
                i--;
                continue;
            }
            studentGrades.add(grade);
        }

        double average = calculateAverage(studentGrades);

        System.out.println("\nStudent Grade Report:");
        for (int i = 0; i < numberOfStudents; i++) {
            String gradeLetter = getGradeLetter(studentGrades.get(i));
            System.out.println(studentNames.get(i) + ": " + studentGrades.get(i) + " (" + gradeLetter + ")");
        }

        System.out.println("\nAverage Grade: " + average);
        findHighestAndLowest(studentNames, studentGrades);
    }

    private static double calculateAverage(List<Double> grades) {
        double sum = 0.0;
        for (Double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    private static String getGradeLetter(double grade) {
        if (grade >= 90) return "A";
        else if (grade >= 80) return "B";
        else if (grade >= 70) return "C";
        else if (grade >= 60) return "D";
        else return "F";
    }

    private static void findHighestAndLowest(List<String> names, List<Double> grades) {
        double highest = grades.get(0);
        double lowest = grades.get(0);
        String highestStudent = names.get(0);
        String lowestStudent = names.get(0);
        
        for (int i = 1; i < grades.size(); i++) {
            if (grades.get(i) > highest) {
                highest = grades.get(i);
                highestStudent = names.get(i);
            }
            if (grades.get(i) < lowest) {
                lowest = grades.get(i);
                lowestStudent = names.get(i);
            }
        }
        
        System.out.println("Highest Score: " + highestStudent + " with " + highest);
        System.out.println("Lowest Score: " + lowestStudent + " with " + lowest);
    }
}