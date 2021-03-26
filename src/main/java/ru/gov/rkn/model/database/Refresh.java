package ru.gov.rkn.model.database;

import com.sun.istack.NotNull;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import ru.gov.rkn.model.Channel;
import ru.gov.rkn.model.User;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Refresh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "channel_id")
    private Channel channel;

    @NotNull
    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    private LocalDateTime created;

    @NotNull
    private double newFrequency;

    @NotNull
    private double newPolarizationValue;

}
