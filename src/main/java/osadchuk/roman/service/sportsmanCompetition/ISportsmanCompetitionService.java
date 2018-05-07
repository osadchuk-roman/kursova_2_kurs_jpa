package osadchuk.roman.service.sportsmanCompetition;

import osadchuk.roman.model.SportsmanCompetition;

import java.util.List;

public interface ISportsmanCompetitionService {
    List<SportsmanCompetition> getAll();
    SportsmanCompetition insert(SportsmanCompetition sportsmanCompetition);
    SportsmanCompetition update(SportsmanCompetition sportsmanCompetition);
    SportsmanCompetition getById(int id);
    void delete(int id);
}
