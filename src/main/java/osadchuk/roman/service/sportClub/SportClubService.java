package osadchuk.roman.service.sportClub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osadchuk.roman.model.SportClub;
import osadchuk.roman.repository.SportClubRepository;

import java.util.List;

@Service
public class SportClubService implements ISportClubService {
    @Autowired
    SportClubRepository repository;
    @Override
    public List<SportClub> getAll() {
        return (List<SportClub>)repository.findAll();
    }

    @Override
    public SportClub insert(SportClub sportClub) {
        return repository.save(sportClub);
    }

    @Override
    public SportClub update(SportClub sportClub) {
        return repository.save(sportClub);
    }

    @Override
    public SportClub getById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
