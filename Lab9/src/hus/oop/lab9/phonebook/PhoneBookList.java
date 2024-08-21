package hus.oop.lab9.phonebook;

import java.util.ArrayList;
public class PhoneBookList implements PhoneBook {
    ArrayList<Student> phoneBook;

    public PhoneBookList() {
        phoneBook = new ArrayList<>();
    }

    @Override
    public void addPerson(Student p) {
        phoneBook.add(p);
    }

    @Override
    public Student searchByName(String name) {
        for (Student s : phoneBook) {
            if (s.name.equals(name)) {
                return s;
            }
        }
        return null;
    }

    @Override
    public Student searchLastname(String lastname) {
        for (Student s : phoneBook) {
            if (s.lastName.equals(lastname)) {
                return s;
            }
        }
        return null;
    }

    @Override
    public Student searchByNumber(String phone) {
        for (Student s : phoneBook) {
            if (s.phone.equals(phone)) {
                return s;
            }
        }
        return null;
    }

    @Override
    public void deleteByNumber(String phone) {
        for (int i = 0; i < phoneBook.size(); i++) {
            Student student = phoneBook.get(i);
            if (student.phone.equals(phone)) {
                phoneBook.remove(i);
                return;
            }
        }
    }
}
