package com.enviro.assessment.grad001.chikanimashaba.envirowaste.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class WasteCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty
    private String name;

    private String description;
    
    private String disposalGuideline;
    
    private String recyclingTip;

    public WasteCategory(String name, String description, String disposalGuideline, String recyclingTip){
        this.name = name;
        this.description = description;
        this.disposalGuideline = disposalGuideline;
        this.recyclingTip = recyclingTip;

    }
}
