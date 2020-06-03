package org.study.response;

/**
 * @author fanqie
 * @date 2020/6/2
 */
public class ApiResponse {

    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";
    private final String status;
    private final Object body;

    private ApiResponse(String status, Object body) {
        this.status = status;
        this.body = body;
    }

    public static ApiResponse success(Object body) {
        return new ApiResponse(SUCCESS, body);
    }

    public static ApiResponse fail(String message) {
        return new ApiResponse(FAIL, message);
    }

    public String getStatus() { return status; }
    public Object getBody() { return body; }
}
