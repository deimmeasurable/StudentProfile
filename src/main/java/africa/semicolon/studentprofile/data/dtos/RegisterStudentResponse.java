package africa.semicolon.studentprofile.data.dtos;

public class RegisterStudentResponse {
    private String userName;
    private String fullName;
    private String email;
    private String password;
    private String StateOfOrigin;


    public RegisterStudentResponse(){

    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getFullName(){
        return fullName;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }
    public void setPassword(String password){
        this.password = password;

    }
    public String getPassword(){
        return password;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }
    public String getUserName(){
        return userName;
    }

    public void setStateOfOrigin(String stateOfOrigin) {
        this.StateOfOrigin=stateOfOrigin;
    }
    public String getStateOfOrigin(){
        return StateOfOrigin;
    }
}
