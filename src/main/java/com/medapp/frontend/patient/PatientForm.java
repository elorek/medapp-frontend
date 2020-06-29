package com.medapp.frontend.patient;

import com.medapp.frontend.patient.domain.Patient;
import com.medapp.frontend.patient.service.PatientService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;

@Route("newPatient")
public class PatientForm extends FormLayout {
    private TextField name = new TextField("name");
    private TextField last_name = new TextField("last_name");
    private TextField pesel = new TextField("pesel");
    private TextField adress = new TextField("adress");
    private Button addNewPatient = new Button("add new patient");
    private Button delete = new Button("delete");
    private Binder<Patient> binder = new Binder<>(Patient.class);
    private PatientService patientService = PatientService.getInstance();
    private PatientView patientView = new PatientView();


    public PatientForm() {
        HorizontalLayout buttons = new HorizontalLayout(addNewPatient, delete);
        addNewPatient.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        add(name, last_name, pesel, adress, buttons);
        binder.bindInstanceFields(this);
        addNewPatient.addClickListener(event -> addNewPatient());
        delete.addClickListener(event -> delete());
    }

    private void addNewPatient() {
        Patient patient = binder.getBean();
        patientService.addPatient(patient);
        patientView.refresh();
        setPatient(null);
    }

    private void delete() {
        Patient patient = binder.getBean();
        patientService.delete(patient);
        patientView.refresh();
        setPatient(null);
    }

    public void setPatient(Patient patient) {
        binder.setBean(patient);
        if (patient == null) {
            setVisible(false);
        } else {
            setVisible(true);
        }
    }
}
