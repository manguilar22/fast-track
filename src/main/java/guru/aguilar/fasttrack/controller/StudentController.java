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
/*
    @Autowired
    private RedisService redisService;

    @GetMapping("/test")
    @ResponseBody
    public String test(){
        return redisService.getStoredInCacheNames().toString();
    }

    @GetMapping("/all")
    @ResponseBody
    public String getAllRecords(){
        return redisService.findAll().toString();
    }

    @GetMapping("/")
    @ResponseBody
    public String index(){
        List<Student> st = new ArrayList<>();
        redisService.findAll().forEach(st::add);
        String rs = st.toString();
        return rs;
    }

    @PostMapping("/")
    @ResponseBody
    public Student addStudent(@RequestBody Student student){
        redisService.insertNewStudent(student);
        return student;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Student findById(@PathVariable String id){
        return redisService.findById(id);
    }

    @GetMapping("/get")
    @ResponseBody
    public Student getStudentByName(@RequestParam String name){
        return redisService.getSomeStudentByName(name);
        }

    @PostMapping("/flush")
    public void flushCache(){
        redisService.flushCache();
    }
*/
}
