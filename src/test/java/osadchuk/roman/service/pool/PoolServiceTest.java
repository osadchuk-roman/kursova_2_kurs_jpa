package osadchuk.roman.service.pool;

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
import osadchuk.roman.model.Organizer;
import osadchuk.roman.model.Pool;
import osadchuk.roman.repository.OrganizerRepository;
import osadchuk.roman.repository.PoolRepository;
import osadchuk.roman.service.organizer.OrganizerService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class PoolServiceTest {
    @Mock
    PoolRepository repository;
    @InjectMocks
    PoolService service;

    List<Pool> list;
    List<Pool> all;
    Pool obj;
    Pool obj1;
    Optional<Pool> optional;
    int id;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        list=new ArrayList<>(Arrays.asList(
                new Pool(null,2752,2,3,4),
                new Pool(null,225,2,2,247),
                new Pool(null,1254,2,227,4),
                new Pool(null,88,2,25,4)
        ));
        id=2;
        obj = new Pool(null,1,2,3,4);
        Mockito.when(repository.findAll()).thenReturn(list);
        Mockito.when(repository.save((obj))).thenReturn(obj);
        all = service.getAll();
        optional=Optional.of(new Pool(null,1,2,3,4));
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