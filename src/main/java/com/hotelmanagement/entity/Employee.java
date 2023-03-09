package com.hotelmanagement.entity;

import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "employees", schema = "hotel_springboot_db")
public class Employee {
    @Id
    @Size(max = 8)
    @Column(name = "employeeID", nullable = false, length = 8)
    private String id;

    @Size(max = 20)
    @NotNull
    @Column(name = "employeeType", nullable = false, length = 20)
    private String employeeType;

    @Size(max = 5)
    @NotNull
    @Column(name = "title", nullable = false, length = 5)
    private String title;

    @Size(max = 12)
    @NotNull
    @Column(name = "nic", nullable = false, length = 12)
    private String nic;

    @Size(max = 50)
    @NotNull
    @Column(name = "firstName", nullable = false, length = 50)
    private String firstName;

    @Size(max = 50)
    @Column(name = "lastName", length = 50)
    private String lastName;

    @NotNull
    @Column(name = "dob", nullable = false)
    private LocalDate dob;

    @Size(max = 6)
    @NotNull
    @Column(name = "sex", nullable = false, length = 6)
    private String sex;

    @Size(max = 10)
    @NotNull
    @Column(name = "telNo", nullable = false, length = 10)
    private String telNo;

    @Size(max = 150)
    @NotNull
    @Column(name = "address", nullable = false, length = 150)
    private String address;

    @Size(max = 50)
    @Column(name = "email", length = 50)
    private String email;

    @NotNull
    @Column(name = "salary", nullable = false, precision = 8, scale = 2)
    private BigDecimal salary;

    @Size(max = 10)
    @NotNull
    @Column(name = "status", nullable = false, length = 10)
    private String status;

    @Column(name = "joinedDate")
    private LocalDate joinedDate;

    @Column(name = "deletedAt")
    private Instant deletedAt;

    @OneToOne(mappedBy = "employees")
    private Waiter waiter;

    @OneToOne(mappedBy = "employees")
    private Cashier cashier;

    @OneToOne(mappedBy = "employees")
    private Receptionist receptionist;

    @OneToMany(mappedBy = "employeeID")
    private Set<Bonus> bonuses = new LinkedHashSet<>();

    @OneToOne(mappedBy = "employees")
    private Manager manager;

    @OneToOne(mappedBy = "employeeID")
    private User users;

    @OneToOne(mappedBy = "employees")
    private Chef chef;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(LocalDate joinedDate) {
        this.joinedDate = joinedDate;
    }

    public Instant getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Instant deletedAt) {
        this.deletedAt = deletedAt;
    }

    @OneToMany(mappedBy = "employeeID")
    private Set<Advance> advances = new LinkedHashSet<>();

    public Set<Advance> getAdvances() {
        return advances;
    }

    public void setAdvances(Set<Advance> advances) {
        this.advances = advances;
    }

    public Chef getChef() {
        return chef;
    }

    public void setChef(Chef chef) {
        this.chef = chef;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Set<Bonus> getBonuses() {
        return bonuses;
    }

    public void setBonuses(Set<Bonus> bonuses) {
        this.bonuses = bonuses;
    }

    public Receptionist getReceptionist() {
        return receptionist;
    }

    public void setReceptionist(Receptionist receptionist) {
        this.receptionist = receptionist;
    }

    public Cashier getCashier() {
        return cashier;
    }

    public void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Employee employee = (Employee) o;
        return id != null && Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
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
                "salary = " + salary + ", " +
                "status = " + status + ", " +
                "joinedDate = " + joinedDate + ", " +
                "waiter = " + waiter + ", " +
                "cashier = " + cashier + ", " +
                "receptionist = " + receptionist + ", " +
                "manager = " + manager + ", " +
                "users = " + users + ", " +
                "chef = " + chef + ")";
    }
}