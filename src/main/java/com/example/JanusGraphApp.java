package com.example;

import za.ac.sun.grapl.Cannon;
import za.ac.sun.grapl.hooks.JanusGraphHook;
import za.ac.sun.grapl.hooks.TinkerGraphHook;

import java.io.File;
import java.io.IOException;

public class JanusGraphApp {

    public static void main(String[] args) throws Exception {
        System.out.println("Creating hook");
        JanusGraphHook hook = new JanusGraphHook
                .JanusGraphHookBuilder("src/main/resources/conf/remote.properties")
                .clearDatabase(true)
                .build();
        // Attach the hook to the cannon
        Cannon cannon = new Cannon(hook);
        File f = new File("./src/main/resources/examples/intraprocedural/basic/Basic1.java");
        // Load the cannon with the directory of all the tests
        cannon.load(f);
        // Fire the loaded files to be projected the graph database
        System.out.println("Projecting graph");
        cannon.fire();
        hook.close();
        System.out.println("Done!");
        System.exit(0);
    }

}
