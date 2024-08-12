package com.andreidodu.andreitest.model;

import com.andreidodu.andreitest.model.common.ModelCommon;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@Setter
@Table(name = "tag")
@EntityListeners(AuditingEntityListener.class)
public class Tag extends ModelCommon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 100)
    private String name;

}
