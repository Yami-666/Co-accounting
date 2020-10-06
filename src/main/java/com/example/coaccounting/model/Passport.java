package com.example.coaccounting.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "passport")
public class Passport {

    public Passport() {
    }

    public Passport(Integer id, String number, String fio, String addressPassport, Date dateBirth, CoWorker coWorker) {
        this.id = id;
        this.number = number;
        this.fio = fio;
        this.addressPassport = addressPassport;
        this.dateBirth = dateBirth;
        this.coWorker = coWorker;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "number")
    private String number;

    @Column(name = "fio")
    private String fio;

    @Column(name = "address_passport")
    private String addressPassport;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "dateBirth")
    private Date dateBirth;

    @OneToOne(mappedBy = "passport", cascade = CascadeType.ALL)
    private CoWorker coWorker;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getAddressPassport() {
        return addressPassport;
    }

    public void setAddressPassport(String addressPassport) {
        this.addressPassport = addressPassport;
    }

    public CoWorker getCoWorker() {
        return coWorker;
    }

    public void setCoWorker(CoWorker coWorker) {
        this.coWorker = coWorker;
    }
}
