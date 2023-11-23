// package th.mfu.domain;

// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;

// import java.util.List;

// import javax.persistence.CascadeType;
// import javax.persistence.Entity;
// import javax.persistence.Id;
// import javax.persistence.OneToMany;
// import javax.persistence.Table;

// @Entity 
// @Table(name = "Game", schema = "new_schema")
// public class Game {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id; 
//     private String gameName;

//      @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
//     private List<Players> players;
    
   
//     public List<Players> getPlayers() {
//         return players;
//     }
//     public void setPlayers(List<Players> players) {
//         this.players = players;
//     }
    
//     //constructor 
//     public Game(){
//     }
//     public Game(String gameName) {
//         this.gameName = gameName;
//     }
    

//     //getter and setter 
//     public Long getId() {
//         return id;
//     }
//     public void setId(Long id) {
//         this.id = id;
//     }

//     public String getGameName() {
//         return gameName;
//     }
//     public void setGameName(String gameName) {
//         this.gameName = gameName;
//     }


// }