package com.grsu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Университет
 */
@Entity
@Table(name = "education_institution")
public class EducationInstitution implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    /**
     * Название
     */
    @Column
    private String name;

    /**
     * Основная почта
     */
    @Column(name = "email")
    private String primaryMail;

    @Column(name = "type_education_institution")
    @Enumerated(EnumType.STRING)
    private TypeEducationInstitution typeEducationInstitution;

    /**
     * Почта для обратной связи
     */
    @Column(name = "feedback")
    private String mailFeedback;

    /**
     * Сайт университета
     */
    @Column
    private String site;

    /**
     * Адрес
     */
    @Column
    private String address;

    /**
     * Город
     */
    @Column
    private String city;

    /**
     * Рейтинг в РБ
     */
    @Column(name = "local_rating")
    private Integer localRating;

    /**
     * Факультеты
     */
    @OneToMany(mappedBy = "educationInstitution")
    private List<Faculty> faculties;

    public EducationInstitution() {
    }

    public TypeEducationInstitution getTypeEducationInstitution() {
        return typeEducationInstitution;
    }

    public void setTypeEducationInstitution(TypeEducationInstitution typeEducationInstitution) {
        this.typeEducationInstitution = typeEducationInstitution;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrimaryMail() {
        return primaryMail;
    }

    public void setPrimaryMail(String primaryMail) {
        this.primaryMail = primaryMail;
    }

    public String getMailFeedback() {
        return mailFeedback;
    }

    public void setMailFeedback(String mailFeedback) {
        this.mailFeedback = mailFeedback;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getLocalRating() {
        return localRating;
    }

    public void setLocalRating(Integer localRating) {
        this.localRating = localRating;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }
}