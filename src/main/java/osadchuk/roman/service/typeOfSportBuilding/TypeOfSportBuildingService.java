package osadchuk.roman.service.typeOfSportBuilding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osadchuk.roman.model.TypeOfSportBuilding;
import osadchuk.roman.repository.TypeOfSportBuildingRepository;

import java.util.List;

@Service
public class TypeOfSportBuildingService implements ITypeOfSportBuildingService {
    @Autowired
    TypeOfSportBuildingRepository repository;
    @Override
    public List<TypeOfSportBuilding> getAll() {
        return (List<TypeOfSportBuilding>)repository.findAll();
    }

    @Override
    public TypeOfSportBuilding insert(TypeOfSportBuilding typeOfSportBuilding) {
        return repository.save(typeOfSportBuilding);
    }

    @Override
    public TypeOfSportBuilding update(TypeOfSportBuilding typeOfSportBuilding) {
        return repository.save(typeOfSportBuilding);
    }

    @Override
    public TypeOfSportBuilding getById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
