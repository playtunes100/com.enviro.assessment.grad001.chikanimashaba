package com.enviro.assessment.grad001.chikanimashaba.envirowaste.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.enviro.assessment.grad001.chikanimashaba.envirowaste.model.WasteCategory;
import com.enviro.assessment.grad001.chikanimashaba.envirowaste.service.WasteCategoryService;
import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:8080")

@RequestMapping("/api")
public class WasteCategoryController {

    @Autowired // Injects the WasteCategoryService dependency
    private WasteCategoryService wasteCategoryService;

    // Handles GET requests for all waste categories
    @GetMapping("/wastecategory")
    public ResponseEntity<List<WasteCategory>> getAllWasteCategories() {
        try {
            List<WasteCategory> wasteCategories = wasteCategoryService.getAllWasteCategories();

            if(wasteCategories.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Returns 204 No Content if list is empty
            }

            return new ResponseEntity<>(wasteCategories, HttpStatus.OK); // Returns 200 OK with the list
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Returns 500 Internal Server Error on exception
        }
    }

    // Handles GET requests for waste category by ID
    @GetMapping("/wastecategory/{id}")
    public ResponseEntity<WasteCategory> getWasteCategoryById(@PathVariable("id") Integer id) {
        Optional<WasteCategory> wasteCategories = wasteCategoryService.getWasteCategoryById(id);

        if(wasteCategories.isPresent()) {
            return new ResponseEntity<>(wasteCategories.get(), HttpStatus.OK); // Returns 200 OK with the waste category
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Returns 404 Not Found if waste category not found
        }
    }

    // Handles POST requests to add a new waste category
    @PostMapping("/wastecategory")
    public ResponseEntity<WasteCategory> saveCategory(@Valid @RequestBody WasteCategory wasteCategory) {
        try {
            WasteCategory categoryObj = wasteCategoryService.saveWasteCategory(wasteCategory);
            return new ResponseEntity<>(categoryObj, HttpStatus.CREATED); // Returns 201 Created with the created waste category
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Returns 500 Internal Server Error on exception
        }
    }

    // Handles PUT requests to update an existing waste category by ID
    @PutMapping("/wastecategory/{id}")
    public ResponseEntity<WasteCategory> updateWasteCategoryById(
            @PathVariable("id") Integer id,
            @Valid @RequestBody WasteCategory updatedWasteCategory) {

        try {
            WasteCategory updatedData = wasteCategoryService.updateCategory(id, updatedWasteCategory);

            if (updatedData != null) {
                return new ResponseEntity<>(HttpStatus.OK); // Returns 200 OK if successfully updated
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Returns 404 Not Found if resource not found
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Returns 500 Internal Server Error for other exceptions
        }
    }

    // Handles DELETE requests to remove a waste category by ID
    @DeleteMapping("/wastecategory/{id}")
    public ResponseEntity<HttpStatus> deleteCategoryById(@PathVariable("id") Integer id) {
        try{
            wasteCategoryService.deleteWasteCategory(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Returns 204 No Content after successful deletion
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Returns 500 Internal Server Error on exception
        }
    }
}
