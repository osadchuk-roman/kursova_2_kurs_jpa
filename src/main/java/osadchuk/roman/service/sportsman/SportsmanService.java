package osadchuk.roman.service.sportsman;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osadchuk.roman.model.Sportsman;
import osadchuk.roman.repository.SportsmanRepository;

import java.util.List;

@Service
public class SportsmanService implements ISportsmanService {
    @Autowired
    SportsmanRepository repository;
    @Override
    public List<Sportsman> getAll() {
        return (List<Sportsman>)repository.findAll();
    }

    @Override
    public Sportsman insert(Sportsman sportsman) {
        return repository.save(sportsman);
    }

    @Override
    public Sportsman update(Sportsman sportsman) {
        return repository.save(sportsman);
    }

    @Override
    public Sportsman getById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
