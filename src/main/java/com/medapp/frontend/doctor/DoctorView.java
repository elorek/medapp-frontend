package com.medapp.frontend.doctor;

import com.medapp.frontend.doctor.domain.Doctor;
import com.medapp.frontend.doctor.service.DoctorService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

@Route("doctors")
public class DoctorView extends VerticalLayout {
    private DoctorService doctorService = DoctorService.getInstance();
    private Grid<Doctor> grid = new Grid<>(Doctor.class);
    private TextField filter = new TextField();
    private Button makeAnAppointment = new Button("Make an appointment");

    public DoctorView() {
        filter.setPlaceholder("Filter by specialization");
        filter.setClearButtonVisible(true);
        filter.setValueChangeMode(ValueChangeMode.EAGER);
        filter.addValueChangeListener(e -> update());
        grid.setColumns("id", "name", "last_name", "specialization");
    }

    public void refresh() {
        grid.setItems(doctorService.getDoctors());
    }

    private void update() {
        grid.setItems(doctorService.findBySpecialization(filter.getValue()));
    }
}
