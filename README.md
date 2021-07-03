# SalaryAdmin

## Problem

1. Create a data access layer that consumes the following API (that you can test through
swagger) as your data repository.
API response example:

```bash
[{"id":1,"name":"Andrea","contractTypeName":"HourlySalaryEmployee","roleId":1,"roleName":"Administrator","roleDescription":null,"hourlySalary":10000.0,"monthlySalary":50000.0},
{"id":2,"name":"Alex","contractTypeName":"MonthlySalaryEmployee","roleId":2,"roleName":"Contractor","roleDescription":null,"hourlySalary":10000.0,"monthlySalary":50000.0}]
```

2. Based on data returned on previous step, build a new package that returns the
   employee with his calculated Annual Salary following these rules:
   • Employees can have to 2 types of Contracts: Hourly Salary Contract and Monthly
   Salary Contract.
   ▪ For Hourly Salary Employees the Annual Salary is
> 120 * HourlySalary * 12


▪ For Monthly Salary Employees the Annual Salary is

> 120 * Monthly * 12


### Execution

Use maven

```bash
mvn clean package -DskipTests=true
```

### Usage

```bash
java -jar ./target/salaryAdmin-0.0.1-SNAPSHOT.jar
```

### Usage on Windows

```bash
java -jar .\target\salaryAdmin-0.0.1-SNAPSHOT.jar


