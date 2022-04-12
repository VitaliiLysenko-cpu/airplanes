package com.lysenko.airlines.model.dao;

import com.lysenko.airlines.model.entity.Airplane;

import java.util.List;

public interface AirplaneDao {

    void addNewAirplane(Airplane newAirplane);

    Airplane findAirplaneByCode(String code);

    List<Airplane> findAllAirplanes();

    void deleteAirplaneByParameter(String parameter1, String parameter2);

    List<Airplane> searchAirplanesByCrewName(String name);

    void updateAirplaneWithProvidedCrew(int crewId, String code, String name);
}
