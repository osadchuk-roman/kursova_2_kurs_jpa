package osadchuk.roman.service.sportArena;

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
import osadchuk.roman.model.Pool;
import osadchuk.roman.model.SportArena;
import osadchuk.roman.repository.PoolRepository;
import osadchuk.roman.repository.SportArenaRepository;
import osadchuk.roman.service.pool.PoolService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class SportArenaServiceTest {
    @Mock
    SportArenaRepository repository;
    @InjectMocks
    SportArenaService service;

    List<SportArena> list;
    List<SportArena> all;
    SportArena obj;
    SportArena obj1;
    Optional<SportArena> optional;
    int id;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        list=new ArrayList<>(Arrays.asList(
                new SportArena(null,1,true,true,true),
                new SportArena(null,2,true,true,true),
                new SportArena(null,3,true,true,true),
                new SportArena(null,4,true,true,true)
        ));
        id=2;
        obj = new SportArena(null,1,true,true,true);
        Mockito.when(repository.findAll()).thenReturn(list);
        Mockito.when(repository.save((obj))).thenReturn(obj);
        all = service.getAll();
        optional=Optional.of(new SportArena(null,1,true,true,true));
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