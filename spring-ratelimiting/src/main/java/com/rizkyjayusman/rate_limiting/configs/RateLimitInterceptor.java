package com.rizkyjayusman.rate_limiting.configs;

import io.github.bucket4j.Bucket;
import io.github.bucket4j.ConsumptionProbe;
import io.github.bucket4j.distributed.proxy.ProxyManager;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.BucketConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.nio.charset.StandardCharsets;
import java.time.Duration;

@Component
public class RateLimitInterceptor implements HandlerInterceptor {

    private final ProxyManager<byte[]> proxyManager;

    public RateLimitInterceptor(ProxyManager<byte[]> proxyManager) {
        this.proxyManager = proxyManager;
    }

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler
    ) throws Exception {

        if (!(handler instanceof HandlerMethod method)) {
            return true;
        }

        RateLimit rateLimit = method.getMethodAnnotation(RateLimit.class);
        if (rateLimit == null) {
            return true;
        }

        BucketConfiguration config = BucketConfiguration.builder()
                .addLimit(Bandwidth.simple(rateLimit.capacity(), Duration.ofSeconds(rateLimit.refillSeconds())))
                .build();

        String key = "rate-limit:" + rateLimit.key();
        Bucket bucket = proxyManager.builder().build(key.getBytes(StandardCharsets.UTF_8), config);

        ConsumptionProbe probe = bucket.tryConsumeAndReturnRemaining(1);

        if (probe.isConsumed()) {
            response.setHeader(
                    "X-Rate-Limit-Remaining",
                    String.valueOf(probe.getRemainingTokens())
            );
            return true;
        }

        response.setStatus(429);
        response.getWriter().write("Too Many Requests");
        return false;
    }
}
