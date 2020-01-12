package com.bcreagh;

import com.bcreagh.exception.RequestCreationException;
import com.bcreagh.request.Request;
import com.bcreagh.request.RequestFactory;
import com.bcreagh.request.RequestType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class RequestFactoryTest
{

    private RequestFactory requestFactory;

    @Before
    public void setup() {
        requestFactory = new RequestFactory();
    }

    @Test
    public void createRequest_createReadRequest_commandIsRead()
    {
        String key = "Key";
        String[] input = new String[] {"READ", key};
        Request request = requestFactory.createRequest(input);


        assertEquals(RequestType.READ, request.getRequestType());
        assertEquals(key, request.getKey());
        assertNull(request.getValue());
    }

    @Test(expected = RequestCreationException.class)
    public void createRequest_throwsException_tooFewArgumentsForRead()
    {
        String[] input = new String[] {"READ"};
        requestFactory.createRequest(input);
    }

    @Test(expected = RequestCreationException.class)
    public void createRequest_throwsException_tooManyArgumentsForRead()
    {
        String[] input = new String[] {"READ", "asf", "sfsaf", "sfdasdf"};
        requestFactory.createRequest(input);
    }

    @Test
    public void createRequest_createInsertRequest_commandIsInsert()
    {
        String key = "Key";
        String value = "Value";
        String[] input = new String[] {"INSERT", key, value};
        Request request = requestFactory.createRequest(input);


        assertEquals(RequestType.INSERT, request.getRequestType());
        assertEquals(key, request.getKey());
        assertEquals(value, request.getValue());
    }

    @Test(expected = RequestCreationException.class)
    public void createRequest_throwsException_tooFewArgumentsForInsert()
    {
        String key = "Key";
        String[] input = new String[] {"INSERT", key};
        requestFactory.createRequest(input);
    }

    @Test(expected = RequestCreationException.class)
    public void createRequest_throwsException_tooManyArgumentsForInsert()
    {
        String[] input = new String[] {"INSERT", "asf", "sfsaf", "sfdasdf"};
        requestFactory.createRequest(input);
    }

    @Test
    public void createRequest_createUpdateRequest_commandIsUpdate()
    {
        String key = "Key";
        String value = "Value";
        String[] input = new String[] {"UPDATE", key, value};
        Request request = requestFactory.createRequest(input);


        assertEquals(RequestType.UPDATE, request.getRequestType());
        assertEquals(key, request.getKey());
        assertEquals(value, request.getValue());
    }

    @Test(expected = RequestCreationException.class)
    public void createRequest_throwsException_tooFewArgumentsForUpdate()
    {
        String key = "Key";
        String[] input = new String[] {"UPDATE", key};
        requestFactory.createRequest(input);
    }

    @Test(expected = RequestCreationException.class)
    public void createRequest_throwsException_tooManyArgumentsForUpdate()
    {
        String[] input = new String[] {"UPDATE", "asf", "sfsaf", "sfdasdf"};
        requestFactory.createRequest(input);
    }

    @Test
    public void createRequest_createDeleteRequest_commandIsDelete()
    {
        String key = "Key";
        String[] input = new String[] {"DELETE", key};
        Request request = requestFactory.createRequest(input);


        assertEquals(RequestType.DELETE, request.getRequestType());
        assertEquals(key, request.getKey());
        assertNull(request.getValue());
    }

    @Test(expected = RequestCreationException.class)
    public void createRequest_throwsException_tooFewArgumentsForDelete()
    {
        String[] input = new String[] {"DELETE"};
        requestFactory.createRequest(input);
    }

    @Test(expected = RequestCreationException.class)
    public void createRequest_throwsException_tooManyArgumentsForDelete()
    {
        String[] input = new String[] {"DELETE", "asf", "sfsaf", "sfdasdf"};
        requestFactory.createRequest(input);
    }

    @Test(expected = RequestCreationException.class)
    public void createRequest_throwsException_invalidRequestType()
    {
        String[] input = new String[] {"READOO", "asf", "sfsaf"};
        requestFactory.createRequest(input);
    }

    @Test
    public void createRequest_createReadRequest_withLowerCaseRequestType()
    {
        String key = "Key";
        String[] input = new String[] {"read", key};
        Request request = requestFactory.createRequest(input);


        assertEquals(RequestType.READ, request.getRequestType());
        assertEquals(key, request.getKey());
        assertNull(request.getValue());
    }
}
