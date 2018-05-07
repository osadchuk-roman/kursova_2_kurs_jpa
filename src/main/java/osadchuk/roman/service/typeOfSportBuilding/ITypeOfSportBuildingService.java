package osadchuk.roman.service.typeOfSportBuilding;

import osadchuk.roman.model.TypeOfSportBuilding;

import java.util.List;

public interface ITypeOfSportBuildingService {
    List<TypeOfSportBuilding> getAll();
    TypeOfSportBuilding insert(TypeOfSportBuilding typeOfSportBuilding);
    TypeOfSportBuilding update(TypeOfSportBuilding typeOfSportBuilding);
    TypeOfSportBuilding getById(int id);
    void delete(int id);
}
