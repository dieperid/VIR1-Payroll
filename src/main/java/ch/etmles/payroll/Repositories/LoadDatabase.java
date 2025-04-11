package ch.etmles.payroll.Employee;

import ch.etmles.payroll.Employee.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository){
        return args->{
            log.info("Preloading " + repository.save(new Employee("Bilbo Baggins", "burglar", "bilbo@eduvaud.ch")));
            log.info("Preloading " + repository.save(new Employee("Frodo Baggins", "thief", "frodo@eduvaud.ch")));
        };
    }
}
