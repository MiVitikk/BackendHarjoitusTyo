package harjoitustyo.harjoitustyo.domain;

import jakarta.persistence.*;

import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("Player")
public class Player extends TeamMember{


    
    private int goals, assists, points;
    

    public Player(Long memberid, @NotNull @Size(min = 1, max = 30) String firstName,
            @NotNull @Size(min = 1, max = 30) String lastName, @NotNull int jerseyNumber, Team team, int goals,
            int assists, int points) {
        super(memberid, firstName, lastName, jerseyNumber, team);
        this.goals = goals;
        this.assists = assists;
        this.points = points;
    }

    

    public Player(String firstName, String lastName, int jerseyNumber, Team team, int goals, int assists, int points) {
        super(firstName, lastName, jerseyNumber, team); 
        this.goals = goals;
        this.assists = assists;
        this.points = points;
        
    }
    public Player(){
        
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Player [goals=" + goals + ", assists=" + assists + ", points=" + points + "]";
    }
}
