package com.lysenko.airlines.demo;


import com.lysenko.airlines.model.dao.AirplaneDaoImpl;
import com.lysenko.airlines.model.entity.Airplane;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Demo {

    public static void main(String[] args) {
        AirplaneDaoImpl airplaneDao = new AirplaneDaoImpl();
        airplaneDao.addNewAirplane(createAirplane("123", "airplane", "U124",
                LocalDate.of(2002, 3, 10), 270, 17345.45, 5));
        List<Airplane> airplanes = airplaneDao.findAllAirplanes();
        for (Airplane a: airplanes) {
            System.out.println(Arrays.toString(airplanes.toArray()));
        }

        System.out.println(airplaneDao.findAirplaneByCode("123"));

        airplaneDao.deleteAirplaneByParameter("125","airplane1");

        System.out.println("----------------------");
        List<Airplane> crew3 = airplaneDao.searchAirplanesByCrewName("crew5");
        for (Airplane a:crew3) {
            System.out.println(a);
        }

        airplaneDao.updateAirplaneWithProvidedCrew(2,"126", "airplane");
    }


    private static Airplane createAirplane(String code, String name, String model, LocalDate manufactureDate,
                                           int capacity, double flightRange, int crew) {
        Airplane airplane = new Airplane.AirplaneBuilder()
                .withCode(code)
                .withName(name)
                .withModel(model)
                .withManufactureDate(manufactureDate)
                .withCapacity(capacity)
                .withFlightRange(flightRange)
                .withCrew(crew)
                .build();
        return airplane;
    }
}



