package africa.semicolon.studentprofile.data.dtos;

import africa.semicolon.studentprofile.data.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Data
//@AllArgsConstructor
public class StudentProfileResponse{
   @Setter
   private Student student;
}
