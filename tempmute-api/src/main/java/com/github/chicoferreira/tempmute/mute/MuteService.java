package com.github.chicoferreira.tempmute.mute;

import com.github.chicoferreira.tempmute.user.User;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public interface MuteService {

    void mute(User user, Duration timeUnit);

    void unmute(User user);

    boolean isMuted(User user);

    MuteDetails getMuteDetails(User user);

}
