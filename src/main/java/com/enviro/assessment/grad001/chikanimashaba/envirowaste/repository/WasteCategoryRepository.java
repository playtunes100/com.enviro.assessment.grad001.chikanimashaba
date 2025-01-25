package com.enviro.assessment.grad001.chikanimashaba.envirowaste.repository;

import com.enviro.assessment.grad001.chikanimashaba.envirowaste.model.WasteCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface WasteCategoryRepository 
    extends CrudRepository<WasteCategory, Integer>{
    
}
