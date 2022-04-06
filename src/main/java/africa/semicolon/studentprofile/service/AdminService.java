package africa.semicolon.studentprofile.service;

import lombok.Data;
import org.springframework.stereotype.Service;


public interface AdminService extends StudentService{

   void deleteByMatricNumber(int matric) ;


}
