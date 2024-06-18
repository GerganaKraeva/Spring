package bg.softuni.eventsschedulingcaches.chache;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;
import java.util.List;

@RestController
public class StudentController {


    public final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/cache")
    public String getAll() {
       studentService.
                getAllStudents()
                .forEach(System.out::println);
        System.out.println("----------");
        studentService.
                getAllStudents()
                .forEach(System.out::println);
        System.out.println("----------");
        studentService.
                updateStudents();
        studentService.
                getAllStudents()
                .forEach(System.out::println);
//        var student1 = studentService.getStudentByName("Pesho");
//        var student2 =studentService.getStudentByName("Pesho");
//        var student3 =studentService.getStudentByName("Ani");
//        var student4 =studentService.getStudentByName("Ani");
//
//        System.out.println(student1);
//        System.out.println(student2);
//        System.out.println(student3);
//        System.out.println(student4);




        return "OK";
    }


}
