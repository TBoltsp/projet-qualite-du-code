package io.cucumber.skeleton;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.platform.engine.Cucumber;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;

import foo.petNanny.domain.PlageHoraire;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.time.LocalDateTime;

public class StepDefinitions {
    PlageHoraire plageDeDateA;
    PlageHoraire plageDeDateB;

    @Given("Plage de date A du {int}-{int}-{int} au {int}-{int}-{int}")
    public void creation_Plage_Dat_eA(int anneeDeb, int moisDeb, int jourDeb, int anneeFin, int moisFin, int jourFin) {
        LocalDateTime dateDeb = LocalDateTime.of(anneeDeb, moisDeb, jourDeb, 0, 0);
        LocalDateTime dateFin = LocalDateTime.of(anneeFin, moisFin, jourFin, 0, 0);
        this.plageDeDateA = new PlageHoraire(dateDeb,dateFin);
    }

    @When("Plage de date B va du {int}-{int}-{int} au {int}-{int}-{int}")
    public void creation_Plage_Date_B(int anneeDeb, int moisDeb, int jourDeb, int anneeFin, int moisFin, int jourFin) {
        LocalDateTime dateDeb = LocalDateTime.of(anneeDeb, moisDeb, jourDeb, 0, 0);
        LocalDateTime dateFin = LocalDateTime.of(anneeFin, moisFin, jourFin, 0, 0);
        this.plageDeDateB = new PlageHoraire(dateDeb,dateFin);
    }



    @Then("il ne doit pas y avoir de colision")
    public void pas_de_colision() {
        assertThat(this.plageDeDateA.collision(plageDeDateB), equalTo(false));
    }
    
    @Then("il doit y avoir de colision")
    public void presence_de_colision() {
        assertThat(this.plageDeDateA.collision(plageDeDateB), equalTo(true));
    }

}