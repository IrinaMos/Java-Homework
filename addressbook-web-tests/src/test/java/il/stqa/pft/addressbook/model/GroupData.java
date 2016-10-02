package il.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@XStreamAlias("group")
@Entity
@Table(name = "group_list")
public class GroupData {
  @XStreamOmitField
  @Id
  @Column(name = "group_id")
  private int id = Integer.MAX_VALUE;

  @Expose
  @Column(name = "group_name")
  private String name;

  @Expose
  @Type(type = "text")
  @Column(name = "group_header")
  private String header;

  @Expose
  @Type(type = "text")
  @Column(name = "group_footer")
  private String footer;

    /* public GroupData(String name, String header, String footer) {
    this.id = Integer.MAX_VALUE;
    this.name = name;
    this.header = header;
    this.footer = footer;
  }

  public GroupData(int id, String name, String header, String footer) {
    this.id = id;
    this.name = name;
    this.header = header;
    this.footer = footer;
  }*/

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }


  public String getHeader() {
    return header.replaceAll("\\r\\n", "\n");
  }

  public String getFooter() {
    return footer.replaceAll("\\r\\n", "\n");
  }

  public GroupData withId(int id) {
    this.id = id;
    return this;
  }

  public GroupData withName(String name) {
    this.name = name;
    return this;
  }

  public GroupData withFooter(String footer) {
    footer = footer.replaceAll("\r\n", "\n");
    this.footer = footer;
    return this;
  }

  public GroupData withHeader(String header) {
    header = header.replaceAll("\r\n", "\n");
    this.header = header;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    GroupData groupData = (GroupData) o;

    if (id != groupData.id) return false;
    if (name != null ? !name.equals(groupData.name) : groupData.name != null) return false;
    if (header != null ? !getHeader().equals(groupData.getHeader()) : groupData.getFooter() != null) return false;
    return footer != null ? getFooter().equals(groupData.getFooter()) : groupData.getFooter() == null;

  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (header != null ? getHeader().hashCode() : 0);
    result = 31 * result + (footer != null ? getFooter().hashCode() : 0);
    return result;
  }

  @Override

  public String toString() {
    return "GroupData{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            '}';
  }

}
