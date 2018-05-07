package osadchuk.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import osadchuk.roman.model.KindOfSport;
import osadchuk.roman.model.SportBuilding;
import osadchuk.roman.model.SportBuildingSport;
import osadchuk.roman.service.sportBuildingSport.SportBuildingSportService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SportBuildingSportController {
    @Autowired
    SportBuildingSportService service;

    @RequestMapping("/sport_building_sport")
    public List<SportBuildingSport> getAll(){
        return service.getAll();
    }

    @RequestMapping("/sport_building_sport/get")
    public SportBuildingSport getById(@RequestParam int id){
        return service.getById(id);
    }

    @RequestMapping("/sport_building_sport/del")
    public void delete(@RequestParam int id){
        service.delete(id);
    }
    @RequestMapping("/sport_building_sport/insert")
    public SportBuildingSport insert(@RequestParam  int sportBuildingId, int sportId) {

        SportBuilding sportBuilding = new SportBuilding(

                null,
                null,
                null,
                null
        );
        sportBuilding.setId(sportBuildingId);
        KindOfSport kindOfSport= new KindOfSport(null);
        kindOfSport.setId(sportId);
        SportBuildingSport sportBuildingSport = new SportBuildingSport(
                sportBuilding,
                kindOfSport
        );
        return service.insert(sportBuildingSport);
    }

    @RequestMapping("/sport_building_sport/update")
    public SportBuildingSport update(@RequestParam int id, int sportBuildingId, int sportId) {
        SportBuilding sportBuilding = new SportBuilding(

                null,
                null,
                null,
                null
        );
        sportBuilding.setId(sportBuildingId);
        KindOfSport kindOfSport= new KindOfSport(null);
        kindOfSport.setId(sportId);
        SportBuildingSport sportBuildingSport = new SportBuildingSport(
                sportBuilding,
                kindOfSport
        );
        sportBuildingSport.setId(id);
        return service.update(sportBuildingSport);
    }

    /*@PostMapping("/sport_building_sport/insert")
    public SportBuildingSport insert(@RequestBody SportBuildingSport sportBuildingSport){

        return service.insert(sportBuildingSport);
    }

    @PostMapping("/sport_building_sport/update")
    public SportBuildingSport update(@RequestBody SportBuildingSport sportBuildingSport){

        return service.update(sportBuildingSport);
    }*/
}
