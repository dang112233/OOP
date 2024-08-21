package hus.oop.lab9.phonebook;

public interface PhoneBook {
    void addPerson(Student p);
    Student searchByName(String name);
    Student searchLastname(String lastname);
    Student searchByNumber(String phone);
    void deleteByNumber(String phone);
}
