package hr.fer.rassus.lti.response;

@Data
public class Response {

    private Integer temperature;
    private String message;

    public Response(Integer temperature) {
        this.temperature = temperature;
    }
}
