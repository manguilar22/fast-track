package guru.aguilar.fasttrack.repository;

import guru.aguilar.fasttrack.dao.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface StudentRepository extends CrudRepository<Student,String> {

    Optional<Student> findByName(String name);

}
