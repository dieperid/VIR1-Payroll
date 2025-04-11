package ch.etmles.payroll.Department;

import ch.etmles.payroll.Department.Department;
import ch.etmles.payroll.Department.DepartmentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentRepository repository;

    DepartmentController(DepartmentRepository repository){
        this.repository = repository;
    }

    /* curl sample :
    curl -i localhost:8080/department
    */
    @GetMapping
    List<Department> all(){
        return repository.findAll();
    }

    /* curl sample :
    curl -i -X POST localhost:8080/department ^
        -H "Content-type:application/json" ^
        -d "{\"name\": \"Informatique\"}"
    */
    @PostMapping
    Department newDepartment(@RequestBody Department newDepartment){
        return repository.save(newDepartment);
    }

    /* curl sample :
    curl -i localhost:8080/department/1
    */
    @GetMapping("/{id}")
    Department one(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException(id));
    }

    /* curl sample :
    curl -i -X PUT localhost:8080/department/2 ^
        -H "Content-type:application/json" ^
        -d "{\"name\": \"Samwise Bing\", \"role\": \"peer-to-peer\"}"
     */
    @PutMapping("/{id}")
    Department replaceDepartment(@RequestBody Department newDepartment, @PathVariable Long id) {
        return repository.findById(id)
                .map(department -> {
                    department.setName(newDepartment.getName());
                    return repository.save(department);
                })
                .orElseGet(() -> {
                    newDepartment.setId(id);
                    return repository.save(newDepartment);
                });
    }

    /* curl sample :
    curl -i -X DELETE localhost:8080/department/2
    */
    @DeleteMapping("/{id}")
    void deleteDepartment(@PathVariable Long id){
        repository.deleteById(id);
    }
}
