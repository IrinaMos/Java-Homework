package il.stqa.pft.addressbook.model;

public class ContactData {
  private  int id;
  private final String firstName;
  private final String mobileNum;
  private final String companyName;
  private final String address;
  private final String lastName;
  private String group;

  public ContactData(int id, String firstName, String mobileNum, String companyName, String address, String lastName, String group) {
    this.id = id;
    this.firstName = firstName;
    this.mobileNum = mobileNum;
    this.companyName = companyName;
    this.address = address;
    this.lastName = lastName;
    this.group = group;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    return firstName != null ? firstName.equals(that.firstName) : that.firstName == null;

  }

  @Override
  public int hashCode() {
    return firstName != null ? firstName.hashCode() : 0;
  }

  public ContactData(String firstName, String mobileNum, String companyName, String address, String lastName, String group) {
    this.id = Integer.MAX_VALUE;
    this.firstName = firstName;
    this.mobileNum = mobileNum;
    this.companyName = companyName;
    this.address = address;
    this.lastName = lastName;
    this.group = group;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getMobileNum() {
    return mobileNum;
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

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", firstName='" + firstName + '\'' +
            '}';
  }

}
