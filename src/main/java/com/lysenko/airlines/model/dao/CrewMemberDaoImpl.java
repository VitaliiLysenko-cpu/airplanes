package com.lysenko.airlines.model.dao;

import com.lysenko.airlines.model.entity.Crew;
import com.lysenko.airlines.model.entity.CrewMember;

import java.util.List;

public class CrewMemberDaoImpl implements CrewMemberDao {
    private Crew crew;
    private CrewMember crewMember;
    private List<CrewMember> crewMemberList;
    private List<Crew> crewListId;

    public boolean addNewCrewMemberToSpecificCrew(CrewMember crewMember, Crew crew) {
        //todo
        return true;
    }

    public List<CrewMember> getListOfCrewMembersByCrewId(int id) {
        //todo
        return crewMemberList;
    }

    public List<CrewMember> getListOfCrewMembersByCrewName(String name) {
        //todo
        return crewMemberList;
    }

    public List<Crew> linkCrewMemberToSomeCrewByTheirId(int crewMemberId) {
        //todo
        return crewListId;
    }
}
