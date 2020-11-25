package org.niebieskidom.bluecamps.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

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
    private String place;



}
