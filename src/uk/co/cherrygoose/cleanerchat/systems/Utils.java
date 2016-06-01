package uk.co.cherrygoose.cleanerchat.systems;

public class Utils 
{
	public static String capitalise(String string)
	{
		// Declares string for output
		String output = "";
		
		// For all characters in the string
		for (int i = 0; i < string.length(); i++)
		{
			// If the char is first in the string
			if(i == 0)
			{
				// Char toUpperCase
				output += Character.toUpperCase(string.charAt(i));
			}
			// If char is after an underscore
			else if(string.charAt(i - 1) == '_') 
			{
				// Char toUpperCase
				output += Character.toUpperCase(string.charAt(i));
			}
			// Else
			else 
			{
				// Char toLowerCase
				output += Character.toLowerCase(string.charAt(i));
			}
		}
		
		// Returns resultant string
		return output;
	}
}
