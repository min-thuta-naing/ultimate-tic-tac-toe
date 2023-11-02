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
    ScoreYRepository scoreYRepo; 

    @PostMapping 
    public String createName(Model model){

    }

    @PostMapping 
    public String updateName(Model model){
        
    }
}

@GetMapping("/board")
public char[][] getBoard(){
    return
}