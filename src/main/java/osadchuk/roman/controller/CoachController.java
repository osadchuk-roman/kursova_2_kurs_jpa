package osadchuk.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import osadchuk.roman.model.Coach;
import osadchuk.roman.model.SportClub;
import osadchuk.roman.service.coach.CoachService;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CoachController {
    @Autowired
    CoachService service;

    @RequestMapping("/coach")
    public List<Coach> getAll(){
        List<Coach> list=service.getAll();
        list=list.stream().sorted(Comparator.comparing(Coach::getId)).collect(Collectors.toList());
        return service.getAll();
    }

    @RequestMapping("/coach/get")
    public Coach getById(@RequestParam int id){
        return service.getById(id);
    }

    @RequestMapping("/coach/del")
    public void delete(@RequestParam int id){
        service.delete(id);
    }

    @RequestMapping("/coach/insert")
    public Coach insert(@RequestParam String name,int sportClubId){
        SportClub sportClub = new SportClub(null,null,null,null);
        sportClub.setId(sportClubId);
        Coach sportBuilding = new Coach(
                name,
                sportClub
        );
        return service.insert(sportBuilding);
    }

    @RequestMapping("/coach/update")
    public Coach update(@RequestParam int id, String name,int sportClubId)  {
        SportClub sportClub = new SportClub(null,null,null,null);
        sportClub.setId(sportClubId);
        Coach coach = new Coach(
                name,
                sportClub
        );
        coach.setId(id);
        return service.update(coach);
    }
    /*@PostMapping("/coach/insert")
    public Coach insert(@RequestBody Coach coach){

        return service.insert(coach);
    }

    @PostMapping("/coach/update")
    public Coach update(@RequestBody Coach coach){

        return service.update(coach);
    }*/

}
