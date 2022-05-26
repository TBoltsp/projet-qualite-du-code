package io.cucumber.skeleton;

import foo.petNanny.domain.PlageHoraire;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.time.LocalDateTime;

public class StepDefinitions {
    PlageHoraire plageHoraireA;
    PlageHoraire plageHoraireB;

    @Given("Plage de horaire A du {int}-{int}-{int} au {int}-{int}-{int}")
    public void creation_Plage_Date_A(int anneeDeb, int moisDeb, int jourDeb, int anneeFin, int moisFin, int jourFin) {
        LocalDateTime dateDeb = LocalDateTime.of(anneeDeb, moisDeb, jourDeb, 0, 0);
        LocalDateTime dateFin = LocalDateTime.of(anneeFin, moisFin, jourFin, 0, 0);
        this.plageHoraireA = new PlageHoraire(dateDeb,dateFin);
    }

    @When("Plage de horaire B va du {int}-{int}-{int} au {int}-{int}-{int}")
    public void creation_Plage_Date_B(int anneeDeb, int moisDeb, int jourDeb, int anneeFin, int moisFin, int jourFin) {
        LocalDateTime dateDeb = LocalDateTime.of(anneeDeb, moisDeb, jourDeb, 0, 0);
        LocalDateTime dateFin = LocalDateTime.of(anneeFin, moisFin, jourFin, 0, 0);
        this.plageHoraireB = new PlageHoraire(dateDeb,dateFin);
    }



    @Then("il ne doit pas y avoir de collision")
    public void pas_de_collision() {
        assertThat(this.plageHoraireA.collision(plageHoraireB), equalTo(false));
    }

    @Then("il doit y avoir une collision")
    public void presence_de_collision() {
        assertThat(this.plageHoraireA.collision(plageHoraireB), equalTo(true));
    }

}
