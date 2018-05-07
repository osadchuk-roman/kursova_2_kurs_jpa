package osadchuk.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import osadchuk.roman.model.Competition;
import osadchuk.roman.model.KindOfSport;
import osadchuk.roman.model.Organizer;
import osadchuk.roman.model.SportBuilding;
import osadchuk.roman.service.competition.CompetitionService;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CompetitionController {
    @Autowired
    CompetitionService service;

    @RequestMapping("/competition")
    public List<Competition> getAll(){
        return service.getAll();
    }

    @RequestMapping("/competition/get")
    public Competition getById(@RequestParam int id){
        return service.getById(id);
    }

    @RequestMapping("/competition/del")
    public void delete(@RequestParam int id){
        service.delete(id);
    }

    @RequestMapping("/competition/insert")
    public Competition insert(@RequestParam String name, Date date, int organizerId,
                              int sportBuildingId, int sportId) throws SQLException {
        Organizer organizer = new Organizer(null,null,null,null);
        organizer.setId(organizerId);
        SportBuilding sportBuilding= new SportBuilding(null,
                null,null,null);
        sportBuilding.setId(sportBuildingId);
        KindOfSport kindOfSport =new KindOfSport(null);
        kindOfSport.setId(sportId);
        Competition competition=new Competition( name, date, organizer,sportBuilding,kindOfSport);
        return service.insert(competition);
    }

    @RequestMapping("/competition/update")
    public Competition insert(@RequestParam int id, String name, Date date, int organizerId,
                              int sportBuildingId, int sportId) throws SQLException {
        Organizer organizer = new Organizer(null,null,null,null);
        organizer.setId(organizerId);
        SportBuilding sportBuilding= new SportBuilding(null,
                null,null,null);
        sportBuilding.setId(sportBuildingId);
        KindOfSport kindOfSport =new KindOfSport(null);
        kindOfSport.setId(sportId);
        Competition competition=new Competition( name, date, organizer,sportBuilding,kindOfSport);
        competition.setId(id);
        return service.update(competition);
    }
    /*@PostMapping("/competition/insert")
    public Competition insert(@RequestBody Competition competition){
        return service.insert(competition);
    }

    @PostMapping("/competition/update")
    public Competition update(@RequestBody Competition competition){

        return service.update(competition);
    }*/

}
