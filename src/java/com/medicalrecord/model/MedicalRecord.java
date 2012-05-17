package com.medicalrecord.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author retna p
 */
@Entity
public class MedicalRecord implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column (name="medicalrecord_id")
    private int id;
    
    @Column (name="diagnose", nullable=false)
    private String diagnose;
    
    @ManyToOne
    @JoinColumn(name="patient_id", nullable=false)
    private Patient patient;
    
    @ManyToOne
    @JoinColumn(name="doctor_id", nullable=false)
    private Doctor doctor;
    
    
    @OneToMany(mappedBy="medicalrecord")
    private List<MedicineRecord> medicinerecords;

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<MedicineRecord> getMedicinerecords() {
        return medicinerecords;
    }

    public void setMedicinerecords(List<MedicineRecord> medicinerecords) {
        this.medicinerecords = medicinerecords;
    }

}