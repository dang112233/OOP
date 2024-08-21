package hus.oop.studentmanager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class App {
    private static final String COMMA_DELIMITER = ",";

    public static void readListData(String filePath) {
        BufferedReader dataReader = null;
        try {
            String line;
            dataReader = new BufferedReader(new FileReader(filePath));

            while ((line = dataReader.readLine()) != null) {
                List<String> dataList = parseDataLineToList(line);
                if (dataList.size() != 7) {
                    continue;
                }

                if (dataList.get(0).equals("id")) {
                    continue;
                }

                Student student = new Student.StudentBuilder(dataList.get(0))
                        .withLastname(dataList.get(1))
                        .withFirstname(dataList.get(2))
                        .withYearOfBirth(Integer.parseInt(dataList.get(3)))
                        .withMathsGrade(Double.parseDouble(dataList.get(4)))
                        .withPhysicsGrade(Double.parseDouble(dataList.get(5)))
                        .withChemistryGrade(Double.parseDouble(dataList.get(6)))
                        .build();

                StudentManager.getInstance().append(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dataReader != null)
                    dataReader.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
    }

    public static List<String> parseDataLineToList(String dataLine) {
        List<String> result = new ArrayList<>();
        if (dataLine != null) {
            String[] splitData = dataLine.split(COMMA_DELIMITER);
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }

    public static String[] parseDataLineToArray(String dataLine) {
        if (dataLine == null) {
            return null;
        }
        return dataLine.split(COMMA_DELIMITER);
    }

    public static void main(String[] args) {
        testOriginalData();
    }

    public static void init() {
        String filePath = "data/students.csv";
        readListData(filePath);
    }

    public static void testOriginalData() {
        init();
        String studentIds = StudentManager.getInstance().idOfStudentsToString(StudentManager.getInstance().getStudentList());
        System.out.print(studentIds);
    }

    public static void testSortYearOfBirthIncreasing() {
        init();
        List<Student> students = StudentManager.getInstance().sortYearOfBirthIncreasing();
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.print(studentIdsString);
    }

    public static void testSortYearOfBirthDecreasing() {
        init();
        List<Student> students = StudentManager.getInstance().sortYearOfBirthDecreasing();
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.print(studentIdsString);
    }

    public static void testSortMathsGradeIncreasing() {
        init();
        List<Student> students = StudentManager.getInstance().sortMathsGradeIncreasing();
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.print(studentIdsString);
    }

    public static void testSortMathsGradeDecreasing() {
        init();
        List<Student> students = StudentManager.getInstance().sortMathsGradeDecreasing();
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.print(studentIdsString);
    }

    public static void testSortPhysicsGradeIncreasing() {
        init();
        List<Student> students = StudentManager.getInstance().sortPhysicsGradeIncreasing();
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.print(studentIdsString);
    }

    public static void testSortPhysicsGradeDecreasing() {
        init();
        List<Student> students = StudentManager.getInstance().sortPhysicsGradeDecreasing();
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.print(studentIdsString);
    }

    public static void testSortChemistryGradeIncreasing() {
        init();
        List<Student> students = StudentManager.getInstance().sortChemistryGradeIncreasing();
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.print(studentIdsString);
    }

    public static void testSortChemistryGradeDecreasing() {
        init();
        List<Student> students = StudentManager.getInstance().sortChemistryGradeDecreasing();
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.print(studentIdsString);
    }

    public static void testFilterStudentsHighestMathsGrade() {
        init();
        List<Student> students = StudentManager.getInstance().filterStudentsHighestMathsGrade(5);
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.print(studentIdsString);
    }

    public static void testFilterStudentsLowestMathsGrade() {
        init();
        List<Student> students = StudentManager.getInstance().filterStudentsLowestMathsGrade(5);
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.print(studentIdsString);
    }

    public static void testFilterStudentsHighestPhysicsGrade() {
        init();
        List<Student> students = StudentManager.getInstance().filterStudentsHighestPhysicsGrade(5);
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.print(studentIdsString);
    }

    public static void testFilterStudentsLowestPhysicsGrade() {
        init();
        List<Student> students = StudentManager.getInstance().filterStudentsLowestPhysicsGrade(5);
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.print(studentIdsString);
    }

    public static void testFilterStudentsHighestChemistryGrade() {
        init();
        List<Student> students = StudentManager.getInstance().filterStudentsHighestChemistryGrade(5);
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.print(studentIdsString);
    }

    public static void testFilterStudentsLowestChemistryGrade() {
        init();
        List<Student> students = StudentManager.getInstance().filterStudentsLowestChemistryGrade(5);
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.print(studentIdsString);
    }

    public static void testFilterStudentsHighestAverageGrade() {
        init();
        List<Student> students = StudentManager.getInstance().sortAverageGradeDecreasing();
        List<Student> nHighestAverageGradeStudents = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            nHighestAverageGradeStudents.add(students.get(i));
        }
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(nHighestAverageGradeStudents);
        System.out.print(studentIdsString);
    }

    public static void testFilterStudentsLowestAverageGrade() {
        init();
        List<Student> students = StudentManager.getInstance().sortAverageGradeIncreasing();
        List<Student> nLowestAverageGradeStudents = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            nLowestAverageGradeStudents.add(students.get(i));
        }
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(nLowestAverageGradeStudents);
        System.out.print(studentIdsString);
    }
}
