package NameGenerator.data;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "prefix")
@Data
@NoArgsConstructor
public class Prefix {
    @NotNull
    @Id
    @GeneratedValue(strategy=IDENTITY)
    private long id;

    @Min(3)
    private String prefixName;

    public Prefix(String prefixName) {
        this.prefixName = prefixName;
    }

    public Prefix(long id) {
        this.id = id;
    }
}
