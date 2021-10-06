package com.relation.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Country country;

    @Builder.Default
    @OneToMany(mappedBy = "food", fetch = FetchType.LAZY)
    private List<FoodCategory> foodCategories = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "food", fetch = FetchType.LAZY)
    private List<FoodTag> foodTags = new ArrayList<>();

}
