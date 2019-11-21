import com.mqx.dao.StudentDao;
import com.mqx.dao.StudentDaoImpl;
import com.mqx.po.Student;

import java.util.List;

/**
 * @authordell
 * @Create2019-11-21-11:39
 */
public class TestStudentDao {
   @org.junit.Test
    public  void  testStudentDaoSelectAll(){
       StudentDao sd=new StudentDaoImpl();
       List<Student> students=((StudentDaoImpl) sd).selectQueryAll();
       for(Student student:students){
           System.out.println("student = " + student);
       }
   }
}
