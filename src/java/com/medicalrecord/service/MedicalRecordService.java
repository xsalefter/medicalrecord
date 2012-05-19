/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medicalrecord.service;

import com.medicalrecord.model.MedicalRecord;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Retna P
 */
@Stateless
public class MedicalRecordService {
    @PersistenceContext
    private EntityManager entityManager;
    
    public List<MedicalRecord> findAll() {
        return this.entityManager.
                createQuery("from MedicalRecord", MedicalRecord.class).
                getResultList();
    }
    
    public MedicalRecord get(Long id) {
        return this.entityManager.find(MedicalRecord.class, id);
    }
    
    public void save(MedicalRecord toSave) {
        this.entityManager.persist(toSave);
    }
    
    public MedicalRecord merge(MedicalRecord toMerge) {
        return this.entityManager.merge(toMerge);
    }
    
    public void delete(MedicalRecord toDelete) {
        this.entityManager.remove(toDelete);
    }
}
