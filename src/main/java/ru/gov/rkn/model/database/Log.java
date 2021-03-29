package ru.gov.rkn.model.database;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Log implements Comparable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User cc_user;

    @ManyToOne
    @JoinColumn(name = "channel_id")
    private Channel channel;

    @NotNull
    private String created;

    @NotNull
    private double newFrequency;

    @NotNull
    private double newPolarizationValue;

    @Override
    public int compareTo(Object o) {
        Log anotherLog = (Log) o;
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");
//        LocalDateTime thisTime = LocalDateTime.parse(this.created, formatter);
//        LocalDateTime anotherTime = LocalDateTime.parse(anotherLog.created, formatter);
//
//        if (thisTime.isBefore(anotherTime)) {
//            return 1;
//        } else if (thisTime.isAfter(anotherTime)) {
//            return -1;
//        } else if (this.cc_user == anotherLog.cc_user && this.channel == anotherLog.channel
//                && this.newFrequency == anotherLog.newFrequency && this.newPolarizationValue == anotherLog.newPolarizationValue) {
//            return 0;
//        }
//
//        return 1;
        if (this.id > anotherLog.id) {
            return -1;
        } else if (this.id < anotherLog.id) {
            return 1;
        }

        return 0;
    }
}
