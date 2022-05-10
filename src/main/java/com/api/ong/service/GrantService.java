package com.api.ong.service;

import com.api.ong.model.GrantModel;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface GrantService {

    GrantModel create(GrantModel grant);

    GrantModel update(GrantModel grant);

    GrantModel delete(Long id);

    GrantModel getById(Long id);

    List<GrantModel> getAll();
}
