package osadchuk.roman.service.sportArena;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osadchuk.roman.model.SportArena;
import osadchuk.roman.repository.SportArenaRepository;

import java.util.List;

@Service
public class SportArenaService implements ISportArenaService {
    @Autowired
    SportArenaRepository repository;
    @Override
    public List<SportArena> getAll() {
        return (List<SportArena>)repository.findAll();
    }

    @Override
    public SportArena insert(SportArena sportArena) {
        return repository.save(sportArena);
    }

    @Override
    public SportArena update(SportArena sportArena) {
        return repository.save(sportArena);
    }

    @Override
    public SportArena getById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
