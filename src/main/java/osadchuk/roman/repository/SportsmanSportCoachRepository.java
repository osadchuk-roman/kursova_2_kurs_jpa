package osadchuk.roman.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import osadchuk.roman.model.Coach;
import osadchuk.roman.model.Sportsman;
import osadchuk.roman.model.SportsmanSportCoach;

import java.util.List;

@Repository
public interface SportsmanSportCoachRepository extends JpaRepository<SportsmanSportCoach,Integer> {
    @Query("select distinct ssc.sportsman from SportsmanSportCoach ssc " +
            "where ssc.kindOfSport.id=:sport order by ssc.sportsman.id")
    List<Sportsman> getSportsmanBySport(@Param("sport")int sport);

    @Query("select distinct ssc from SportsmanSportCoach ssc " +
            "where ssc.kindOfSport.id=:sport " +
            "and ssc.sportCategory.id<=:sportCategory " +
            "order by ssc.sportsman.id")
    List<SportsmanSportCoach> getSportsmanBySportAndSportCategory(
            @Param("sport")int sport, @Param("sportCategory")int sportCategory);

    @Query("select distinct ssc.sportsman from SportsmanSportCoach ssc " +
            "where ssc.coach.id=:coach order by ssc.sportsman.id")
    List<Sportsman> getSportsmanByCoach(@Param("coach")int coach);

    @Query("select distinct ssc from SportsmanSportCoach ssc " +
            "where ssc.coach.id=:coach  " +
            "and ssc.sportCategory.id<=:sportCategory " +
            "order by ssc.sportsman.id")
    List<SportsmanSportCoach> getSportsmanByCoachAndSportCategory(
            @Param("coach")int coach, @Param("sportCategory")int sportCategory );

    @Query("select ssc from SportsmanSportCoach ssc " +
            "where ssc.sportsman.name in " +
            "(select ssc2.sportsman.name from SportsmanSportCoach ssc2 " +
            "group by ssc2.sportsman.name having count(ssc2.sportsman.id)>1 " +
            "and count (distinct ssc2.kindOfSport.id)>=2)order by ssc.sportsman.id")
    List<SportsmanSportCoach> getSportsmenAndTheirSport();

    @Query("select ssc from SportsmanSportCoach ssc where ssc.sportsman.id=:sportsman")
    List<SportsmanSportCoach> getCoachesBySportsman(@Param("sportsman")int sportsman );

    @Query("select distinct ssc.coach from SportsmanSportCoach ssc where ssc.kindOfSport.id=:sport")
    List<Coach> getCoachesBySport(@Param("sport")int sport );
}
