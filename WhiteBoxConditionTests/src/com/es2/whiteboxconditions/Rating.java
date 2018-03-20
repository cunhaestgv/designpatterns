package com.es2.whiteboxconditions;

public class Rating {
	/**
	 * Evaluates the score of an individual in a game and the temperature in the room.
	 * @param score represents the score
	 * @param temperature represents the temperature
	 * @return "It's hot out, and so am I" when the score is equal or greater than 10 and the temperature is equal or greater than 35. Otherwise, returns "I'm in a bad mood" when the the score is less than 5 or the temperature is equal or lower than 20. In all other situations, it returns ""I'm balanced".  
	 */
	public String evaluateScoreTemperature(int score, int temperature) {
		if ( (score >= 10) && (temperature >= 35) ) {
			return "It's hot out, and so am I";
		}else if ( (score < 5) || (temperature <= 20) )
			return "I'm in a bad mood";

		return "I'm balanced";
	}

	/**
	 * Evaluates if a person can be accepted to enter in a disco
	 * @param dressStyle Classification of dress style from 0 to 10
	 * @param talkSkill Classification of talking skills from 0 to 10
	 * @return "Accepted" if the dressStyle is equal or higher than 8 and the talkSkill is equal or higher than 5. Otherwise, returns "Not Accepted".
	 */
	public String evaluateIfCouldBeAcceptedAtDisco(int dressStyle, int talkSkill) {
		if (dressStyle>=8 && talkSkill>=5)
			return "Accepted";
		else
			return "Not Accepted";
	}
}
