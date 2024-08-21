package hus.oop.studentmanager;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class StudentManager {
    // Singleton pattern
    private static StudentManager instance;

    private List<Student> studentList;

    private StudentManager() {
        studentList = new LinkedList<>();
    }

    public static StudentManager getInstance() {
        if (instance == null) {
            instance = new StudentManager();
        }
        return instance;
    }

    public List<Student> getStudentList() {
        return this.studentList;
    }

    public void append(Student student) {
        studentList.add(student);
    }

    public void add(Student student, int index) {
        studentList.add(index, student);
    }

    public void remove(int index) {
        studentList.remove(index);
    }

    public void remove(Student student) {
        studentList.remove(student);
    }

    public Student studentAt(int index) {
        return studentList.get(index);
    }

    public List<Student> sortYearOfBirthIncreasing() {
        List<Student> newList = new LinkedList<>(this.studentList);
        Collections.sort(newList, new Comparator<Student>() {
            @Override
            public int compare(Student left, Student right) {
                return left.getYearOfBirth() - right.getYearOfBirth();
            }
        });
        return newList;
    }

    public List<Student> sortYearOfBirthDecreasing() {
        List<Student> newList = new LinkedList<>(this.studentList);
        Collections.sort(newList, new Comparator<Student>() {
            @Override
            public int compare(Student left, Student right) {
                return right.getYearOfBirth() - left.getYearOfBirth();
            }
        });
        return newList;
    }

    public List<Student> sortMathsGradeIncreasing() {
        List<Student> newList = new LinkedList<>(this.studentList);
        Collections.sort(newList, new Comparator<Student>() {
            @Override
            public int compare(Student left, Student right) {
                return Double.compare(left.getMathsGrade(), right.getMathsGrade());
            }
        });
        return newList;
    }

    public List<Student> sortMathsGradeDecreasing() {
        List<Student> newList = new LinkedList<>(this.studentList);
        Collections.sort(newList, new Comparator<Student>() {
            @Override
            public int compare(Student left, Student right) {
                return Double.compare(right.getMathsGrade(), left.getMathsGrade());
            }
        });
        return newList;
    }

    public List<Student> sortPhysicsGradeIncreasing() {
        List<Student> newList = new LinkedList<>(this.studentList);
        Collections.sort(newList, new Comparator<Student>() {
            @Override
            public int compare(Student left, Student right) {
                return Double.compare(left.getPhysicsGrade(), right.getPhysicsGrade());
            }
        });
        return newList;
    }

    public List<Student> sortPhysicsGradeDecreasing() {
        List<Student> newList = new LinkedList<>(this.studentList);
        Collections.sort(newList, new Comparator<Student>() {
            @Override
            public int compare(Student left, Student right) {
                return Double.compare(right.getPhysicsGrade(), left.getPhysicsGrade());
            }
        });
        return newList;
    }

    public List<Student> sortChemistryGradeIncreasing() {
        List<Student> newList = new LinkedList<>(this.studentList);
        Collections.sort(newList, new Comparator<Student>() {
            @Override
            public int compare(Student left, Student right) {
                return Double.compare(left.getChemistryGrade(), right.getChemistryGrade());
            }
        });
        return newList;
    }

    public List<Student> sortChemistryGradeDecreasing() {
        List<Student> newList = new LinkedList<>(this.studentList);
        Collections.sort(newList, new Comparator<Student>() {
            @Override
            public int compare(Student left, Student right) {
                return Double.compare(right.getChemistryGrade(), left.getChemistryGrade());
            }
        });
        return newList;
    }

    public List<Student> sortAverageGradeIncreasing() {
        List<Student> newList = new LinkedList<>(this.studentList);
        Collections.sort(newList, new Comparator<Student>() {
            @Override
            public int compare(Student left, Student right) {
                return Double.compare(left.getAverageGrade(), right.getAverageGrade());
            }
        });
        return newList;
    }

    public List<Student> sortAverageGradeDecreasing() {
        List<Student> newList = new LinkedList<>(this.studentList);
        Collections.sort(newList, new Comparator<Student>() {
            @Override
            public int compare(Student left, Student right) {
                return Double.compare(right.getAverageGrade(), left.getAverageGrade());
            }
        });
        return newList;
    }

    public List<Student> filterStudentsHighestPhysicsGrade(int howMany) {
        List<Student> sortedList = sortPhysicsGradeDecreasing();
        return sortedList.subList(0, Math.min(howMany, sortedList.size()));
    }

    public List<Student> filterStudentsLowestPhysicsGrade(int howMany) {
        List<Student> sortedList = sortPhysicsGradeIncreasing();
        return sortedList.subList(0, Math.min(howMany, sortedList.size()));
    }

    public List<Student> filterStudentsHighestMathsGrade(int howMany) {
        List<Student> sortedList = sortMathsGradeDecreasing();
        return sortedList.subList(0, Math.min(howMany, sortedList.size()));
    }

    public List<Student> filterStudentsLowestMathsGrade(int howMany) {
        List<Student> sortedList = sortMathsGradeIncreasing();
        return sortedList.subList(0, Math.min(howMany, sortedList.size()));
    }

    public List<Student> filterStudentsHighestChemistryGrade(int howMany) {
        List<Student> sortedList = sortChemistryGradeDecreasing();
        return sortedList.subList(0, Math.min(howMany, sortedList.size()));
    }

    public List<Student> filterStudentsLowestChemistryGrade(int howMany) {
        List<Student> sortedList = sortChemistryGradeIncreasing();
        return sortedList.subList(0, Math.min(howMany, sortedList.size()));
    }

    public static String idOfStudentsToString(List<Student> studentList) {
        StringBuilder idOfStudents = new StringBuilder();
        idOfStudents.append("[");
        for (Student student : studentList) {
            idOfStudents.append(student.getId()).append(" ");
        }
        return idOfStudents.toString().trim() + "]";
    }

    public static void print(List<Student> studentList) {
        StringBuilder studentsString = new StringBuilder();
        studentsString.append("[\n");
        for (Student student : studentList) {
            studentsString.append(student.toString()).append("\n");
        }
        System.out.print(studentsString.toString().trim() + "\n]");
    }
}
