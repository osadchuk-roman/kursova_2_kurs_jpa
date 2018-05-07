package osadchuk.roman.service.stadium;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osadchuk.roman.model.Stadium;
import osadchuk.roman.repository.StadiumRepository;

import java.util.List;

@Service
public class StadiumService implements IStadiumService {
    @Autowired
    StadiumRepository repository;
    @Override
    public List<Stadium> getAll() {
        return (List<Stadium>)repository.findAll();
    }

    @Override
    public Stadium insert(Stadium stadium) {
        return repository.save(stadium);
    }

    @Override
    public Stadium update(Stadium stadium) {
        return repository.save(stadium);
    }

    @Override
    public Stadium getById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
