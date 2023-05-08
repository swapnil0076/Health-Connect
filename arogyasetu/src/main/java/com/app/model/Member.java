package com.app.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.time.LocalDate;
@Data
@Getter
@Setter
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "boolean default false")
    private boolean dose1Status = false;
    @Column(columnDefinition = "boolean default false")
    private boolean dose2Status = false;
    @Column(columnDefinition = "Date default null")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dose1Date;
    @Column(columnDefinition = "Date default null")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dose2Date;
    private VaccineRegistration registration;
    @OneToOne(cascade = CascadeType.ALL)
    private User user;
    @JsonProperty(access =  JsonProperty.Access.WRITE_ONLY)
    @OneToOne(mappedBy = "memberId",cascade = CascadeType.ALL)
    private Appointment appointment;
    @JsonProperty(access =  JsonProperty.Access.WRITE_ONLY)
    @OneToOne(mappedBy = "member",cascade = CascadeType.ALL)
    private Vaccine vaccine;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Member{");
        sb.append("user=").append(user);
        sb.append('}');
        return sb.toString();
    }
}
