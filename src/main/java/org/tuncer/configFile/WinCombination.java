package org.tuncer.configFile;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WinCombination {

    private double rewardMultiplier;
    private WinCombinationWhen when;
    private WinCombinationGroup group;

    @JsonProperty("reward_multiplier")
    public double getRewardMultiplier() {
        return rewardMultiplier;
    }

    public void setRewardMultiplier(double rewardMultiplier) {
        this.rewardMultiplier = rewardMultiplier;
    }

    public WinCombinationWhen getWhen() {
        return when;
    }

    public void setWhen(WinCombinationWhen when) {
        this.when = when;
    }

    public WinCombinationGroup getGroup() {
        return group;
    }

    public void setGroup(WinCombinationGroup group) {
        this.group = group;
    }
}
