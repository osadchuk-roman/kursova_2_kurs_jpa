package osadchuk.roman.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import osadchuk.roman.model.SportBuilding;
import osadchuk.roman.model.SportBuildingSport;

import java.util.List;

@Repository
public interface SportBuildingSportRepository extends JpaRepository<SportBuildingSport,Integer> {
    @Query("select sbs.sportBuilding from SportBuildingSport sbs " +
            "where sbs.sportBuilding.typeOfSportBuilding.id=:type and " +
            "sbs.kindOfSport.id=:sport")
    List<SportBuilding> getSportBuildingByTypeAndSport(@Param("type")int type,@Param("sport")int sport);
}
