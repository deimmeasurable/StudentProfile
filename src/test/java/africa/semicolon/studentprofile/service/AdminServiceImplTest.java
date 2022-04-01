package africa.semicolon.studentprofile.service;

import africa.semicolon.studentprofile.data.dtos.RegisterStudentRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class AdminServiceImplTest {
    AdminService adminService;

    @BeforeEach
    void setUp() {
        adminService= new AdminServiceImpl();
    }
    @Test
    void testThatStudentCanBeDeleted(){
        RegisterStudentRequest registerForm2 = new RegisterStudentRequest();
        registerForm2.setFirstName("tunji");
        registerForm2.setLastName("tolani");
        registerForm2.setMiddleName("kelani");
        registerForm2.setPhoneNumber("09865743");
        registerForm2.setEmail("tolumilade56@gmail.com");
        registerForm2.setPassword("yitrt78");
        registerForm2.setStateOfOrigin("uyo");

        RegisterStudentRequest registerForm = new RegisterStudentRequest();
        registerForm2.setFirstName("tolu");
        registerForm2.setLastName("yemisi");
        registerForm2.setMiddleName("yinka");
        registerForm2.setPhoneNumber("09865743");
        registerForm2.setEmail("fias678@gmail.com");
        registerForm2.setPassword("rest345");
        registerForm2.setStateOfOrigin("uyo");
        adminService.register(registerForm);
        adminService.register(registerForm2);
        assertEquals(2,adminService.getRepository().count());
//      assertEquals(1, adminService.getRepository().count());
    }
}