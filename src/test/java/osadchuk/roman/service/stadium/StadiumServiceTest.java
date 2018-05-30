package osadchuk.roman.service.stadium;

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
import osadchuk.roman.model.KindOfSport;
import osadchuk.roman.model.Sportsman;
import osadchuk.roman.model.SportsmanSportCoach;
import osadchuk.roman.model.Stadium;
import osadchuk.roman.repository.SportsmanSportCoachRepository;
import osadchuk.roman.repository.StadiumRepository;
import osadchuk.roman.service.sportsmanSportCoach.SportsmanSportCoachService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class StadiumServiceTest {
    @Mock
    StadiumRepository repository;
    @InjectMocks
    StadiumService service;

    List<Stadium> list;
    List<Stadium> all;
    Stadium obj;
    Stadium obj1;
    Optional<Stadium> optional;
    int id;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        list=new ArrayList<>(Arrays.asList(
                new Stadium(null,2330,233.431,true, false),
                new Stadium(null,36,6454,true, false),
                new Stadium(null,145626,6,true, false),
                new Stadium(null,233260,6.431,true, false)
        ));
        id=2;
        obj = new Stadium(null,2330,233.431,true, false);
        Mockito.when(repository.findAll()).thenReturn(list);
        Mockito.when(repository.save((obj))).thenReturn(obj);
        all = service.getAll();
        optional=Optional.of(new Stadium(null,2330,233.431,true, false));
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