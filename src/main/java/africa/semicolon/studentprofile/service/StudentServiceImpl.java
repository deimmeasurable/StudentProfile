package africa.semicolon.studentprofile.service;

import africa.semicolon.studentprofile.data.dtos.RegisterStudentRequest;
import africa.semicolon.studentprofile.data.dtos.RegisterStudentResponse;
import africa.semicolon.studentprofile.data.dtos.Responses;
import africa.semicolon.studentprofile.data.dtos.StudentProfileResponse;
import africa.semicolon.studentprofile.data.model.Student;
import africa.semicolon.studentprofile.data.repository.StudentRepository;
import africa.semicolon.studentprofile.data.repository.StudentRepositoryImpl;

import africa.semicolon.studentprofile.exception.PasswordNotSuccessfulException;
import africa.semicolon.studentprofile.exception.RegisterStudentException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Locale;

//@Service
@org.springframework.stereotype.Service
public class StudentServiceImpl implements StudentService {
    @Autowired
//    Logger logger = Logger.getLogger(StudentServiceImpl.class.getName());
    public StudentRepository studentRepository = new StudentRepositoryImpl();

    @Override
    public RegisterStudentResponse register(RegisterStudentRequest registerForm) {
        Student student = new Student();
        student.setFirstName(registerForm.getFirstName().trim());
        student.setLastName(registerForm.getLastName().trim());
        student.setMiddleName(registerForm.getMiddleName().trim());
        student.setPhoneNumber(registerForm.getPhoneNumber().trim());
        student.setEmail(registerForm.getEmail().trim());
        student.setStateOfOrigin(registerForm.getStateOfOrigin().trim());
        student.setPassword(registerForm.getPassword().trim());
        if (studentAlreadyExist(registerForm.getEmail(), registerForm.getPhoneNumber()))
            throw new RegisterStudentException("student exist already");

        Student savedStudent = studentRepository.save(student);


        RegisterStudentResponse response = new RegisterStudentResponse();
        response.setFullName(savedStudent.getFirstName() + " " + savedStudent.getLastName() + " " + savedStudent.getMiddleName().trim());
        response.setEmail(savedStudent.getEmail());

        response.setPassword(savedStudent.getPassword());
        response.setStateOfOrigin(savedStudent.getStateOfOrigin());
        response.setUserName(String.valueOf(savedStudent.getMatric()).trim());

        return response;
    }

    @Override
    public StudentRepository getRepository() {
        return studentRepository;

    }

    @Override
    public StudentProfileResponse canCheckProfile(int matric) {
        Student student = studentRepository.findByMatric(matric);
            System.out.println("Student from the checkProfile " + student);
            StudentProfileResponse response = new StudentProfileResponse();
            response.setStudent(student);
            return response;

    }


    @Override
    public Responses studentCanResetPassWord(String email, String password) {
        Student student = studentRepository.resetPasswordWhenCorrectEmailExist(email, password);


        studentRepository.save(student);
        if(student.getPassword().equals(password)) {
            Responses responses = new Responses();
            responses.setResponse("Password update successful");
            return responses;
        }else {
            throw new PasswordNotSuccessfulException("password Update is not sucessful");
        }
    }


    private boolean studentAlreadyExist(String email,String phoneNumber) {
        if (studentRepository.findStudentByEmail(email)!=null && studentRepository.findStudentByPhoneNumber(phoneNumber)!=null ){
            return true;
        }
        return false;
    }
}