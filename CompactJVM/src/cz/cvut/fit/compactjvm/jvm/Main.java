package cz.cvut.fit.compactjvm.jvm;

import cz.cvut.fit.compactjvm.jvm.CompactJVM;


/**
 *
 * @author Adam Vesecky
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // load testing class file
        args = new String[]{"../CompactJVMLab/build/classes/compactjvmlab/CompactJVMLab.class"};
        
        try {

            if (args.length < 1) {
                System.out.println("Missing path to class file!");
                return;
            }

            //JVMLogger.enableLogging(JVMLogger.TAG_INSTR);
            JVMLogger.enableLogging(JVMLogger.TAG_OTHER);
            JVMLogger.enableLogging(JVMLogger.TAG_HEAP);
            JVMLogger.enableLogging(JVMLogger.TAG_GC);
            
            String classPath = args[0];
            CompactJVM jvm = new CompactJVM();
            jvm.loadApplication(classPath);
            jvm.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}