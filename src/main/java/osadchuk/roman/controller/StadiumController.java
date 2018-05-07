package osadchuk.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import osadchuk.roman.model.SportBuilding;
import osadchuk.roman.model.Stadium;
import osadchuk.roman.service.stadium.StadiumService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StadiumController {
    @Autowired
    StadiumService service;

    @RequestMapping("/stadium")
    public List<Stadium> getAll(){
        return service.getAll();
    }

    @RequestMapping("/stadium/get")
    public Stadium getById(@RequestParam int id){
        return service.getById(id);
    }

    @RequestMapping("/stadium/del")
    public void delete(@RequestParam int id){
        service.delete(id);
    } @RequestMapping("/stadium/insert")
    public Stadium insert(@RequestParam int sportBuildingId,int capacity,double fieldArea,
                          boolean pathForRunning, boolean gymnasticZone){

        SportBuilding sportBuilding = new SportBuilding(
                null,
                null,
                null,
                null
        );
        sportBuilding.setId(sportBuildingId);
        Stadium stadium=new Stadium(sportBuilding,capacity,fieldArea,pathForRunning,gymnasticZone);
        return service.insert(stadium);
    }

    @RequestMapping("/stadium/update")
    public Stadium update(@RequestParam int id, int sportBuildingId,int capacity,double fieldArea,
                          boolean pathForRunning, boolean gymnasticZone) {
        SportBuilding sportBuilding = new SportBuilding(
                null,
                null,
                null,
                null
        );
        sportBuilding.setId(sportBuildingId);
        Stadium stadium=new Stadium(sportBuilding,capacity,fieldArea,pathForRunning,gymnasticZone);
        stadium.setId(id);
        return service.update(stadium);
    }

    /*@PostMapping("/stadium/insert")
    public Stadium insert(@RequestBody Stadium stadium){

        return service.insert(stadium);
    }

    @PostMapping("/stadium/update")
    public Stadium update(@RequestBody Stadium stadium){

        return service.update(stadium);
    }*/
}
