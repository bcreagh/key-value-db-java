package com.bcreagh.data;

public class BinaryNode implements BdbNode {

    private String key;
    private String value;
    private NodeInfo leftNodeInfo;
    private NodeInfo rightNodeInfo;


    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String getValue() {
        return value;
    }
}
