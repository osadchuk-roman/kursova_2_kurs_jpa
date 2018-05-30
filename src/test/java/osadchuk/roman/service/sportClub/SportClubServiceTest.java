package osadchuk.roman.service.sportClub;

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
import osadchuk.roman.model.SportCategory;
import osadchuk.roman.model.SportClub;
import osadchuk.roman.repository.SportCategoryRepository;
import osadchuk.roman.repository.SportClubRepository;
import osadchuk.roman.service.sportCategory.SportCategoryService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class SportClubServiceTest {
    @Mock
    SportClubRepository repository;
    @InjectMocks
    SportClubService service;

    List<SportClub> list;
    List<SportClub> all;
    SportClub obj;
    SportClub obj1;
    Optional<SportClub> optional;
    int id;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        list=new ArrayList<>(Arrays.asList(
                new SportClub("tratata","dvgseg","35667Y","fsbhfhnrrftm"),
                new SportClub("brw","dvgseg","235","GN"),
                new SportClub("rbetbn","t35","4667","NFNH"),
                new SportClub("tra4g5yj4tata","T4H","36","sffgrn")
        ));
        id=2;
        obj = new SportClub("tratata","dvgseg","2311435","fsbhfhnrrftm");
        Mockito.when(repository.findAll()).thenReturn(list);
        Mockito.when(repository.save((obj))).thenReturn(obj);
        all = service.getAll();
        optional=Optional.of(new SportClub("tratata","dvgseg","2311435","fsbhfhnrrftm"));
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