package ru.gov.rkn.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gov.rkn.model.database.Refresh;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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

    private String name;

    private double frequency;

    private double polarizaionValue;

    @ManyToMany(mappedBy = "channels", cascade = CascadeType.MERGE)
    List<Satellite> satellites;

    @OneToMany(mappedBy = "channel")
    private List<Refresh> refreshes;
}
