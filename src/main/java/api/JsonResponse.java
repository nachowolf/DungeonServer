package api;

public class JsonResponse {

    private Status status;
    private Object data;

    public JsonResponse(Status status, Object data) {
        this.status = status;
        this.data = data;
    }

    public JsonResponse(Status status) {
        this.status = status;
    }
}
