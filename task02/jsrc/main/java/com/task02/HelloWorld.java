package com.task02;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.syndicate.deployment.annotations.lambda.LambdaHandler;
import com.syndicate.deployment.model.RetentionSetting;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

@LambdaHandler(
        lambdaName = "hello_world",
        roleName = "hello_world-role",
        isPublishVersion = true,
        aliasName = "${lambdas_alias_name}",
        logsExpiration = RetentionSetting.SYNDICATE_ALIASES_SPECIFIED
)

//@LambdaUrlConfig(
//        authType = AuthType.NONE,
//        invokeMode = InvokeMode.BUFFERED
//)
public class HelloWorld implements RequestHandler<Map<String, Object>, Map<String, Object>> {

    private final Gson gson = new Gson();

    @Override
    public Map<String, Object> handleRequest(Map<String, Object> input, Context context) {
        // Extract HTTP method and path from the input
        String httpMethod = (String) input.get("httpMethod");
        String path = (String) input.get("path");

        Map<String, Object> response = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        Map<String, String> headers = new HashMap<>();
        headers.put("content-type", "application/json");

        // Default is 200, unless we have a bad request
        int statusCode = 200;

        // Logic based on the path and HTTP method
        if ("/hello".equals(path) && "GET".equals(httpMethod)) {
            body.put("statusCode", 200);
            body.put("message", "Hello from Lambda");
        } else {
            // For other paths or methods
            statusCode = 400;
            body.put("statusCode", 400);
            body.put("message", String.format("Bad request syntax or unsupported method. Request path: %s. HTTP method: %s", path, httpMethod));
        }

        // Set the response
        response.put("statusCode", statusCode);
        response.put("body", gson.toJson(body));  // Convert body map to JSON string
        response.put("headers", headers);
        response.put("isBase64Encoded", false);

        return response;
    }
}
