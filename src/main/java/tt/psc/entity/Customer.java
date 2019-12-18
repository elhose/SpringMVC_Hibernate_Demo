package tt.psc.entity;

import tt.psc.DBNames.CustomerNames;

import javax.persistence.*;

@Entity
@Table(name = CustomerNames.TABLENAME)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = CustomerNames.ID_COLUMNNAME)
    private Integer id;

    @Column(name = CustomerNames.FIRST_NAME_COLUMNNAME)
    private String firstName;

    @Column(name = CustomerNames.LAST_NAME_COLUMNNAME)
    private String lastName;

    @Column(name = CustomerNames.EMAIL_COLUMNNAME)
    private String email;

    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Customer() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
