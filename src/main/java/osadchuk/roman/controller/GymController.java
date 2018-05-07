package osadchuk.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import osadchuk.roman.model.Gym;
import osadchuk.roman.model.SportBuilding;
import osadchuk.roman.service.gym.GymService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GymController {
    @Autowired
    GymService service;

    @RequestMapping("/gym")
    public List<Gym> getAll(){
        return service.getAll();
    }

    @RequestMapping("/gym/get")
    public Gym getById(@RequestParam int id){
        return service.getById(id);
    }

    @RequestMapping("/gym/del")
    public void delete(@RequestParam int id){
        service.delete(id);
    }


    @RequestMapping("/gym/insert")
    public Gym insert(@RequestParam int sportBuildingId,boolean cardioZone,
                      boolean crossfitZone, boolean boxingRing) {

        SportBuilding sportBuilding = new SportBuilding(
                null,
                null,
                null,
                null
        );
        sportBuilding.setId(sportBuildingId);
        Gym gym=new Gym(sportBuilding,cardioZone,crossfitZone,boxingRing);
        return service.insert(gym);
    }

    @RequestMapping("/gym/update")
    public Gym update(@RequestParam int id, int sportBuildingId, boolean cardioZone,
                      boolean crossfitZone, boolean boxingRing) {

        SportBuilding sportBuilding = new SportBuilding(
                null,
                null,
                null,
                null
        );
        sportBuilding.setId(sportBuildingId);
        Gym gym=new Gym(sportBuilding,cardioZone,crossfitZone,boxingRing);
        gym.setId(id);
        return service.update(gym);
    }
    /*@PostMapping("/gym/insert")
    public Gym insert(@RequestBody Gym gym){

        return service.insert(gym);
    }

    @PostMapping("/gym/update")
    public Gym update(@RequestBody Gym gym){

        return service.update(gym);
    }*/
}
