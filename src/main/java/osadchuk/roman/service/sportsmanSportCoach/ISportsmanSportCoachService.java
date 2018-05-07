package osadchuk.roman.service.sportsmanSportCoach;

import osadchuk.roman.model.SportsmanSportCoach;

import java.util.List;

public interface ISportsmanSportCoachService {
    List<SportsmanSportCoach> getAll();
    SportsmanSportCoach insert(SportsmanSportCoach sportsmanSportCoach);
    SportsmanSportCoach update(SportsmanSportCoach sportsmanSportCoach);
    SportsmanSportCoach getById(int id);
    void delete(int id);
}
