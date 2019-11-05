package example.service.hello.model;

public class HelloResponse {

    private String message;

    public HelloResponse() {}

    public HelloResponse(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
