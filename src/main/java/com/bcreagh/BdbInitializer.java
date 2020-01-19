package com.bcreagh;

import com.bcreagh.data.BinaryNodeBlock;
import com.bcreagh.data.BinaryNodeService;
import com.bcreagh.data.BlockService;
import com.bcreagh.data.RedBlackTree;
import com.bcreagh.request.RequestDispatcher;

import java.nio.file.Paths;

public class BdbInitializer {

    public static RequestDispatcher initialize() {
        return initialize("bdbData.db");
    }

    public static RequestDispatcher initialize(String dbFile) {

        BlockService<BinaryNodeBlock> blockService = new BlockService<>(Paths.get(dbFile), BinaryNodeBlock.class);

        BinaryNodeService nodeService = new BinaryNodeService();
        nodeService.setBlockService(blockService);

        RedBlackTree bdbTree = new RedBlackTree();
        bdbTree.setNodeService(nodeService);

        RequestDispatcher requestDispatcher = new RequestDispatcher();
        requestDispatcher.setBdbTree(bdbTree);

        return requestDispatcher;
    }
}
