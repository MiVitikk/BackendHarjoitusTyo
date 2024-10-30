package harjoitustyo.harjoitustyo;

import org.springframework.boot.test.context.SpringBootTest;

import harjoitustyo.harjoitustyo.domain.Player;
import harjoitustyo.harjoitustyo.domain.PlayerRepository;
import harjoitustyo.harjoitustyo.domain.Team;
import harjoitustyo.harjoitustyo.domain.TeamRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import static org.assertj.core.api.Assertions.*;

import java.util.List;


@SpringBootTest(classes = HarjoitustyoApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PlayerRepositoryTests {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;

    

    @Test
    public void findByLastNameShouldReturnPlayer(){
        List<Player> players = playerRepository.findByLastName("Mikkonen");
        //assertThat(players).hasSize(1);
        assertThat(players.get(0).getLastName()).isEqualTo("Mikkonen");
    }

    

    @Test
    public void createNewPlayer(){
        Team testTeam = new Team("testTeamName",0,0);
        teamRepository.save(testTeam);
        Player player = new Player("TestFirstName", "TestLastName", 99, testTeam, 0, 0, 0);
        playerRepository.save(player);
        assertThat(player.getMemberid()).isNotNull();
    }

    @Test
    public void deletePlayer(){
        List<Player> playersDelete = playerRepository.findByLastName("Mikkonen");
        Player player = playersDelete.get(0);
        playerRepository.delete(player);
        List<Player> newPlayers = playerRepository.findByLastName("Mikkonen");
        assertThat(newPlayers).hasSize(0);
        

    }

}
