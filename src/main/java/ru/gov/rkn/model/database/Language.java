package ru.gov.rkn.model.database;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gov.rkn.model.enums.LanguageCaption;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private LanguageCaption caption;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "channels_languages",
            joinColumns = {@JoinColumn(name = "language_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "channel_id", referencedColumnName = "id")}
    )
    private List<Channel> channels;

}
