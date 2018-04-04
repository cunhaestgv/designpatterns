package com.es2.blackboxpartitioning;

import java.util.Random;

/**
 * Models a playing die with sides numbered 1 to N.
 * All sides have uniform probability of being rolled.
 */
public class Die
{   public static final int DEFAULT_SIDES = 6;

    private static Random ourRandNumGen = new Random();

    private final int iMyNumSides;
    private int iMyResult;


    /**
     * Default constructor.<p>
     * pre: none<br>
     * post: getNumSides() = DEFAULT_SIDES = 6, getResult() = 1
     */
    public Die()
    {   
    		this(DEFAULT_SIDES);
    }


    /**
     * Create a Die with numSides sides<p>
     * @param numSides specifies the number of sides of the die<br>
     * pre: numSides > 1 && numSides <=6 <br>
     * post: getNumSides() = numSides, getResult() = 1
     * @throws AssertionError if the preconditions are not met
     */
    public Die(int numSides)
    {   
    		if(!(numSides > 1  && numSides <= 6)) throw new AssertionError("Violation of precondition: numSides = " + numSides + "numSides must be greater than 1");

        iMyNumSides = numSides;
        iMyResult = 1;
        if(!(getResult() == 1 && getNumSides() == numSides)) throw new AssertionError();
    }


    /**
     * Create a Die with numSides and top side and result set to result<p>
     * @param numSides specifies the number of sides of the die
     * @param result specifies the current result of the die, indicated by the top side<br>
     * pre: numSides > 1, 1 <= result <= numSides<br>
     * post: getNumSides() = numSides, getResult() = 1<br>
     * AssertionError exception will be generated if the preconditions are not met
     */
    public Die(int numSides, int result)
    {   if(!(numSides > 1 && 1 <= result && result <= numSides)) throw new AssertionError("Violation of precondition");

        iMyNumSides = numSides;
        iMyResult = result;
    }


    /**
     * Roll this Die. Every side has an equal chance of being the new result<br>
     * pre: none<br>
     * post: 1 <= getResult() <= getNumSides()
     * @return the result of the Die after the roll
     * Code to generate a new number randomly
     * <pre>{@code Random ourRandNumGen = new Random();
     * .... 
     * iMyResult = ourRandNumGen.nextInt(iMyNumSides) + 1;
     * }</pre> 
     */
    public int roll()
    {   iMyResult = ourRandNumGen.nextInt(iMyNumSides) + 1;

        if(!( ( 1 <= getResult() ) && ( getResult() <= getNumSides() ))) throw new AssertionError();

        return iMyResult;
    }


    /**
     * Determines how many sides this Die has<br>
     * pre: none<br>
     * post: return how many sides this Die has
     * @return the number of sides on this Die
     */
    public int getNumSides()
    {   return iMyNumSides; }

    
    /**
     * Get the current result or top number of this Die<br>
     * pre: none<br>
     * post: return the number on top of this Die
     * @return Returns the current result of this Die
     */
    public int getResult()
    {   return iMyResult;   }


    /**
     * Returns a String containing information about this Die<br>
     * pre: none<br>
     * post: return a String with information about the current state of this Die
     * @return: A String with the number of sides and current result of this Die
     */
    public String toString()
    {   return "Num sides " + getNumSides() + " result " + getResult();
    }


}
