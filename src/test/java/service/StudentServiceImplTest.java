package service;

import data.dtos.RegisterContactRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentServiceImplTest {
 private StudentService studentService;
    @BeforeEach
    void setUp() {
        studentService = new StudentServiceImpl();
    }
    @Test
    void testStudentCanBeAddedToRepository(){
        //given
        RegisterContactRequest registerForm = new RegisterContactRequest();
        registerForm.setFirstName("dele");
        registerForm.setLastName("yusuf");
        registerForm.setMiddleName("ifeanyi");
        registerForm.setPhoneNumber("090567432");
        registerForm.setEmail("romeo567@gmail");
        registerForm.setPreferredPassword("titt789");

        //when
        studentService.register(registerForm);



    }


}