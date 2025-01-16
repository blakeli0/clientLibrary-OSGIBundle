package org.example.testOSGI;

import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.auth.Credentials;
import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.discoveryengine.v1.DataStore;
import com.google.cloud.discoveryengine.v1.DataStoreName;
import com.google.cloud.discoveryengine.v1.DataStoreServiceClient;
import com.google.cloud.discoveryengine.v1.DataStoreServiceSettings;

public class DataStoreClientWrapper {
    public DataStore getDataStore() {
        String tokenString = "your token";
        Credentials credentials = GoogleCredentials.create(AccessToken.newBuilder().setTokenValue(tokenString).build());
        try (DataStoreServiceClient client = DataStoreServiceClient.create(DataStoreServiceSettings
                .newHttpJsonBuilder()
                .setQuotaProjectId("your quota project id")
                .setCredentialsProvider(FixedCredentialsProvider.create(credentials))
                .build())) {
            return client.getDataStore(DataStoreName.of("your project id", "your location name", "your datastore id"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
