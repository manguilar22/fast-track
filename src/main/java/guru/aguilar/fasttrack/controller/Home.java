package guru.aguilar.fasttrack.controller;

import guru.aguilar.fasttrack.dao.Student;
import guru.aguilar.fasttrack.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class Home {

    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping("/")
    public String message(){
        return "home";
    }

    @RequestMapping("/add")
    public String addNoteToRedis(){
        Student student = new Student("1","A",Student.Classification.FRESHMAN,100);
        try {
            studentRepository.save(student);
            return "added to redis: " + student.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "FAIL";
        }

    @RequestMapping("/all")
    public Iterable<Student> getAllNotesInRedis(){
        return studentRepository.findAll();
    }



}
