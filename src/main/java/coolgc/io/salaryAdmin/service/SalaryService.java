package coolgc.io.salaryAdmin.service;

import coolgc.io.salaryAdmin.dto.EmployeeDTO;
import coolgc.io.salaryAdmin.dto.EmployeeSalaryReportDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class SalaryService {

    @Autowired
    RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {

        return builder
                .setConnectTimeout(Duration.ofMillis(5000))
                .setReadTimeout(Duration.ofMillis(5000))
                .build();
    }

    private BigDecimal calculateAnnualSalary(EmployeeDTO employeeDTO) {
        BigDecimal annualSalary = null;
        BigDecimal hoursPerMonth = new BigDecimal(120);

        String contractType = employeeDTO.getContractTypeName();

        if (contractType.equals("HourlySalaryEmployee")) {
            annualSalary = employeeDTO.getHourlySalary().multiply(hoursPerMonth).
                    multiply(new BigDecimal(12));
        } else if (contractType.equals("MonthlySalaryEmployee")) {
            annualSalary = employeeDTO.getMonthlySalary().multiply(hoursPerMonth).
                    multiply(new BigDecimal(12));
        }

        return annualSalary;
    }


    public List<EmployeeSalaryReportDTO> getSalaryReport(Long employeeId) {
        List<EmployeeSalaryReportDTO> response = null;
        EmployeeDTO[] result = restTemplate.getForObject
                ("http://masglobaltestapi.azurewebsites.net/api/employees", EmployeeDTO[].class);


        if (employeeId != null) {
            Predicate<EmployeeDTO> fe = e -> e.getId().equals(employeeId);
            response = Arrays.stream(result).filter(fe).
                    map(e -> new EmployeeSalaryReportDTO(e.getId(), e.getName(),
                            e.getContractTypeName(), this.calculateAnnualSalary(e))).collect(Collectors.toList());
        } else {
            response = Arrays.stream(result).map(e ->
                    new EmployeeSalaryReportDTO(e.getId(), e.getName(),
                            e.getContractTypeName(), this.calculateAnnualSalary(e))).collect(Collectors.toList());
        }

        return response;
    }
}