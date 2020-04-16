package com.github.chicoferreira.tempmute.mute;

public class MuteDetails {

    private final long timeInMillis;
    private final long muteDate;

    private MuteDetails(long timeInMillis, long muteDate) {
        this.timeInMillis = timeInMillis;
        this.muteDate = muteDate;
    }

    public MuteDetails(long timeInMillis) {
        this(timeInMillis, System.currentTimeMillis());
    }

    public long getTimeInMillis() {
        return timeInMillis;
    }

    public long getMuteDate() {
        return muteDate;
    }

    public boolean hasAlreadyPassed() {
        return System.currentTimeMillis() > muteDate + timeInMillis;
    }

    public static MuteDetails of(long timeInMillis, long muteDate) {
        return new MuteDetails(timeInMillis, muteDate);
    }

    public static MuteDetails of(long timeInMillis) {
        return new MuteDetails(timeInMillis);
    }
}
