package team.flint.trunk.utils;

import java.util.UUID;

/**
 *
 */

public class IDKit {
    public static String buildUUID () {
        String tmp = UUID.randomUUID().toString();
        return tmp.replace("-", "");
    }
}
