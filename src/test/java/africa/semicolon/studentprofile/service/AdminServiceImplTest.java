package africa.semicolon.studentprofile.service;

import africa.semicolon.studentprofile.data.dtos.RegisterStudentRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AdminServiceImplTest {
    AdminService adminService;

    @BeforeEach
    void setUp() {
        adminService= new AdminServiceImpl();
    }
    @Test
    void testThatStudentCanBeDeleted(){
        RegisterStudentRequest student1 = new RegisterStudentRequest();
        student1.setFirstName("tunji");
        student1.setLastName("tolani");
        student1.setMiddleName("kelani");
        student1.setPhoneNumber("09865743");
        student1.setEmail("tolumilade56@gmail.com");
        student1.setPassword("yitrt78");
        student1.setStateOfOrigin("uyo");


        RegisterStudentRequest student2 = new RegisterStudentRequest();
        student2.setFirstName("tolu");
        student2.setLastName("yemisi");
        student2.setMiddleName("yinka");
        student2.setPhoneNumber("09865743");
        student2.setEmail("fias678@gmail.com");
        student2.setPassword("rest345");
        student2.setStateOfOrigin("uyo");


       adminService.register(student1);
     adminService.register(student2);
     //assert that to student exist in the db
        assertEquals(2,adminService.getRepository().count());


        //when will delete by matric
        adminService.deleteByMatricNumber(1);
      System.out.println(adminService);
assertEquals(1, adminService.getRepository().count());
  }
}
