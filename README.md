Group 13
Ultimate Tic-Tac-Toe Pro
=======================

<b>Group Members</b>
|  Student ID  |  Name  |  Github Account  |
|  ---  |  ---  |  ---  |
|  6531503143  |  Htet Yunn Shwe Yi  |  Htet-Yunn-Shwe-Yi  |
|  6531503151  |  Lwin Moe Aung |  DanielLweis  |           
|  6531503157  |  Min Thuta Naing |  mtn94887  |        
|  6531503183  |  Shwin Pyone Thu |  shwinpyonethu  |    
|  6531503170  |  Phue Phue Soe Lwin |  PhuePhueSoeLwin  |      
|  6531503186  |  Soe Yu Yu Kyaw |  SoeYuYuKyaw  |         

link to our web app: https://lab-utttpr-meibtcsfoq-uc.a.run.app/start-game

<p float="left">
  <img src="https://github.com/maefahluang-uni/99-project-ultimatetictactoepro_group13/assets/122962636/16c70243-ee73-4bf6-ab46-1362049cab90" width="400" />
  <img src="https://github.com/maefahluang-uni/99-project-ultimatetictactoepro_group13/assets/122962636/dc57208f-b51e-47e4-8035-e32b2f6ac9e4" width="400" /> 
</p>


  The very fist page is the "Start" page, serves as a cover before getting into the game. Two functioning components on this page are "Start" and "i", information button on the bottom left corner of the page. "Start" button will take players to the next page where player will enter their names before continuing to play. Moreover, the "i", information button serves as an access to the "Help" page. On this page players can learn about how the game works and some other basic informations. "Back" button will allow the access back to the start page.

<p float="left">
  <img src="https://github.com/maefahluang-uni/99-project-ultimatetictactoepro_group13/assets/122962636/567f90ec-a5b3-46c5-9da0-63998d29a96e" width="400" />
  <img src="https://github.com/maefahluang-uni/99-project-ultimatetictactoepro_group13/assets/122962636/02ed0be4-6dc3-498b-a119-86e340f75309" width="400" /> 
</p>


  Once players click "Start", players will be asked to enter a name to continue. First the player who will take the part of "X" will fill the name. When "Enter" is clicked the input data will go into the "Players" table. Without this players cannot proceed to the next step. The next page will ask to do the for player who is taking part of "O". This input data will also go into its respective table "!!!".

![Screenshot](https://github.com/maefahluang-uni/99-project-ultimatetictactoepro_group13/assets/122962636/6166d3ce-e4d1-4a7c-98b2-0dc700330733 | width=400)

  Then it will take the players to the main page where the players will play the game. Before anything, players will be asked to chooese who would like to go first. When that is done each players will take turns to play againts each other. On this page there is one icon, "Restart" button on the bottom left corner. At any point of the game players can restart the game. When players click on the icon there will be a pop up window to confirm from any accidental clicks. Players can choose to restart or click "Cancel" to continue playing.

<img width="1512" alt="Screenshot 2566-11-22 at 12 40 17 PM" src="https://github.com/maefahluang-uni/99-project-ultimatetictactoepro_group13/assets/122962636/1472db38-79bc-4be5-83d7-83629405fc2b">

  The last page is to display leaderboard. The graph will display the results from each round. When the game is over the results will be stored in the "Rounds" and "Time" tables respectively, with the name of the player who wins along side the round ID. Players can choose to continue to the next round by clicking on "Next Round" button on the bottom right corner. If the players continue to play the round ID will increase with the number of replays and corresponding winner will for each round will continue to display on the table. However, is the players decide to quit to game by clicking on "Quit" button, all the previous data stored on the "Players", "Rounds" and "Time" tables will be erased and this will take players back to the start page. The game will have to start again for the database to collect data again.

  Some other functions on the last page include "Leave Feedback". Here players can comment and express their thoughts on the web application. Another function is rating, this will only appear one the players click on "Quit". After the pop up to confirm players actually want to quit the game, there will be stars to rate from 1 to 5. Both ratings and feedbacks from the players can be viewed by developers side to accept supports and compaints to improve further. 
![Image 24-11-2566 BE at 6 12 PM](https://github.com/maefahluang-uni/99-project-ultimatetictactoepro_group13/assets/122962636/7983f447-75a7-4a02-8e68-0b08db7dd4b9)
