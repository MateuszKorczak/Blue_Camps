package org.niebieskidom.bluecamps.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "camps")
public class Camp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotEmpty
    private String campsName;

    @NotNull
    @NotEmpty
    @DateTimeFormat
    private LocalDateTime startDate;

    @NotNull
    @NotEmpty
    @DateTimeFormat
    private LocalDateTime endDate;

    @NotNull
    @NotEmpty
    private String address;

    @ManyToMany
    @JoinTable(name = "camps_children", joinColumns = @JoinColumn(name = "camp_id"), inverseJoinColumns = @JoinColumn(name = "children_id"))
    private List<Child> children = new ArrayList<>();

    public Camp() {
    }

    public Camp(@NotNull @NotEmpty String campsName, @NotNull @NotEmpty LocalDateTime startDate, @NotNull @NotEmpty LocalDateTime endDate, @NotNull @NotEmpty String address) {
        this.campsName = campsName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.address = address;
    }

    public Camp(@NotNull @NotEmpty String campsName, @NotNull @NotEmpty LocalDateTime startDate, @NotNull @NotEmpty LocalDateTime endDate, @NotNull @NotEmpty String address, List<Child> children) {
        this.campsName = campsName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.address = address;
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

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String place) {
        this.address = place;
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
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", place='" + address + '\'' +
                ", children=" + children +
                '}';
    }
}
