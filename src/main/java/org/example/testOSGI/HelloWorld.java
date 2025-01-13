package org.example.testOSGI;

import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.auth.Credentials;
import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.discoveryengine.v1.DataStore;
import com.google.cloud.discoveryengine.v1.DataStoreName;
import com.google.cloud.discoveryengine.v1.DataStoreServiceClient;
import com.google.cloud.discoveryengine.v1.DataStoreServiceSettings;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class HelloWorld implements BundleActivator {
    public void start(BundleContext ctx) {
        System.out.println("Hello world.");
        getDataStore();
    }

    private static void getDataStore() {
        String tokenString = "your token";
        Credentials credentials = GoogleCredentials.create(AccessToken.newBuilder().setTokenValue(tokenString).build());
        try (DataStoreServiceClient client = DataStoreServiceClient.create(DataStoreServiceSettings
                .newHttpJsonBuilder()
                .setQuotaProjectId("your quota project id")
                .setCredentialsProvider(FixedCredentialsProvider.create(credentials))
                .build())) {
            DataStore dataStore = client.getDataStore(DataStoreName.of("your project id", "your location name", "your datastore id"));
            System.out.println(dataStore);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stop(BundleContext bundleContext) {
        System.out.println("Goodbye world.");
    }
}