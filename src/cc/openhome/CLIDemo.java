/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.openhome;

import static java.lang.System.out;

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
        if(hasOption(arguments, "-help")) {
            out.println("show help");
        } 
        
        if(hasOption(arguments, "-version")) {
            out.println("show version");
        }
    }
    
    public static boolean hasOption(String[] arguments, String option) {
        
        for(String arg : arguments) {
            if(option.equals(arg)) {
                return true;
            }
        }
        return false;
    }
}
