package harjoitustyo.harjoitustyo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table(name="teammember")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "membertype", discriminatorType = DiscriminatorType.STRING)
public class TeamMember {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberid;

    @NotNull
    @Size(min=1, max=30)
    @Column(name="firstname")
    private String firstName; 
    @NotNull
    @Size(min=1, max=30)
    @Column(name="lastname")
    private String lastName;

    @NotNull
    @Column(name="jerseynumber")
    private int jerseyNumber;

    @ManyToOne
    @JoinColumn(name = "teamid")
    private Team team;

    

    public TeamMember(Long memberid, @NotNull @Size(min = 1, max = 30) String firstName,
            @NotNull @Size(min = 1, max = 30) String lastName, @NotNull int jerseyNumber, Team team) {
        this.memberid = memberid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.jerseyNumber = jerseyNumber;
        this.team = team;
    }

    public TeamMember(@NotNull @Size(min = 1, max = 30) String firstName,
            @NotNull @Size(min = 1, max = 30) String lastName, @NotNull int jerseyNumber, Team team) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.jerseyNumber = jerseyNumber;
        this.team = team;
    }

    public TeamMember() {
    }

    public Long getMemberid() {
        return memberid;
    }

    public void setMemberid(Long memberid) {
        this.memberid = memberid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "TeamMember [memberid=" + memberid + ", firstName=" + firstName + ", lastName=" + lastName
                + ", jerseyNumber=" + jerseyNumber + ", team=" + team + "]";
    }
 }

    