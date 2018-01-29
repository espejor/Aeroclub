package aeroclub;

import java.util.EventListener;

public interface MantoListener extends EventListener {
    void onBreakDown(EventManto e);
}
