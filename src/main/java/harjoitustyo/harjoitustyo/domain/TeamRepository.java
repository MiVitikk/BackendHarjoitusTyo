package harjoitustyo.harjoitustyo.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository <Team, Long>{
    List<Team> findByTeamName(String teamName);
    
}
