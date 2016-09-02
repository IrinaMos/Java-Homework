package il.stqa.pft.addressbook.model;

public class ContactData {
  private final String firstName;
  private final String mobileNum;
  private final String companyName;
  private final String address;
  private final String lastName;
  private String group;

  public ContactData(String firstName, String mobileNum, String companyName, String address, String lastName, String group) {
    this.firstName = firstName;
    this.mobileNum = mobileNum;
    this.companyName = companyName;
    this.address = address;
    this.lastName = lastName;
    this.group = group;
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
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
    if (mobileNum != null ? !mobileNum.equals(that.mobileNum) : that.mobileNum != null) return false;
    if (companyName != null ? !companyName.equals(that.companyName) : that.companyName != null) return false;
    if (address != null ? !address.equals(that.address) : that.address != null) return false;
    if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
    return group != null ? group.equals(that.group) : that.group == null;

  }

  @Override
  public int hashCode() {
    int result = firstName != null ? firstName.hashCode() : 0;
    result = 31 * result + (mobileNum != null ? mobileNum.hashCode() : 0);
    result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
    result = 31 * result + (address != null ? address.hashCode() : 0);
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    result = 31 * result + (group != null ? group.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "firstName='" + firstName + '\'' +
            ", mobileNum='" + mobileNum + '\'' +
            ", companyName='" + companyName + '\'' +
            ", address='" + address + '\'' +
            ", lastName='" + lastName + '\'' +
            ", group='" + group + '\'' +
            '}';

  }
}
