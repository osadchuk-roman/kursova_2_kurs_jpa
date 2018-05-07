package osadchuk.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import osadchuk.roman.model.SportClub;
import osadchuk.roman.service.sportClub.SportClubService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SportClubController {
    @Autowired
    SportClubService service;

    @RequestMapping("/sport_club")
    public List<SportClub> getAll(){
        return service.getAll();
    }

    @RequestMapping("/sport_club/get")
    public SportClub getById(@RequestParam int id){
        return service.getById(id);
    }

    @RequestMapping("/sport_club/del")
    public void delete(@RequestParam int id){
        service.delete(id);
    }@RequestMapping("/sport_club/insert")
    public SportClub insert(@RequestParam String name, String adminName, String phone, String address) {
        SportClub sportClub = new SportClub(name,adminName,phone,address);
        return service.insert(sportClub);
    }

    @RequestMapping("/sport_club/update")
    public SportClub insert(@RequestParam int id, String name, String adminName, String phone, String address){
        SportClub sportClub = new SportClub(name,adminName,phone,address);
        sportClub.setId(id);
        return service.update(sportClub);
    }

    /*@PostMapping("/sport_club/insert")
    public SportClub insert(@RequestBody SportClub sportClub){

        return service.insert(sportClub);
    }

    @PostMapping("/sport_club/update")
    public SportClub update(@RequestBody SportClub sportClub){

        return service.update(sportClub);
    }*/
}
