package io.github.cdiamondgit.tvfinder;

public class Recommendation {
    private Television television;
    private int score;

    public Recommendation(Television television, int score) {
        this.television = television;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public Television getTelevision() {
        return television;
    }

    public void setScore(int score) {
        this.score = score;
    }
}