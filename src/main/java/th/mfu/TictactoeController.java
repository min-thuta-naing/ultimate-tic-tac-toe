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

import th.mfu.domain.PlayerO;

@Controller 
public class TictactoeController{
    @Autowired
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
}
}

