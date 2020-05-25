package guru.aguilar.fasttrack.services;

import guru.aguilar.fasttrack.dao.Student;
import guru.aguilar.fasttrack.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RedisService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CacheManager cacheManager;

    public String TROUBLESHOOT(){
        Student student = new Student("1","A",Student.Classification.SENIOR,3);
        studentRepository.save(student);
        return "inserted: "+student.toString();
    }

    public Student getSomeStudentByName(String name){
        Optional<Student> op = studentRepository.findByName(name);
        if (op.isPresent())
        {
            return op.get();
        }
        return null;
    }

    @Cacheable(cacheNames = "findAllCache", unless = "#result == null")
    public Iterable<Student> findAll(){
        return studentRepository.findAll();
    }

    @CacheEvict(cacheNames = "findAllCache")
    public Student insertNewStudent(Student student){
        studentRepository.save(student);
        return student;
    }

    @Cacheable(cacheNames = "findByIdCache",key = "#id",unless = "#result == null")
    public Student findById(String id){
       Student opt = studentRepository.findById(id).get();
       return opt;
    }

    public Map<String,String> getStoredInCacheNames(){
        Map<String,String> m = new HashMap<>();
        for(String s: cacheManager.getCacheNames())
        {
            m.put(s,cacheManager.getCache(s).getName());
        }
        return m;
    }

    public void flushCache(){
        for(String s: cacheManager.getCacheNames()){
            cacheManager.getCache(s).clear();
        }
    }

}
