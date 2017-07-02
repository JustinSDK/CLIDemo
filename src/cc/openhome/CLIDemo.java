/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.openhome;

import static java.lang.System.out;

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
        if(hasOption(arguments, new Option("-help", "show help messages"))) {
            out.println("show help");
        } 
        
        if(hasOption(arguments,  new Option("-version", "show version messages"))) {
            out.println("show version");
        }
    }
    
    public static boolean hasOption(String[] arguments, Option option) {
        for(String arg : arguments) {
            if(option.name.equals(arg)) {
                return true;
            }
        }
        return false;
    }
}
