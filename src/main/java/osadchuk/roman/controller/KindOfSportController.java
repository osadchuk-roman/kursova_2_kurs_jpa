package osadchuk.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import osadchuk.roman.model.KindOfSport;
import osadchuk.roman.service.kindOfSport.KindOfSportService;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class KindOfSportController {
    @Autowired
    KindOfSportService service;

    @RequestMapping("/kind_of_sport")
    public List<KindOfSport> getAll(){
        List<KindOfSport> list=service.getAll();
        list=list.stream().sorted(Comparator.comparing(KindOfSport::getId)).collect(Collectors.toList());
        return list;
    }

    @RequestMapping("/kind_of_sport/get")
    public KindOfSport getById(@RequestParam int id){
        return service.getById(id);
    }

    @RequestMapping("/kind_of_sport/del")
    public void delete(@RequestParam int id){
        service.delete(id);
    }

    /*@PostMapping("/kind_of_sport/insert")
    public KindOfSport insert(@RequestBody KindOfSport kindOfSport){

        return service.insert(kindOfSport);
    }

    @PostMapping("/kind_of_sport/update")
    public KindOfSport update(@RequestBody KindOfSport kindOfSport){

        return service.update(kindOfSport);
    }
*/
    @RequestMapping("/kind_of_sport/insert")
    public KindOfSport insert(@RequestParam String name) {
        /*List<KindOfSport> list=service.getAll();
        list=list.stream().sorted(Comparator.comparing(KindOfSport::getId)).collect(Collectors.toList());
        int lastId=list.get(list.size()-1).getId();*/
        KindOfSport kindOfSport = new KindOfSport(name);
        //kindOfSport.setId(lastId+1);
        return service.insert(kindOfSport);
    }

    @RequestMapping("/kind_of_sport/update")
    public KindOfSport insert(@RequestParam int id, String name) {
        KindOfSport kindOfSport = new KindOfSport(name);
        kindOfSport.setId(id);
        return service.update(kindOfSport);
    }
}
