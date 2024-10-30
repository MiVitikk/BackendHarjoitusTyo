package harjoitustyo.harjoitustyo.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlayerRepository extends CrudRepository<Player, Long>{
    List<Player> findByLastName(String lastName);
    List<Player> findByTeam(Team team);
    
    
}
