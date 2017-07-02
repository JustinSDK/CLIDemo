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
        String[] arguments = {"-version"};
        commandLine(arguments);
    }

    public static void commandLine(String[] arguments)  {
        if(arguments.length != 0 && "-help".equals(arguments[0])) {
            out.println("show help");
        } else if(arguments.length != 0 && "-version".equals(arguments[0])) {
            out.println("show version");
        }
    }
}
