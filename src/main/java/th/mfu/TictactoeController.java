package th.mfu;   

import javax.transaction.Transactional;

import org.hibernate.mapping.List;
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
        //model.addAttribute("rounds", roundsRepository.findAll());    
        //return "list";
        Iterable<Rounds> roundsList = roundsRepository.findAll();
        model.addAttribute("rounds", roundsList);
        
        //method for displaying shortest game play duration 
        Iterable<Time> timeList = timeRepository.findAll();
        model.addAttribute("time", timeList);

        return "list"; 
    }

    //method for displaying gameboard
    @GetMapping("/tictactoe")
    public String displayGameboard(Model model){
        Iterable<Players> playersList = playersRepository.findAll();
        model.addAttribute("players", playersList);
    return "ticTacToe";
    }
    
    @Autowired
    private RoundsRepository roundsRepository;

    @Autowired
    private TimeRepository timeRepository; 

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

        Time roundTime = new Time(); 
        roundTime.setRoundId(round);
        roundTime.setDurationInSeconds(durationInSeconds);
        timeRepository.save(roundTime); 

        return "redirect:/name-list";
    }

    //method for quitting the game and deleting all the players and game data 
    @GetMapping("/quit-delete")
    public String quitAndDelete(){
         timeRepository.deleteAll();        
         roundsRepository.deleteAll();
         playersRepository.deleteAll();
        
        return "redirect:/start-game";
    }
        //method for renaming (updating)
        /*
        
        //method for renaming players(updating)
        /* @PostMapping("/rename")
        public String renameThePlayers (@ModelAttribute PlayerX nameX){
        repoX.updateNameById(nameX.getId(), nameX.getNameX());
        return "redirect:/name-list";
        } */

        /* 
         * 
         * 
         Developers and admins 
         * 
         * 
         */

         @Autowired
         private CommentsRepository commentsRepository; 

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

         @Autowired
        private RatingRepository ratingRepository;


        @PostMapping("/save-rating")
        public String saveUserRating(@RequestParam("rating") int rating, Model model) {
            Rating userRating = new Rating();
            userRating.setRates(rating);
            ratingRepository.save(userRating);
            return "redirect:/name-list";
        }

}


