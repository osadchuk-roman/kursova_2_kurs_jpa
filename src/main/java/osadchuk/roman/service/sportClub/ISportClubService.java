package osadchuk.roman.service.sportClub;

import osadchuk.roman.model.SportClub;

import java.util.List;

public interface ISportClubService {
    List<SportClub> getAll();
    SportClub insert(SportClub sportClub);
    SportClub update(SportClub sportClub);
    SportClub getById(int id);
    void delete(int id);
}
