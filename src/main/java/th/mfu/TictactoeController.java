package th.mfu;   
import java.util.ArrayList;
import java.util.Optional;

import java.util.*; 
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
//import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.WebDataBinder;  
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.InitBinder;  
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import th.mfu.domain.Players;
import th.mfu.domain.Rating;
import th.mfu.domain.Rounds;
import th.mfu.domain.Time;   
import th.mfu.domain.Comments;
 
@Controller
public class TictactoeController {

    @Autowired
    private PlayersRepository playersRepository;

    @Autowired
    private RoundsRepository roundsRepository;

    @Autowired
    private TimeRepository timeRepository; 

    public TictactoeController(PlayersRepository playersRepository){
        this.playersRepository = playersRepository;
    }

    //method for displaying start page
    @GetMapping("/start-game")
    public String displayStartPage(Model model){
        return "start";
    }


    //method for displaying help page
    @GetMapping("/help")
    public String displayHelp(Model model){
        return "help";
    }

    //method for x-entry page (x entry)
    @GetMapping("/x_entry")
         public String xentry(Model model){
        model.addAttribute("name", new Players());
        return "x_entry";
    }

    @PostMapping("/x_entry")
    public String saveNameX(@ModelAttribute Players name, Model model){
        playersRepository.save(name);
        Iterable<Players> playersList = playersRepository.findAll();
        model.addAttribute("players", playersList);
        return "redirect:/o_entry";
    }
    //method for o-entry page (o entry)
    @GetMapping("/o_entry")
        public String addNameForm(Model model){
        model.addAttribute("name", new Players());
        return "o_entry";
    }

    @PostMapping("/o_entry")
        public String saveNameO(@ModelAttribute Players name, Model model){
        playersRepository.save(name);
         Iterable<Players> playersList = playersRepository.findAll();
        model.addAttribute("players", playersList);
        return "redirect:/tictactoe";
    }


     //method for displaying gameboard 
    @GetMapping("/tictactoe")
    public String displayGameboard(Model model){
        Iterable<Players> playersList = playersRepository.findAll();
        model.addAttribute("players", playersList);
        return "ticTacToe";
    }

   
    //method for saving game rounds winner and timeStamps  ---- UPDATING ----
    @PostMapping("/save-result")
    public String saveGameResult(@RequestParam("winnerId") Long winnerId, @RequestParam("durationInSeconds") long durationInSeconds, Model model) {
        Players winner;
        if (winnerId == -1){
            winner = null;
        }else {
            winner = playersRepository.findById(winnerId)
                .orElse(null);
        }
        Rounds round; 
        if (winner == null) {
            round = new Rounds();
            round.setWinner(null);
        } else {
            round = new Rounds();
            round.setWinner(winner);
        }
        roundsRepository.save(round);
        // if ("tie".equals(winner)) {
        //     Rounds tieRound = new Rounds();
        //     tieRound.setWinner(winner);
        //     roundsRepository.save(tieRound);
        //     } else {
        //     // Assuming player1 and player2 names are stored in the player1Name and player2Name variables
        //     Rounds winningRound = new Rounds();
        //     winningRound.setWinner(winner);
        //     roundsRepository.save(winningRound);
        //     }
            
        Time roundTime = new Time();
        roundTime.setRoundId(round);
        roundTime.setDurationInSeconds(durationInSeconds);
        timeRepository.save(roundTime); 
        return "redirect:/name-list";
    }

    //method for scoreboard page  ---- LISTING ----
    @GetMapping("/name-list")
    public String nameList(Model model){
    
        Iterable<Rounds> roundsIterable = roundsRepository.findAll();
        List<Rounds> roundsList = new ArrayList<>();
        roundsIterable.forEach(roundsList::add);

        roundsList.sort(Comparator.comparing(Rounds::getRoundId));
        model.addAttribute("rounds", roundsList);
        //displaying shortest game play duration 
        Iterable<Time> timeList = timeRepository.findAll();
        model.addAttribute("time", timeList);
        return "list"; 
    }

    @Autowired
    private ResetAutoIncrementService resetAutoIncrementService;
    //method for quitting the game and deleting all the players and game data  ---- DELETING ----
    @GetMapping("/quit-delete")
    public String quitAndDelete(){
        
        timeRepository.deleteAll();
        roundsRepository.deleteAll();
        playersRepository.deleteAll();
        
        // auto-increment for each table
        resetAutoIncrementService.resetAutoIncrement("Time", "new_schema");
        resetAutoIncrementService.resetAutoIncrement("Rounds", "new_schema");
        resetAutoIncrementService.resetAutoIncrement("Players", "new_schema");

        return "redirect:/start-game";
    }
   
    /* 
    * 
    * 
    Developers and admins 
    * 
    * 
    */

    @Autowired
    private CommentsRepository commentsRepository; 

    @Autowired
    private RatingRepository ratingRepository;

    //saving rating  ---- CREATING AND UPDATING ----
    @PostMapping("/save-rating")
    public String saveUserRating(@RequestParam("rating") int rating, Model model) {
        Rating userRating = new Rating();
        userRating.setRates(rating);
        ratingRepository.save(userRating);
        return "redirect:/start-game";
    }

    @GetMapping("/get-ratings")
    public ResponseEntity<Iterable<Rating>> getRatings() {
        Iterable<Rating> ratings = ratingRepository.findAll();
        return new ResponseEntity<>(ratings, HttpStatus.OK);
    }

    //method for receiving user feedback input from users comment box 
    @PostMapping("/save-feedbacks")
    public String saveUsersFeedbacks(@RequestParam("comments") String comment, Model model){
        Comments cmt = new Comments(); 
        cmt.setComment(comment);
        commentsRepository.save(cmt); 
        return "redirect:/name-list";
    }

    //method for viewing comments page (admin-page)
    @GetMapping("/admin-page")
        public String viewUsersFeedbacks(Model model){
        Iterable<Comments> commentList = commentsRepository.findAll();
        model.addAttribute("comments", commentList); 
        return "comments";
    }
}
