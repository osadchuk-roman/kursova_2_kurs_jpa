package osadchuk.roman.service.sportBuildingSport;

import osadchuk.roman.model.SportBuildingSport;

import java.util.List;

public interface ISportBuildingSportService {
    List<SportBuildingSport> getAll();
    SportBuildingSport insert(SportBuildingSport sportBuildingSport);
    SportBuildingSport update(SportBuildingSport sportBuildingSport);
    SportBuildingSport getById(int id);
    void delete(int id);
}
