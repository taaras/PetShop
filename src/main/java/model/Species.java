package model;

import javax.persistence.*;

@Entity
@Table(name = "species")
public class Species {
    @Id
    @Column(name = "speciesID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "latinTitle")
    private String latinTitle;

    @Column(name = "maleAverageAge")
    private int maleAverageAge;

    @Column(name = "femaleAverageAge")
    private int femaleAverageAge;

    @Column(name = "nutrition")
    @Enumerated(EnumType.STRING)
    private Nutrition nutrition;

    public Species(String latinTitle, int maleAverageAge, int femaleAverageAge, Nutrition nutrition) {
        this.latinTitle = latinTitle;
        this.maleAverageAge = maleAverageAge;
        this.femaleAverageAge = femaleAverageAge;
        this.nutrition = nutrition;
    }

    @Override
    public String toString() {
        return "Species{" +
                "id=" + id +
                ", latinTitle='" + latinTitle + '\'' +
                ", maleAverageAge=" + maleAverageAge +
                ", femaleAverageAge=" + femaleAverageAge +
                ", nutrition=" + nutrition +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLatinTitle() {
        return latinTitle;
    }

    public void setLatinTitle(String latinTitle) {
        this.latinTitle = latinTitle;
    }

    public int getMaleAverageAge() {
        return maleAverageAge;
    }

    public void setMaleAverageAge(int maleAverageAge) {
        this.maleAverageAge = maleAverageAge;
    }

    public int getFemaleAverageAge() {
        return femaleAverageAge;
    }

    public void setFemaleAverageAge(int femaleAverageAge) {
        this.femaleAverageAge = femaleAverageAge;
    }

    public Nutrition getNutrition() {
        return nutrition;
    }

    public void setNutrition(Nutrition nutrition) {
        this.nutrition = nutrition;
    }
}
