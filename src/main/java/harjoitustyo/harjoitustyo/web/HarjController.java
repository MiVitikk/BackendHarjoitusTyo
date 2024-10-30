package harjoitustyo.harjoitustyo.web;

import org.apache.el.stream.Optional;
import org.hibernate.mapping.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import harjoitustyo.harjoitustyo.HarjoitustyoApplication;
import jakarta.validation.Valid;
import harjoitustyo.harjoitustyo.domain.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;;

@Controller
public class HarjController {
    private static final Logger log = LoggerFactory.getLogger(HarjoitustyoApplication.class);
    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private GoalieRepository goalieRepository;

    @Autowired
    private TeamMemberRepository tmRepository;

    @RequestMapping(value="/login")
    public String login(){
        return "login";
    }

    @GetMapping("/index")
    public String mainPage() {
        return "index";
    }

    @GetMapping("/teamList")
    public String showTeams(Model model) {
        model.addAttribute("teams", teamRepository.findAll());
        return "teamList";
    }

    @GetMapping("/teamMembersByTeam/{id}")
    public String showTeamMembersByTeam(@PathVariable("id") Long teamId, Model model){
        Team team = teamRepository.findById(teamId).orElse(null);
        model.addAttribute("players", playerRepository.findByTeam(team));
        model.addAttribute("goalies", goalieRepository.findByTeam(team));
        model.addAttribute("team", team);
        
        return "teamMembersByTeam";
    }

    @GetMapping("/teamMemberList")
    public String showTeamMembers(Model model) {
        log.info("Fetching all team members...");
        log.info("Players: " + playerRepository.findAll().toString());
        log.info("Goalies: " + goalieRepository.findAll().toString());
        log.info("Teams: " + teamRepository.findAll().toString());
        model.addAttribute("teamMembers", tmRepository.findAll());
        model.addAttribute("players", playerRepository.findAll());
        model.addAttribute("goalies", goalieRepository.findAll());
        model.addAttribute("teams", teamRepository.findAll());
        return "teamMemberList";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/newPlayer")
    public String addPlayer(Model model){
        model.addAttribute("player", new Player());
        model.addAttribute("teams", teamRepository.findAll());
        return "newPlayer";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/newGoalie")
    public String addGoalie(Model model){
        model.addAttribute("goalie", new Goalie());
        model.addAttribute("teams", teamRepository.findAll());
        return "newGoalie";
    }

    @PostMapping("/savePlayer")
    public String savePlayer(@Valid @ModelAttribute("player") Player player, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "newPlayer";
        }
        playerRepository.save(player);
        return "redirect:/teamMemberList";
    }

    @PostMapping("/saveGoalie")
    public String saveGoalie(@Valid @ModelAttribute("goalie") Goalie goalie, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "newGoalie";
        }
        goalieRepository.save(goalie);
        return "redirect:/teamMemberList";
    }
    //Tarkasta pisteet/maalit yms editoidessa
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("editPlayer/{id}")
    public String editPlayer(@PathVariable("id") Long memberid, Model model){
        model.addAttribute("editPlayer", playerRepository.findById(memberid));
        model.addAttribute("teams", teamRepository.findAll());
        return "editPlayer";
    }
    //Tarkasta tilastot editoidessa
    @GetMapping("editGoalie/{id}")
    public String editgoalie(@PathVariable("id") Long memberid, Model model){
        model.addAttribute("editGoalie", goalieRepository.findById(memberid));
        model.addAttribute("teams", teamRepository.findAll());
        return "editGoalie";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("delete/{id}")
    public String deleteTeamMember(@PathVariable("id") Long memberId){
        tmRepository.deleteById(memberId);
        return "redirect:/teamMemberList";
    }
}
