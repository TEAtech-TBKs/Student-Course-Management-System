# Student Course Management System

A console-based Java application developed as part of the COS201 Programming I Mid-Semester Lab Assessment, as a student of MIVA Open University.

## Overview

The Student Course Management System is designed o help students record and manage the
courses they are taking for the semester. The application allows users to add, view, search, save, and load course information through a menu-driven console interface.

The project demonstrates the application of object-oriented programming principles, file handling, recursion, exception handling, string processing, and collection classes in Java.

## Features

- Add new courses
- View all registered courses
- Search for a course by course code
- Compute the total registered course units
- Save course records to a text file
- Load previously saved course records
- Input validation and exception handling
- Recursive course search

## Technologies Used

- Java 25
- Java Collections Framework (ArrayList)
- Object-Oriented Programming (OOP)

## Project Structure

```
StudentCourseManagement/
│
├── src/
│   ├── App.java
│   ├── Course.java
│   └── CourseManager.java
│
├── courses.txt
└── README.md
```

## Class Description

### App.java

Contains the `main()` method and serves as the entry point of the application.

### Course.java

Represents a course object containing:

- Course Code
- Course Title
- Course Unit

### CourseManager.java

Contains the business logic of the application, including:

- Menu handling
- Adding courses
- Viewing courses
- Searching courses
- Computing total units
- Saving courses to a file
- Loading courses from a file

## How to Run the Project

1. Clone the repository.

```bash
git clone https://github.com/YOUR_USERNAME/COS201-Student-Course-Management-System.git
```

2. Navigate to the project directory.

```bash
cd COS201-Student-Course-Management-System
```

3. Compile the source files.

```bash
javac src/*.java
```

4. Run the application.

```bash
java -cp src App
```

## Sample Menu

```
STUDENT COURSE MANAGEMENT SYSTEM

1. Add Course
2. View All Courses
3. Search Course
4. Compute Total Units
5. Save to File
6. Load from File
7. Exit
```

## Concepts Demonstrated

This project demonstrates the following Java concepts:

- Classes and Objects
- Constructors
- Methods
- ArrayList
- Loops
- Recursion
- File Handling
- Exception Handling
- String Manipulation
- Input Validation
- Switch Statements

## Author

**Tolulope E Akinwale**

Software Engineering Student

MIVA Open University

## License

This project was developed for academic purposes.