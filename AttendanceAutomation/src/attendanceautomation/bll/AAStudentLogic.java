package attendanceautomation.bll;

import attendanceautomation.be.Student;
import attendanceautomation.dal.StudentDAO;
import java.sql.SQLException;
import java.util.List;

/**
 * A simple pass through logic layer class.
 * 
 * @author Daniel
 */
public class AAStudentLogic{
    
    public Student createStudent(Student s) throws SQLException{
        StudentDAO sdao = new StudentDAO();
        return sdao.createStudent(0, s);
    }
    
    public Student getStudent(int id){
        StudentDAO sdao = new StudentDAO();
        return sdao.getStudent(id);
    }
    
    public void updateStudent(Student s) throws SQLException{
        StudentDAO sdao = new StudentDAO();
        sdao.updateStudent(s);
    }
    
    public void deleteStudent(Student s) throws SQLException{
        StudentDAO sdao = new StudentDAO();
        sdao.deleteStudent(s);
    }
    
    public List<Student> getAllStudents(){
        StudentDAO sdao = new StudentDAO();
        return sdao.getAllStudents();
    }
}