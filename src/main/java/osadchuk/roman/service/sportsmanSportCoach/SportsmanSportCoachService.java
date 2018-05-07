package osadchuk.roman.service.sportsmanSportCoach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osadchuk.roman.model.SportsmanSportCoach;
import osadchuk.roman.repository.SportsmanSportCoachRepository;

import java.util.List;

@Service
public class SportsmanSportCoachService implements ISportsmanSportCoachService {
    @Autowired
    SportsmanSportCoachRepository repository;
    @Override
    public List<SportsmanSportCoach> getAll() {
        return (List<SportsmanSportCoach>)repository.findAll();
    }

    @Override
    public SportsmanSportCoach insert(SportsmanSportCoach sportsmanSportCoach) {
        return repository.save(sportsmanSportCoach);
    }

    @Override
    public SportsmanSportCoach update(SportsmanSportCoach sportsmanSportCoach) {
        return repository.save(sportsmanSportCoach);
    }

    @Override
    public SportsmanSportCoach getById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
