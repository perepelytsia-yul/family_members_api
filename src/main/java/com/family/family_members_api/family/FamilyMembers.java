package com.family.family_members_api.family;

import javax.persistence.*;

@Entity
@Table
public class FamilyMembers {
    @Id
    @SequenceGenerator(
            name = "family_sequence",
            sequenceName = "family_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "family_sequence"
    )
    private Integer id;
    private String name;
    private Integer age;

    public FamilyMembers() {
    }

    public FamilyMembers(Integer id,
                         String name,
                         Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public FamilyMembers(String name,
                         Integer age) {
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "FamilyMembers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age + "}";
    }
}
