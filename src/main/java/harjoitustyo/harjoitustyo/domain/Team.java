package harjoitustyo.harjoitustyo.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name="team")
public class Team {

    
    

    
    

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="teamid")
    private Long teamId;

    @Column(name="teamname")
    private String teamName;

    @Column(name="teamwins")
    private int teamWins;
    
    @Column(name="teamlosses") 
    private int teamLosses;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "team")
    @JsonIgnore
    private List<TeamMember> teamMembers;
    
    public Team(String teamName, int teamWins, int teamLosses) {
        this.teamName = teamName;
        this.teamWins = teamWins;
        this.teamLosses = teamLosses;
    }
    public Team() {
    }
    public Team(Long teamId, String teamName, int teamWins, int teamLosses) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.teamWins = teamWins;
        this.teamLosses = teamLosses;
    }
    public Team(String teamName, int teamWins, int teamLosses, List<TeamMember> teamMembers) {
        this.teamName = teamName;
        this.teamWins = teamWins;
        this.teamLosses = teamLosses;
        this.teamMembers = teamMembers;
    }


    
    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getTeamWins() {
        return teamWins;
    }

    public void setTeamWins(int teamWins) {
        this.teamWins = teamWins;
    }

    public int getTeamLosses() {
        return teamLosses;
    }

    public void setTeamLosses(int teamLosses) {
        this.teamLosses = teamLosses;
    }

    @Override
    public String toString() {
        return "Team [teamId=" + teamId + ", teamName=" + teamName + ", teamWins=" + teamWins + ", TeamLosses="
                + teamLosses + "]";
    }

}
