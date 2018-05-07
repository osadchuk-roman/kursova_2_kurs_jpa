package osadchuk.roman.service.organizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osadchuk.roman.model.Organizer;
import osadchuk.roman.repository.OrganizerRepository;

import java.util.List;

@Service
public class OrganizerService implements IOrganizerService {
    @Autowired
    OrganizerRepository repository;
    @Override
    public List<Organizer> getAll() {
        return (List<Organizer>)repository.findAll();
    }

    @Override
    public Organizer insert(Organizer organizer) {
        return repository.save(organizer);
    }

    @Override
    public Organizer update(Organizer organizer) {
        return repository.save(organizer);
    }

    @Override
    public Organizer getById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
