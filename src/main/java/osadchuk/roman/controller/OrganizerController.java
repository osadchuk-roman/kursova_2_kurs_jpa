package osadchuk.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import osadchuk.roman.model.Organizer;
import osadchuk.roman.service.organizer.OrganizerService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrganizerController {
    @Autowired
    OrganizerService service;

    @RequestMapping("/organizer")
    public List<Organizer> getAll(){
        return service.getAll();
    }

    @RequestMapping("/organizer/get")
    public Organizer getById(@RequestParam int id){
        return service.getById(id);
    }

    @RequestMapping("/organizer/del")
    public void delete(@RequestParam int id){
        service.delete(id);
    }

    @RequestMapping("/organizer/insert")
    public Organizer insert(@RequestParam String name, String adminName, String phone, String address) {
        Organizer organizer = new Organizer(name,adminName,phone,address);
        return service.insert(organizer);
    }

    @RequestMapping("/organizer/update")
    public Organizer insert(@RequestParam int id, String name, String adminName, String phone, String address) {
        Organizer organizer = new Organizer(name,adminName,phone,address);
        organizer.setId(id);
        return service.update(organizer);
    }

    /*@PostMapping("/organizer/insert")
    public Organizer insert(@RequestBody Organizer organizer){

        return service.insert(organizer);
    }

    @PostMapping("/organizer/update")
    public Organizer update(@RequestBody Organizer organizer){

        return service.update(organizer);
    }*/
}
