package register;

import com.opensymphony.xwork2.ActionSupport;
import java.util.HashMap;
import java.util.Map;

public class Test extends ActionSupport {
    
    private Map<String, String> jsonResponse;

    public String execute() {
        jsonResponse = new HashMap<>();
        jsonResponse.put("message", "Hello, World!");
        jsonResponse.put("status", "success");
        return SUCCESS;
    }

    // Getters for JSON serialization
    public Map<String, String> getJsonResponse() {
        return jsonResponse;
    }
}
