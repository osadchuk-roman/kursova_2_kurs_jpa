package osadchuk.roman.service.coach;

import org.hibernate.validator.constraints.EAN;
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
import osadchuk.roman.repository.CoachRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class CoachServiceTest {
    @Mock
    CoachRepository repository;
    @InjectMocks
    CoachService service;

    List<Coach> list;
    Coach coach;
    Coach coach1;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        list=new ArrayList<>(Arrays.asList(
                new Coach("coach0",null),
                new Coach("coach1",null),
                new Coach("coach2",null),
                new Coach("coach3",null)
        ));

        coach = new Coach("coach", null);
        Mockito.when(repository.findAll()).thenReturn(list);
        Mockito.when(repository.save((coach))).thenReturn(coach);
    }

    @Test public void getAllTest(){
       List<Coach> all = service.getAll();
       Assert.assertEquals(all,list);
    }

    @Test public void getFirst(){
       List<Coach> all = service.getAll();
       Assert.assertEquals(all.get(0),list.get(0));
    }

    @Test public void getMiddle(){
       List<Coach> all = service.getAll();
       Assert.assertEquals(all.get(2),list.get(2));
    }

    @Test public void getLast(){
       List<Coach> all = service.getAll();
       Assert.assertEquals(all.get(all.size()-1),list.get(list.size()-1));
    }

    @Test public void getById(){
        int id = 2;
        Optional<Coach> coach=Optional.of(new Coach(null,null));
        Mockito.when(repository.findById(id)).thenReturn(coach);
        Coach coach1=service.getById(id);
        Assert.assertEquals(coach.get(),coach1);
    }

}