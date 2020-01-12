package com.bcreagh.request;

import com.bcreagh.exception.RequestCreationException;

import java.util.HashMap;

/**
 * Responsible for creating Request objects.
 */
public class RequestFactory {

    private HashMap<RequestType, Integer> expectNumberOfArgsMap = new HashMap<>();

    public RequestFactory() {
        expectNumberOfArgsMap.put(RequestType.READ, 1);
        expectNumberOfArgsMap.put(RequestType.INSERT, 2);
        expectNumberOfArgsMap.put(RequestType.UPDATE, 2);
        expectNumberOfArgsMap.put(RequestType.DELETE, 1);
    }

    public Request createRequest(String[] input) {
        RequestType requestType = getRequestType(input);
        validateCorrectNumberOfArguments(input, requestType);
        Request request = new Request();
        request.setRequestType(requestType);
        request.setKey(getKey(input, requestType));
        request.setValue(getValue(input, requestType));
        return request;
    }

    private RequestType getRequestType(String[] input) {
        try {
            return RequestType.valueOf(input[0].toUpperCase());
        } catch(IllegalArgumentException exception) {
            throw new RequestCreationException(input[0] + " is not a valid request type.");
        }
    }

    private void validateCorrectNumberOfArguments(String[] input, RequestType requestType) {
        int actualNumberOfArgs = input.length - 1;
        int expectedNumberOfArgs = expectNumberOfArgsMap.get(requestType);
        if (expectedNumberOfArgs != actualNumberOfArgs) {
            throw new RequestCreationException("Received the wrong number of arguments for " +
                    requestType.toString() + ". Expected " + expectedNumberOfArgs + " , Got " + actualNumberOfArgs);
        }
    }

    private String getKey(String[] input, RequestType requestType) {
        if (expectNumberOfArgsMap.get(requestType) >= 1) {
            return input[1];
        }
        return null;
    }


    private String getValue(String[] input, RequestType requestType) {
        if (expectNumberOfArgsMap.get(requestType) >= 2) {
            return input[2];
        }
        return null;
    }

}
