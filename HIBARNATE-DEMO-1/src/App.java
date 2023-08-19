import entity.StudentEntity;
import repository.StudentRepository;

public class App {
    public static void main(String[] args) throws Exception {

        StudentRepository repository = new StudentRepository();
        StudentEntity studentEntity = repository.getStudent(3);
        System.out.println(studentEntity.toString());

        studentEntity.setNic("881879789V");
        studentEntity.getStudentName().setFirstName("Updated First Name");

        repository.updateStudent(studentEntity);

        studentEntity = repository.getStudent(3);
        System.out.println(studentEntity.toString());

        repository.deleteStudent(studentEntity);
    }
}
