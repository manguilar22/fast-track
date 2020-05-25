package guru.aguilar.fasttrack.controller;

import guru.aguilar.fasttrack.dao.Student;
import guru.aguilar.fasttrack.services.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private RedisService redisService;


    @GetMapping("/test")
    public String test(){
        return redisService.getStoredInCacheNames().toString();
    }

    @GetMapping("/all")
    public String getAllRecords(){
        return redisService.findAll().toString();
    }

    @GetMapping("/")
    public String index(){
        List<Student> st = new ArrayList<>();
        redisService.findAll().forEach(st::add);
        return st.toString();
    }

    @PostMapping("/")
    public Student addStudent(@RequestBody Student student){
        redisService.insertNewStudent(student);
        return student;
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable String id){
        return redisService.findById(id);
    }

    @GetMapping("/get")
    public Student getStudentByName(@RequestParam String name){
        return redisService.getSomeStudentByName(name);
        }

    @GetMapping("/flush")
    public void flushCache(){
        redisService.flushCache();
    }

/*
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
*/


}
