package com.api.ong.controller.impl;

import com.api.ong.controller.GrantController;
import com.api.ong.model.GrantModel;
import com.api.ong.service.GrantService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class GrantControllerImpl implements GrantController {

    private final GrantService grantService;

    @Override
    public ResponseEntity<GrantModel> create(GrantModel grant) {
        return ResponseEntity.ok(grantService.create(grant));
    }

    @Override
    public ResponseEntity<GrantModel> update(GrantModel grant) {
        return ResponseEntity.ok(grantService.update(grant));
    }

    @Override
    public ResponseEntity<GrantModel> delete(Long id) {
        return ResponseEntity.ok(grantService.delete(id));
    }

    @Override
    public ResponseEntity<GrantModel> getById(Long id) {
        return ResponseEntity.ok(grantService.getById(id));
    }

    @Override
    public ResponseEntity<List<GrantModel>> getAll() {
        return ResponseEntity.ok(grantService.getAll());
    }
}
