package vo;

import util.Time;

public class AccountFilterFlagsVO {
    String name;
    Time minTime;
    Time maxTime;

    public AccountFilterFlagsVO(String name, Time minTime, Time maxTime){
        this.name = name;
        this.minTime = minTime;
        this.maxTime = maxTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Time getMaxTime() {
        return maxTime;
    }

    public Time getMinTime() {
        return minTime;
    }

    public void setMaxTime(Time maxTime) {
        this.maxTime = maxTime;
    }

    public void setMinTime(Time minTime) {
        this.minTime = minTime;
    }

}
