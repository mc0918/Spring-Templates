package ${PACKAGE_NAME};

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "${ENDPOINT}-service")
public interface ${NAME} {
    @RequestMapping(value = "/${ENDPOINT}", method = RequestMethod.POST)
    public ${CLIENT_MODEL} save${CLIENT_MODEL}(@RequestBody ${CLIENT_MODEL} o);

    @RequestMapping(value = "/${ENDPOINT}/{id}", method = RequestMethod.GET)
    public ${CLIENT_MODEL} get${CLIENT_MODEL}(@PathVariable int id) throws ${EXCEPTION};

    @RequestMapping(value = "/${ENDPOINT}", method = RequestMethod.GET)
    public List<${CLIENT_MODEL}> getAll${CLIENT_MODEL}s();

    @RequestMapping(value = "/${ENDPOINT}", method = RequestMethod.PUT)
    public String update${CLIENT_MODEL}(@RequestBody ${CLIENT_MODEL} o) throws ${EXCEPTION};

    @RequestMapping(value = "/${ENDPOINT}/{id}", method = RequestMethod.DELETE)
    public String delete${CLIENT_MODEL}(@PathVariable int id) throws ${EXCEPTION};
}
