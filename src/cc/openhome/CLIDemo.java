/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.openhome;

import static java.lang.System.out;
import java.util.*;

class Option {
    String name;
    String description;

    public Option(String name, String description) {
        this.name = name;
        this.description = description;
    }
}

class Options {
    Map<String, Option> options = new HashMap<>();
    
    public void addOption(String name, String description) {
        options.put(name, new Option(name, description));
    } 
    
    public Option getOption(String name) {
        return options.get(name);
    }
}

interface CommandLine {
     public boolean hasOption(String option);
}

class Parser {
    public CommandLine parse(String[] arguments, Options options) {
        if(arguments.length != 0 && arguments[0].startsWith("-")) {
            return new POSIXCommandLine(arguments, options);
        }
        throw new RuntimeException("unknown commandline style");
    }
}

class POSIXCommandLine implements CommandLine {
    String[] arguments;
    Options options;

    public POSIXCommandLine(String[] arguments, Options options) {
        this.arguments = arguments;
        this.options = options;
    }
    
    public boolean hasOption(String option) {
        for(String arg : arguments) {
            if(("-" + options.getOption(option).name).equals(arg)) {
                return true;
            }
        }
        return false;
    }    
}

class HelpFormatter {
    public void printHelp(String title, Options options) {
        out.println(title);
        options.options.forEach((name, option) -> {
            out.printf("\t%-10s\t%s%n", option.name, option.description);
        });        
    }
}
/**
 *
 * @author Justin
 */
public class CLIDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[] arguments = {"-help", "-version"};
        commandLine(arguments);
    }

    public static void commandLine(String[] arguments)  {
        Options options = new Options();
        options.addOption("help", "show help messages");
        options.addOption("version", "show version messages");
        
        Parser parser = new Parser();
        
        CommandLine cmd = parser.parse(arguments, options);
        
        if(cmd.hasOption("help")) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("Help", options);
        } 
        
        if(cmd.hasOption("version")) {
            out.println("show version");
        }
    }
}
