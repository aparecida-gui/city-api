package com.city.api.states.entities;

import com.city.api.countries.entities.Country;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.List;

@Entity(name = "State")
@Table(name = "estado")
@TypeDefs({@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)})
public class State {

    @Id
    private Long id;

    @Column(name = "nome")
    private String name;

    private String uf;
    private Integer ibge;

//    @Column(name = "pais")
//    private Integer countryId;

    @ManyToOne
    @JoinColumn(name = "pais", referencedColumnName = "id")
    private Country country;

    @Type(type = "jsonb")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "ddd", columnDefinition = "jsonb")
    private List<Integer> ddd;

    public State () {
    }

    public Long getId () {
        return id;
    }

    public String getName () {
        return name;
    }

    public String getUf () {
        return uf;
    }

    public Integer getIbge () {
        return ibge;
    }

    //public Integer getCountryId () {
    // return countryId;
    // }

    public Country getCountry () {
        return country;
    }

    public List<Integer> getDdd () {
        return ddd;
    }
}
