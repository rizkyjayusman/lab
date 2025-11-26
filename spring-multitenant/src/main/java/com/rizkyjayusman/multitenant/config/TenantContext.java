package com.rizkyjayusman.multitenant.config;

public class TenantContext {

    private static ThreadLocal<String> currentTenant = new InheritableThreadLocal<>();
    public static final String DEFAULT_TENANT_ID = "public";

    public static String getCurrentTenant() {
        return currentTenant.get();
    }

    public static void setCurrentTenant(String tenant) {
        currentTenant.set(tenant);
    }

    public static void clear() {
        currentTenant.set(null);
    }
}