import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

class ClockMock extends Clock {

    private static final Instant DEFAULT_DATE = Instant.parse("1789-07-14T16:00:00Z");

    private Instant date = DEFAULT_DATE;

    void setDate(Instant date) {
        this.date = date;
    }

    @Override
    public ZoneId getZone() {
        return ZoneId.systemDefault();
    }

    @Override
    public Clock withZone(ZoneId zone) {
        return Clock.system(getZone());
    }

    @Override
    public Instant instant() {
        return this.date;
    }

}
