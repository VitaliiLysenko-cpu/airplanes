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

    private Airplane(AirplaneBuilder airplaneBuilder) {
        this.code = airplaneBuilder.code;
        this.name = airplaneBuilder.name;
        this.model = airplaneBuilder.model;
        this.manufactureDate = airplaneBuilder.manufactureDate;
        this.capacity = airplaneBuilder.capacity;
        this.flightRange = airplaneBuilder.flightRange;
        this.crew = airplaneBuilder.crew;
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
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", manufactureDate=" + manufactureDate +
                ", capacity=" + capacity +
                ", flightRange=" + flightRange +
                ", crew=" + crew +
                '}';
    }

    public static class AirplaneBuilder {
        private String code;
        private String name;
        private String model;
        private LocalDate manufactureDate;
        private int capacity;
        private double flightRange;
        private int crew;

        public AirplaneBuilder withCode(String code) {
            this.code = code;
            return this;
        }

        public AirplaneBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public AirplaneBuilder withModel(String model) {
            this.model = model;
            return this;
        }

        public AirplaneBuilder withManufactureDate(LocalDate manufactureDate) {
            this.manufactureDate = manufactureDate;
            return this;
        }

        public AirplaneBuilder withCapacity(int capacity) {
            this.capacity = capacity;
            return this;
        }

        public AirplaneBuilder withFlightRange(double flightRange) {
            this.flightRange = flightRange;
            return this;
        }

        public AirplaneBuilder withCrew(int crew) {
            this.crew = crew;
            return this;
        }

        public Airplane build() {
            return new Airplane(this);
        }
    }
}
