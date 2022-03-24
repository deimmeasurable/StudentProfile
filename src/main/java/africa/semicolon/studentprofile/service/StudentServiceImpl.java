package africa.semicolon.studentprofile.service;

import africa.semicolon.studentprofile.data.dtos.RegisterContactRequest;
import africa.semicolon.studentprofile.data.dtos.RegisterStudentResponse;
import africa.semicolon.studentprofile.data.model.Student;
import africa.semicolon.studentprofile.data.repository.StudentRepository;
import africa.semicolon.studentprofile.data.repository.StudentRepositoryImpl;

import africa.semicolon.studentprofile.exception.RegisterStudentException;
import org.springframework.stereotype.Service;

@Service

public class StudentServiceImpl implements StudentService {
//    Logger logger = Logger.getLogger(StudentServiceImpl.class.getName());
    public StudentRepository studentRepository = new StudentRepositoryImpl();

    @Override
    public RegisterStudentResponse register(RegisterContactRequest registerForm) {
        Student student = new Student();
        student.setFirstName(registerForm.getFirstName());
        student.setLastName(registerForm.getLastName());
        student.setMiddleName(registerForm.getMiddleName());
        student.setPhoneNumber(registerForm.getPhoneNumber());
        student.setEmail(registerForm.getEmail());
        student.setStateOfOrigin(registerForm.getStateOfOrigin());
        student.setPassword(registerForm.getPassword());
        if (studentAlreadyExist(registerForm.getEmail(),registerForm.getPhoneNumber()))throw new RegisterStudentException(registerForm+"student exist already");

        Student savedStudent = studentRepository.save(student);


        RegisterStudentResponse response = new RegisterStudentResponse();
        response.setFullName(savedStudent.getFirstName() + "" + savedStudent.getLastName() + " " + savedStudent.getMiddleName());
        response.setEmail(savedStudent.getEmail());

        response.setPassword(savedStudent.getPassword());
        response.setStateOfOrigin(savedStudent.getStateOfOrigin());

        return response;
    }

    @Override
    public StudentRepository getRepository() {

        return studentRepository;

    }

    @Override
    public void canCheckProfile(RegisterContactRequest registerForm2) {
        

    }


    private boolean studentAlreadyExist(String email,String phoneNumber) {
        if (studentRepository.findStudentByEmail(email)!=null && studentRepository.findStudentByPhoneNumber(phoneNumber)!=null ){
            return true;
        }
        return false;
    }
}