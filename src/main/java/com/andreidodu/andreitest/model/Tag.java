package com.andreidodu.andreitest.model;

import com.andreidodu.andreitest.model.common.ModelCommon;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@Setter
@Table(name = "el_tag")
@EntityListeners(AuditingEntityListener.class)
public class Tag extends ModelCommon {
    @Id
    @GeneratedValue(generator = "el_tag_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "el_tag_seq", sequenceName = "el_tag_seq", allocationSize = 50)
    private Long id;

    @Column(name = "name", length = 100)
    private String name;

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
