package com.mmtvbd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Timestamp;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Models {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "name is mandatory")
    @Size(max = 50)
    @Column(nullable = false)
    private String modelName;
    private Timestamp entryDate;

    @ManyToOne
    private Brand brand;

}
