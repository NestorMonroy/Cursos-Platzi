package com.nestor.jobsearch;

import com.beust.jcommander.JCommander;
import com.nestor.jobsearch.api.APIJobs;
import com.nestor.jobsearch.cli.CLIArguments;
import com.nestor.jobsearch.cli.CLIFunctions;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static com.nestor.jobsearch.CommanderFunctions.buildCommanderWithName;
import static com.nestor.jobsearch.CommanderFunctions.parseArguments;
import static com.nestor.jobsearch.api.APIFunctions.buildAPI;

public class JobSearch {
    public static void main(String[] args) {
        System.out.println("Hello job search");
        //Creacion de nuestro CLI con JCommander
        JCommander jCommander = buildCommanderWithName("job-search", CLIArguments::newInstance);

        //Obtenemos las opciones que se le dieron a JCommander
        Stream<CLIArguments> streamOfCLI =
                //Nos retorna un Optional<List<Object>>
                parseArguments(jCommander, args, JCommander::usage)
                        //En caso de un Optional.empty()
                        .orElse(Collections.emptyList())
                        .stream()
                        .map(obj -> (CLIArguments) obj);


        //Tomamos nuestro Stream y obtenemos las opciones que se dieron en el CLI
        Optional<CLIArguments> cliOptional = streamOfCLI
                //Solo nos interesan los casos donde no sea la solicitud de ayuda
                .filter(cli -> !cli.isHelp())
                //Y que contengan un keyword, en otros caso no tenemos que buscar
                .filter(cli -> cli.getKeyword() != null)
                .findFirst();

        //Si el Optional tiene un dato, lo convertimos a Map<String,Object>
        cliOptional.map(CLIFunctions::toMap)
                //Convertimos el Map en un request
                .map(JobSearch::executeRequest)
                //Aun seguimos operando sobre un Optional… en caso de que no hubiera datos
                //Generamos un stream vacio
                .orElse(Stream.empty())
                //Imprimimos los datos por pantalla.
                .forEach(System.out::println);

    }

    private static Stream<JobPosition> executeRequest(Map<String, Object> params){
        APIJobs api = buildAPI(APIJobs.class, "https://jobs.github.com");
        return Stream.of(params)
                .map(api::jobs)
                .flatMap(Collection::stream);
    }
}
