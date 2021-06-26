package coolgc.io.salaryAdmin.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class EmployeeDTO {
    private Long id;
    private String name;
    private String contractTypeName;
    private Long roleId;
    private String roleDescription;
    private BigDecimal monthlySalary;
    private BigDecimal hourlySalary;

}
