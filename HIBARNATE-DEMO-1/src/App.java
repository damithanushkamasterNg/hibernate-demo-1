import java.util.ArrayList;
import java.util.List;
import entity.StudentEntity;
import entity.embeded.StudentName;
import repository.StudentRepository;

public class App {
    public static void main(String[] args) throws Exception {

        StudentRepository repository = new StudentRepository();
        StudentEntity studentEntity = new StudentEntity();
        StudentName studentName = new StudentName("firstName1", "lastname");
        List<String>  moblies = new ArrayList<>();
        moblies.add("3232323232323");
        moblies.add("2324545646465");

        studentEntity.setNic("43242342V");
        studentEntity.setStudentName(studentName);
        studentEntity.setMobileNos(moblies);
        repository.saveStudent(studentEntity);

    }
}
