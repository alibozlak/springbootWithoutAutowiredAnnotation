package bozlak.autowiredless.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@Entity
@Table(name = "us_states")
// @Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UsState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "state_id")
    @Setter(AccessLevel.NONE)
    private int stateId;

    @Column(name = "state_name")
    private String stateName;

    @Column(name = "state_abbr")
    private String stateAbbr;

    @Column(name = "state_region")
    private String stateRegion;


}
