package com.bcreagh.data;

import java.nio.file.Path;

public class BlockService {

    private Path bdbFile;

    public BlockService(Path bdbFile) {
        this.bdbFile = bdbFile;
    }
}
