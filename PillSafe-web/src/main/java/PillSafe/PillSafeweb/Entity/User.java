package PillSafe.PillSafeweb.Entity;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Table(name="user_table")
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "user_googleId")
    private String googleId;

    @NonNull
    @Column(name="user_username")
    private String name;

    @NonNull
    @Column(name="user_email")
    private String email;
}