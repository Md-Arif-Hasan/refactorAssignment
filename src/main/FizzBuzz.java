package main;


import java.util.List;


public class FizzBuzz {

    private List<PatternMatcher> patternMatchers;
    private PatternMatcher nullObjectPattern;

    public FizzBuzz(List<PatternMatcher> patternMatchers, PatternMatcher nullObjectPattern)
    {
        super();
        this.patternMatchers = patternMatchers;
        this.nullObjectPattern = nullObjectPattern;
    }

    public String responseHandler(int number)
    {

        String response = null;
        for (PatternMatcher patternMatcher : patternMatchers) {
            if (patternMatcher.checkMatching(number))
            {
                response += patternMatcher.createResponse();
            }
        }

         response = nullObjectPattern.createResponse();

        if(response.equals(""))
        {
            response+=String.valueOf(number);
        }

        return response;
    }
}
