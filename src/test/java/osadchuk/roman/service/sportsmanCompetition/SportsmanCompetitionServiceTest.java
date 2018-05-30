package osadchuk.roman.service.sportsmanCompetition;

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
import osadchuk.roman.model.Competition;
import osadchuk.roman.model.Sportsman;
import osadchuk.roman.model.SportsmanCompetition;
import osadchuk.roman.repository.SportsmanCompetitionRepository;
import osadchuk.roman.repository.SportsmanRepository;
import osadchuk.roman.service.sportsman.SportsmanService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class SportsmanCompetitionServiceTest {
    @Mock
    SportsmanCompetitionRepository repository;
    @InjectMocks
    SportsmanCompetitionService service;

    List<SportsmanCompetition> list;
    List<SportsmanCompetition> all;
    SportsmanCompetition obj;
    SportsmanCompetition obj1;
    Optional<SportsmanCompetition> optional;
    int id;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        list=new ArrayList<>(Arrays.asList(
                new SportsmanCompetition(new Sportsman("rbg",18,"чоловіча",null),
                        new Competition("ujsdbuefvb",null,null,null,null),1),
                new SportsmanCompetition(new Sportsman("rbg",18,"чоловіча",null),
                        new Competition("ujsdbuefvb",null,null,null,null),4),
                new SportsmanCompetition(new Sportsman("rbg",18,"чоловіча",null),
                        new Competition("ujsdbuefvb",null,null,null,null),3),
                new SportsmanCompetition(new Sportsman("rbg",18,"чоловіча",null),
                        new Competition("ujsdbuefvb",null,null,null,null),2)
        ));
        id=2;
        obj = new SportsmanCompetition(new Sportsman("rbg",18,"чоловіча",null),
                new Competition("ujsdbuefvb",null,null,null,null),1);
        Mockito.when(repository.findAll()).thenReturn(list);
        Mockito.when(repository.save((obj))).thenReturn(obj);
        all = service.getAll();
        optional=Optional.of(new SportsmanCompetition(new Sportsman("rbg",18,"чоловіча",null),
                new Competition("ujsdbuefvb",null,null,null,null),1));
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