package africa.semicolon.studentprofile.controllers;

import africa.semicolon.studentprofile.data.dtos.RegisterStudentRequest;
import africa.semicolon.studentprofile.exception.PasswordNotSuccessfulException;
import africa.semicolon.studentprofile.exception.RegisterStudentException;
import africa.semicolon.studentprofile.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody RegisterStudentRequest requestForm){
        try{
            return new ResponseEntity<>(studentService.register(requestForm), HttpStatus.OK);
        }catch(RegisterStudentException ex){
            return new ResponseEntity<>(new ApiResponse(false,ex.getMessage()),HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/{matric}")
    public ResponseEntity<?>findByMatric(@PathVariable int matric){
        try{
            return new ResponseEntity<>(studentService.canCheckProfile(matric),HttpStatus.OK);
        } catch (RegisterStudentException e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()),HttpStatus.NOT_FOUND);
        }
    }
    @PatchMapping("/{email}/{updatePassword}")
    public ResponseEntity<?>studentCanResetPassWord(@PathVariable String email,String updatePassword){
        try{
            return new ResponseEntity<>(studentService.studentCanResetPassWord(email,updatePassword),HttpStatus.OK);
        }catch (PasswordNotSuccessfulException e){
            return new ResponseEntity<>(new ApiResponse(false,e.getMessage()),HttpStatus.NOT_FOUND);
        }
    }

}
