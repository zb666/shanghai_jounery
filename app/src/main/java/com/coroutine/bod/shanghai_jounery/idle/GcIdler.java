package com.coroutine.bod.shanghai_jounery.idle;

import android.os.MessageQueue;

public class GcIdler implements MessageQueue.IdleHandler {
    @Override
    public boolean queueIdle() {
        return false;
    }
}
