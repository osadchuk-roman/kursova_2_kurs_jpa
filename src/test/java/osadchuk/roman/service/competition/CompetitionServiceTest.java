package osadchuk.roman.service.competition;

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
import osadchuk.roman.model.Coach;
import osadchuk.roman.model.Competition;
import osadchuk.roman.repository.CoachRepository;
import osadchuk.roman.repository.CompetitionRepository;
import osadchuk.roman.service.coach.CoachService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class CompetitionServiceTest {
    @Mock
    CompetitionRepository repository;
    @InjectMocks
    CompetitionService service;

    List<Competition> list;
    List<Competition> all;
    Competition obj;
    Competition obj1;
    Optional<Competition> optional;
    int id;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        list=new ArrayList<>(Arrays.asList(
                new Competition("test", null,null,null,null),
                new Competition("test", null,null,null,null),
                new Competition("test", null,null,null,null),
                new Competition("test", null,null,null,null)
        ));
        id=2;
        obj = new Competition("test", null,null,null,null);
        Mockito.when(repository.findAll()).thenReturn(list);
        Mockito.when(repository.save((obj))).thenReturn(obj);
        all = service.getAll();
        optional=Optional.of(new Competition("test", null,null,null,null));
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