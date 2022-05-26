package io.cucumber.skeleton;

public class Belly {
    private Integer cakes =0;
    private Integer stomachTime;

    public void eat(Integer cukes) {
        this.cakes += cukes;
    }

    public void waitX(Integer time) {
        this.stomachTime = time;
    }

    public boolean isGrowling() {
        return  (stomachTime<=  cakes / 10 );
    }

    public Integer getCakes() {
        return this.cakes;
    }
}
