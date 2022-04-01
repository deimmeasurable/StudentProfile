package africa.semicolon.studentprofile.data.dtos;

import lombok.Data;

@Data
@lombok.Getter
@lombok.Setter
public class FindStudentResponse {
    private long matricNo;
    private String password;

}
