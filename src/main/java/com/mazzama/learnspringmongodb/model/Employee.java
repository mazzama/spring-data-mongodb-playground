package com.mazzama.learnspringmongodb.model;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by azzam on 25/04/19.
 */
@Document(collection = "employee")
public class Employee {

    @Id
    private String id;
    private String name;
    private double experience;
    private double salary;
    @Indexed(unique = true)
    private String email;

    public Employee() {
    }

    @ApiModelProperty(name = "id", value = "Id of employee", example = "5cc138cc1c790f551d78ef76", dataType = "String")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @ApiModelProperty(name = "name", value = "name of employee", example = "Azzam", dataType = "String")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ApiModelProperty(name = "email", value = "email of employee", example = "mazzamabduljabbar@gmail.com", dataType = "String")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @ApiModelProperty(name = "experience", value = "experience of employee", example = "3", dataType = "double")
    public double getExperience() {
        return experience;
    }

    public void setExperience(double experience) {
        this.experience = experience;
    }

    @ApiModelProperty(name = "salary", value = "salary of employee", example = "6000", dataType = "double")
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
