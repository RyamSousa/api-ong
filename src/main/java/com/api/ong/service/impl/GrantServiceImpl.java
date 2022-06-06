package com.api.ong.service.impl;

import com.api.ong.model.ClinicalCaseModel;
import com.api.ong.model.GrantModel;
import com.api.ong.model.UserModel;
import com.api.ong.repository.GrantRepository;
import com.api.ong.service.ClinicalCaseService;
import com.api.ong.service.GrantService;
import com.api.ong.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

import static com.api.ong.utils.Utils.*;
import static org.springframework.http.HttpStatus.*;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class GrantServiceImpl implements GrantService {

    private final GrantRepository grantRepository;
    private final ClinicalCaseService clinicalCaseService;
    private final UserService userService;

    @Override
    public GrantModel create(@NotNull GrantModel grant) {
        if (grant.getId() != null) {
            Optional<GrantModel> grantById = grantRepository.findById(grant.getId());

            grantById.ifPresent(g -> {
                if (g.getId().equals(grant.getId())) {
                    throw new ResponseStatusException(CONFLICT, RESOURCE_ALREADY_EXISTS);
                }
            });
        }

        UserModel userById = userService.getById(grant.getUser().getId());
        ClinicalCaseModel clinicalCaseById = clinicalCaseService.getById(grant.getClinicalCase().getId());

        grant.setUser(userById);
        grant.setClinicalCase(clinicalCaseById);

        return grantRepository.save(grant);
    }

    @Override
    public GrantModel update(@NotNull GrantModel grant) {
        if (grant.getId() == null) {
            throw new ResponseStatusException(BAD_REQUEST, ID_CANT_BE_NULL);
        }

        return grantRepository.save(grant);
    }

    @Override
    public GrantModel delete(@NotNull Long id) {
        Optional<GrantModel> grantById = grantRepository.findById(id);

        if (grantById.isEmpty()) {
            throw new ResponseStatusException(NOT_FOUND, RESOURCE_NOT_FOUND);
        }
        grantRepository.deleteById(grantById.get().getId());

        return grantById.get();
    }

    @Override
    public GrantModel getById(@NotNull Long id) {
        Optional<GrantModel> grant = grantRepository.findById(id);

        if (grant.isEmpty()) {
            throw new ResponseStatusException(NOT_FOUND, RESOURCE_NOT_FOUND);
        }

        return grant.get();
    }

    @Override
    public List<GrantModel> getAll() {
        List<GrantModel> allGrants = grantRepository.findAll();

        if (allGrants.isEmpty()) {
            throw new ResponseStatusException(NO_CONTENT, NO_RECORDS_FOUND);
        }

        return allGrants;
    }
}
