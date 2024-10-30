package harjoitustyo.harjoitustyo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import harjoitustyo.harjoitustyo.domain.*;

@SpringBootApplication
public class HarjoitustyoApplication {
	private static final Logger log = LoggerFactory.getLogger(HarjoitustyoApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(HarjoitustyoApplication.class, args);
	}

/* 	@Bean
	public CommandLineRunner teamData(PlayerRepository playerRepository, GoalieRepository goalieRepository ,TeamRepository teamRepository, TeamMemberRepository tmRepository, AppUserRepository userRepository){
		return (args) -> {
			AppUser user1 = new AppUser("user" , "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			AppUser user2 = new AppUser("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			userRepository.save(user1);
			userRepository.save(user2);


			Team team1 = new Team("Mellunmäen Pinkka", 1 ,1);
			Team team2 = new Team("Tuiran Raitis", 1, 1);

			teamRepository.save(team1);
			teamRepository.save(team2);

			TeamMember member1 = new TeamMember("Jonne" , "Janne", 1, team1);
			tmRepository.save(member1);

			Player player1 = new Player("Mikko", "Mikkonen", 70, team1, 3, 0, 3);
			Player player2 = new Player("Matti", "Mattinen", 13, team1, 0, 3, 3);
			Player player3 = new Player("Kalle", "Kallela", 10, team1, 1, 0 ,1);
			Goalie goalie1 = new Goalie("Pekka", "Pekkala", 40, team1, 30, 100, 1, 0);

			Player player4 = new Player("Tommi", "Tomminen", 22, team2, 0, 0, 0);
			Player player5 = new Player("Vilho", "Vilhonen", 98, team2, 0, 0, 0);
			Player player6 = new Player("Juho", "Juhola", 91,	team2, 0 ,0 ,0);
			Goalie goalie2 = new Goalie("Tuukka", "Tuukkanen", 35, team2, 27, 90, 0, 1);

			playerRepository.save(player1);
			playerRepository.save(player2);
			playerRepository.save(player3);
			playerRepository.save(player4);
			playerRepository.save(player5);
			playerRepository.save(player6);

			goalieRepository.save(goalie1);
			goalieRepository.save(goalie2);


		};
	}*/

}
