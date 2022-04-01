package africa.semicolon.studentprofile.service;

import africa.semicolon.studentprofile.data.dtos.RegisterStudentRequest;
import africa.semicolon.studentprofile.data.dtos.RegisterStudentResponse;
import africa.semicolon.studentprofile.data.dtos.Responses;
import africa.semicolon.studentprofile.data.dtos.StudentProfileResponse;
import africa.semicolon.studentprofile.data.model.Student;
import africa.semicolon.studentprofile.data.repository.StudentRepository;
import africa.semicolon.studentprofile.data.repository.StudentRepositoryImpl;


public class AdminServiceImpl implements AdminService {
    private final StudentRepository repository=new StudentRepositoryImpl();


    @Override
    public RegisterStudentResponse register(RegisterStudentRequest registerForm) {
       Student student =new Student();
            student.setFirstName(registerForm.getFirstName());
            student.setLastName(registerForm.getLastName());
            student.setMiddleName(registerForm.getMiddleName());
            student.setEmail(registerForm.getEmail());
            student.setMatric(registerForm.getMatric());
            student.setPhoneNumber(registerForm.getPhoneNumber());
            student.setStateOfOrigin(registerForm.getStateOfOrigin());

         RegisterStudentResponse response = new RegisterStudentResponse();

        repository.save(student);
        return response;
    }

    @Override
    public StudentRepository getRepository() {
        return repository;
    }

    @Override
    public StudentProfileResponse canCheckProfile(int matric) {
        return null;
    }

    @Override
    public Responses studentCanResetPassWord(String email, String passWord) {
        return null;
    }

    @Override
    public void deleteByMatricNumber(int matricNumber) {
        for (Student s : repository.findAll()){
            repository.deleteStudent(repository.findByMatric(matricNumber));

            }

        }



    @Override
    public int count() {
        return repository.count();
    }



}



