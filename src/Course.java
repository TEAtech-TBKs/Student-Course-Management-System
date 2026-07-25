public class Course {

    private String courseCode;
    private String courseTitle;
    private int unit;

    public Course(String courseCode, String courseTitle, int unit) {
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.unit = unit;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public int getUnit() {
        return unit;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-30s %d Unit(s)", courseCode, courseTitle, unit, "Course Code", "Course Title", "Unit");
    }
}