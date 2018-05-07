package osadchuk.roman.service.sportsmanCompetition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osadchuk.roman.model.SportsmanCompetition;
import osadchuk.roman.repository.SportsmanCompetitionRepository;

import java.util.List;

@Service
public class SportsmanCompetitionService implements ISportsmanCompetitionService {
    @Autowired
    SportsmanCompetitionRepository repository;
    @Override
    public List<SportsmanCompetition> getAll() {
        return (List<SportsmanCompetition>)repository.findAll();
    }

    @Override
    public SportsmanCompetition insert(SportsmanCompetition sportsmanCompetition) {
        return repository.save(sportsmanCompetition);
    }

    @Override
    public SportsmanCompetition update(SportsmanCompetition sportsmanCompetition) {
        return repository.save(sportsmanCompetition);
    }

    @Override
    public SportsmanCompetition getById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
