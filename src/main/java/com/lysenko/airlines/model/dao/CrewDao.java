package com.lysenko.airlines.model.dao;

import com.lysenko.airlines.model.entity.Crew;

public interface CrewDao {

    boolean addNewCrewMember(Crew crew);

    boolean updateCrewMember(Crew crew);

    Crew findCrewMemberById(int parameter);
}
