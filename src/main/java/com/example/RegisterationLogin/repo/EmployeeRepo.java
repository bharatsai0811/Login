        package com.example.RegisterationLogin.repo;

        import com.example.RegisterationLogin.entity.Employee;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

        import java.util.Optional;

        @Repository
        public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
                public Employee findByEmployeeMail(String EmployeeMail);

        }
