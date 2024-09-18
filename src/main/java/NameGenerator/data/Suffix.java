package NameGenerator.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "suffix")
@Data
@NoArgsConstructor
public class Suffix {
    @NotNull
    @Id
    @GeneratedValue(strategy=IDENTITY)
    private long id;

    @Min(3)
    private String suffixName;

    public Suffix(long id) {
        this.id = id;
    }

    public Suffix(String suffixName) {
        this.suffixName = suffixName;
    }
}
