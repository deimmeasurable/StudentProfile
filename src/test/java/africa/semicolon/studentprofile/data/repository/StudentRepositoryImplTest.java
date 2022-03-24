package africa.semicolon.studentprofile.data.repository;

import africa.semicolon.studentprofile.data.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepositoryImplTest {
private StudentRepository studentRepository;
    @BeforeEach
    void setUp() {
        studentRepository = new StudentRepositoryImpl();
    }
    @Test
    void studentCanCreateAccountTest(){
        //given
        Student student = new Student();
        student.setFirstName("ola");
        student.setLastName("seyi");
        student.setMiddleName("oyin");
        student.setEmail("seyi456@gmail.com");
        student.setStateOfOrigin("oyo");
        student.setPhoneNumber("0705643");
        student.setPassword("rest456");
        //when
        studentRepository.save(student);

        assertEquals(1,studentRepository.count());


    }
    @Test
    void testThatWeHaveMoreStudentThatRegister(){
        //given
    threeStudentForm();

        assertEquals(3,studentRepository.count());

    }
    private void threeStudentForm(){


        Student student = new Student();
        student.setFirstName("ola");
        student.setLastName("seyi");
        student.setMiddleName("oyin");
        student.setEmail("seyi456@gmail.com");
        student.setStateOfOrigin("oyo");
        student.setPhoneNumber("0705643");
        student.setPassword("rest456");



        Student student2 = new Student();
        student2.setFirstName("akin");
        student2.setLastName("fola");
        student2.setMiddleName("rotimi");
        student2.setEmail("folaakin67@gmail.com");
        student2.setStateOfOrigin("kano");
        student2.setPassword("rat5678");
        student2.setPhoneNumber("098567");


        Student student3= new Student();
        student3.setFirstName("akintola");
        student3.setLastName("yinka");
        student3.setMiddleName("damola");
        student3.setEmail("yinkadamola@gmail.com");
        student3.setStateOfOrigin("lagos");
        student3.setPassword("del1234");
        student3.setPhoneNumber("0856743");


        studentRepository.save(student);
        studentRepository.save(student2);
        studentRepository.save(student3);




    }
    @Test
    void testThatStudentCanBeFindByEmail(){
        //given
        threeStudentForm();
        //
        Student student=studentRepository.findStudentByEmail("yinkadamola@gmail.com");

        assertEquals("yinkadamola@gmail.com",student.getEmail());

    }
    @Test
    void testThatStudentCanResetPasswordIfCorrectEmailIsProvided(){

        threeStudentForm();

    Student studentResetPassword =  studentRepository.resetPasswordWhenCorrectEmailExist("seyi456@gmail.com","gogo556");

        studentRepository.save(studentResetPassword);

        assertEquals("seyi456@gmail.com", studentResetPassword.getEmail());
        assertEquals("gogo556", studentResetPassword.getPassword());



    }
    @Test
    void testThatStudentCanBeFindByPhoneNumber(){
        threeStudentForm();
        Student foundByPhoneNumber= studentRepository.findStudentByPhoneNumber("098567");
        assertEquals("098567",foundByPhoneNumber.getPhoneNumber());
    }
    @Test
    void testThatStudentCanUpdatePhoneNumber(){
        //given
        threeStudentForm();
        //when

        Student studentUpdatePhone= studentRepository.studentUpdatePhone("yinkadamola@gmail.com","del1234","09067543123");
//        studentRepository.save(studentUpdatePhone);
      assertEquals("yinkadamola@gmail.com",studentUpdatePhone.getEmail());
        assertEquals("del1234",studentUpdatePhone.getPassword());
        assertEquals("09067543123",studentUpdatePhone.getPhoneNumber());

    }
    @Test
    void CanDeleteAStudent(){
        Student student = new Student();
        student.setFirstName("ola");
        student.setLastName("seyi");
        student.setMiddleName("oyin");
        student.setEmail("seyi456@gmail.com");
        student.setStateOfOrigin("oyo");
        student.setPhoneNumber("0705643");
        student.setPassword("rest456");



        Student student2 = new Student();
        student2.setFirstName("akin");
        student2.setLastName("fola");
        student2.setMiddleName("rotimi");
        student2.setEmail("folaakin67@gmail.com");
        student2.setStateOfOrigin("kano");
        student2.setPassword("rat5678");
        student2.setPhoneNumber("098567");


        Student student3= new Student();
        student3.setFirstName("akintola");
        student3.setLastName("yinka");
        student3.setMiddleName("damola");
        student3.setEmail("yinkadamola@gmail.com");
        student3.setStateOfOrigin("lagos");
        student3.setPassword("del1234");
        student3.setPhoneNumber("0856743");


        studentRepository.save(student);
        studentRepository.save(student2);
        studentRepository.save(student3);


        studentRepository.deleteStudent(student);
        assertEquals(2,studentRepository.count());
    }





}