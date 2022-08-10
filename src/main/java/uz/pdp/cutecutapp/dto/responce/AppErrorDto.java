package uz.pdp.cutecutapp.dto.responce;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import uz.pdp.cutecutapp.dto.BaseDto;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppErrorDto implements BaseDto {

    private Timestamp timestamp;
    private Integer status;
    private String code;
    private String message;
    private String path;

    public AppErrorDto() {
    }

    public AppErrorDto(String message, WebRequest webRequest, HttpStatus httpStatus) {
        this(message, ((ServletWebRequest) webRequest).getRequest().getRequestURI(), httpStatus);
    }

    public AppErrorDto(String message, String path, HttpStatus httpStatus) {
        this.timestamp = Timestamp.valueOf(LocalDateTime.now());
        this.status = httpStatus.value();
        this.code = httpStatus.getReasonPhrase();
        this.message = message;
        this.path = path;
    }


    public AppErrorDto(HttpStatus status, String message, String path) {
        this.timestamp = Timestamp.valueOf(LocalDateTime.now());
        this.status = status.value();
        this.code = status.getReasonPhrase();
        this.message = message;
        this.path = path;
    }

    public AppErrorDto(String error,HttpStatus internalServerError) {
        this.message=error;
        this.timestamp = Timestamp.valueOf(LocalDateTime.now());
        this.status=internalServerError.value();
        this.code=internalServerError.getReasonPhrase();

    }

    public AppErrorDto(Integer status, String message) {
        this.status = status;
        this.message = message;
    }
}
