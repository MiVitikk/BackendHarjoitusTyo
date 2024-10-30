package harjoitustyo.harjoitustyo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@DiscriminatorValue("Goalie")
public class Goalie extends TeamMember{

    

    private int saves, wins, losses;
    @Column(name="saveprc")
    private int savePrc;

    public Goalie(@NotNull @Size(min = 1, max = 30) String firstName, @NotNull @Size(min = 1, max = 30) String lastName,
            @NotNull int jerseyNumber, Team team, int saves, int savePrc, int wins,
            int losses) {
        super(firstName, lastName, jerseyNumber, team);
        this.saves = saves;
        this.savePrc = savePrc;
        this.wins = wins;
        this.losses = losses;
    }

    

    public Goalie(Long memberid, @NotNull @Size(min = 1, max = 30) String firstName,
            @NotNull @Size(min = 1, max = 30) String lastName, @NotNull int jerseyNumber, Team team,
            int saves, int savePrc, int wins, int losses) {
        super(memberid, firstName, lastName, jerseyNumber, team);
        this.saves = saves;
        this.savePrc = savePrc;
        this.wins = wins;
        this.losses = losses;
    }



    public Goalie(){
        
    }

    public Goalie(int saves, int savePrc, int wins, int losses) {
        this.saves = saves;
        this.savePrc = savePrc;
        this.wins = wins;
        this.losses = losses;
    }

    public int getSaves() {
        return saves;
    }

    public void setSaves(int saves) {
        this.saves = saves;
    }

    public int getSavePrc() {
        return savePrc;
    }

    public void setSavePrc(int savePrc) {
        this.savePrc = savePrc;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    @Override
    public String toString() {
        return "Goalie [saves=" + saves + ", savePrc=" + savePrc + ", wins=" + wins + ", losses=" + losses + "]";
    }
    
}
