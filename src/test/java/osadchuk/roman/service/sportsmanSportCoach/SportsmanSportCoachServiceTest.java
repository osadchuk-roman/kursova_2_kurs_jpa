package osadchuk.roman.service.sportsmanSportCoach;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import osadchuk.roman.model.*;
import osadchuk.roman.repository.SportsmanCompetitionRepository;
import osadchuk.roman.repository.SportsmanSportCoachRepository;
import osadchuk.roman.service.sportsmanCompetition.SportsmanCompetitionService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class SportsmanSportCoachServiceTest {
    @Mock
    SportsmanSportCoachRepository repository;
    @InjectMocks
    SportsmanSportCoachService service;

    List<SportsmanSportCoach> list;
    List<SportsmanSportCoach> all;
    SportsmanSportCoach obj;
    SportsmanSportCoach obj1;
    Optional<SportsmanSportCoach> optional;
    int id;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        list=new ArrayList<>(Arrays.asList(
                new SportsmanSportCoach(new Sportsman("rbg",18,"чоловіча",null),
                        new KindOfSport("ytytsdvcysvdc"),null,null),
                new SportsmanSportCoach(new Sportsman("thw",18,"чоловіча",null),
                        new KindOfSport("eth"),null,null),
                new SportsmanSportCoach(new Sportsman("rbnrn",18,"чоловіча",null),
                        new KindOfSport("et"),null,null),
                new SportsmanSportCoach(new Sportsman("ethneryhy",18,"чоловіча",null),
                        new KindOfSport("efwg"),null,null)
        ));
        id=2;
        obj = new SportsmanSportCoach(new Sportsman("rbg",18,"чоловіча",null),
                new KindOfSport("ytytsdvcysvdc"),null,null);
        Mockito.when(repository.findAll()).thenReturn(list);
        Mockito.when(repository.save((obj))).thenReturn(obj);
        all = service.getAll();
        optional=Optional.of(new SportsmanSportCoach(new Sportsman("rbg",18,"чоловіча",null),
                new KindOfSport("ytytsdvcysvdc"),null,null));
        Mockito.when(repository.findById(id)).thenReturn(optional);
    }

    @Test
    public void getAllTest(){
        Assert.assertEquals(all,list);
    }

    @Test public void getFirst(){
        Assert.assertEquals(all.get(0),list.get(0));
    }

    @Test public void getMiddle(){
        Assert.assertEquals(all.get(2),list.get(2));
    }

    @Test public void getLast(){
        Assert.assertEquals(all.get(all.size()-1),list.get(list.size()-1));
    }

    @Test public void getById(){
        obj1=service.getById(id);
        Assert.assertEquals(optional.get(),obj1);
    }
}