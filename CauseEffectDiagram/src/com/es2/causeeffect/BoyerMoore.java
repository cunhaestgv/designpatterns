package com.es2.causeeffect;

public class BoyerMoore
{
    protected final int BASE;
    protected int[]     occurrence;
    protected String    pattern;
 
    /**
     * Constructor
     * @param pattern Represents the text to be searched
     */
    public BoyerMoore(String pattern)
    {
    		assert pattern != null : "Pattern should not be null";
    		
        this.BASE = 256;
        this.pattern = pattern;
        occurrence = new int[BASE];
        for (int c = 0; c < BASE; c++)
            occurrence[c] = -1;
        for (int j = 0; j < pattern.length(); j++)
            occurrence[pattern.charAt(j)] = j;
    }
 
    /**
     * Searches the pattern in the text
     * @param text The text where the pattern is searched.
     * @param minChars Defines the minimum number of chars of the pattern (starting from the first position) acceptable. When set to 0, is is considered the full pattern for analysis.
     * @return The position in the text where the pattern starts.
     * @throws PatternNotFoundException 
     */
    public int search(String text, int minChars) throws PatternNotFoundException
    { 	
    		assert text != null : "Text should be not null";
    		assert minChars>=0 : "MinChars should be positive";
    		assert minChars==0 || minChars<=pattern.length() : "MinChars cannot be higher than pattern length";
        int n = text.length();
        int m = (minChars> 0)?minChars:pattern.length();
        int skip;
        for (int i = 0; i <= n - m; i += skip)
        {
            skip = 0;
            for (int j = m - 1; j >= 0; j--)
            {
                if (pattern.charAt(j) != text.charAt(i + j))
                {
                    skip = Math.max(1, j - occurrence[text.charAt(i + j)]);
                    break;
                }
            }
            if (skip == 0)
                return i;
        }
        if(n==text.length()) throw new PatternNotFoundException();
        return n;
    }
}