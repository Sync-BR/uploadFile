package com.uploadFile.uploadFile.util;

import java.util.UUID;

public class IdGeneratorService {
    public static String generateFolderIdentifier() {
        return UUID.randomUUID().toString();
    }
}
