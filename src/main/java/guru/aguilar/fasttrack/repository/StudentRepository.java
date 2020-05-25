package guru.aguilar.fasttrack.repository;

import guru.aguilar.fasttrack.dao.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student,String> { }
