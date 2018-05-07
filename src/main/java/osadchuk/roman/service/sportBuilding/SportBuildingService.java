package osadchuk.roman.service.sportBuilding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osadchuk.roman.model.SportBuilding;
import osadchuk.roman.repository.SportBuildingRepository;

import java.util.List;

@Service
public class SportBuildingService implements ISportBuildingService {
    @Autowired
    SportBuildingRepository repository;
    @Override
    public List<SportBuilding> getAll() {
        return (List<SportBuilding>)repository.findAll();
    }

    @Override
    public SportBuilding insert(SportBuilding sportBuilding) {
        return repository.save(sportBuilding);
    }

    @Override
    public SportBuilding update(SportBuilding sportBuilding) {
        return repository.save(sportBuilding);
    }

    @Override
    public SportBuilding getById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
