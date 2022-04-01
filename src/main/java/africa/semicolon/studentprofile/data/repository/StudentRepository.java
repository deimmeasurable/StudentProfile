package africa.semicolon.studentprofile.data.repository;

import africa.semicolon.studentprofile.data.model.Student;

import java.util.List;


public interface  StudentRepository {

    Student save(Student student);
    int count();
    Student findStudentByEmail(String email);

    Student resetPasswordWhenCorrectEmailExist(String email,String password);

    Student findStudentByPhoneNumber(String PhoneNumber);

    Student studentUpdatePhone(String email, String passWord, String phoneNumber);

    void deleteStudent(Student student);

    Student findByMatric(int matric);
    List<Student> findAll();
}
