package ${PACKAGE_NAME};

//import ${PACKAGE_NAME}.${SERVICE_LAYER_OR_DAO_CLASS};
//import ${PACKAGE_NAME}.${OBJECT};
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ${NAME} {

    @Autowired
    private ${SERVICE_LAYER_OR_DAO_CLASS} ${SERVICE_LAYER};

    @RequestMapping(value = "/${ENDPOINT}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ${OBJECT} save${OBJECT}(@RequestBody ${OBJECT} o){
        return ${SERVICE_LAYER}.save${OBJECT}(o);
    }

    @RequestMapping(value = "/${ENDPOINT}/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ${OBJECT} get${OBJECT}(@PathVariable int id) throws IllegalArgumentException{
        try{
            return ${SERVICE_LAYER}.get${OBJECT}(id);
        }catch(NullPointerException n){
            throw new IllegalArgumentException("illegal argument or another exception idk");
        }
    }

    @RequestMapping(value = "/${ENDPOINT}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<${OBJECT}> getAll${OBJECT}s() {
        return ${SERVICE_LAYER}.getAll${OBJECT}s();
    }

    @RequestMapping(value = "/${ENDPOINT}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public String update${OBJECT}(@RequestBody ${OBJECT} o) throws Exception{
        try{
            ${SERVICE_LAYER}.update${OBJECT}(o);
            return "Update: Successful";
        } catch(Exception e){
            return "Update: Fail";
        }
    }

    @RequestMapping(value = "/${ENDPOINT}/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String delete${OBJECT}(@PathVariable int id) {
        try{
            ${SERVICE_LAYER}.delete${OBJECT}(id);
            return "Delete: Success";
        } catch(Exception e){
            return "Delete: Fail";
        }
    }
}
