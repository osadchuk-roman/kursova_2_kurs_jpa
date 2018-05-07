package osadchuk.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import osadchuk.roman.model.TypeOfCover;
import osadchuk.roman.service.typeOfCover.TypeOfCoverService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TypeOfCoverController {
    @Autowired
    TypeOfCoverService service;

    @RequestMapping("/type_of_cover")
    public List<TypeOfCover> getAll(){
        return service.getAll();
    }

    @RequestMapping("/type_of_cover/get")
    public TypeOfCover getById(@RequestParam int id){
        return service.getById(id);
    }

    @RequestMapping("/type_of_cover/del")
    public void delete(@RequestParam int id){
        service.delete(id);
    }

    @RequestMapping("/type_of_cover/insert")
    public TypeOfCover insert(@RequestParam String name) {
        TypeOfCover typeOfSportBuilding = new TypeOfCover(name);
        return service.insert(typeOfSportBuilding);
    }

    @RequestMapping("/type_of_cover/update")
    public TypeOfCover insert(@RequestParam int id, String name){
        TypeOfCover typeOfSportBuilding = new TypeOfCover(name);
        typeOfSportBuilding.setId(id);
        return service.update(typeOfSportBuilding);
    }

    /*@PostMapping("/type_of_cover/insert")
    public TypeOfCover insert(@RequestBody TypeOfCover typeOfCover){

        return service.insert(typeOfCover);
    }

    @PostMapping("/type_of_cover/update")
    public TypeOfCover update(@RequestBody TypeOfCover typeOfCover){

        return service.update(typeOfCover);
    }*/
}
