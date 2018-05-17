package osadchuk.roman.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import osadchuk.roman.model.Competition;
import osadchuk.roman.model.Organizer;
import osadchuk.roman.requestModel.OrganizerAndAmountOfCompetitions;

import java.sql.Date;
import java.util.List;

@Repository

public interface CompetitionRepository extends JpaRepository<Competition,Integer> {
    @Query("select com from Competition com where com.date between :date1 and :date2")
    List<Competition> getCompetitionByDateInterval(@Param("date1")Date date1, @Param("date2")Date date2);

    @Query("select com from Competition com where com.organizer.id=:organizer " +
            "and com.date between :date1 and :date2")
    List<Competition> getCompetitionByDateIntervalAndOrganizer(
            @Param("date1")Date date1, @Param("date2")Date date2, @Param("organizer")int organizerId);

    @Query("select com from Competition com where com.sportBuilding.id=:sportBuilding ")
    List<Competition> getCompetitionsByBuilding(@Param("sportBuilding")int sportBuildingId);

    @Query("select com from Competition com where com.kindOfSport.id=:sport")
    List<Competition> getCompetitionsSport(@Param("sport")int sportId);

    @Query("select com from Competition com where com.date between :date1 and :date2")
    List<Competition> getSportBuildingByDateInterval(@Param("date1")Date date1, @Param("date2")Date date2);

    @Query("select com.organizer from Competition com " +
            "where com.date between :date1 and :date2 " +
            "group by com.organizer.id order by com.organizer.id"
    )
    List<Organizer> getOrganizerByDateInterval(@Param("date1")Date date1, @Param("date2")Date date2);

    @Query("select count (com.organizer.id) from Competition com " +
            "where com.date between :date1 and :date2 " +
            "group by com.organizer.id order by com.organizer.id"
    )
    List<Long> getAmountOfCompetitionsByDateInterval(@Param("date1")Date date1, @Param("date2")Date date2);





}
