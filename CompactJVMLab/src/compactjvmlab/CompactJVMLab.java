/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compactjvmlab;

/**
 * Simple class that will be used for testing CompactJVM project
 * Just write anything, compile into class file and load it, using CompactJVM
 * @author Adam Vesecky
 */
public class CompactJVMLab {

    private static int staticPrivateProm1;
    private static int staticPrivateProm2;
    private static int staticPrivateProm3;
    
    
    private void setStaticProm() {
        staticPrivateProm1 = 11;
        staticPrivateProm2 = 12;
        staticPrivateProm3 = 13;
    }

    public static void main() {
        /*int local = 7;
        local = local + 1;*/
        TestClass.testMethod(4, 5);
    }
    /*public static int staticPublicProm;
    
    private int instantPrivateProm;
    public int instantPublicProm;
    
    public int localVariableMethod() {
        int a = 13;
        return a;
    }
    
    public static void staticVoidMethod(){
        
    }
    
    public static int staticIntMethod(){
        return 12;
    }
    
    public void instantVoidMethod(){
        
    }
    
    public int instantIntMethod(){
        return 25;
    }
    
    public static void main(String[] args) {
        staticVoidMethod();
        staticIntMethod();
        
        CompactJVMLab mn = new CompactJVMLab();
        mn.instantVoidMethod();
        mn.instantIntMethod();
    }
    */
}
