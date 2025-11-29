package com.rizkyjayusman.multitenant.module.tenant.provisioning;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TenantProvisioningController {

    private final OnboardNewTenantUseCase onboardNewTenantUseCase;

    @GetMapping("/tenants/{tenant_code}/migrations")
    public ResponseEntity<Void> migrate(@PathVariable("tenant_code") String tenantCode) {
        onboardNewTenantUseCase.migrate(tenantCode);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
