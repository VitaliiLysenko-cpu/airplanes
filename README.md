# airplanes

# Task

### Implement a persistence layer using JDBC API for an Airlines application.

## Key points:
###•*create project and add appropriate dependencies*
###•*create next entities:*
#####`Airplane(id, code, name, model, manufacture date, capacity, flight range, crew)`
#####`Crew(id, name, List<CrewMember> crewMembers)`
#####`CrewMember(id, first name, last name, position, birthday,citizenship)`
###•*provide one-to-many relation between*
#####`Airplane and Crew: One Crew could be assigned to many Airplanes`
###•*provide many-to-many relation between*
####Crew and CrewMember: 
#####`One Crew could have many Crew members, and one Crew member could be assigned to different Crews.`
###•*use PostgreSQL or MySQL*
###•*project should consist of SQL script, that creates all required database tables*
###•*create AirplaneDao and implement methods that could:*
#####`-save new airplane`
#####`-find airplane by code`
#####`-find all airplanes`
#####`-delete airplane`
#####`-search airplanes by crew name`
#####`-update airplane with provided crew`
###•*create CrewMemberDao and implement methods that could:*
#####`-save new crew member`
#####`-update crew member`
#####`-find crew member by id`
###•*create CrewDao and implement methods that could:*
#####`-add new crew member to specific crew`
#####`-get list of crew members by crew id`
#####`-get list of crew members by crew name`
#####`-link crew member to some crew by their id`
###•*project should be pushed to GitHub*
###•*cover code with unit tests*
