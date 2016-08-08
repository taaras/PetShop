package app.model;

import javax.persistence.*;

@Entity
@Table(name = "pet")
public class Pet {
    @Id
    @Column(name = "petID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "speciesID")
    private Species species;

    @Column(name = "age_month")
    private int ageInMonth;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "price")
    private int price;

    @Column(name = "additional")
    private String additional;

    public Pet() {
    }

    public Pet(Species species, int ageInMonth, Gender gender, int price, String additional) {
        this.species = species;
        this.ageInMonth = ageInMonth;
        this.gender = gender;
        this.price = price;
        this.additional = additional;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", species=" + species +
                ", ageInMonth=" + ageInMonth +
                ", gender=" + gender +
                ", price=" + price +
                ", additional='" + additional + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public int getAgeInMonth() {
        return ageInMonth;
    }

    public void setAgeInMonth(int ageInMonth) {
        this.ageInMonth = ageInMonth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAdditional() {
        return additional;
    }

    public void setAdditional(String additional) {
        this.additional = additional;
    }
}
