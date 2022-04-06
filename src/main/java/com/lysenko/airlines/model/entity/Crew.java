package com.lysenko.airlines.model.entity;

import java.util.List;
import java.util.Objects;

public class Crew {
    private final int id;
    private final String name;
    private final List<CrewMember> crewMembers;

    public Crew(int id, String name, List<CrewMember> crewMembers) {
        this.id = id;
        this.name = name;
        this.crewMembers = crewMembers;
    }

    public List<CrewMember> getCrewMembers() {
        return crewMembers;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Crew)) return false;
        Crew crew = (Crew) o;
        return getId() == crew.getId() && getName().equals(crew.getName()) && Objects.equals(getCrewMembers(), crew.getCrewMembers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCrewMembers());
    }

    @Override
    public String toString() {
        return "Crew{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", crewMembers=" + crewMembers +
                '}';
    }
}
