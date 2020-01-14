package com.bcreagh;

import com.bcreagh.data.BdbTree;
import com.bcreagh.data.BlockService;
import com.bcreagh.data.NodeService;
import com.bcreagh.request.RequestDispatcher;

import java.nio.file.Paths;

public class BdbInitializer {

    public static RequestDispatcher initialize(String dbFile) {

        BlockService blockService = new BlockService(Paths.get(dbFile));

        NodeService nodeService = new NodeService();
        nodeService.setBlockService(blockService);

        BdbTree bdbTree = new BdbTree();
        bdbTree.setNodeService(nodeService);

        RequestDispatcher requestDispatcher = new RequestDispatcher();
        requestDispatcher.setBdbTree(bdbTree);
    }
}
