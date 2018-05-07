package osadchuk.roman.service.gym;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osadchuk.roman.model.Gym;
import osadchuk.roman.repository.GymRepository;

import java.util.List;

@Service
public class GymService implements IGymService {
    @Autowired
    GymRepository repository;
    @Override
    public List<Gym> getAll() {
        return (List<Gym>)repository.findAll();
    }

    @Override
    public Gym insert(Gym gym) {
        return repository.save(gym);
    }

    @Override
    public Gym update(Gym gym) {
        return repository.save(gym);
    }

    @Override
    public Gym getById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
