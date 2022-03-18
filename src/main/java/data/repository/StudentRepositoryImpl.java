package data.repository;

import data.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository{
List<Student> db = new ArrayList<>();
    @Override
    public Student save(Student student) {
        //given that we have database
        // when student register we save

        db.add(student);
        return student;
    }

    @Override
    public int count() {
        return db.size();

    }

    @Override
    public Student findStudentByEmail(String email) {
        for (Student student:db) {
            if(email.equals(student.getEmail().toLowerCase())){
                return student;

            }
        }
        return null;
    }

    @Override
    public Student resetPasswordWhenCorrectEmailExist(String email,String password) {
        //given that student details exist in db
        if (emailExist(email.toLowerCase())) {
            for (Student student : db) {
                student.setPassword(password);

                System.out.println(student);
                return student;
            }

        }
        return null;
    }

    @Override
    public Student findStudentByPhoneNumber(String phoneNumber) {
        for (Student student:db) {
            if(student.getPhoneNumber().equals(phoneNumber)){
                return student;
            }

        }
        return null;
    }

    @Override
    public Student studentUpdatePhone(String email, String password, String phoneNumber) {
//
            for (Student student : db) {
                if (student.getEmail().equals(email) && student.getPassword().equals(password)) {

                    student.setPhoneNumber(phoneNumber);
                    return student;
                }



            }


            return null;
    }

//    private boolean studentEmailAndPassWordExist(Student student) {
//
//
//        if (student.getEmail(student.setEmail(email))){
//            return true;
//
//        }
//        return false;
//    }

    private boolean emailExist(String email) {
        return email != null;
    }
}
