package ${PACKAGE_NAME};

//import ${PACKAGE_NAME}.${FEIGN_CLIENT_CLASS};
//import ${PACKAGE_NAME}.${DAO_CLASS};
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ${NAME} {
/*
YOU MIGHT NEED TO CHANGE THINGS (LIKE METHOD NAMES) TO MATCH WITH JPA
in which case the methods should be:
    save(o), getOne(id), finadAll(), save(o) bc update is save again, deleteById(id)
*/
    #if(${FEIGN_CLIENT_CLASS} != "")private ${FEIGN_CLIENT_CLASS} client;#end
    #if(${DAO_CLASS} != "")private ${DAO_CLASS} repository;#end
    
    @Autowired
    public ${NAME}(#if(${FEIGN_CLIENT_CLASS} != "")${FEIGN_CLIENT_CLASS} client, #end #if(${DAO_CLASS}!="")${DAO_CLASS} repository#end) {
        #if(${FEIGN_CLIENT_CLASS} != "")this.client = client;#end
        #if(${DAO_CLASS} != "")this.repository = repository;#end
    }

    #if(${FEIGN_CLIENT_CLASS}!="")
    public ${FEIGN_OBJECT} save${FEIGN_OBJECT}(${FEIGN_OBJECT} o){
        return client.save${FEIGN_OBJECT}(o);
    }
    
    public ${FEIGN_OBJECT} get${FEIGN_OBJECT}(int id){
        return client.get${FEIGN_OBJECT}(id);
    }

    public List<${FEIGN_OBJECT}> getAll${FEIGN_OBJECT}s(){
        return client.getAll${FEIGN_OBJECT}s();
    }
    
    public void update${FEIGN_OBJECT}(${FEIGN_OBJECT} o){
        client.update${FEIGN_OBJECT}(o);
    }
    
    public void delete${FEIGN_OBJECT}(int id){
        client.delete${FEIGN_OBJECT}(id);
    }#end
    
    #if(${DAO_CLASS}!="")
    public ${DAO_OBJECT} save${DAO_OBJECT}(${DAO_OBJECT} o){
        return repository.save${DAO_OBJECT}(o);
    }
    
    public ${DAO_OBJECT} get${DAO_OBJECT}(int id){
        return repository.get${DAO_OBJECT}(id);
    }

    public List<${DAO_OBJECT}> getAll${DAO_OBJECT}s(){
        return repository.getAll${DAO_OBJECT}s();
    }
    
    public void update${DAO_OBJECT}(${DAO_OBJECT} o){
        repository.update${DAO_OBJECT}(o);
    }
    
    public void delete${DAO_OBJECT}(int id){
        repository.delete${DAO_OBJECT}(id);
    }#end
}
