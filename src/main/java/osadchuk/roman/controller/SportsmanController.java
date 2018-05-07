package osadchuk.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import osadchuk.roman.model.SportClub;
import osadchuk.roman.model.Sportsman;
import osadchuk.roman.service.sportsman.SportsmanService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SportsmanController {
    @Autowired
    SportsmanService service;

    @RequestMapping("/sportsman")
    public List<Sportsman> getAll(){
        return service.getAll();
    }

    @RequestMapping("/sportsman/get")
    public Sportsman getById(@RequestParam int id){
        return service.getById(id);
    }

    @RequestMapping("/sportsman/del")
    public void delete(@RequestParam int id){
        service.delete(id);
    }@RequestMapping("/sportsman/insert")
    public Sportsman insert(@RequestParam String name,int age,String gender,int sportClubId)  {
        SportClub sportClub = new SportClub(null,null,null,null);
        sportClub.setId(sportClubId);
        Sportsman sportsman = new Sportsman(

                name,
                age,
                gender,
                sportClub
        );
        return service.insert(sportsman);
    }

    @RequestMapping("/sportsman/update")
    public Sportsman update(@RequestParam int id, String name,int age,String gender,int sportClubId) {
        SportClub sportClub = new SportClub(null,null,null,null);
        sportClub.setId(sportClubId);
        Sportsman sportsman = new Sportsman(

                name,
                age,
                gender,
                sportClub
        );
        sportsman.setId(id);
        return service.update(sportsman);
    }

    /*@PostMapping("/sportsman/insert")
    public Sportsman insert(@RequestBody Sportsman sportsman){

        return service.insert(sportsman);
    }

    @PostMapping("/sportsman/update")
    public Sportsman update(@RequestBody Sportsman sportsman){

        return service.update(sportsman);
    }*/
}
