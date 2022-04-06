package com.lysenko.airlines.model.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Airplane {
    private final String code;
    private final String name;
    private final String model;
    private final LocalDate manufactureDate;
    private final int capacity;
    private final double flightRange;
    private final int crew;
    private int id;

    public Airplane(String code, String name, String model, LocalDate manufactureDate,
                    int capacity, double flightRange, int crew) {
        this.code = code;
        this.name = name;
        this.model = model;
        this.manufactureDate = manufactureDate;
        this.capacity = capacity;
        this.flightRange = flightRange;
        this.crew = crew;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getFlightRange() {
        return flightRange;
    }

    public int getCrew() {
        return crew;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Airplane)) return false;
        Airplane airplane = (Airplane) o;
        return getCapacity() == airplane.getCapacity() && Double.compare(airplane.getFlightRange(),
                getFlightRange()) == 0 && getCrew() == airplane.getCrew() && getCode().equals(airplane.getCode()) &&
                getName().equals(airplane.getName()) && getModel().equals(airplane.getModel()) &&
                getManufactureDate().equals(airplane.getManufactureDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode(), getName(), getModel(), getManufactureDate(), getCapacity(), getFlightRange(),
                getCrew());
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", manufactureDate=" + manufactureDate +
                ", capacity=" + capacity +
                ", flightRange=" + flightRange +
                ", crew=" + crew +
                '}';
    }
}
