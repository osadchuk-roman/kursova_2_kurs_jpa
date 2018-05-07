package osadchuk.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import osadchuk.roman.model.Pool;
import osadchuk.roman.model.SportBuilding;
import osadchuk.roman.service.pool.PoolService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PoolController {
    @Autowired
    PoolService service;

    @RequestMapping("/pool")
    public List<Pool> getAll(){
        return service.getAll();
    }

    @RequestMapping("/pool/get")
    public Pool getById(@RequestParam int id){
        return service.getById(id);
    }

    @RequestMapping("/pool/del")
    public void delete(@RequestParam int id){
        service.delete(id);
    }

    @RequestMapping("/pool/insert")
    public Pool insert(@RequestParam int sportBuildingId,int depth, int width, int length,
                       int maxHeight)  {

        SportBuilding sportBuilding = new SportBuilding(
                null,
                null,
                null,
                null
        );
        sportBuilding.setId(sportBuildingId);
        Pool pool=new Pool(sportBuilding,depth,width,length,maxHeight);
        return service.insert(pool);
    }

    @RequestMapping("/pool/update")
    public Pool update(@RequestParam int id, int sportBuildingId,int depth, int width,
                       int length, int maxHeight) {
        SportBuilding sportBuilding = new SportBuilding(
                null,
                null,
                null,
                null
        );
        sportBuilding.setId(sportBuildingId);
        Pool pool=new Pool(sportBuilding,depth,width,length,maxHeight);
        pool.setId(id);
        return service.update(pool);
    }

    /*@PostMapping("/pool/insert")
    public Pool insert(@RequestBody Pool pool){

        return service.insert(pool);
    }

    @PostMapping("/pool/update")
    public Pool update(@RequestBody Pool pool){

        return service.update(pool);
    }*/
}
