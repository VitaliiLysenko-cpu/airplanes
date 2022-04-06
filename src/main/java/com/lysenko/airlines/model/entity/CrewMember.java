package com.lysenko.airlines.model.entity;

import java.time.LocalDate;
import java.util.Objects;

public class CrewMember {
    private final int id;
    private final String firstName;
    private final String lastName;
    private final Position position;
    private final LocalDate birthday;
    private final Citizenship citizenship;

    public CrewMember(int id, String firstName, String lastName, Position position, LocalDate birthday, Citizenship citizenship) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.birthday = birthday;
        this.citizenship = citizenship;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Position getPosition() {
        return position;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Citizenship getCitizenship() {
        return citizenship;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CrewMember)) return false;
        CrewMember that = (CrewMember) o;
        return getId() == that.getId() && getFirstName().equals(that.getFirstName()) && getLastName().equals(that.getLastName()) && getPosition() == that.getPosition() && getBirthday().equals(that.getBirthday()) && getCitizenship() == that.getCitizenship();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getPosition(), getBirthday(), getCitizenship());
    }

    @Override
    public String toString() {
        return "CrewMember{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position=" + position +
                ", birthday=" + birthday +
                ", citizenship=" + citizenship +
                '}';
    }
}
