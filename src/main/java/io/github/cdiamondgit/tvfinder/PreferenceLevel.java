package io.github.cdiamondgit.tvfinder;

public enum PreferenceLevel {
    NO_PREFERENCE(0),
    SLIGHT_PREFERENCE(1),
    MEDIUM_PREFERENCE(2),
    STRONG_PREFERENCE(3),
    ESSENTIAL(0);

    private final int importanceWeight;

    PreferenceLevel(int importanceWeight) {
        this.importanceWeight = importanceWeight;
    }

    public int getImportanceWeight() {
        return importanceWeight;
    }
}