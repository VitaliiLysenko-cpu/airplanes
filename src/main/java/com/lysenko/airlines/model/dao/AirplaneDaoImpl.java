package com.lysenko.airlines.model.dao;

import com.lysenko.airlines.model.ConnectionPool;
import com.lysenko.airlines.model.entity.Airplane;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.lysenko.airlines.model.conctant.ConstantsForAirplaneDAO.*;

public class AirplaneDaoImpl implements AirplaneDao {

    public void addNewAirplane(Airplane newAirplane) {
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
    }

    public Airplane findAirplaneByCode(String code) {

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_AIRPLANE_BY_CODE)) {
            preparedStatement.setString(1, code);
            return getAirplane(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Airplane getAirplane(PreparedStatement preparedStatement) throws SQLException {
        Airplane airplane = null;
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            airplane = new Airplane.AirplaneBuilder()
                    .withCode(rs.getString("code"))
                    .withName(rs.getString("name"))
                    .withModel(rs.getString("model"))
                    .withManufactureDate(rs.getDate("manufactureDate").toLocalDate())
                    .withCapacity(rs.getInt("capacity"))
                    .withFlightRange(rs.getDouble("flightRange"))
                    .withCrew(rs.getInt("crew_id"))
                    .build();
        }
        return airplane;
    }

    public List<Airplane> findAllAirplanes() {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_AIRPLANES)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            return  getAirplaneList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    private List<Airplane> getAirplaneList(  ResultSet rs) throws SQLException {
        List<Airplane> listAirplanes = new ArrayList<>();
        while (rs.next()) {
            Airplane airplane = new Airplane.AirplaneBuilder()
                    .withCode(rs.getString("code"))
                    .withName(rs.getString("name"))
                    .withModel(rs.getString("model"))
                    .withManufactureDate(rs.getDate("manufactureDate").toLocalDate())
                    .withCapacity(rs.getInt("capacity"))
                    .withFlightRange(rs.getDouble("flightRange"))
                    .withCrew(rs.getInt("crew_id"))
                    .build();
            listAirplanes.add(airplane);
        }
        return listAirplanes;
    }

    public void deleteAirplaneByParameter(String code, String name) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_AIRPLANE_BY_CODE_AND_NAME)) {
            preparedStatement.setString(1, code);
            preparedStatement.setString(2, name);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Airplane> searchAirplanesByCrewName(String name) {
        Airplane airplane;
        List<Airplane> listAirplanes = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_AIRPLANES_BY_CREW_NAME)) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            return  getAirplaneList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public void updateAirplaneWithProvidedCrew(int crewId, String code, String name) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_AIRPLANE_BY_CODE_AND_NAME)) {
            preparedStatement.setInt(1, crewId);
            preparedStatement.setString(2, code);
            preparedStatement.setString(3, name);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
