package com.hotelmanagement.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link com.hotelmanagement.entity.Employee} entity
 */
public class StoreEmployeeDTO implements Serializable {
    @Size(max = 20)
    @NotNull
    private String employeeType;
    @Size(max = 5)
    @NotNull
    private String title;
    @Size(max = 12)
    @NotNull
    private String nic;
    @Size(max = 50)
    @NotNull
    private String firstName;
    @Size(max = 50)
    private String lastName;
    @NotNull
    private LocalDate dob;
    @Size(max = 6)
    @NotNull
    private String sex;
    @Size(max = 10)
    @NotNull
    private String telNo;
    @Size(max = 150)
    @NotNull
    private String address;
    @Size(max = 50)
    private String email;
    @NotNull
    private BigDecimal salary;

    public StoreEmployeeDTO() {
    }

    public StoreEmployeeDTO(String employeeType, String title, String nic, String firstName, String lastName, LocalDate dob, String sex, String telNo, String address, String email, BigDecimal salary) {
        this.employeeType = employeeType;
        this.title = title;
        this.nic = nic;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.sex = sex;
        this.telNo = telNo;
        this.address = address;
        this.email = email;
        this.salary = salary;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StoreEmployeeDTO entity = (StoreEmployeeDTO) o;
        return Objects.equals(this.employeeType, entity.employeeType) &&
                Objects.equals(this.title, entity.title) &&
                Objects.equals(this.nic, entity.nic) &&
                Objects.equals(this.firstName, entity.firstName) &&
                Objects.equals(this.lastName, entity.lastName) &&
                Objects.equals(this.dob, entity.dob) &&
                Objects.equals(this.sex, entity.sex) &&
                Objects.equals(this.telNo, entity.telNo) &&
                Objects.equals(this.address, entity.address) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.salary, entity.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeType, title, nic, firstName, lastName, dob, sex, telNo, address, email, salary);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "employeeType = " + employeeType + ", " +
                "title = " + title + ", " +
                "nic = " + nic + ", " +
                "firstName = " + firstName + ", " +
                "lastName = " + lastName + ", " +
                "dob = " + dob + ", " +
                "sex = " + sex + ", " +
                "telNo = " + telNo + ", " +
                "address = " + address + ", " +
                "email = " + email + ", " +
                "salary = " + salary + ")";
    }
}