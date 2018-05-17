package osadchuk.roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import osadchuk.roman.model.*;
import osadchuk.roman.requestModel.OrganizerAndAmountOfCompetitions;
import osadchuk.roman.requestModel.SportClubAndAmountOfSportsmen;
import osadchuk.roman.service.request.RequestService;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RequestController {
    @Autowired
    RequestService service;
    @RequestMapping("/request1_1")
    List<SportBuilding> getSportBuildingByType(@RequestParam int type_id){
        return service.getSportBuildingByType(type_id);
    }

    @RequestMapping("/request1_2")
    List<SportBuilding> getSportBuildingByTypeAndSport(@RequestParam int type_id, int sport_id){
        return service.getSportBuildingByTypeAndSport(type_id,sport_id);
    }

    @RequestMapping("/request2_1")
    List<Sportsman> getSportsmanBySport(@RequestParam int sport_id){
        return service.getSportsmanBySport(sport_id);
    }

    @RequestMapping("/request2_2")
    List<SportsmanSportCoach> getSportsmanBySportAndCategory(@RequestParam  int sport_id, int category_id){
        return service.getSportsmanBySportAndCategory(sport_id,category_id);
    }


    @RequestMapping("/request3_1")
    List<Sportsman> getSportsmanByCoach(@RequestParam int coach_id){
        return service.getSportsmanByCoach(coach_id);
    }

    @RequestMapping("/request3_2")
    List<SportsmanSportCoach> getSportsmanByCoachAndCategory(@RequestParam  int coach_id, int category_id){
        return service.getSportsmanByCoachAndCategory(coach_id,category_id);
    }

    @RequestMapping("/request3_3")
    List<Sportsman> getSportsmanBySportClub(@RequestParam  int sportClub_id){
        return service.getSportsmanBySportClub(sportClub_id);
    }

    @RequestMapping("/request4")
    List<SportsmanSportCoach> getSportsmenAndTheirSports(){
        return service.getSportsmenAndTheirSports();
    }

    @RequestMapping("/request5")
    List<SportsmanSportCoach> getCoachesBySportsman(@RequestParam int sportsman_id){
        return service.getCoachesBySportsman(sportsman_id);
    }

    @RequestMapping("/request6_1")
    List<Competition> getCompetitionByDateInterval(@RequestParam Date firstDate, Date secondDate){
        return service.getCompetitionsByDateInterval(firstDate,secondDate);
    }

    @RequestMapping("/request6_2")
    List<Competition> getCompetitionsByDateIntervalAndOrganizer(
            @RequestParam Date firstDate, Date secondDate, int organizer_id){
        return service.getCompetitionsByDateIntervalAndOrganizer(firstDate,secondDate,organizer_id);
    }

    @RequestMapping("/request7_1")
    List<SportsmanCompetition> getWinnersByCompetition(@RequestParam  int competition_id){
        return service.getWinnersByCompetition(competition_id);
    }

    @RequestMapping("/request7_2")
    List<SportsmanCompetition> getAllParticipantsByCompetition(@RequestParam  int competition_id){
        return service.getAllParticipantsByCompetition(competition_id);
    }

    @RequestMapping("/request8_1")
    List<Competition> getCompetitionsByBuilding(@RequestParam  int building_id){
        return service.getCompetitionsByBuilding(building_id);
    }

    @RequestMapping("/request8_2")
    List<Competition> getCompetitionsBySport(@RequestParam int sport_id){
        return service.getCompetitionsBySport(sport_id);
    }

    @RequestMapping("/request10")
    List<Coach> getCoachesBySport(@RequestParam int sport_id){
        return service.getCoachesBySport(sport_id);
    }

    @RequestMapping("/request9")
    List<SportClubAndAmountOfSportsmen> getSportClubAndSportsmenByDateInterval(
            @RequestParam Date firstDate, Date secondDate){
        return service.getSportClubAndSportsmenByDateInterval(firstDate,secondDate);
    }

    @RequestMapping("/request11")
    List<Sportsman> getSportsmenNotCompetitionParticipantsByDateInterval(
            @RequestParam Date firstDate, Date secondDate ){
        return service.getSportsmenNotCompetitionParticipantsByDateInterval(firstDate,secondDate);
    }

    @RequestMapping("/request12")
    List<OrganizerAndAmountOfCompetitions> getOrganizerCompetitionsByDateInterval(
            @RequestParam Date firstDate, Date secondDate ){
        return service.getOrganizerCompetitionsByDateInterval(firstDate,secondDate);
    }

    @RequestMapping("/request13")
    List<Competition> getSportBuildingByDateInterval(
            @RequestParam Date firstDate, Date secondDate ){
        return service.getSportBuildingByDateInterval(firstDate,secondDate);
    }
}
