package service;

import data.dtos.RegisterContactRequest;
import data.dtos.RegisterContactResponse;
import data.model.Student;
import data.repository.StudentRepository;
import exception.RegisterContactException;

public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    @Override
    public RegisterContactRequest register(RegisterContactRequest registerForm) throws RegisterContactException {
        //given that we have a db
        //when student register
        //we save
        Student student = new Student();
                registerForm.setLastName(registerForm.getFirstName());
                 registerForm.setLastName(registerForm.getLastName());
                 registerForm.setMiddleName(registerForm.getMiddleName());
                 registerForm.setPhoneNumber(registerForm.getPhoneNumber());
                 registerForm.setEmail(registerForm.getEmail());
                 registerForm.setStateOfOrigin(registerForm.getStateOfOrigin());
                 registerForm.setPreferredPassword(registerForm.getPreferredPassword());

                 if(studentAlreadyExist(student.getEmail())) throw new RegisterContactException("student exist already");
                    Student savedStudent = studentRepository.save(student);
                 RegisterContactResponse response = new RegisterContactResponse();
                 response.setFullName(savedStudent.getFirstName()+""+savedStudent.getLastName()+" " +savedStudent.getMiddleName());
                 response.setEmail(savedStudent.getEmail());
                 response.setUserName(savedStudent.getUserName());

        return null;
    }

    private boolean studentAlreadyExist(String email) {
        if(studentRepository.findStudentByEmail(email)!=null){
            return true;
        }
        else return false;
    }


}
