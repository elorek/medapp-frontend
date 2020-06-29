package com.medapp.frontend.patient;

import com.medapp.frontend.patient.domain.Patient;
import com.medapp.frontend.patient.service.PatientService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

@Route("patients")
public class PatientView extends VerticalLayout {
    private PatientService patientService = PatientService.getInstance();
    private Grid grid = new Grid<>(Patient.class);
    private TextField filter = new TextField();

    public PatientView() {
        filter.setPlaceholder("Filter by last_name");
        filter.setClearButtonVisible(true);
        filter.setValueChangeMode(ValueChangeMode.EAGER);
        filter.addValueChangeListener(e -> update());
        grid.setColumns("id", "name", "last_name", "pesel", "adress");

        add(filter, grid);
        setSizeFull();
    }

    public void refresh() {
        grid.setItems(patientService.getPatients());
    }

    private void update() {
        grid.setItems(patientService.findByLastname(filter.getValue()));
    }
}
