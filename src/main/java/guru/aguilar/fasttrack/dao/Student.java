package guru.aguilar.fasttrack.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {

    public enum Classification {
        FRESHMAN, SOPHMORE, JUNIOR, SENIOR
    }

    @Id private  String id;
    private  String name;
    private  Classification classification;
    private  Integer grade;

}
