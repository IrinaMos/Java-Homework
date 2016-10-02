package il.stqa.pft.addressbook.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "addressbook")

@XStreamAlias("contact")
public class ContactData {
  @XStreamOmitField
  @Id
  @Column(name = "id")
  private int id = Integer.MAX_VALUE;

  @Column(name = "firstname")
  private String firstName;

  @Column(name = "home")
  @Type(type = "text")
  private String homeNum;

  @Column(name = "mobile")
  @Type(type = "text")
  private String mobileNum;

  @Column(name = "work")
  @Type(type = "text")
  private String workNum;

  @Transient
  private String allPhones;

  @Transient
  private String companyName;

  @Transient
  private String address;

  @Transient
  private String firstMail;

  @Transient
  private String secondMail;

  @Transient
  private String thirdMail;

  @Transient
  private String allMails;

  @Column(name = "lastname")
  private String lastName;

  @Transient
  private String details;

  @Column(name = "photo")
  @Type(type = "text")
  private String photo;

  @ManyToMany (fetch = FetchType.EAGER)
  @JoinTable (name = "address_in_groups", joinColumns = @JoinColumn(name = "id"),
          inverseJoinColumns = @JoinColumn(name = "group_id") )
  private Set<GroupData> groups = new HashSet<GroupData>();



  /*public ContactData(int id, String firstName, String mobileNum, String companyName, String address, String lastName, String group) {
    this.id = id;
    this.firstName = firstName;
    this.mobileNum = mobileNum;
    this.companyName = companyName;
    this.address = address;
    this.lastName = lastName;
    this.group = group;
  }

  public ContactData(String firstName, String mobileNum, String companyName, String address, String lastName, String group) {
    this.id = Integer.MAX_VALUE;
    this.firstName = firstName;
    this.mobileNum = mobileNum;
    this.companyName = companyName;
    this.address = address;
    this.lastName = lastName;
    this.group = group;
  }*/

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public File getPhoto() {
    return new File(photo);
  }


  public ContactData withHomeNum(String homeNum) {
    this.homeNum = homeNum;
    return this;
  }

  public ContactData withMobileNum(String mobileNum) {
    this.mobileNum = mobileNum;
    return this;
  }

  public ContactData withWorkNum(String workNum) {
    this.workNum = workNum;
    return this;
  }

  public ContactData withCompanyName(String companyName) {
    this.companyName = companyName;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public int getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getHomeNum() {
    return homeNum;
  }

  public String getMobileNum() {
    return mobileNum;
  }

  public String getWorkNum() {
    return workNum;
  }

  public String getCompanyName() {
    return companyName;
  }

  public String getAddress() {
    return address;
  }

  public String getSecondMail() {
    return secondMail;
  }

  public String getThirdMail() {
    return thirdMail;
  }

  public String getLastName() {
    return lastName;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public Groups getGroups() {
    return new Groups (groups);
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public String getFirstMail() {
    return firstMail;
  }

  public ContactData withFirstMail(String firstMail) {
    this.firstMail = firstMail;
    return this;
  }

  public String getSecondtMail() {
    return secondMail;
  }

  public ContactData withSecondtMail(String secondMail) {
    this.secondMail = secondMail;
    return this;
  }

  public String getThirdtMail() {
    return thirdMail;
  }

  public ContactData withThirdtMail(String thirdMail) {
    this.thirdMail = thirdMail;
    return this;
  }

  public String getAllMails() {
    return allMails;

  }

  public ContactData withAllMails(String allMails) {
    this.allMails = allMails;
    return this;
  }

  public ContactData setId(int id) {
    this.id = id;
    return this;
  }

  public ContactData setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public ContactData setHomeNum(String homeNum) {
    this.homeNum = homeNum;
    return this;
  }

  public ContactData setMobileNum(String mobileNum) {
    this.mobileNum = mobileNum;
    return this;
  }

  public ContactData setWorkNum(String workNum) {
    this.workNum = workNum;
    return this;
  }


  public ContactData setFirstMail(String firstMail) {
    this.firstMail = firstMail;
    return this;
  }

  public ContactData setSecondMail(String secondMail) {
    this.secondMail = secondMail;
    return this;
  }

  public ContactData setAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public ContactData setThirdMail(String thirdMail) {
    this.thirdMail = thirdMail;
    return this;
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }

  public ContactData setAllMails(String allMails) {
    this.allMails = allMails;
    return this;
  }

  public ContactData withDetails(String details) {
    this.details = details;
    return this;
  }

  public ContactData setDetails(String details) {
    this.details = details;
    return this;
  }

  public String getDetails() {
    return details;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    return firstName != null ? firstName.equals(that.firstName) : that.firstName == null;

  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
    return result;
  }


  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }

  public ContactData inGroup(GroupData group) {
   groups.add(group);
    return this;
  }
}
