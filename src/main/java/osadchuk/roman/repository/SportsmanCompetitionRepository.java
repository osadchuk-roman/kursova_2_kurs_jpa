package osadchuk.roman.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import osadchuk.roman.model.SportClub;
import osadchuk.roman.model.Sportsman;
import osadchuk.roman.model.SportsmanCompetition;

import java.sql.Date;
import java.util.List;

@Repository
public interface SportsmanCompetitionRepository extends JpaRepository<SportsmanCompetition,Integer> {
    @Query("select sc from SportsmanCompetition sc " +
            "where sc.competition.id=:competition " +
            "and sc.prizePlace in (1,2,3) " +
            "order by sc.prizePlace")
    List<SportsmanCompetition> getWinnersByCompetition(@Param("competition") int competitionId);

    @Query("select sc from SportsmanCompetition sc " +
            "where sc.competition.id=:competition " +
            "order by sc.prizePlace")
    List<SportsmanCompetition> getAllParticipantsByCompetition(@Param("competition") int competitionId);

    @Query("select sc.sportsman.sportClub from SportsmanCompetition sc " +
            "where sc.competition.date between :date1 and :date2 " +
            "group by sc.sportsman.sportClub.id " +
            "order by sc.sportsman.sportClub.id")
    List<SportClub> getSportClubByDateInterval(@Param("date1")Date date1, @Param("date2")Date date2);


    @Query("select count (distinct sc.sportsman.id)from SportsmanCompetition sc " +
            "where sc.competition.date between :date1 and :date2 " +
            "group by sc.sportsman.sportClub.id " +
            "order by sc.sportsman.sportClub.id")
    List<Long> getAmountOfSportsmenByDateInterval(@Param("date1")Date date1, @Param("date2")Date date2);




}
