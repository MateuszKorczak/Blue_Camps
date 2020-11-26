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
    private String place;

    @ManyToMany
    @JoinColumn(name = "id_child")
    private List<Child> children = new ArrayList<>();   // czy lepiej byłoby korzystać z set?

}
