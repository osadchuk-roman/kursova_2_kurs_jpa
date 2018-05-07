package osadchuk.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import osadchuk.roman.model.Court;
import osadchuk.roman.model.SportBuilding;
import osadchuk.roman.model.TypeOfCover;
import osadchuk.roman.repository.CourtRepository;
import osadchuk.roman.service.court.CourtService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourtController {
    @Autowired
    CourtService service;

    @RequestMapping("/court")
    public List<Court> getAll(){
        return service.getAll();
    }

    @RequestMapping("/court/get")
    public Court getById(@RequestParam int id){
        return service.getById(id);
    }

    @RequestMapping("/court/del")
    public void delete(@RequestParam int id){
        service.delete(id);
    }

    /*@PostMapping("/court/insert")
    public Court insert(@RequestBody Court court){

        return service.insert(court);
    }

    @PostMapping("/court/update")
    public Court update(@RequestBody Court court){

        return service.update(court);
    }*/


    @RequestMapping("/court/insert")
    public Court insert(@RequestParam int sportBuildingId,int typeOfCoverId,
                        double width, double length) {

        SportBuilding sportBuilding = new SportBuilding(
                null,
                null,
                null,
                null
        );
        sportBuilding.setId(sportBuildingId);
        TypeOfCover typeOfCover= new TypeOfCover(null);
        typeOfCover.setId(typeOfCoverId);
        Court court=new Court(sportBuilding,typeOfCover,width,length);
        return service.insert(court);
    }

    @RequestMapping("/court/update")
    public Court update(@RequestParam int id, int sportBuildingId,int typeOfCoverId,
                        double width, double length)  {

        SportBuilding sportBuilding = new SportBuilding(
                null,
                null,
                null,
                null
        );
        sportBuilding.setId(sportBuildingId);
        TypeOfCover typeOfCover= new TypeOfCover(null);
        typeOfCover.setId(typeOfCoverId);
        Court court=new Court(sportBuilding,typeOfCover,width,length);
        court.setId(id);
        return service.update(court);
    }
}
