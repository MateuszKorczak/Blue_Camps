package org.niebieskidom.bluecamps.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.annotation.Secured;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "camps")
@Secured("ROLE_ADMIN")
public class Camp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    private String campsName;

    @NotNull
    @NotEmpty
    private String address;

    @NotNull
    @Basic
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private java.util.Date startDate;

    @NotNull
    @Basic
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private java.util.Date endDate;

    @NotNull
    @Range(min = 15, max = 300, message = "Liczba musi mieścić się w zakresie 15-300.")
    private Integer personLimit;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinTable(name = "camp_children", joinColumns = @JoinColumn(name = "camp_id"),
            inverseJoinColumns = @JoinColumn(name = "children_id"))
    private List<Child> children;



//    constructor

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

//    Getters and setters

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
