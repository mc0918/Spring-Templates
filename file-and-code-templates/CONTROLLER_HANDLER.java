package ${PACKAGE_NAME};

import org.springframework.hateoas.mediatype.vnderrors.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
@RequestMapping(produces = "application/vnd.error+json")
public class ${NAME} {
    @ExceptionHandler(value = {${EXCEPTION_1}.class})
    #if(${UNPROCESSABLE_ENTITY} != "")@ResponseStatus(HttpStatus.${UNPROCESSABLE_ENTITY})#end
    #if(${UNPROCESSABLE_ENTITY} == "")@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<VndErrors> handle${EXCEPTION_1}Exception(${EXCEPTION_1} e, WebRequest request) {
        #if(${UNPROCESSABLE_ENTITY} != "")return buildResponseEntity(e, request, HttpStatus.${UNPROCESSABLE_ENTITY});#end
        #if(${UNPROCESSABLE_ENTITY} == "")return buildResponseEntity(e, request, HttpStatus.UNPROCESSABLE_ENTITY);#end
    }

    private static ResponseEntity<VndErrors> buildResponseEntity(Exception e, WebRequest request, HttpStatus status) {
        VndErrors error = new VndErrors(request.toString(), e.getMessage());
        ResponseEntity<VndErrors> responseEntity = new ResponseEntity<>(error, status);
        return responseEntity;
    }
}
