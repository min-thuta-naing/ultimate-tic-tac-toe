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
import th.mfu.domain.Players;   
@Controller
public class TictactoeController {
    @Autowired
    private PlayersRepository playersRepository;

    public TictactoeController(PlayersRepository playersRepository){
    this.playersRepository = playersRepository;
    }


    //method for start page
    @GetMapping("/start-game")
    public String displayStartPage(Model model){
    return "start";
    }


    //method for accepting players's names (player name entry)
    @GetMapping("/name-entry")
    public String addNameForm(Model model){
    model.addAttribute("name", new Players());
    return "player-name-entry";
    }


    @PostMapping("/name-entry")
    public String saveNameX(@ModelAttribute Players name, Model model){
    playersRepository.save(name);


    Iterable<Players> playersList = playersRepository.findAll();
    model.addAttribute("players", playersList);
    return "redirect:/name-entry";
    }



    //method for help page (help page)
    @GetMapping("/help")
    public String displayHelp(Model model){
    return "help";
    }


    //method for scoreboard page (listing)
    @GetMapping("/name-list")
    public String nameList(Model model){
    //model.addAttribute("name", playersRepository.findAll());
    return "list";
    }


    //method for displaying gameboard
    @GetMapping("/tictactoe")
    public String displayGameboard(Model model){
        Iterable<Players> playersList = playersRepository.findAll();
        model.addAttribute("players", playersList);
    return "ticTacToe";



    }


        //method for renaming (updating)




        /*
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

}