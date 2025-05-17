package org.example.lab_2.client.wrapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DiscountApiWrapper {
    private final PetOwnerApi ownerApi;
    public PetOwnerApi Wrapper(PetOwnerApi ownerApi) {
        this.ownerApi = ownerApi;
    }

    public PetOwnerInfoDto getPetOwnerInfo(Long petId) {
        try {
            return ownerApi.apiV1PetIdPetOwnerInfoGet(petId).getBody();
        } catch (Exception exception) {
            log.info("Error getPetOwnerInfo with id {}: {}", petId, exception.getMessage());
            return new PetOwnerInfoDto();
        }
    }
}