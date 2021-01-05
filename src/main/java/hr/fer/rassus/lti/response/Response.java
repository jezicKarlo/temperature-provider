package hr.fer.rassus.lti.response;

import lombok.Data;

@Data
public class Response {

    private Integer temperature;
    private String message;

    public Response(Integer temperature) {
        this.temperature = temperature;
    }
}
