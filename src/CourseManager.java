import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CourseManager {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Course> courses = new ArrayList<>();

    public static void start() {

        while (true) {

            System.out.println(" STUDENT COURSE MANAGEMENT SYSTEM");
            System.out.println();
            System.out.println("1. Add Course");
            System.out.println("2. View All Courses");
            System.out.println("3. Search Course");
            System.out.println("4. Compute Total Units");
            System.out.println("5. Save to File");
            System.out.println("6. Load from File");
            System.out.println("7. Exit");

            System.out.print("\nEnter your choice: ");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:
                    addCourse();
                    break;

                case 2:
                    viewCourses();
                    break;

                case 3:
                    searchCourse();
                    break;

                case 4:
                    computeTotalUnits();
                    break;

                case 5:
                    saveCourses();
                    break;

                case 6:
                    loadCourses();
                    break;

                case 7:
                    System.out.println("Thank you for using the system.");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }


    public static void addCourse() {

        try {

            System.out.print("Enter Course Code: ");
            String code = input.nextLine().trim().toUpperCase();

            if (code.isEmpty()) {
                System.out.println("Course code cannot be empty.");
                return;
            }

            System.out.print("Enter Course Title: ");
            String title = input.nextLine().trim();

            if (title.isEmpty()) {
                System.out.println("Course title cannot be empty.");
                return;
            }

            System.out.print("Enter Course Unit: ");
            int unit = input.nextInt();
            input.nextLine();

            if (unit <= 0) {
                System.out.println("Course unit must be greater than 0.");
                return;
            }

            Course course = new Course(code, title, unit);

            courses.add(course);

            System.out.println("\nCourse added successfully!");

        } catch (Exception e) {

            System.out.println("Invalid input.");
            input.nextLine();
        }
    }
      public static void viewCourses() {

            if (courses.isEmpty()) {

                System.out.println("\nNo courses have been added yet.");
                return;

            }

            System.out.println("\n ALL COURSES ");

            for (Course course : courses) {

                System.out.println(course);

            }

        }
        public static void searchCourse() {

            if (courses.isEmpty()) {
                System.out.println("\nNo courses available to search.");
                return;
            }

            System.out.print("Enter Course Code to search: ");
            String searchCode = input.nextLine().trim().toUpperCase();

            searchCourseRecursive(searchCode, 0);
        }

        public static void searchCourseRecursive(String searchCode, int index) {

            // Base case: reached the end of the list
            if (index >= courses.size()) {
                System.out.println("\nCourse not found.");
                return;
            }

            Course course = courses.get(index);

            if (course.getCourseCode().equals(searchCode)) {
                System.out.println("\nCourse Found:");
                System.out.println(course);
                return;
            }

            // Recursive call: check the next course
            searchCourseRecursive(searchCode, index + 1);
        }
        
        public static void computeTotalUnits() {

            if (courses.isEmpty()) {
                System.out.println("\nNo courses have been added yet.");
                return;
            }

            int totalUnits = 0;

            for (Course course : courses) {
                totalUnits += course.getUnit();
            }

            System.out.println("\nTotal Units Registered: " + totalUnits);
        }

        public static void saveCourses() {

            if (courses.isEmpty()) {
                System.out.println("\nThere are no courses to save.");
                return;
            }

            try {

                PrintWriter writer = new PrintWriter(new FileWriter("courses.txt"));

                for (Course course : courses) {

                    writer.println(
                        course.getCourseCode() + "," +
                        course.getCourseTitle() + "," +
                        course.getUnit()
                    );

                }

                writer.close();

                System.out.println("\nCourses saved successfully!");

            } catch (IOException e) {

                System.out.println("Error saving courses.");

            }
        }

        public static void loadCourses() {

            try {

                File file = new File("courses.txt");

                if (!file.exists()) {
                    System.out.println("\nNo saved courses found.");
                    return;
                }

                Scanner fileReader = new Scanner(file);

                courses.clear();

                while (fileReader.hasNextLine()) {

                    String line = fileReader.nextLine();

                    String[] data = line.split(",");

                    String code = data[0];
                    String title = data[1];
                    int unit = Integer.parseInt(data[2]);

                    Course course = new Course(code, title, unit);

                    courses.add(course);
                }

                fileReader.close();

                System.out.println("\nCourses loaded successfully!");

            } catch (Exception e) {

                System.out.println("Error loading courses.");

            }

        }
}