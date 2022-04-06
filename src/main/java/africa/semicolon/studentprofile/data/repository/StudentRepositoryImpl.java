package africa.semicolon.studentprofile.data.repository;

import africa.semicolon.studentprofile.data.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class StudentRepositoryImpl implements StudentRepository{
//    Logger logger = Logger.getLogger(StudentRepository.class.getName());
List<Student> db = new ArrayList<>();
    private int matricNo =0;


    @Override
    public Student save(Student student) {
//        logger.info(student.getEmail()+ " ............. ..//");
        //given that we have database
        // when student register we save
        student.setMatric(generateMatricNumber());
        db.add(student);
        System.out.println(db);
        System.out.println(student);

        return student;
    }

    private int generateMatricNumber(){
        return matricNo+=1;
    }
    @Override
    public int count() {

        return db.size();

    }

    @Override
    public Student findStudentByEmail(String email) {
        email=email.toLowerCase(Locale.ROOT);
        for (Student student:db) {
            if(email.equals(student.getEmail())){
                return student;

            }
        }
        return null;
    }

    @Override
    public Student resetPasswordWhenCorrectEmailExist(String email,String password) {

            for (Student student : db) {
                if (student.getEmail().equals(email)) {
                    Student newStudent = student;
                newStudent.setPassword(password);
                db.remove(student);


                return newStudent;
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
//        for (Student s : db){
//            if (s.getMatric() == 1){
//                db.remove(s)
//            }
//        }
        db.remove(student);
    }

    @Override
    public Student findByMatric(int matric) {
        for (Student student : db) {
            if (student.getMatric() == matric) {
                return student;
            }
        }
        throw new  IllegalArgumentException("Student with matric number "+matric+" does not exist");
    }

    @Override
    public List<Student> findAll() {
        return db;
    }

    private boolean emailExist(String email) {
        return email != null;
    }


}