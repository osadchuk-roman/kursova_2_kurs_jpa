package osadchuk.roman.service.sportBuildingSport;

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
import osadchuk.roman.model.SportBuilding;
import osadchuk.roman.model.SportBuildingSport;
import osadchuk.roman.repository.SportBuildingRepository;
import osadchuk.roman.repository.SportBuildingSportRepository;
import osadchuk.roman.service.sportBuilding.SportBuildingService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class SportBuildingSportServiceTest {
    @Mock
    SportBuildingSportRepository repository;
    @InjectMocks
    SportBuildingSportService service;

    List<SportBuildingSport> list;
    List<SportBuildingSport> all;
    SportBuildingSport obj;
    SportBuildingSport obj1;
    Optional<SportBuildingSport> optional;
    int id;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        list=new ArrayList<>(Arrays.asList(
                new SportBuildingSport(
                        new SportBuilding("adadfsf",null,"5","gn"),
                        new KindOfSport("taradf")),
                new SportBuildingSport(
                        new SportBuilding("g4ethj",null,"45","gnrfn"),
                        new KindOfSport("eg")),
                new SportBuildingSport(
                        new SportBuilding("3thb",null,"2334245","bthn"),
                        new KindOfSport("g4th4th")),
                new SportBuildingSport(
                        new SportBuilding("adadfsf",null,"66y","232re3rdsfdevg"),
                        new KindOfSport("rhbrtnb"))
        ));
        id=2;
        obj = new SportBuildingSport(
                new SportBuilding("adadfsf",null,"2334245","232re3rdsfdevg"),
                new KindOfSport("taradf"));
        Mockito.when(repository.findAll()).thenReturn(list);
        Mockito.when(repository.save((obj))).thenReturn(obj);
        all = service.getAll();
        optional=Optional.of(new SportBuildingSport(
                new SportBuilding("adadfsf",null,"2334245","232re3rdsfdevg"),
                new KindOfSport("taradf")));
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