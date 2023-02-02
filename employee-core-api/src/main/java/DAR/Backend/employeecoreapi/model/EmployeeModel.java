package DAR.Backend.employeecoreapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeModel {
    private String employeeid;
    @NotNull(message = "Name can not be empty")
    private String name;
    @NotNull(message = "Surame can not be empty")
    @Size(min = 2, max = 16, message = "Surname must be greater than 2 and less than 16")
    private String surname;
    private String company;
    private String position;
    @Email(message = "incorrect email")
    private String email;
    private double salary;

}
