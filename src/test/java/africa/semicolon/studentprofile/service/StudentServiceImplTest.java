package africa.semicolon.studentprofile.service;

import africa.semicolon.studentprofile.data.dtos.RegisterStudentRequest;
import africa.semicolon.studentprofile.data.dtos.Responses;
import africa.semicolon.studentprofile.data.dtos.StudentProfileResponse;
import africa.semicolon.studentprofile.data.model.Student;
import africa.semicolon.studentprofile.exception.RegisterStudentException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceImplTest {
 private StudentService studentService;

    @BeforeEach
    void setUp() {
        studentService = new StudentServiceImpl();
    }
    @Test
    void testStudentCanBeAddedToRepository(){
        //given
        RegisterStudentRequest registerForm = new RegisterStudentRequest();
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
        RegisterStudentRequest registerForm= new RegisterStudentRequest();
        registerForm.setFirstName("dele");
        registerForm.setLastName("yusuf");
        registerForm.setMiddleName("ifeanyi");
        registerForm.setPhoneNumber("090567432");
        registerForm.setEmail("fola456@gmail.com");
        registerForm.setPassword("tit789");
        registerForm.setStateOfOrigin("kwara");





        RegisterStudentRequest registerForm2 = new RegisterStudentRequest();
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

       RegisterStudentRequest registerForm= new RegisterStudentRequest();
        registerForm.setFirstName("dele");
        registerForm.setLastName("yusuf");
        registerForm.setMiddleName("ifeanyi");
        registerForm.setPhoneNumber("090567432");
        registerForm.setEmail("fola456@gmail.com");
        registerForm.setPassword("tit789");
        registerForm.setStateOfOrigin("kwara");
        studentService.register(registerForm);

        RegisterStudentRequest reg= new RegisterStudentRequest();
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
    void testThatStudentCanCheckTheirProfile(){
    RegisterStudentRequest registerForm = new RegisterStudentRequest();
    registerForm.setFirstName("tunji");
    registerForm.setLastName("tolani");
    registerForm.setMiddleName("kelani");
    registerForm.setPhoneNumber("09865743");
    registerForm.setEmail("tolumilade56@gmail.com");
    registerForm.setPassword("yitrt78");
    registerForm.setStateOfOrigin("uyo");
    studentService.register(registerForm);

    RegisterStudentRequest registerForm2 = new RegisterStudentRequest();
    registerForm2.setFirstName("tunji");
    registerForm2.setLastName("tolani");
    registerForm2.setMiddleName("kelani");
    registerForm2.setPhoneNumber("09865743");
    registerForm2.setEmail("tolumilade56@gmal.com");
    registerForm2.setPassword("yitrt78");
    registerForm2.setStateOfOrigin("uyo");
    studentService.register(registerForm2);

    StudentProfileResponse response = studentService.canCheckProfile(1);
//    StudentProfileResponse response2 = studentService.canCheckProfile(2);
  System.out.println("response "+response.toString());
   assertFalse(response.getStudent().getEmail().isEmpty());
    assertEquals(1,registerForm.getMatric());
//    assertEquals(2,registerForm2.getMatric());

}
@Test
    void testThatStudentCanResetPassword(){

    RegisterStudentRequest registerForm2 = new RegisterStudentRequest();
    registerForm2.setFirstName("tunji");
    registerForm2.setLastName("tolani");
    registerForm2.setMiddleName("kelani");
    registerForm2.setPhoneNumber("09865743");
    registerForm2.setEmail("tolumilade56@gmal.com");
    registerForm2.setPassword("yitrt78");
    registerForm2.setStateOfOrigin("uyo");
    studentService.register(registerForm2);

   Responses responses = studentService.studentCanResetPassWord("tolumilade56@gmal.com","yitrt7890");
   Student student = studentService.getRepository().findStudentByEmail("tolumilade56@gmal.com");

   assertEquals("yitrt7890",student.getPassword());
    assertEquals("Password update successful",responses.getResponse());
}


}