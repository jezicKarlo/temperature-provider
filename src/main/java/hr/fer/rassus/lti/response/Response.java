package hr.fer.rassus.lti.response;

import lombok.Data;

@Data
public class Response {

    private Integer reading;
    private String message;

    public Response(Integer reading) {
        this.reading = reading;
    }
}
