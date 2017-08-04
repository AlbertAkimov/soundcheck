package net.space.model;

import org.hibernate.annotations.Columns;

import javax.persistence.*;

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
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name_group")
    private String nameGroup;

    public Band() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    @Override
    public String toString() {
        return "Band{" +
                "id=" + id +
                ", nameGroup='" + nameGroup + '\'' +
                '}';
    }
}
