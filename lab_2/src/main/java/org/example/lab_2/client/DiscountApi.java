package org.example.lab_2.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "discount-info-api", url = "{$discount-info.url}")
public interface DiscountApi {
}
