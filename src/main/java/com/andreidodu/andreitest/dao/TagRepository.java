package com.andreidodu.andreitest.dao;

import com.andreidodu.andreitest.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
