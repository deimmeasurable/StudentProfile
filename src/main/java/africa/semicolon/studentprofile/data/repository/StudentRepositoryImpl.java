package africa.semicolon.studentprofile.data.repository;

import africa.semicolon.studentprofile.data.model.Student;

import java.util.ArrayList;
import java.util.List;


public class StudentRepositoryImpl implements StudentRepository{
//    Logger logger = Logger.getLogger(StudentRepository.class.getName());
List<Student> db = new ArrayList<>();
    private int matricNo =0;

    @Override
    public Student save(Student student) {
//        logger.info(student.getEmail()+ " ............. ..//");
        //given that we have database
        // when student register we save
      generateMatric(student);
//        saveNew(student);
        db.add(student);
        System.out.println(student);

        return student;
    }
    private int generateMatric(Student student){

        saveNew(student);
        ++matricNo;
        System.out.println(matricNo);
        return matricNo;
    }
    private boolean saveNew(Student student) {

            if (student.getMatric() !=0 && student.getEmail() != null) {


                return true;

            }
            return false;
        }


    @Override
    public int count() {
        return db.size();

    }

    @Override
    public Student findStudentByEmail(String email) {
        for (Student student:db) {
            if(email.equalsIgnoreCase(student.getEmail())){
                return student;

            }
        }
        return null;
    }

    @Override
    public Student resetPasswordWhenCorrectEmailExist(String email,String password) {

            for (Student student : db) {
                if (emailExist(email)) {
                student.setPassword(password);

//                System.out.println(student);
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
                if (student.getEmail().toLowerCase().equals(email) && student.getPassword().equals(password)) {

                    student.setPhoneNumber(phoneNumber);
                    return student;
                }



            }


            return null;
    }

    @Override
    public void deleteStudent(Student student) {
        db.remove(student);
    }



    private boolean emailExist(String email) {
        return email != null;
    }

}
