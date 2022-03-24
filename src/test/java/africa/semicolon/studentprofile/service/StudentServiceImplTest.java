package africa.semicolon.studentprofile.service;

import africa.semicolon.studentprofile.data.dtos.RegisterContactRequest;
import africa.semicolon.studentprofile.exception.RegisterStudentException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        registerForm.setEmail("fola456@gmail.com");
        registerForm.setPassword("tit789");
        registerForm.setStateOfOrigin("kwara");

//        registerForm.

        //when
        studentService.register(registerForm);

        assertEquals(1,studentService.getRepository().count());



    }
    @Test
    void testThatMoreStudentCanRegister(){
        RegisterContactRequest registerForm= new RegisterContactRequest();
        registerForm.setFirstName("dele");
        registerForm.setLastName("yusuf");
        registerForm.setMiddleName("ifeanyi");
        registerForm.setPhoneNumber("090567432");
        registerForm.setEmail("fola456@gmail.com");
        registerForm.setPassword("tit789");
        registerForm.setStateOfOrigin("kwara");

//        registerForm.

        //when

        RegisterContactRequest registerForm2 = new RegisterContactRequest();
        registerForm2.setFirstName("tunji");
        registerForm2.setLastName("tolani");
        registerForm2.setMiddleName("kelani");
        registerForm2.setPhoneNumber("09865743");
        registerForm2.setEmail("tolumilade56@gmail.com");
        registerForm2.setPassword("yitrt78");
        registerForm2.setStateOfOrigin("uyo");



        //when
       studentService.register(registerForm);
      studentService.register(registerForm2);


        assertEquals(2,studentService.getRepository().count());

    }
    @Test
    void testThatThereIsNoduplicateRegistration(){

       RegisterContactRequest registerForm= new RegisterContactRequest();
        registerForm.setFirstName("dele");
        registerForm.setLastName("yusuf");
        registerForm.setMiddleName("ifeanyi");
        registerForm.setPhoneNumber("090567432");
        registerForm.setEmail("fola456@gmail.com");
        registerForm.setPassword("tit789");
        registerForm.setStateOfOrigin("kwara");
        studentService.register(registerForm);

        RegisterContactRequest reg= new RegisterContactRequest();
        reg.setFirstName("dele");
        reg.setLastName("yusuf");
        reg.setMiddleName("ifeanyi");
        reg.setPhoneNumber("090567432");
        reg.setEmail("fola456@gmail.com");
        reg.setPassword("tit789");
        reg.setStateOfOrigin("kwara");


        assertThrows(RegisterStudentException.class,()->studentService.register(reg));

    }
    @Test
    void studentCanBeDeletedFromRepository(){
        RegisterContactRequest registerForm2 = new RegisterContactRequest();
        registerForm2.setFirstName("tunji");
        registerForm2.setLastName("tolani");
        registerForm2.setMiddleName("kelani");
        registerForm2.setPhoneNumber("09865743");
        registerForm2.setEmail("tolumilade56@gmail.com");
        registerForm2.setPassword("yitrt78");
        registerForm2.setStateOfOrigin("uyo");

       studentService.canCheckProfile(registerForm2);

        assertEquals(1,studentService.getRepository().count());
    }



}