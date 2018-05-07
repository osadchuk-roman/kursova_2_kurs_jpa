package osadchuk.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import osadchuk.roman.model.*;
import osadchuk.roman.service.sportsmanSportCoach.SportsmanSportCoachService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SportsmanSportCoachController {
    @Autowired
    SportsmanSportCoachService service;

    @RequestMapping("/sportsman_sport_coach")
    public List<SportsmanSportCoach> getAll(){
        return service.getAll();
    }

    @RequestMapping("/sportsman_sport_coach/get")
    public SportsmanSportCoach getById(@RequestParam int id){
        return service.getById(id);
    }

    @RequestMapping("/sportsman_sport_coach/del")
    public void delete(@RequestParam int id){
        service.delete(id);
    }

    @RequestMapping("/sportsman_sport_coach/insert")
    public SportsmanSportCoach insert(@RequestParam int sportsmanId, int sportId, int categoryId, int coachId){
        Sportsman sportsman=new Sportsman(null,0,null,null);
        sportsman.setId(sportsmanId);
        KindOfSport kindOfSport = new KindOfSport(null);
        kindOfSport.setId(sportId);
        Coach coach =new Coach( null,null);
        coach.setId(coachId);
        SportCategory sportCategory = new SportCategory(null);
        sportCategory.setId(categoryId);
        SportsmanSportCoach sportsmanSportCoach=new SportsmanSportCoach(

                sportsman,
                kindOfSport,
                sportCategory,
                coach
        );
        return service.insert(sportsmanSportCoach);
    }

    @RequestMapping("/sportsman_sport_coach/update")
    public SportsmanSportCoach update(@RequestParam int id, int sportsmanId, int sportId, int categoryId, int coachId) {
        Sportsman sportsman=new Sportsman(null,0,null,null);
        sportsman.setId(sportsmanId);
        KindOfSport kindOfSport = new KindOfSport(null);
        kindOfSport.setId(sportId);
        Coach coach =new Coach( null,null);
        coach.setId(coachId);
        SportCategory sportCategory = new SportCategory(null);
        sportCategory.setId(categoryId);
        SportsmanSportCoach sportsmanSportCoach=new SportsmanSportCoach(

                sportsman,
                kindOfSport,
                sportCategory,
                coach
        );
        sportsmanSportCoach.setId(id);
        return service.insert(sportsmanSportCoach);
    }

    /*@PostMapping("/sportsman_sport_coach/insert")
    public SportsmanSportCoach insert(@RequestBody SportsmanSportCoach sportsmanSportCoach){

        return service.insert(sportsmanSportCoach);
    }

    @PostMapping("/sportsman_sport_coach/update")
    public SportsmanSportCoach update(@RequestBody SportsmanSportCoach sportsmanSportCoach){

        return service.update(sportsmanSportCoach);
    }*/
}
