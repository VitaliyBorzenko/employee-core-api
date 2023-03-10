package DAR.Backend.employeecoreapi.controller;



import DAR.Backend.employeecoreapi.model.EmployeeModel;

import DAR.Backend.employeecoreapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeServiсe;

    @GetMapping("/check")
    public String check(){
        return "employee-core-api is working";
    }
    @PostMapping
    public ResponseEntity<String> createEmployee(@Valid @RequestBody EmployeeModel employeeModel){
        employeeServiсe.createEmployee(employeeModel);
        return new ResponseEntity<String>("Successfully created", HttpStatus.OK);
    }
    @GetMapping("/all")
    public List<EmployeeModel> getAllEmployees(){
        return employeeServiсe.getAllEmployees();
    }

    @GetMapping("/{employeeId}")
    public EmployeeModel getEmployeeById(@PathVariable String emploteeId){
        return employeeServiсe.getEmployeeById(emploteeId);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<String> updateEmployeeById(@PathVariable String employeeId,@Valid @RequestBody EmployeeModel employeeModel){
        employeeServiсe.updateEmployeeById(employeeId, employeeModel);
        return new ResponseEntity<String>("Successfully update", HttpStatus.OK) ;
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable String employeeId){
        employeeServiсe.deleteEmployeeById(employeeId);
        return new ResponseEntity<String>("Successfully deleted",HttpStatus.OK);
    }

}
