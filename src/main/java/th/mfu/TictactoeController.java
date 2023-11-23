package th.mfu;   
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import org.hibernate.mapping.List;
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
import th.mfu.domain.Game; 
 
@Controller
public class TictactoeController {
    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private PlayersRepository playersRepository;

    @Autowired
    private RoundsRepository roundsRepository;

    @Autowired
    private TimeRepository timeRepository; 

    public TictactoeController(PlayersRepository playersRepository){
        this.playersRepository = playersRepository;
    }

    //method for start page
    @GetMapping("/start-game")
    public String displayStartPage(Model model){
        model.addAttribute("gameName", new Game());
        return "start";
    }

    @PostMapping("/addId")
    public String addingGameId(@ModelAttribute Game game, Model model){
        gameRepository.save(game);
        model.addAttribute("gameName", gameRepository.findAll());
        return "redirect:/name-entry";
    }

    //method for help page (help page)
    @GetMapping("/help")
    public String displayHelp(Model model){
        return "help";
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


     //method for displaying gameboard
    @GetMapping("/tictactoe")
    public String displayGameboard(Model model){
        Iterable<Players> playersList = playersRepository.findAll();
        model.addAttribute("players", playersList);
        return "ticTacToe";
    }

    // @Autowired
    // private ResetAutoIncrementService resetAutoIncrementService;
    //method for saving game rounds winner and timeStamps (updating)
    @PostMapping("/save-result")
    public String saveGameResult(@RequestParam("winnerId") Long winnerId, @RequestParam("durationInSeconds") long durationInSeconds, Model model) {
        Players winner = playersRepository.findById(winnerId)
                .orElse(null);
        Rounds round; 
        if (winner == null) {
            round = new Rounds();
            round.setWinner(null);
        } else {
            // Assuming player1 and player2 names are stored in the player1Name and player2Name variables
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

    //method for scoreboard page (listing)
    @GetMapping("/name-list")
    public String nameList(Model model){
    //model.addAttribute("rounds", roundsRepository.findAll());    
        //return "list";
        Iterable<Rounds> roundsList = roundsRepository.findAll();
        model.addAttribute("rounds", roundsList);
        //method for displaying shortest game play duration 
        Iterable<Time> timeList = timeRepository.findAll();
        model.addAttribute("time", timeList);
        return "list"; 
    }


   
    
    
    

    //method for quitting the game and deleting all the players and game data 
    @GetMapping("/quit-delete")
    public String quitAndDelete(){
         
        // roundsRepository.deleteAll();
        // timeRepository.deleteAll();
        // playersRepository.deleteAll();
        
        // Reset auto-increment counter for each table
        // resetAutoIncrementService.resetAutoIncrement("time");
        // resetAutoIncrementService.resetAutoIncrement("rounds");
        // resetAutoIncrementService.resetAutoIncrement("players");

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

    //saving rating 
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

    //method for view comments page 
    @GetMapping("/admin-page")
        public String viewUsersFeedbacks(Model model){
        Iterable<Comments> commentList = commentsRepository.findAll();
        model.addAttribute("comments", commentList); 
        return "comments";
    }
}
