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
    private String[] gameBoard;
    private String currentPlayer;
    private boolean gameActive;

    public TictactoeController() {
        gameBoard = new String[]{"", "", "", "", "", "", "", "", ""};
        currentPlayer = "X";
        gameActive = true;
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);

        while (gameActive) {
            printBoard();
            System.out.println("Player " + currentPlayer + ", enter your move (1-9): ");
            int move = scanner.nextInt();

            if (isValidMove(move)) {
                makeMove(move);
                if (checkWinner()) {
                    printBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameActive = false;
                } else if (isBoardFull()) {
                    printBoard();
                    System.out.println("It's a draw!");
                    gameActive = false;
                } else {
                    currentPlayer = currentPlayer.equals("X") ? "O" : "X";
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        scanner.close();
    }

    private void printBoard() {
        System.out.println(" " + gameBoard[0] + " | " + gameBoard[1] + " | " + gameBoard[2]);
        System.out.println("-----------");
        System.out.println(" " + gameBoard[3] + " | " + gameBoard[4] + " | " + gameBoard[5]);
        System.out.println("-----------");
        System.out.println(" " + gameBoard[6] + " | " + gameBoard[7] + " | " + gameBoard[8]);
    }

    private boolean isValidMove(int move) {
        return move >= 1 && move <= 9 && gameBoard[move - 1].equals("");
    }

    private void makeMove(int move) {
        gameBoard[move - 1] = currentPlayer;
    }

    private boolean checkWinner() {
        // Implement your winning conditions here
        return false;
    }

    private boolean isBoardFull() {
        for (String cell : gameBoard) {
            if (cell.equals("")) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TictactoeController game = new TictactoeController();
        game.startGame();
    }


}

