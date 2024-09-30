package org.tuncer.scratch.config;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StandardSymbol extends Symbol {

    private double rewardMultiplier;

    @JsonProperty("reward_multiplier")
    public double getRewardMultiplier() {
        return rewardMultiplier;
    }

    public void setRewardMultiplier(double rewardMultiplier) {
        this.rewardMultiplier = rewardMultiplier;
    }
}
