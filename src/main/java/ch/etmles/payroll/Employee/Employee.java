package ch.etmles.payroll.Employee;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

@Entity
public class Employee {

    private @Id
    @GeneratedValue Long id;
    private String name;
    private String role;
    private String email;

    public Employee(){}

    public Employee(String name, String role, String email){
        this.setName(name);
        this.setRole(role);
        this.setEmail(email);
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

    public String getRole(){
        return this.role.toUpperCase();
    }

    public void setRole(String role){
        this.role = role;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;
        if(!(o instanceof Employee employee))
            return false;
        return  Objects.equals(this.id, employee.id) &&
                Objects.equals(this.name, employee.name) &&
                Objects.equals(this.role, employee.role) &&
                Objects.equals(this.email, employee.email);
    }

    @Override
    public int hashCode(){
        return Objects.hash(
                this.id,
                this.name,
                this.role,
                this.email);
    }

    @Override
    public String toString(){
        return "Employee{" + "id=" +
                this.getID() + ", name='" +
                this.getName() + '\'' + ", role='" +
                this.getRole() + '\'' + ", email='" +
                this.getEmail() + '\'' +
                '}';
    }
}
