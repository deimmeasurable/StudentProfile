package data.repository;

import data.model.Student;

public interface StudentRepository {
    Student save(Student student);

    int count();

    Student findStudentByEmail(String password);

    Student resetPasswordWhenCorrectEmailExist(String email,String password);

    Student findStudentByPhoneNumber(String PhoneNumber);

    Student studentUpdatePhone(String email, String passWord, String phoneNumber);
}
