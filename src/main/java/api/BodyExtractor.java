package api;

public class BodyExtractor {

    private String key;
    private String data;

    public BodyExtractor(String key, String data) {
        this.key = key;
        this.data = data;
    }

    public String getKey() {
        return key;
    }

    public String getData() {
        return data;
    }
}
