package osadchuk.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import osadchuk.roman.model.SportArena;
import osadchuk.roman.model.SportBuilding;
import osadchuk.roman.service.sportArena.SportArenaService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SportArenaController {
    @Autowired
    SportArenaService service;

    @RequestMapping("/sport_arena")
    public List<SportArena> getAll(){
        return service.getAll();
    }

    @RequestMapping("/sport_arena/get")
    public SportArena getById(@RequestParam int id){
        return service.getById(id);
    }

    @RequestMapping("/sport_arena/del")
    public void delete(@RequestParam int id){
        service.delete(id);
    }

    @RequestMapping("/sport_arena/insert")
    public SportArena insert(@RequestParam int sportBuildingId,int capacity,
                             boolean gymnastic, boolean box, boolean matirialArts)  {

        SportBuilding sportBuilding = new SportBuilding(
                null,
                null,
                null,
                null
        );
        sportBuilding.setId(sportBuildingId);
        SportArena sportArena=new SportArena(sportBuilding,capacity,gymnastic,box,matirialArts);
        return service.insert(sportArena);
    }

    @RequestMapping("/sport_arena/update")
    public SportArena update(@RequestParam int id, int sportBuildingId,int capacity,
                             boolean gymnastic, boolean box, boolean matirialArts) {
        SportBuilding sportBuilding = new SportBuilding(
                null,
                null,
                null,
                null
        );
        sportBuilding.setId(sportBuildingId);
        SportArena sportArena=new SportArena(sportBuilding,capacity,gymnastic,box,matirialArts);
        sportArena.setId(id);
        return service.update(sportArena);
    }

    /*@PostMapping("/sport_arena/insert")
    public SportArena insert(@RequestBody SportArena sportArena){

        return service.insert(sportArena);
    }

    @PostMapping("/sport_arena/update")
    public SportArena update(@RequestBody SportArena sportArena){

        return service.update(sportArena);
    }*/
}
