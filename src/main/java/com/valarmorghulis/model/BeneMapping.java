package com.valarmorghulis.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Vijay on 12/06/2016.
 */
@Entity
@Table(name="bene_mapping")
public class BeneMapping {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    int id;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="benefactor_id")
    private Login benefactor;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="beneficiary_id")
    private Beneficiary beneficiary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Login getBenefactor() {
        return benefactor;
    }

    public void setBenefactor(Login benefactor) {
        this.benefactor = benefactor;
    }

    public Beneficiary getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(Beneficiary beneficiary) {
        this.beneficiary = beneficiary;
    }
}
