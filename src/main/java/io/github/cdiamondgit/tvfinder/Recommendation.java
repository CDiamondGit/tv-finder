package io.github.cdiamondgit.tvfinder;

public class Recommendation {
    private Television television;
    private double score;

    public Recommendation(Television television, double score) {
        this.television = television;
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public Television getTelevision() {
        return television;
    }

    public void setScore(double score) {
        this.score = score;
    }
}