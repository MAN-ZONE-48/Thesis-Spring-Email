package id.project.skripsi.manzone.dto.response;

public class Response {

    private boolean error;
    private int code;
    private String message;
    private Object data;

    public Response() {
    }

    public Response(boolean error, int code, String message, Object data) {
        this.error = error;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
