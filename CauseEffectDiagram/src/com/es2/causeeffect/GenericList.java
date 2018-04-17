package com.es2.causeeffect;

/**
 * A class to provide a simple list.
 * List resizes automatically. Used to illustrate 
 * various design and implementation details of 
 * a class in Java.
 *
 */
public class GenericList{
    // class constant for default size
    private static final int DEFAULT_CAP = 10;
    
    //instance variables
    // iValues store the elements of the list and 
    // may have extra capacity
    private Object[] iValues;
    private int iSize;
    
    /**
     * Insert obj at position pos.
     * post: get(pos) = x, size() = old size() + 1
     * @param pos 0 <= pos <= size()
     * @param obj The element to add, which should be other than null.
     */
    public void insert(int pos, Object obj){
    		assert obj != null : "Object should not be null";    		
    		assert pos >=0 && pos <= iSize : "pos should be within the interval";
    		
        ensureCapacity();
        
        for(int i = iSize; i > pos; i--){
            iValues[i] = iValues[i - 1];
        }
        iValues[pos] = obj;
        iSize++;
    }
        
    private void ensureCapacity(){
        // is there extra capacity available?
        // if not, resize
        if(iSize == iValues.length)
            resize();
    }
    
    public int size(){
        return iSize;
    }
    
    // resize internal storage container by a factor of 2
    private void resize() {
        Object[] temp = new Object[iValues.length * 2];
        System.arraycopy(iValues, 0, temp, 0, iValues.length);
        iValues = temp;
    }
    
    /**
     * Default constructor. Creates an empty list.
     */
    public GenericList(){
        //redirect to single int constructor
        this(DEFAULT_CAP);
        //other statments could go here.
    }

    /**
     * Constructor to allow user of class to specify 
     * initial capacity in case they intend to add a lot
     * of elements to new list. Creates an empty list.
     * @param initialCap > 0
     */    
    public GenericList(int initialCap) {
        assert initialCap > 0 : "Violation of precondition. IntListVer1(int initialCap):"
            + "initialCap must be greater than 0. Value of initialCap: " + initialCap;
        iValues = new Object[initialCap];
        iSize = 0;
    }
    


}