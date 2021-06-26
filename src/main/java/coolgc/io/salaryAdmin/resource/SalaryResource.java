package coolgc.io.salaryAdmin.resource;

import coolgc.io.salaryAdmin.dto.EmployeeSalaryReportDTO;
import coolgc.io.salaryAdmin.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SalaryResource {

    @Autowired
    private SalaryService salarySevice;

    @GetMapping("/salary")
    List<EmployeeSalaryReportDTO> getSalaryReport(@RequestParam(required = false) Long employeeId){
        System.out.println(employeeId);
        return salarySevice.getSalaryReport(employeeId);

    }

}
