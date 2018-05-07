package osadchuk.roman.service.sportBuildingSport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osadchuk.roman.model.SportBuildingSport;
import osadchuk.roman.repository.SportBuildingSportRepository;

import java.util.List;

@Service
public class SportBuildingSportService implements ISportBuildingSportService {
    @Autowired
    SportBuildingSportRepository repository;
    @Override
    public List<SportBuildingSport> getAll() {
        return (List<SportBuildingSport>)repository.findAll();
    }

    @Override
    public SportBuildingSport insert(SportBuildingSport sportBuildingSport) {
        return repository.save(sportBuildingSport);
    }

    @Override
    public SportBuildingSport update(SportBuildingSport sportBuildingSport) {
        return repository.save(sportBuildingSport);
    }

    @Override
    public SportBuildingSport getById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
