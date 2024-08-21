package hus.oop.mystudentmanager;

public class StudentManager {
    // Singleton pattern
    private static StudentManager instance;

    private MyList studentList;

    private StudentManager() {
        /* TODO */
        studentList = new MyLinkedList();
    }

    public static StudentManager getInstance() {
        /* TODO */
        if (instance == null) {
            instance = new StudentManager();
        }
        return instance;
    }

    public MyList getStudentList() {
        /* TODO */
        return studentList;
    }

    /**
     * Thêm sinh viên vào cuối danh sách.
     * @param student
     */
    public void append(Student student) {
        /* TODO */
        studentList.insertAtEnd(student);
    }

    /**
     * Thêm sinh viên vào danh sách ở vị trí index.
     * @param student
     * @param index
     */
    public void add(Student student, int index) {
        /* TODO */
        studentList.insertAtPosition(student, index);
    }

    /**
     * Bỏ sinh viên ở vị trí index.
     * @param index
     */
    public void remove(int index) {
        /* TODO */
        studentList.remove(index);
    }

    /**
     * Bỏ sinh viên như tham số truyền vào.
     * @param student
     */
    public void remove(Student student) {
        /* TODO */


    }

    /**
     * Lấy ra sinh viên ở vị trí index
     * @param index
     * @return
     */
    public Student studentAt(int index) {
        /* TODO */
        return (Student) studentList.iterator().next();

    }

    /**
     * Lọc ra những sinh viên có điểm trung bình trên 15 điểm.
     * @return
     */
    public MyList filterStudentsByAverageGrade() {
        /* TODO */
        if (studentList.size() == 0) {
            return null;
        }

        MyIterator interator = studentList.iterator();
        Student student = (Student) interator.next();
        while (interator.hasNext()) {
            Student current = (Student) interator.next();
            if (current.getAverageGrade() > 15) {
                student = current;
            }
        }
        return student;
    }

    /**
     * Lọc ra những sinh viên có điểm toán trên 5 điểm.
     * @return
     */
    public MyList filterStudentsByMathGrade() {
        /* TODO */
        if (studentList.size() == null) {
            return null;
        }
        MyIterator interator = studentList.iterator();
        Student s = (Student) interator.next();
        while (interator.hasNext()) {
            Student current = (Student) interator.next();
            if (current.getMathsGrade() > 5) {
                s = current;
            }
        }
        return s;
    }
}
