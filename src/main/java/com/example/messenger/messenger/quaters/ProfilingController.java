package com.example.messenger.messenger.quaters;

import lombok.Getter;
import lombok.Setter;

public class ProfilingController implements ProfilingControllerMBean{
    private boolean enabled = true;

    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
