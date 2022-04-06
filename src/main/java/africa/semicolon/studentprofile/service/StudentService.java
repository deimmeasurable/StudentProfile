package africa.semicolon.studentprofile.service;

import africa.semicolon.studentprofile.data.dtos.RegisterStudentRequest;
import africa.semicolon.studentprofile.data.dtos.RegisterStudentResponse;
import africa.semicolon.studentprofile.data.dtos.Responses;
import africa.semicolon.studentprofile.data.dtos.StudentProfileResponse;
import africa.semicolon.studentprofile.data.model.Student;
import africa.semicolon.studentprofile.data.repository.StudentRepository;

public interface StudentService {
   RegisterStudentResponse register(RegisterStudentRequest registerForm);

    StudentRepository getRepository();
    StudentProfileResponse canCheckProfile(int matric);
    Responses studentCanResetPassWord(String email, String passWord);


}
