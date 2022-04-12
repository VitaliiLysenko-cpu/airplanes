package com.lysenko.airlines.model.conctant;

public class ConstantsForAirplaneDAO {
    public static final String CREATE_NEW_AIRPLANE = "INSERT INTO airplane (code, name, model, manufactureDate," +
            " capacity, flightRange, crew_id)VALUES (?,?,?,?,?,?,?)";
    public static final String FIND_AIRPLANE_BY_CODE = "SELECT * FROM airplane WHERE code=?";
    public static final String FIND_ALL_AIRPLANES = "SELECT  * FROM airplane";
    public static final String DELETE_AIRPLANE_BY_CODE_AND_NAME = "DELETE FROM airplane WHERE code=? and name=?";
    public static final String FIND_AIRPLANES_BY_CREW_NAME = "SELECT * FROM airplane\n" +
            "WHERE crew_id = (select id from crew WHERE crew.name = ?);";
    public static final String UPDATE_AIRPLANE_BY_CODE_AND_NAME =" UPDATE airplane\n" +
            "SET crew_id = ? WHERE code = ? and name = ?";

}
