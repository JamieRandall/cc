package ru.gov.rkn.model.database;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gov.rkn.model.enums.ChannelCountry;
import ru.gov.rkn.model.enums.ChannelEncoding;
import ru.gov.rkn.model.enums.ChannelPolarization;
import ru.gov.rkn.model.enums.ChannelType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Channel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private Integer frequency;

    @NotNull
    private Integer flowRate;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ChannelPolarization polarization;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ChannelCountry country;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ChannelEncoding encoding;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ChannelType type;

    @NotNull
    private String broadcastBegan;

    @NotNull
    private String broadcastConfirmed;

    @NotNull
    private boolean isBroadcasted;

    private String description;

    @ManyToMany(mappedBy = "channels", cascade = CascadeType.MERGE)
    private List<Satellite> satellites;

    @ManyToMany(mappedBy = "channels", cascade = CascadeType.MERGE)
    private List<Language> languages;

    @OneToMany(mappedBy = "channel")
    private List<Log> logs;
}
