package hus.oop.lab9.phonebook;

import java.util.HashMap;

public class PhoneBookMap implements PhoneBook {
    HashMap<String, Student> phoneBook;

    public PhoneBookMap() {
        phoneBook = new HashMap<>();
    }

    @Override
    public void addPerson(Student s) {
        phoneBook.put(s.phone, s);
    }

    @Override
    public Student searchByName(String name) {
        for (Student student : phoneBook.values()) {
            if (student.name.equals(name)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public Student searchLastname(String lastname) {
        for (Student student : phoneBook.values()) {
            if (student.lastName.equals(lastname)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public Student searchByNumber(String phone) {
        return phoneBook.get(phone);
    }

    @Override
    public void deleteByNumber(String phone) {
        phoneBook.remove(phone);
    }
}

