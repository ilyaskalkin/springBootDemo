package ru.iskalkin.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.iskalkin.domain.Employee;
import ru.iskalkin.repo.EmployeeRepo;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeController(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @GetMapping
    public List<Employee> list() {
        return employeeRepo.findAll();
    }

    @GetMapping("{id}")
    public Employee getOne(@PathVariable("id") Employee employee) {
        return employee;
    }

    @PostMapping
    public Employee create(@RequestBody Employee employee) {
        return employeeRepo.save(employee);
    }

    @PutMapping("{id}")
    public Employee update(
            @PathVariable("id") Employee employeeFromDb,
            @RequestBody Employee employee) {
        BeanUtils.copyProperties(employee, employeeFromDb, "id");
        return employeeRepo.save(employeeFromDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Employee employee) {
        employeeRepo.delete(employee);
    }
}
