package helpers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public interface Logging {
        Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
}



