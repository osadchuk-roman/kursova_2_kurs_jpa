package osadchuk.roman.service.court;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osadchuk.roman.model.Court;
import osadchuk.roman.repository.CourtRepository;

import java.util.List;
@Service
public class CourtService implements ICourtService {
    @Autowired
    CourtRepository repository;

    @Override
    public List<Court> getAll() {
        return (List<Court>)repository.findAll();
    }

    @Override
    public Court getById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public Court insert(Court court) {
        return repository.save(court);
    }

    @Override
    public Court update(Court court) {
        return repository.save(court);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
