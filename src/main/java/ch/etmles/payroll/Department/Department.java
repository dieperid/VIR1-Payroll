package ch.etmles.payroll.Department;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

@Entity
public class Department {

    private @Id
    @GeneratedValue Long id;
    private String name;

    public Department(){}

    public Department(String name, String role){
        this.setName(name);
    }

    public Long getID(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;
        if(!(o instanceof Department department))
            return false;
        return  Objects.equals(this.id, department.id) &&
                Objects.equals(this.name, department.name);
    }

    @Override
    public int hashCode(){
        return Objects.hash(
                this.id,
                this.name);
    }

    @Override
    public String toString(){
        return "Department{" + "id=" +
                this.getID() + ", name='" +
                this.getName() + '\''+ '}';
    }
}
