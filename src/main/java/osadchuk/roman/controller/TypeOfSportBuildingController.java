package osadchuk.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import osadchuk.roman.model.TypeOfSportBuilding;
import osadchuk.roman.service.typeOfSportBuilding.TypeOfSportBuildingService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TypeOfSportBuildingController {
    @Autowired
    TypeOfSportBuildingService service;

    @RequestMapping("/type_of_sport_building")
    public List<TypeOfSportBuilding> getAll(){
        return service.getAll();
    }

    @RequestMapping("/type_of_sport_building/get")
    public TypeOfSportBuilding getById(@RequestParam int id){
        return service.getById(id);
    }

    @RequestMapping("/type_of_sport_building/del")
    public void delete(@RequestParam int id){
        service.delete(id);
    }

    @RequestMapping("/type_of_sport_building/insert")
    public TypeOfSportBuilding insert(@RequestParam String name) {
        TypeOfSportBuilding typeOfSportBuilding = new TypeOfSportBuilding(name);
        return service.insert(typeOfSportBuilding);
    }

    @RequestMapping("/type_of_sport_building/update")
    public TypeOfSportBuilding insert(@RequestParam int id, String name) {
        TypeOfSportBuilding typeOfSportBuilding = new TypeOfSportBuilding(name);
        typeOfSportBuilding.setId(id);
        return service.update(typeOfSportBuilding);
    }

    /*@PostMapping("/type_of_sport_building/insert")
    public TypeOfSportBuilding insert(@RequestBody TypeOfSportBuilding typeOfSportBuilding){

        return service.insert(typeOfSportBuilding);
    }

    @PostMapping("/type_of_sport_building/update")
    public TypeOfSportBuilding update(@RequestBody TypeOfSportBuilding typeOfSportBuilding){

        return service.update(typeOfSportBuilding);
    }*/
}
