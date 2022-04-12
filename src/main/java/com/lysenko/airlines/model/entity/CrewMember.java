package com.lysenko.airlines.model.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class CrewMember {
    private final int id;
    private final String firstName;
    private final String lastName;
    private final Position position;
    private final LocalDate birthday;
    private final Citizenship citizenship;

    public CrewMember(CrewMemberBuilder crewMemberBuilder) {
        this.id = crewMemberBuilder.id;
        this.firstName = crewMemberBuilder.lastName;
        this.lastName = crewMemberBuilder.lastName;
        this.position = crewMemberBuilder.position;
        this.birthday = crewMemberBuilder.birthday;
        this.citizenship = crewMemberBuilder.citizenship;
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
    public static class CrewMemberBuilder {
        private  int id;
        private  String firstName;
        private  String lastName;
        private  Position position;
        private  LocalDate birthday;
        private  Citizenship citizenship;

        public CrewMemberBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public CrewMemberBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public CrewMemberBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        public CrewMemberBuilder withPosition(Position position) {
            this.position = position;
            return this;
        }
        public CrewMemberBuilder withBirthday(LocalDate birthday) {
            this.birthday = birthday;
            return this;
        }
        public CrewMemberBuilder withCitizenship(Citizenship citizenship) {
            this.citizenship = citizenship;
            return this;
        }

        public CrewMember build() {
            return new CrewMember(this);
        }
    }
}
