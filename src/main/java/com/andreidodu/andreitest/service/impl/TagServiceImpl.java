package com.andreidodu.andreitest.service.impl;

import com.andreidodu.andreitest.dao.TagRepository;
import com.andreidodu.andreitest.model.Tag;
import com.andreidodu.andreitest.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @Override
    public boolean cleanTable() {
        try {
            tagRepository.deleteAll();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean populateTable() {
        try {
            Tag tag = new Tag();
            tag.setName("Hello World!");
            this.tagRepository.save(tag);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
