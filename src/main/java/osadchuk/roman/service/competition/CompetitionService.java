package osadchuk.roman.service.competition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osadchuk.roman.model.Coach;
import osadchuk.roman.model.Competition;
import osadchuk.roman.repository.CoachRepository;
import osadchuk.roman.repository.CompetitionRepository;

import java.util.List;

@Service
public class CompetitionService implements ICompetitionService {
    @Autowired
    CompetitionRepository repository;
    @Override
    public List<Competition> getAll() {
        return (List<Competition>)repository.findAll();
    }

    @Override
    public Competition insert(Competition competition) {
        return repository.save(competition);
    }

    @Override
    public Competition update(Competition competition) {
        return repository.save(competition);
    }

    @Override
    public Competition getById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
