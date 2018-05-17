package osadchuk.roman.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import osadchuk.roman.model.SportBuilding;
import osadchuk.roman.model.SportBuildingSport;
import osadchuk.roman.model.TypeOfSportBuilding;

import java.util.List;

@Repository

public interface SportBuildingRepository extends JpaRepository<SportBuilding,Integer> {

    @Query("select sb from SportBuilding sb where sb.typeOfSportBuilding.id=:type")
    List<SportBuilding> getSportBuildingByType(@Param("type")int type);
}
