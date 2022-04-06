package com.lysenko.airlines.model.dao;

import com.lysenko.airlines.model.entity.Crew;
import com.lysenko.airlines.model.entity.CrewMember;

import java.util.List;

public interface CrewMemberDao {
    boolean addNewCrewMemberToSpecificCrew(CrewMember crewMember, Crew crew);

    List<CrewMember> getListOfCrewMembersByCrewId(int id);

    List<CrewMember> getListOfCrewMembersByCrewName(String name);

    List<Crew> linkCrewMemberToSomeCrewByTheirId(int crewMemberId);
}
