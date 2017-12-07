package vo;

import util.Time;

public class AccountFilterFlagsVO {
    String name;
    String creator;
    Time minTime;
    Time maxTime;

    public AccountFilterFlagsVO(String name,String creator,Time minTime,Time maxTime){
        this.name = name;
        this.creator = creator;
        this.minTime = minTime;
        this.maxTime = maxTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getCreator() {
        return creator;
    }

    public Time getMaxTime() {
        return maxTime;
    }

    public Time getMinTime() {
        return minTime;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public void setMaxTime(Time maxTime) {
        this.maxTime = maxTime;
    }

    public void setMinTime(Time minTime) {
        this.minTime = minTime;
    }

}
