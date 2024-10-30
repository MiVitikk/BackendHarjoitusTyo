package harjoitustyo.harjoitustyo.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TeamMemberRepository extends CrudRepository<TeamMember, Long>{
    List<TeamMember> findByLastName(String lastName);
    List<TeamMember> findByTeam(Team team);

    
}