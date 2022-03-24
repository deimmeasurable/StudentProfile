package africa.semicolon.studentprofile.service;

import africa.semicolon.studentprofile.data.dtos.RegisterContactRequest;
import africa.semicolon.studentprofile.data.dtos.RegisterStudentResponse;
import africa.semicolon.studentprofile.data.repository.StudentRepository;

public interface StudentService {
   RegisterStudentResponse register(RegisterContactRequest registerForm);

    StudentRepository getRepository();

    void canCheckProfile(RegisterContactRequest registerForm2);

//    void delete(RegisterContactRequest registerForm);
}
