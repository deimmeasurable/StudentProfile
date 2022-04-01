package africa.semicolon.studentprofile.controllers;

import africa.semicolon.studentprofile.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/student")
public class AdminController {
//    @Autowired
    private AdminService adminService;
//
//@DeleteMapping("/{matric}")
//    public ResponseEntity<?> deleteStudent(@PathVariable int matric){
//    try{
//        return new  ResponseEntity<>(adminService.deleteByMatricNumber(matric), HttpStatus.OK);
//    }catch (Exception e){
//        return  new ResponseEntity<>(new ApiResponse(false,e.getMessage()),HttpStatus.NOT_FOUND);
//    }
//}
}
