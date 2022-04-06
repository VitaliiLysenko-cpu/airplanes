package com.lysenko.airlines.model.dao;

import com.lysenko.airlines.model.ConnectionPool;
import com.lysenko.airlines.model.entity.Airplane;
import com.lysenko.airlines.model.entity.Crew;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AirplaneDaoImpl implements AirplaneDao {

    private static final String CREATE_NEW_AIRPLANE = "INSERT INTO airplane (code, name, model, manufactureDate," +
            " capacity, flightRange, crew_id)VALUES (?,?,?,?,?,?,?)";
    private static final String FIND_AIRPLANE_BY_CODE = "SELECT * FROM airplane WHERE code = ?";
    private static final String FIND_ALL_AIRPLANES = "SELECT  * FROM airplane";
    private Airplane airplane;
    private List<Airplane> listAirplanes;

    public boolean addNewAirplane(Airplane newAirplane) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_NEW_AIRPLANE)) {
            preparedStatement.setString(1, newAirplane.getCode());
            preparedStatement.setString(2, newAirplane.getName());
            preparedStatement.setString(3, newAirplane.getModel());
            preparedStatement.setDate(4, Date.valueOf(newAirplane.getManufactureDate()));
            preparedStatement.setInt(5, newAirplane.getCapacity());
            preparedStatement.setDouble(6, newAirplane.getFlightRange());
            preparedStatement.setInt(7, newAirplane.getCrew());
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public Airplane findAirplaneByCode(String code) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_AIRPLANE_BY_CODE)) {
            preparedStatement.setString(1, code);
            return getAirplane(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return airplane;
    }

    private Airplane getAirplane(PreparedStatement preparedStatement) throws SQLException {
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            airplane = new Airplane(

                    rs.getString("code"),
                    rs.getString("name"),
                    rs.getString("model"),
                    rs.getDate("manufactureDate").toLocalDate(),
                    rs.getInt("capacity"),
                    rs.getDouble("flightRange"),
                    rs.getInt("crew_id")
            );
        }
        return airplane;
    }

    public List<Airplane> findAllAirplanes() {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_AIRPLANES)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            listAirplanes = new ArrayList<>();
            while (resultSet.next()) {
                airplane = getAirplane(preparedStatement);
                listAirplanes.add(airplane);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listAirplanes;
    }

    public boolean deleteAirplaneByParameter(String parameter) {
        //todo
        return true;
    }

    private boolean deleteAirplaneByCode(String parameter) {
        //todo

        return true;
    }

    private boolean deleteAirplaneByName(String parameter) {
        //todo
        return true;
    }

    private boolean deleteAirplaneById(int parameter) {
        //todo
        return true;
    }

    public Airplane searchAirplanesByCrewName(String name) {
        //todo
        return airplane;
    }

    public boolean updateAirplaneWithProvidedCrew(Crew crew) {
        //todo
        return true;
    }

}
