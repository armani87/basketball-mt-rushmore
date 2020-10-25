package org.wecancodeit.basketballmtrushmore;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import javax.annotation.Resource;

@Controller
public class PlayerController {

    @Resource
    private PlayerRepository playerRepo;

    @RequestMapping("/player")
    public  String findOnePlayer(@RequestParam(value="id")Long id, Model model){
        model.addAttribute("playerModel", playerRepo.findOne(id));
        return "playerTemplate";
    }

    @RequestMapping("/players")
    public String findAllPlayers(Model model){
        model.addAttribute("playersModel", playerRepo.findAll());
        return "playersTemplate";
    }

}
