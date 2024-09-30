package org.tuncer.configFile;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LinearWinCombination extends WinCombination{

    private String[][] coveredAreas;

    @JsonProperty("covered_areas")
    public String[][] getCoveredAreas() {
        return coveredAreas;
    }

    public void setCoveredAreas(String[][] coveredAreas) {
        this.coveredAreas = coveredAreas;
    }
}
