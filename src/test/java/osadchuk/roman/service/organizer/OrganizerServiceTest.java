package osadchuk.roman.service.organizer;

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
import osadchuk.roman.model.Organizer;
import osadchuk.roman.repository.KindOfSportRepository;
import osadchuk.roman.repository.OrganizerRepository;
import osadchuk.roman.service.kindOfSport.KindOfSportService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class OrganizerServiceTest {
    @Mock
    OrganizerRepository repository;
    @InjectMocks
    OrganizerService service;

    List<Organizer> list;
    List<Organizer> all;
    Organizer obj;
    Organizer obj1;
    Optional<Organizer> optional;
    int id;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        list=new ArrayList<>(Arrays.asList(
                new Organizer("adgefbh","djvnijsvn","34645648","b"),
                new Organizer("vdsa","gr","232143457134234","sbs"),
                new Organizer("vasregv","edghb","7647","gfawef"),
                new Organizer("abgeb","nbgg","5848w463","dvefabvsarhthrthebaq")
        ));
        id=2;
        obj = new Organizer("organizer","djvnijsvn","23214134234","dvefabvsebaq");
        Mockito.when(repository.findAll()).thenReturn(list);
        Mockito.when(repository.save((obj))).thenReturn(obj);
        all = service.getAll();
        optional=Optional.of(new Organizer("organizer","djvnijsvn","23214134234","dvefabvsebaq"));
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