package th.mfu; 

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import th.mfu.domain.PlayerX; 

@Controller 
public class TictactoeController{
    @Autowired
    private PlayerXRepository repoX;

    public TictactoeController(PlayerXRepository repoX){
        this.repoX = repoX;
    }

    //method for start page 
    @GetMapping("/start-game")
    public String displayStartPage(Model model){
        return "start";
    }
    //method for play page (name entry page)
    @GetMapping("/name-entry")
    public String addNameX(Model model){
        model.addAttribute("nameX", new PlayerX());
        return "play";
    }
    @PostMapping("/name-list")
    public String saveNameX(@ModelAttribute PlayerX nameX){
        //add nameX to db 
        repoX.save(nameX);
        //retun to sth 
        return "redirect:/name-list";
    }

    //method for scoreboard page (listing)
    @GetMapping("/name-list")
    public String nameList(Model model){
        model.addAttribute("nameX", repoX.findAll());
        return "list";
    }

    //method for renaming players(updating)
   /* @PostMapping("/rename")
    public String renameThePlayers (@ModelAttribute PlayerX nameX){
        repoX.updateNameById(nameX.getId(), nameX.getNameX());
        return "redirect:/name-list";
    } */

    @GetMapping("/tictactoe")
    public String displayGameboard(Model model){
        return "ticTacToe";
    }

    /*@Autowired
    RoundRepository roundRepo; 

    @Autowired
    PlayerXRepository playerXRepo; 

    @Autowired
    PlayerORepository playerORepo;
    
    @Autowired
    ScoreXRepository scoreXRepo; 

    @Autowired
    ScoreORepository scoreORepo; 

    public TictactoeController(PlayerORepository playerORepo, PlayerXRepository playerXRepo, ScoreXRepository scoreXRepo, ScoreORepository scoreORepo, RoundRepository roundRepo) {
        this.playerORepo = playerORepo;
        this.playerXRepo = playerXRepo;
        this.scoreXRepo = scoreXRepo; 
        this.scoreORepo = scoreORepo; 
        this.roundRepo = roundRepo; 
    }

    @PostMapping("/play")
    public String createName(Model model){
        model.addAttribute("newNameO", new PlayerO());
        model.addAttribute("newNameX", new PlayerX());
        return "main.html";
    }

    @PostMapping("/play")
    public String updateName(Model model){
        model.addAttribute("newNameO", new PlayerO());
        model.addAttribute("newNameX", new PlayerX());
        return "main.html";
    }

    @GetMapping("/ScoreX")
    public int ScoreList(Model model) {
        model.addAttribute("ScoreX", ScoreXRepository.findAll());
        return "ScoreX";
    }
    @GetMapping("/ScoreO")
    public int ScoreList(Model model) {
        model.addAttribute("ScoreO", ScoreORepository.findAll());
        return "ScoreO";
    }
    @GetMapping("/PlayerXdeletename")
    public string Deletename(Model model) {
        model.addAttribute("PlayerXdeletename", PlayerXRepository.findAll());
        return "PlayerX";

    }
    @GetMapping("/PlayerOdeletename")
    public string Deletename(Model model) {
        model.addAttribute("PlayerOdeletename", PlayerORepository.findAll());
        return "PlayerO";
    }*/
}

