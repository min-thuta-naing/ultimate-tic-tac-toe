package th.mfu; 

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

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
import th.mfu.domain.PlayerX; 

@Controller 
public class TictactoeController{
    @Autowired
    private PlayerXRepository repoX;
    @Autowired
    private PlayerORepository repoO;

    public TictactoeController(PlayerXRepository repoX, PlayerORepository repoO){
        this.repoX = repoX;
        this.repoO = repoO;
    }

    //method for start page 
    @GetMapping("/start-game")
    public String displayStartPage(Model model){
        return "start";
    }

    //method for play1 page (accept name for player 1)
    @GetMapping("/name-entry-x")
    public String addNameX(Model model){
        model.addAttribute("nameX", new PlayerX());
        return "play1";
    }
    @PostMapping("/name-list")
    public String saveNameX(@ModelAttribute PlayerX nameX){
        //add nameX to db 
        repoX.save(nameX);
        //retun to sth 
        return "redirect:/name-entry-o";
    }

    //method for play2 page (accept name for player 2)
    @GetMapping("/name-entry-o")
    public String addNameO(Model model){
        model.addAttribute("nameO", new PlayerO());
        return "play2";
    }
    @PostMapping("/name-list")
    public String saveNameO(@ModelAttribute PlayerO nameO){
        //add nameX to db 
        repoO.save(nameO);
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

    /*@GetMapping("/rename/{id}")
    public String displayRenamePage(@PathVariable Long id, Model model) {
        PlayerX nameX = repoX.findById(id).orElse(null);
        if (nameX != null) {
            model.addAttribute("playerX", nameX);
            return "rename"; // Create a Thymeleaf template for the rename page
        } else {
            // Handle the case where the player with the given id is not found
            return "redirect:/name-list";
        }
    }

    // Add a controller method to handle the update after renaming
    @PostMapping("/rename")
    public String updateNameX(@ModelAttribute PlayerX nameX) {
        repoX.save(nameX);
        return "redirect:/name-list";
    }*/

}

