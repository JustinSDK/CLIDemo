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
        Map<String, Option> options = new HashMap<>();
        options.put("-help", new Option("-help", "show help messages"));
        options.put("-version", new Option("-version", "show version messages"));
        
        if(hasOption(arguments, options, "-help")) {
            out.println("show help");
        } 
        
        if(hasOption(arguments, options, "-version")) {
            out.println("show version");
        }
    }
    
    public static boolean hasOption(String[] arguments, Map<String, Option> options,  String option) {
        for(String arg : arguments) {
            if(options.get(option).name.equals(arg)) {
                return true;
            }
        }
        return false;
    }
}
