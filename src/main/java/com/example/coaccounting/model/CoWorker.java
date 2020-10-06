package com.example.coaccounting.model;

import javax.persistence.*;

@Entity
@Table(name="coWorkers")
public class CoWorker {

    public CoWorker() {

    }

    public CoWorker(Integer id, String address, String urlPhoto, String phone, Passport passport) {
        this.id = id;
        this.address = address;
        this.urlPhoto = urlPhoto;
        this.phone = phone;
        this.passport = passport;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "address")
    private String address;

    @Column(name = "url_photo")
    private String urlPhoto;

    @Column(name = "phone")
    private String phone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_id")
    private Passport passport;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
