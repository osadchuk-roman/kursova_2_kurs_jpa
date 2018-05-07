package osadchuk.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import osadchuk.roman.model.SportCategory;
import osadchuk.roman.service.sportCategory.SportCategoryService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SportCategoryController {
    @Autowired
    SportCategoryService service;

    @RequestMapping("/sport_category")
    public List<SportCategory> getAll(){
        return service.getAll();
    }

    @RequestMapping("/sport_category/get")
    public SportCategory getById(@RequestParam int id){
        return service.getById(id);
    }

    @RequestMapping("/sport_category/del")
    public void delete(@RequestParam int id){
        service.delete(id);
    }

    @RequestMapping("/sport_category/insert")
    public SportCategory insert(@RequestParam String name){
        SportCategory sportCategory = new SportCategory(name);
        return service.insert(sportCategory);
    }

    @RequestMapping("/sport_category/update")
    public SportCategory insert(@RequestParam int id, String name) {
        SportCategory sportCategory = new SportCategory(name);
        sportCategory.setId(id);
        return service.update(sportCategory);
    }

    /*@PostMapping("/sport_category/insert")
    public SportCategory insert(@RequestBody SportCategory sportCategory){

        return service.insert(sportCategory);
    }

    @PostMapping("/sport_category/update")
    public SportCategory update(@RequestBody SportCategory sportCategory){

        return service.update(sportCategory);
    }*/
}
