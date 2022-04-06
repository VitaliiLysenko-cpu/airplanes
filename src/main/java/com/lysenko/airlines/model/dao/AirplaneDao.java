package com.lysenko.airlines.model.dao;

import com.lysenko.airlines.model.entity.Airplane;
import com.lysenko.airlines.model.entity.Crew;

import java.util.List;

public interface AirplaneDao {
    boolean addNewAirplane(Airplane newAirplane);

    Airplane findAirplaneByCode(String code);

    List<Airplane> findAllAirplanes();

    boolean deleteAirplaneByParameter(String parameter);

    Airplane searchAirplanesByCrewName(String name);

    boolean updateAirplaneWithProvidedCrew(Crew crew);
}
