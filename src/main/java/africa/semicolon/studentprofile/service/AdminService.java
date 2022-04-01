package africa.semicolon.studentprofile.service;

public interface AdminService extends StudentService{

   void deleteByMatricNumber(int matric) ;
   int count();

}
