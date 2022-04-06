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
        for (int i = 0; i < airplanes.size(); i++) {
            System.out.println(Arrays.toString(airplanes.toArray()));
        }

        System.out.println(airplaneDao.findAirplaneByCode("123"));
    }

    private static Airplane createAirplane(String code, String name, String model, LocalDate manufactureDate,
                                           int capacity, double flightRange, int crew) {
        Airplane airplane = new Airplane(code, name, model, manufactureDate, capacity, flightRange, crew);
        return airplane;
    }
}



