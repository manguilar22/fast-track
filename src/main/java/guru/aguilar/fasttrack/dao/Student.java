package guru.aguilar.fasttrack.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;

@RedisHash("Student")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {

    public enum Classification {
        FRESHMAN, SOPHMORE, JUNIOR, SENIOR
    }

    @Id private  String id;
    @Indexed private  String name;
    @Indexed private  Classification classification;
    @Indexed private  Integer grade;

}
