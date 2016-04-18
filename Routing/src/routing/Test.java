/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package routing;

/**
 *
 * @author simon.yang
 */
public class Test
{
    static class Util
    {
        public static int doBart( int a )
        {
            return a + a*a + 1;
        }
    }
    interface SolverIfc
    {
        public int solve( int x );    
    }
    
    // this is the way if you want to control how people to Bart
    static abstract class Solver implements SolverIfc
    {
        public int solve( int x )
        {
            int a = generateA( x );
            return Util.doBart( a );
        }
        abstract int generateA( int x );
    }
    
    
    // This is the way if you don't want to control it but want to provide 
    // support for people who wants to do Bart
    interface GeneratorIfc
    {
        public int generateA( int x );
    }
    static class Fun extends Solver implements GeneratorIfc
    {
        public int generateA( int x )
        {
            return x/2;
        }
    }
    
    
    static class Fun2 extends Solver implements GeneratorIfc
    {
        public int generateA( int x )
        {
            return x+2;
        }
    }
    public static void main( String args[] )
    {
        // test( "Solver", new Solver(), 10 );
        test( "Fun", new Fun(), 10 );
        test( "Fun2", new Fun2(), 10 );
    }
    
    public static void test( String tag, SolverIfc solver, int x )
    {
        int result = solver.solve( x );
        System.out.println( "Testing " + tag + ": " + x + " -> " + result );
    }
    public static void test2( String tag, GeneratorIfc solver, int x )
    {
        int a = solver.generateA( x );
        int result = Util.doBart(a);
        System.out.println( "Testing " + tag + ": " + x + " -> " + result );
    }
}
