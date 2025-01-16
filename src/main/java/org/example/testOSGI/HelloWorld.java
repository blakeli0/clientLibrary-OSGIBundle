package org.example.testOSGI;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class HelloWorld implements BundleActivator {
    public void start(BundleContext ctx) {
        System.out.println("Hello world.");
        DataStoreClientWrapper wrapper = new DataStoreClientWrapper();
        System.out.println(wrapper.getDataStore());
    }

    public void stop(BundleContext bundleContext) {
        System.out.println("Goodbye world.");
    }
}