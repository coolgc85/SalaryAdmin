package coolgc.io.salaryAdmin.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class EmployeeSalaryReportDTO {
    private Long id;
    private String name;
    private String contractTypeName;
    private BigDecimal yearlySalary;
}
