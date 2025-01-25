package com.enviro.assessment.grad001.chikanimashaba.envirowaste.service;

import com.enviro.assessment.grad001.chikanimashaba.envirowaste.model.WasteCategory;
import com.enviro.assessment.grad001.chikanimashaba.envirowaste.repository.WasteCategoryRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WasteCategoryService {

    @Autowired
    private WasteCategoryRepository wasteCategoryRepository;

    // Retrieve all waste categories
    public List<WasteCategory> getAllWasteCategories() {
        return (List<WasteCategory>)wasteCategoryRepository.findAll();
    }

    // Retrieve waste category by ID
    public Optional<WasteCategory> getWasteCategoryById(Integer id) {
        return wasteCategoryRepository.findById(id);
    }

    // Save a new waste category
    public WasteCategory saveWasteCategory(WasteCategory wasteCategory) {
        return wasteCategoryRepository.save(wasteCategory);
    }

    // Update an existing waste category by ID
    public WasteCategory updateCategory(Integer id, WasteCategory newCategory) {
        Optional<WasteCategory> oldCategory = wasteCategoryRepository.findById(id);

        if(oldCategory.isPresent()) {
            WasteCategory updatedCategory = oldCategory.get();
            updatedCategory.setName(newCategory.getName());
            updatedCategory.setDescription(newCategory.getDescription());
            updatedCategory.setDisposalGuideline(newCategory.getDisposalGuideline());
            updatedCategory.setRecyclingTip(newCategory.getRecyclingTip());

            return wasteCategoryRepository.save(updatedCategory);
        } else {
            return null;
        }
    }

    // Delete a waste category by ID
    public void deleteWasteCategory(Integer id) {
        wasteCategoryRepository.deleteById(id);
    }
} 
