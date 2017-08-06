package net.space.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author A.Albert
 * @Data 8/3/17
 * @Time 9:53 AM
 * @Version 1.0
 * @Info Simple javaBean object.
 */

@Entity
@Table(name = "band")
public class Band {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name_group")
    private String nameGroup;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }
}
