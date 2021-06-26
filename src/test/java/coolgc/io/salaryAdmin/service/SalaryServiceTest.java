package coolgc.io.salaryAdmin.service;

import coolgc.io.salaryAdmin.dto.EmployeeSalaryReportDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SalaryServiceTest {

   @Autowired
   SalaryService salaryService;

    @Test
    void getSalaryReportByEmployeeId() {
        Long employeeId = 2L;
        List<EmployeeSalaryReportDTO> employees =  salaryService.getSalaryReport(employeeId);
        assertFalse(employees.isEmpty());
    }

    @Test
    void getSalaryReportAll() {
        List<EmployeeSalaryReportDTO> employees =  salaryService.getSalaryReport(null);
        assertTrue(employees.size() > 1);
    }
}