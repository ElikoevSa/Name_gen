package NameGenerator.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "affix")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Affix {
    @NotNull
    @Id
    @GeneratedValue(strategy=IDENTITY)
    private long id;

    @Min(3)
    private String affixName;

    public Affix(String affixName) {
        this.affixName = affixName;
    }

    public Affix(long id) {
        this.id = id;
    }
}
