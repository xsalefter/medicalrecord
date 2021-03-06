/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medicalrecord.web;

import com.medicalrecord.model.Medicine;
import com.medicalrecord.service.MedicineService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Retna P
 */
@RequestScoped
@Named
public class MedicineFaces {
    @EJB
    private MedicineService medicineService;
    
    private Medicine medicine;
       
    @PostConstruct
    public void postConstruct() {
        if (this.medicine == null) this.medicine = new Medicine();
    }
    
    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }
    
    public void addMedicine(){
        medicineService.save(medicine);
        medicine = new Medicine();
    }
    
    public void deleteMedicine(Medicine medicine){
        this.medicineService.delete(medicine);
    }
    
    public List<Medicine> getFindAll(){
        return medicineService.findAll();
    }
    
    public void editMedicine(Medicine medicine) {
        this.medicine = medicine;
    }
}
