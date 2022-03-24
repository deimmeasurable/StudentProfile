package africa.semicolon.studentprofile.service;

import africa.semicolon.studentprofile.data.dtos.RegisterContactRequest;
import africa.semicolon.studentprofile.data.dtos.RegisterStudentResponse;
import africa.semicolon.studentprofile.data.model.Student;
import africa.semicolon.studentprofile.data.repository.StudentRepository;
import africa.semicolon.studentprofile.data.repository.StudentRepositoryImpl;


public class AdminServiceImpl implements AdminService{
    private StudentRepository repository = new StudentRepositoryImpl();

    @Override
    public void delete(String email) {
        Student foundStudent = repository.findStudentByEmail(email);
        repository.deleteStudent(foundStudent);

    }

    @Override
    public RegisterStudentResponse register(RegisterContactRequest registerForm) {
        return null;
    }

    @Override
    public StudentRepository getRepository() {
        return null;
    }

}
