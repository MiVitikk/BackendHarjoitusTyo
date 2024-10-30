package harjoitustyo.harjoitustyo.web;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import harjoitustyo.harjoitustyo.domain.*;

@RestController
public class RestHarjController {
    private static final Logger log = LoggerFactory.getLogger(RestHarjController.class);

    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    TeamRepository teamRepository;
    @Autowired
    GoalieRepository goalieRepository;
    @Autowired
    TeamMemberRepository tmRepository;

    // Muista lisätä joukkueet!

    @GetMapping("/players")
    public Iterable<Player> getPlayers(){
        return playerRepository.findAll();
    }

    @GetMapping("/goalies")
    public Iterable<Goalie> getGoalies(){
        return goalieRepository.findAll();
    }

    @GetMapping("/teams")
    public Iterable<Team> getTeams(){
        return teamRepository.findAll();
    }

    @GetMapping("/player/{id}")
    public Optional<Player> getOnePlayer(@PathVariable("id") Long memberid){
        return playerRepository.findById(memberid);
    }

    @GetMapping("/goalie/{id}")
    public Optional<Goalie> getOneGoalie(@PathVariable("id") Long memberid){
        return goalieRepository.findById(memberid);
    }

    @GetMapping("/team/{id}")
    public Optional<Team> getOneTeam(@PathVariable("id") Long teamId){
        return teamRepository.findById(teamId);
    }

    @PostMapping("/player")
    Player newPlayer(@RequestBody Player newPlayer){
        return playerRepository.save(newPlayer);
    }

    @PostMapping("/goalie")
    Goalie newGoalie(@RequestBody Goalie newGoalie){
        return goalieRepository.save(newGoalie);
    }

    @PostMapping("/team")
    Team newTeam(@RequestBody Team newTeam){
        return teamRepository.save(newTeam);
    }

    @PutMapping("/player/{id}")
    Player editPlayer(@RequestBody Player editedPlayer, @PathVariable Long memberid){
        editedPlayer.setMemberid(memberid);
        return playerRepository.save(editedPlayer);
    }

    @PutMapping("/goalie/{id}")
    Goalie editGoalie(@RequestBody Goalie editedGoalie, @PathVariable Long memberid){
        editedGoalie.setMemberid(memberid);
        return goalieRepository.save(editedGoalie);
    }
    @PutMapping("/team/{id}")
    Team editTeam(@RequestBody Team editedTeam, @PathVariable Long teamId){
        editedTeam.setTeamId(teamId);
        return teamRepository.save(editedTeam);
    }

    @DeleteMapping("/teammembers/{id}")
    public Iterable<TeamMember> deleteTeamMember(@PathVariable Long memberid){
        tmRepository.deleteById(memberid);
        return tmRepository.findAll();
    }

    @DeleteMapping("/teams/{id}")
    public Iterable<Team> deleteTeam(@PathVariable Long teamId){
        teamRepository.deleteById(teamId);
        return teamRepository.findAll();
    }
}
