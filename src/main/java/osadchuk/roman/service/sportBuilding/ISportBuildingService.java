package osadchuk.roman.service.sportBuilding;

import osadchuk.roman.model.SportBuilding;

import java.util.List;

public interface ISportBuildingService {
    List<SportBuilding> getAll();
    SportBuilding insert(SportBuilding sportBuilding);
    SportBuilding update(SportBuilding sportBuilding);
    SportBuilding getById(int id);
    void delete(int id);
}
