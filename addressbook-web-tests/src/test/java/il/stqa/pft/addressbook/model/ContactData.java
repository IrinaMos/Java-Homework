package il.stqa.pft.addressbook.model;

public class ContactData {
  private  int id =Integer.MAX_VALUE;
  private  String firstName;
  private String homeNum;
  private  String mobileNum;
  private  String workNum;
  private String allPhones;
  private  String companyName;
  private  String address;
  private  String lastName;
  private String group;

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

  public ContactData withGroup(String group) {
    this.group = group;
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

  public String getAdress() {
    return address;
  }

  public String getLastName() {
    return lastName;
  }

  public String getGroup() {
    return group;
  }
  public String getAllPhones() {
    return allPhones;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }


  public void setId(int id) {
    this.id = id;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
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

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setGroup(String group) {
    this.group = group;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", firstName='" + firstName + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
    if (homeNum != null ? !homeNum.equals(that.homeNum) : that.homeNum != null) return false;
    if (mobileNum != null ? !mobileNum.equals(that.mobileNum) : that.mobileNum != null) return false;
    if (workNum != null ? !workNum.equals(that.workNum) : that.workNum != null) return false;
    return allPhones != null ? allPhones.equals(that.allPhones) : that.allPhones == null;

  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
    result = 31 * result + (homeNum != null ? homeNum.hashCode() : 0);
    result = 31 * result + (mobileNum != null ? mobileNum.hashCode() : 0);
    result = 31 * result + (workNum != null ? workNum.hashCode() : 0);
    result = 31 * result + (allPhones != null ? allPhones.hashCode() : 0);
    return result;
  }
}
