package il.stqa.pft.addressbook.model;

public class ContactData {
  private final String firstName;
  private final String mobileNum;
  private final String companyName;
  private final String address;
  private final String lastName;

  public ContactData(String firstName, String mobileNum, String companyName, String address, String lastName) {
    this.firstName = firstName;
    this.mobileNum = mobileNum;
    this.companyName = companyName;
    this.address = address;
    this.lastName = lastName;
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
}
