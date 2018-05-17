package osadchuk.roman.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import osadchuk.roman.model.Sportsman;
import osadchuk.roman.model.SportsmanCompetition;

import java.sql.Date;
import java.util.List;

@Repository
public interface SportsmanRepository extends JpaRepository<Sportsman,Integer> {

    @Query( "select sm from Sportsman sm where sm.id not in" +
            "(select sman.id from Sportsman sman left join SportsmanCompetition  scom " +
            "on sman.id = scom.sportsman.id where scom.competition.date " +
            "between :date1 and :date2)")
    List<Sportsman>getSportsmenNotCompetitionParticipantsByDateInterval(
            @Param("date1") Date firstDate, @Param("date2") Date secondDate);

    @Query( "select sm from Sportsman sm where sm.sportClub.id = :sportClub " +
            "order by sm.id")
    List<Sportsman>getSportsmanBySportClub( @Param("sportClub") int sportClubId);
}
