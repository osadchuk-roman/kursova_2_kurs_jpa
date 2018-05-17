package osadchuk.roman.service.request;

import osadchuk.roman.model.*;
import osadchuk.roman.requestModel.OrganizerAndAmountOfCompetitions;
import osadchuk.roman.requestModel.SportClubAndAmountOfSportsmen;

import java.sql.Date;
import java.util.List;

public interface IRequestService {
    //1.1
    List<SportBuilding> getSportBuildingByType(int typeId);
    //1.2
    List<SportBuilding> getSportBuildingByTypeAndSport (int typeId, int sportId);
    //2.1
    List<Sportsman> getSportsmanBySport(int sportId);
    //2.2
    List<SportsmanSportCoach> getSportsmanBySportAndCategory(int sportId, int sportCategoryId);
    //3.1
    List<Sportsman> getSportsmanByCoach(int coachId);
    //3.2
    List<SportsmanSportCoach> getSportsmanByCoachAndCategory(int coachId, int sportCategoryId);
    //3.3
    List<Sportsman> getSportsmanBySportClub(int sportClubId);
    //4
    List<SportsmanSportCoach> getSportsmenAndTheirSports();
    //5
    List<SportsmanSportCoach> getCoachesBySportsman(int sportsmanId);
    //6.1
    List<Competition> getCompetitionsByDateInterval(Date firstDate, Date secondDate);
    //6.2
    List<Competition> getCompetitionsByDateIntervalAndOrganizer(
            Date firstDate, Date secondDate, int organizerId);
    //7.1
    List<SportsmanCompetition> getWinnersByCompetition(int competitionId);
    //7.2
    List<SportsmanCompetition> getAllParticipantsByCompetition(int competitionId);
    //8.1
    List<Competition> getCompetitionsByBuilding(int sportBuildingId);
    //8.2
    List<Competition> getCompetitionsBySport(int sportId);
    //9
    List<SportClubAndAmountOfSportsmen> getSportClubAndSportsmenByDateInterval(Date firstDate, Date secondDate);
    //10
    List<Coach> getCoachesBySport(int sportId);
    //11
    List<Sportsman> getSportsmenNotCompetitionParticipantsByDateInterval(Date firstDate, Date secondDate);
    //12
    List<OrganizerAndAmountOfCompetitions> getOrganizerCompetitionsByDateInterval(Date firstDate, Date secondDate);
    //13
    List<Competition> getSportBuildingByDateInterval(Date firstDate, Date secondDate);

}
