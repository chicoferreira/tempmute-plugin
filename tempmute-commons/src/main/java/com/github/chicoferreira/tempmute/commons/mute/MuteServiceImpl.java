package com.github.chicoferreira.tempmute.commons.mute;

import com.github.chicoferreira.tempmute.mute.MuteDetails;
import com.github.chicoferreira.tempmute.mute.MuteService;
import com.github.chicoferreira.tempmute.user.User;

import java.time.Duration;
import java.util.Map;

public class MuteServiceImpl implements MuteService {

    private final Map<String, MuteDetails> mutes;

    public MuteServiceImpl(Map<String, MuteDetails> mutes) {
        this.mutes = mutes;
    }

    @Override
    public void mute(User user, Duration duration) {
        mutes.put(user.getName(), MuteDetails.of(duration.toMillis()));
    }

    @Override
    public void unmute(User user) {
        mutes.remove(user.getName());
    }

    @Override
    public boolean isMuted(User user) {
        MuteDetails muteDetails = getMuteDetails(user);
        return muteDetails != null && !muteDetails.hasAlreadyPassed();
    }

    @Override
    public MuteDetails getMuteDetails(User user) {
        return mutes.get(user.getName());
    }
}
