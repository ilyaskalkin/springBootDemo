package ru.iskalkin.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.iskalkin.domain.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}
