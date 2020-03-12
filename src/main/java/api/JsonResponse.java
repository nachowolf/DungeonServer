package api;

public class JsonResponse {

    private Status status;
    private String message;
    private Object data;

    public JsonResponse(Status status, Object data) {
        this.status = status;
        this.data = data;
    }

    public JsonResponse(Status status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public JsonResponse(Status status) {
        this.status = status;
    }
}
