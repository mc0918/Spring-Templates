package ${PACKAGE_NAME};

#if(${FEIGN_CLIENT_CLASS} !="")import feign.FeignException;#end
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

public class ${NAME} {
/*
YOU MIGHT NEED TO CHANGE THINGS (LIKE METHOD NAMES) TO MATCH WITH JPA
in which case the methods should be:
    save(o), getOne(id), finadAll(), save(o) bc update is save again, deleteById(id)
*/
    #if(${FEIGN_CLIENT_CLASS}!="")
    private static final ${FEIGN_OBJECT} ${FEIGN_OBJECT}_NO_ID = new ${FEIGN_OBJECT}(//fill me out bruhv);
    private static final ${FEIGN_OBJECT} ${FEIGN_OBJECT}_ID = new ${FEIGN_OBJECT}(//fill me out bruhv);
    private static final ${FEIGN_OBJECT} ${FEIGN_OBJECT}_UPDATED = new ${FEIGN_OBJECT}(//fill me out bruhv);
    private static final ${FEIGN_OBJECT} ${FEIGN_OBJECT}_BAD_UPDATE = new ${FEIGN_OBJECT}(//fill me out bruhv);
    private static final List<${FEIGN_OBJECT}> ${FEIGN_OBJECT}_LIST = new ArrayList<>(Arrays.asList(${FEIGN_OBJECT}_ID));
    #end

    #if(${DAO_CLASS}!="")
    private static final ${DAO_OBJECT} ${DAO_OBJECT}_NO_ID = new ${DAO_OBJECT}(//fill me out bruhv);
    private static final ${DAO_OBJECT} ${DAO_OBJECT}_ID = new ${DAO_OBJECT}(//fill me out bruhv);
    private static final ${DAO_OBJECT} ${DAO_OBJECT}_UPDATED = new ${DAO_OBJECT}(//fill me out bruhv);
    private static final ${DAO_OBJECT} ${DAO_OBJECT}_BAD_UPDATE = new ${DAO_OBJECT}(//fill me out bruhv);
    private static final List<${DAO_OBJECT}> ${DAO_OBJECT}_LIST = new ArrayList<>(Arrays.asList(${DAO_OBJECT}_ID));
    #end

    private static final int DNE_ID = 7;
    
    private ${SERVICE_LAYER_CLASS} service;
    #if(${FEIGN_CLIENT_CLASS} != "")private ${FEIGN_CLIENT_CLASS} client;#end
    #if(${DAO_CLASS} != "")private ${DAO_CLASS} repository;#end
    
    @Before
    public void setUp() throws Exception {
        #if(${FEIGN_CLIENT_CLASS}!="")setUpFeignClientMock();#end
        #if(${DAO_CLASS}!="")setUpRepositoryMock();#end
        service = new ServiceLayer(#if(${FEIGN_CLIENT_CLASS}!="")client#end #if(${DAO_CLASS}!="")repository#end);
    }

    #if(${FEIGN_CLIENT_CLASS}!="")
    //feign client tests
    private void setUpFeignClientMock() {
        client = mock(${FEIGN_OBJECT}.class);
        
        doReturn(${FEIGN_OBJECT}_ID).when(client).save${FEIGN_OBJECT}(${FEIGN_OBJECT}_NO_ID);
        doReturn(${FEIGN_OBJECT}_ID).when(client).get${FEIGN_OBJECT}(1);
        doReturn(${FEIGN_OBJECT}_LIST).when(client).getAll${FEIGN_OBJECT}s();
        
        //exceptions
        doThrow(new FeignException.NotFound("Status 404", null)).when(client).get${FEIGN_OBJECT}(DNE_ID); //change the custom exception message at the way way way down bottom of this
    }#end

    #if(${DAO_CLASS} != "")
    //dao or repo tests
    private void setUpRepositoryMock() {
        repository = mock(${DAO_CLASS}.class);

        doReturn(${DAO_OBJECT}_ID).when(repository).save${DAO_OBJECT}(${DAO_OBJECT}_NO_ID);
        doReturn(${DAO_OBJECT}_ID).when(repository).get${DAO_OBJECT}(1);
        doReturn(${DAO_OBJECT}_LIST).when(repository).getAll${DAO_OBJECT}s();
    }#end

    #if(${FEIGN_CLIENT_CLASS}!="")
    @Test
    public void saveFeign${FEIGN_OBJECT}() {
        ${FEIGN_OBJECT} actual = service.save${FEIGN_OBJECT}(${FEIGN_OBJECT}_NO_ID);
        assertEquals(${FEIGN_OBJECT}_ID, actual);
    }

    @Test
    public void getFeign${FEIGN_OBJECT}(){
        ${FEIGN_OBJECT} actual = service.get${FEIGN_OBJECT}(1);
        assertEquals(${FEIGN_OBJECT}_ID, actual);
    }

    @Test
    public void getAllFeign${FEIGN_OBJECT}s(){
        List<${FEIGN_OBJECT}> actual = service.getAll${FEIGN_OBJECT}s();
        assertEquals(${FEIGN_OBJECT}_LIST, actual);
    }

    /*@Test
    public void shouldUpdateFeign${FEIGN_OBJECT}() {
       ${FEIGN_OBJECT} expected = service.update${FEIGN_OBJECT}(EQUIPMENT_LOCATION_1);
       assertEquals(expected, actual);
    }*/ //a sample test for update just in case
    #end

    #if(${DAO_CLASS}!="")
    @Test
    public void save${DAO_OBJECT}() {
        ${DAO_OBJECT} actual = service.save${DAO_OBJECT}(${DAO_OBJECT}_NO_ID);
        assertEquals(${DAO_OBJECT}_ID, actual);
    }

    @Test
    public void get${DAO_OBJECT}(){
        ${DAO_OBJECT} actual = service.get${DAO_OBJECT}(1);
        assertEquals(${DAO_OBJECT}_ID, actual);
    }
    
    @Test
    public void getAll${DAO_OBJECT}s(){
        List<${DAO_OBJECT}> actual = service.getAll${DAO_OBJECT}s();
        assertEquals(${DAO_OBJECT}_LIST, actual);
    }
    
    /*@Test
    public void shouldUpdate${DAO_OBJECT}() {
       ${DAO_OBJECT} expected = service.update${DAO_OBJECT}(EQUIPMENT_LOCATION_1);
       assertEquals(expected, actual);
    }*/ //a sample test for update just in case
    #end
////////////////////////////////////////////////////////////

/*    @Test(expected = NoSuchEquipmentException.class)
    public void shouldThrowExceptionWhenUpdateObjectWithBadId() {
      
        //arrange (all the setup above)
        //act
        Object whatWeGot = service.updateObject(STATIC_FINAL_OBJECT);
        fail("Should have thrown an exception");
    }*/
    
    //test for custom exception
    @Test(expected = ${EXCEPTION_CLASS}.class)
    public void throws${EXCEPTION_CLASS}(){
        ${DAO_OBJECT} actual = service.save${DAO_OBJECT}(${DAO_OBJECT}_BAD_UPDATE); //or some other method to test that we anticipate throws an exception
        
        fail("bad thing"); //or whatever the expected exception message is
    }
}