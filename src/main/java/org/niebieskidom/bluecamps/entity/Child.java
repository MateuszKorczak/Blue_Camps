package org.niebieskidom.bluecamps.entity;

import org.hibernate.validator.constraints.pl.PESEL;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = "children")
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "To pole jest wymagane")
    @NotEmpty(message = "To pole jest wymagane")
    private String firstName;

    @NotNull(message = "To pole jest wymagane")
    @NotEmpty(message = "To pole jest wymagane")
    private String lastName;

    private Character sex;

    @NotNull(message = "To pole jest wymagane")
    @NotEmpty(message = "To pole jest wymagane")
    private String parentsName1;
    private String parentsName2;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @Past(message = "Data musi być starsza niż dzisiaj")
    private Date birthDate;

    @NotNull(message = "To pole jest wymagane")
    @NotEmpty(message = "To pole jest wymagane")
    private String address;

    @NotNull(message = "To pole jest wymagane")
    @NotEmpty(message = "To pole jest wymagane")
    private String parentsAddress;

    @NotNull(message = "To pole jest wymagane")
    @NotEmpty(message = "To pole jest wymagane")
    @Pattern(regexp = "[0-9]{3}-[0-9]{3}-[0-9]{3}", flags = Pattern.Flag.UNICODE_CASE, message = "Podaj nr telefonu zgodny z wzorem")
    private String parentsPhoneNumber;

    @NotNull(message = "To pole jest wymagane")
    @NotEmpty(message = "To pole jest wymagane")
    @Email
    @Pattern(regexp = "[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.([a-zA-Z]{2,})", flags = Pattern.Flag.UNICODE_CASE, message = "Podaj adres email zgodny z wzorem")
    private String parentsEmail;

    private String infoAboutNeeds;

    @NotNull
    @NotEmpty
    private String infoAboutHealth;

    @NotNull
    @NotEmpty
    private String infoAboutVaccination;

    @NotNull
    @NotEmpty
    @PESEL (message = "Podaj prawidłowy nr PESEL")
    private String pesel;

    @AssertTrue(message = "Zgoda jest wymagana")
    private boolean agreement = true;

    private String paymentStatus;

    public Child() {
    }

    public Child(@NotNull @NotEmpty String firstName, @NotNull @NotEmpty String lastName, Character sex, @NotNull @NotEmpty String parentsName1, String parentsName2, @NotNull @Past Date birthDate, @NotNull @NotEmpty String address, @NotNull @NotEmpty String parentsAddress, @NotNull @NotEmpty @Pattern(regexp = "\\d{9}", flags = Pattern.Flag.UNICODE_CASE) String parentsPhoneNumber, @NotNull @NotEmpty @Email @Pattern(regexp = "[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.([a-zA-Z]{2,}){1}", flags = Pattern.Flag.UNICODE_CASE) String parentsEmail,  String infoAboutNeeds, @NotNull @NotEmpty String infoAboutHealth, @NotNull @NotEmpty String infoAboutVaccination, @NotNull @NotEmpty @PESEL String pesel, @AssertTrue boolean agreement, String paymentStatus) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.parentsName1 = parentsName1;
        this.parentsName2 = parentsName2;
        this.birthDate = birthDate;
        this.address = address;
        this.parentsAddress = parentsAddress;
        this.parentsPhoneNumber = parentsPhoneNumber;
        this.parentsEmail = parentsEmail;
        this.infoAboutNeeds = infoAboutNeeds;
        this.infoAboutHealth = infoAboutHealth;
        this.infoAboutVaccination = infoAboutVaccination;
        this.pesel = pesel;
        this.agreement = agreement;
        this.paymentStatus = paymentStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    public String getParentsName1() {
        return parentsName1;
    }

    public void setParentsName1(String parentsName1) {
        this.parentsName1 = parentsName1;
    }

    public String getParentsName2() {
        return parentsName2;
    }

    public void setParentsName2(String parentsName2) {
        this.parentsName2 = parentsName2;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getParentsAddress() {
        return parentsAddress;
    }

    public void setParentsAddress(String parentsAddress) {
        this.parentsAddress = parentsAddress;
    }

    public String getParentsPhoneNumber() {
        return parentsPhoneNumber;
    }

    public void setParentsPhoneNumber(String parentsPhoneNumber) {
        this.parentsPhoneNumber = parentsPhoneNumber;
    }

    public String getParentsEmail() {
        return parentsEmail;
    }

    public void setParentsEmail(String parentsEmail) {
        this.parentsEmail = parentsEmail;
    }

    public String getInfoAboutNeeds() {
        return infoAboutNeeds;
    }

    public void setInfoAboutNeeds(String infoAboutNeeds) {
        this.infoAboutNeeds = infoAboutNeeds;
    }

    public String getInfoAboutHealth() {
        return infoAboutHealth;
    }

    public void setInfoAboutHealth(String infoAboutHealth) {
        this.infoAboutHealth = infoAboutHealth;
    }

    public String getInfoAboutVaccination() {
        return infoAboutVaccination;
    }

    public void setInfoAboutVaccination(String infoAboutVaccination) {
        this.infoAboutVaccination = infoAboutVaccination;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public boolean isAgreement() {
        return agreement;
    }

    public void setAgreement(boolean agreement) {
        this.agreement = agreement;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String toString() {
        return "Child{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sex=" + sex +
                ", parentsName1='" + parentsName1 + '\'' +
                ", parentsName2='" + parentsName2 + '\'' +
                ", birthDate=" + birthDate +
                ", address='" + address + '\'' +
                ", parentsAddress='" + parentsAddress + '\'' +
                ", parentsPhoneNumber='" + parentsPhoneNumber + '\'' +
                ", parentsEmail='" + parentsEmail + '\'' +
                ", infoAboutNeeds='" + infoAboutNeeds + '\'' +
                ", infoAboutHealth='" + infoAboutHealth + '\'' +
                ", infoAboutVaccination='" + infoAboutVaccination + '\'' +
                ", pesel='" + pesel + '\'' +
                ", agreement=" + agreement +
                ", paymentStatus='" + paymentStatus + '\'' +
                '}';
    }
}
