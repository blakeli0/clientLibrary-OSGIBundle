# What is this repo?
This repo demonstrated that a Java Google Cloud Client library (discoveryengine) can be used from an OSGI bundle by embedding all its dependencies. This is achieved by using [maven-bundle-plugin](https://felix.apache.org/documentation/subprojects/apache-felix-maven-bundle-plugin-bnd.html).

This bundle can also be used from another OSGI bundle as long as it embeds all the dependencies. For example, `DataStoreClientWrapper` is a wrapper of `DataStoreServiceClient`, it can be initialized and called from another bundle with the following code:
```
DataStoreClientWrapper wrapper = new DataStoreClientWrapper();
DataStore datastore = wrapper.getDataStore();
```