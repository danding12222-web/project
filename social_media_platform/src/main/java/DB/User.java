package DB;

import jakarta.persistence.*;

@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    
    @Column(nullable = false, unique = true)
    private String phonenumber;
    
    private String name;
    
    private String email;
    
    @Column(nullable = false)
    private String password;

    private String coverImage;

    private String biography;

    // Getter & Setter
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getUserphonenumber() { return phonenumber; }
    public void setUserphonenumber(String phonenumber) { this.phonenumber = phonenumber; }
    
    public String getUsername() { return name; }
    public void setUsername(String name) { this.name = name; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getCoverImage() { return coverImage; }
    public void setCoverImage(String coverImage) { this.coverImage = coverImage; }

    public String getBiography() { return biography; }
    public void setBiography(String biography) { this.biography = biography; }
}


