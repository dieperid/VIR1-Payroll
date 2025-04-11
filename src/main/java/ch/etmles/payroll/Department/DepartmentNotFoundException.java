package ch.etmles.payroll.Department;

public class DepartmentNotFoundException extends RuntimeException{

    DepartmentNotFoundException(Long id){
        super("Could not find department " + id);
    }
}
