package harjoitustyo.harjoitustyo.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface GoalieRepository extends CrudRepository<Goalie, Long>{
    List<Goalie> findByLastName(String lastName);
    List<Goalie> findByTeam(Team team);

}
