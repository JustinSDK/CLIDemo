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
        
        if(hasOption(arguments, options, "help")) {
            out.println("Help   ");
            options.options.forEach((name, option) -> {
                out.printf("\t%-10s\t%s%n", option.name, option.description);
            });
        } 
        
        if(hasOption(arguments, options, "version")) {
            out.println("show version");
        }
    }
    
    public static boolean hasOption(String[] arguments, Options options,  String option) {
        for(String arg : arguments) {
            if(("-" + options.getOption(option).name).equals(arg)) {
                return true;
            }
        }
        return false;
    }
}
