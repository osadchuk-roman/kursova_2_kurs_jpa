package osadchuk.roman.service.sportsman;

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
import osadchuk.roman.model.SportClub;
import osadchuk.roman.model.Sportsman;
import osadchuk.roman.repository.SportClubRepository;
import osadchuk.roman.repository.SportsmanRepository;
import osadchuk.roman.service.sportClub.SportClubService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class SportsmanServiceTest {
    @Mock
    SportsmanRepository repository;
    @InjectMocks
    SportsmanService service;

    List<Sportsman> list;
    List<Sportsman> all;
    Sportsman obj;
    Sportsman obj1;
    Optional<Sportsman> optional;
    int id;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        list=new ArrayList<>(Arrays.asList(
                new Sportsman("tratata",18,"чоловіча",null),
                new Sportsman("eth",23,"чоловіча",null),
                new Sportsman("vrthb148",12,"чоловіча",null),
                new Sportsman("rbg",18,"чоловіча",null)
        ));
        id=2;
        obj = new Sportsman("tratata",18,"чоловіча",null);
        Mockito.when(repository.findAll()).thenReturn(list);
        Mockito.when(repository.save((obj))).thenReturn(obj);
        all = service.getAll();
        optional=Optional.of(new Sportsman("tratata",18,"чоловіча",null));
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