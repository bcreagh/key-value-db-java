package com.bcreagh.request;

import com.bcreagh.data.BdbTree;

/**
 * Responsible for passing requests to the appropriate request handler
 */
public class RequestDispatcher {

    private BdbTree bdbTree;

    public void dispatch(Request request) {

    }

    public void setBdbTree(BdbTree bdbTree) {
        this.bdbTree = bdbTree;
    }
}
