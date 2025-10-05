package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Users") // Đảm bảo tên bảng trong CSDL của bạn là "Users"
public class User implements Serializable {

    // SỬA LỖI: Đặt annotation trực tiếp lên thuộc tính (field)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Dùng IDENTITY rõ ràng hơn cho PostgreSQL/MySQL
    private Long userid;

    private String email;
    private String firstName;
    private String lastName;

    // Getter và Setter không cần annotation
    public Long getUserId() {
        return userid;
    }

    public void setUserId(Long userid) {
        this.userid = userid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
