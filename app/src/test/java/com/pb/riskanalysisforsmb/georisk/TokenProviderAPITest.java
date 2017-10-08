package com.pb.riskanalysisforsmb.georisk;

import com.pb.riskanalysisforsmb.georisk.api.TokenProviderAPI;

import org.junit.Test;


public class TokenProviderAPITest {
    @Test
    public void getBearerAuthToken() throws Exception {
        String bearerAuthToken = TokenProviderAPI.getBearerAuthToken();
        System.out.println(bearerAuthToken);

        bearerAuthToken = TokenProviderAPI.getBearerAuthToken();
        System.out.println(bearerAuthToken);

        bearerAuthToken = TokenProviderAPI.getBearerAuthToken();
        System.out.println(bearerAuthToken);
    }

}