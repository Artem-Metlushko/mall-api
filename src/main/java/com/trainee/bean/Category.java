package com.trainee.bean;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long categoryId;
    private String name;
    private String description;
    private Integer productCount;
    private String image;
    private Double rating;

}


