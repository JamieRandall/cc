package ru.gov.rkn.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Satellite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "channels_satellites",
            joinColumns = {@JoinColumn(name = "satellite_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "channel_id", referencedColumnName = "id")}
    )
    private List<Channel> channels;
}
