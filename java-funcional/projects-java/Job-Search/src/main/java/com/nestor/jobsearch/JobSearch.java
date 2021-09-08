package com.nestor.jobsearch;

import com.beust.jcommander.JCommander;
import com.nestor.jobsearch.cli.CLIArguments;

import static com.nestor.jobsearch.CommanderFunctions.buildCommanderWithName;

public class JobSearch {
    public static void main(String[] args) {
        System.out.println("Hello job search");
        JCommander jCommander = buildCommanderWithName("job-search", CLIArguments::newInstance);
    }
}
