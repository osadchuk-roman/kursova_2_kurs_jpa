package osadchuk.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import osadchuk.roman.model.Competition;
import osadchuk.roman.model.Sportsman;
import osadchuk.roman.model.SportsmanCompetition;
import osadchuk.roman.service.sportsmanCompetition.SportsmanCompetitionService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SportsmanCompetitionController {
    @Autowired
    SportsmanCompetitionService service;

    @RequestMapping("/sportsman_competition")
    public List<SportsmanCompetition> getAll(){
        return service.getAll();
    }

    @RequestMapping("/sportsman_competition/get")
    public SportsmanCompetition getById(@RequestParam int id){
        return service.getById(id);
    }

    @RequestMapping("/sportsman_competition/del")
    public void delete(@RequestParam int id){
        service.delete(id);
    }@RequestMapping("/sportsman_competition/insert")
    public SportsmanCompetition insert(@RequestParam int sportsmanId, int competitionId,int prizePlace){

        Competition competition=new Competition( null, null, null,
                null,null);
        competition.setId(competitionId);
        Sportsman sportsman = new Sportsman(null,0,null,null);
        sportsman.setId(sportsmanId);
        SportsmanCompetition sportsmanCompetition = new SportsmanCompetition(
                sportsman,competition,prizePlace
        );
        return service.insert(sportsmanCompetition);
    }

    @RequestMapping("/sportsman_competition/update")
    public SportsmanCompetition insert(@RequestParam int id, int sportsmanId, int competitionId,int prizePlace) {

        Competition competition=new Competition( null, null, null,
                null,null);
        competition.setId(competitionId);
        Sportsman sportsman = new Sportsman(null,0,null,null);
        sportsman.setId(sportsmanId);
        SportsmanCompetition sportsmanCompetition = new SportsmanCompetition(
                sportsman,competition,prizePlace
        );
        sportsmanCompetition.setId(id);
        return service.update(sportsmanCompetition);
    }

    /*@PostMapping("/sportsman_competition/insert")
    public SportsmanCompetition insert(@RequestBody SportsmanCompetition sportsmanCompetition){

        return service.insert(sportsmanCompetition);
    }

    @PostMapping("/sportsman_competition/update")
    public SportsmanCompetition update(@RequestBody SportsmanCompetition sportsmanCompetition){

        return service.update(sportsmanCompetition);
    }*/
}
