package com.example;

import za.ac.sun.grapl.Cannon;
import za.ac.sun.grapl.hooks.TinkerGraphHook;

import java.io.File;
import java.io.IOException;

public class TinkerGraphApp {

    public static void main(String[] args) throws IOException {
        System.out.println("Creating hook");
        TinkerGraphHook hook = new TinkerGraphHook.TinkerGraphHookBuilder().build();
        // Attach the hook to the cannon
        Cannon cannon = new Cannon(hook);
        File f = new File("./src/main/resources/examples/intraprocedural/arithmetic/Arithmetic1.java");
        // Load the cannon with the directory of all the tests
        cannon.load(f);
        // Fire the loaded files to be projected the graph database
        System.out.println("Projecting graph");
        cannon.fire();
        // For the TinkerGraph hook, we can export this graph using the format and
        // directory specified by the extension
        hook.exportCurrentGraph("./graph.xml");
        System.out.println("Done!");
    }

}
