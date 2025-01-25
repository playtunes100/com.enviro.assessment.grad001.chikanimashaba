package com.enviro.assessment.grad001.chikanimashaba.envirowaste.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.enviro.assessment.grad001.chikanimashaba.envirowaste.model.WasteCategory;
import com.enviro.assessment.grad001.chikanimashaba.envirowaste.repository.WasteCategoryRepository;

@Component
public class DataLoader implements CommandLineRunner {

    private final WasteCategoryRepository wasteCategoryRepository;

    public DataLoader(WasteCategoryRepository wasteCategoryRepository){
        this.wasteCategoryRepository = wasteCategoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        WasteCategory eWaste = new WasteCategory( "E-Waste",
        "Unused/discarded electrical equipment or anything with plugs, cords and electronic components" , 
        "Dispose at a certified e-waste recycler that follows environmental guidelines.Electronics repair shops usually accept E-waste.", 
        "Contact a certified e-waste recycling service to arrange for a pick-up or drop-off. Ensure that data is wiped from devices before handover");

        wasteCategoryRepository.save(eWaste);

        WasteCategory bioWaste = new WasteCategory( "Bio Waste",
        "organic waste that can be broken down by microorganisms and other living things. It can include food waste, animal waste, and medical waste" , 
        "Take waste to a permitted location or use a registered waste collection service.", 
        "The waste is treated using methods like anaerobic digestion, aerobic composting, or thermal treatment. The waste is converted into compost, biogas, or other useful materials");
        
        wasteCategoryRepository.save(bioWaste);

        WasteCategory chemWaste = new WasteCategory( "Chemical Waste",
        "any excess, unused, or unwanted chemical." , 
        "Use appropriate containers Use plastic containers if possible and Keep containers closed. Take waste to a permitted location or use a registered waste collection service.", 
        "The waste can be treated by a treatment facility and some recycled, but best practice is to minimize chemical waste");
        
        wasteCategoryRepository.save(chemWaste);
    }
}
