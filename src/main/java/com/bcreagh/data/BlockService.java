package com.bcreagh.data;

import java.nio.file.Path;

public class BlockService<T extends Block> {

    private Path bdbFile;
    private BlockFactory blockFactory;
    private Class<T> blockType;

    public BlockService(Path bdbFile, Class<T> blockType) {
        this.bdbFile = bdbFile;
        this.blockType = blockType;
    }

    public T getBlock(long blockNumber) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void setBlockFactory(BlockFactory blockFactory) {
        this.blockFactory = blockFactory;
    }
}
