package guru.aguilar.fasttrack.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("Student")
@Data
@AllArgsConstructor
public class Student implements Serializable {

    public enum Classification {
        FRESHMAN, SOPHMORE, JUNIOR, SENIOR
    }

    private  String id;
    private  String name;
    private  Classification classification;
    private  Integer grade;

    protected Student(){}


}
