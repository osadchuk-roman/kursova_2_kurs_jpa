package osadchuk.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import osadchuk.roman.model.SportBuilding;
import osadchuk.roman.model.TypeOfSportBuilding;
import osadchuk.roman.service.sportBuilding.SportBuildingService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SportBuildingController {
    @Autowired
    SportBuildingService service;

    @RequestMapping("/sport_building")
    public List<SportBuilding> getAll(){
        return service.getAll();
    }

    @RequestMapping("/sport_building/get")
    public SportBuilding getById(@RequestParam int id){
        return service.getById(id);
    }

    @RequestMapping("/sport_building/del")
    public void delete(@RequestParam int id){
        service.delete(id);
    }@RequestMapping("/sport_building/insert")
    public SportBuilding insert(@RequestParam String name, int typeOfSportBuildingId,
                                String phone, String address) {
        TypeOfSportBuilding typeOfSportBuilding = new TypeOfSportBuilding(null);
        typeOfSportBuilding.setId(typeOfSportBuildingId);
        SportBuilding sportBuilding = new SportBuilding(

                name,
                typeOfSportBuilding,
                phone,
                address
        );
        return service.insert(sportBuilding);
    }

    @RequestMapping("/sport_building/update")
    public SportBuilding update(@RequestParam int id, String name, int typeOfSportBuildingId,
                                String phone, String address){
        TypeOfSportBuilding typeOfSportBuilding = new TypeOfSportBuilding(null);
        typeOfSportBuilding.setId(typeOfSportBuildingId);
        SportBuilding sportBuilding = new SportBuilding(

                name,
                typeOfSportBuilding,
                phone,
                address
        );
        sportBuilding.setId(id);
        return service.update(sportBuilding);
    }

    /*@PostMapping("/sport_building/insert")
    public SportBuilding insert(@RequestBody SportBuilding sportBuilding){

        return service.insert(sportBuilding);
    }

    @PostMapping("/sport_building/update")
    public SportBuilding update(@RequestBody SportBuilding sportBuilding){

        return service.update(sportBuilding);
    }*/
}
