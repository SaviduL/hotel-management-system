package com.hotelmanagement.entity;

import org.hibernate.Hibernate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "managers", schema = "hotel_springboot_db")
public class Manager {
    @Id
    @Size(max = 8)
    @Column(name = "managerID", nullable = false, length = 8)
    private String id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "managerID", nullable = false)
    private Employee employees;

    @OneToMany(mappedBy = "handlerManagerID")
    private Set<Advance> advances = new LinkedHashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Employee getEmployees() {
        return employees;
    }

    public void setEmployees(Employee employees) {
        this.employees = employees;
    }

    public Set<Advance> getAdvances() {
        return advances;
    }

    public void setAdvances(Set<Advance> advances) {
        this.advances = advances;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Manager manager = (Manager) o;
        return id != null && Objects.equals(id, manager.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ")";
    }
}