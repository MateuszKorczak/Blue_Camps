package org.niebieskidom.bluecamps.entity;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "camps")
public class Camp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "To pole jest wymagane")
    @NotEmpty(message = "To pole jest wymagane")
    private String campsName;

    @NotNull(message = "To pole jest wymagane")
    @NotEmpty(message = "To pole jest wymagane")
    private String address;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date startDate;

    @NotNull(message = "To pole jest wymagane")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date endDate;

    @NotNull
    @Range(min = 15, max = 300, message = "Liczba musi mieścić się w zakresie 15-300.")
    private Integer personLimit;

    @ManyToMany
    @JoinTable(name = "camps_children", joinColumns = @JoinColumn(name = "camp_id"), inverseJoinColumns = @JoinColumn(name = "children_id"))
    private List<Child> children = new ArrayList<>();

    public Camp() {
    }

    public Camp(@NotNull @NotEmpty String campsName, @NotNull @NotEmpty String address, @NotNull Date startDate, @NotNull Date endDate, @NotNull @Digits(integer = 3, fraction = 0) Integer personLimit) {
        this.campsName = campsName;
        this.address = address;
        this.startDate = startDate;
        this.endDate = endDate;
        this.personLimit = personLimit;
    }

    public Camp(@NotNull @NotEmpty String campsName, @NotNull @NotEmpty String address, @NotNull Date startDate, @NotNull Date endDate, @NotNull @Digits(integer = 3, fraction = 0) Integer personLimit, List<Child> children) {
        this.campsName = campsName;
        this.address = address;
        this.startDate = startDate;
        this.endDate = endDate;
        this.personLimit = personLimit;
        this.children = children;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCampsName() {
        return campsName;
    }

    public void setCampsName(String campsName) {
        this.campsName = campsName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getPersonLimit() {
        return personLimit;
    }

    public void setPersonLimit(Integer personLimit) {
        this.personLimit = personLimit;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Camp{" +
                "id=" + id +
                ", campsName='" + campsName + '\'' +
                ", address='" + address + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", personLimit=" + personLimit +
                ", children=" + children +
                '}';
    }
}
