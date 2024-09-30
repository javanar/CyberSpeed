package org.tuncer.configFile;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MultiplierBonusSymbol extends BonusSymbol{

    private int rewardMultiplier;

    @JsonProperty("reward_multiplier")
    public int getRewardMultiplier() {
        return rewardMultiplier;
    }

    public void setRewardMultiplier(int rewardMultiplier) {
        this.rewardMultiplier = rewardMultiplier;
    }
}
