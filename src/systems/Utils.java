package systems;

public class Utils 
{
	public static String capitalise(String string)
	{
		// Declares string for colour name
		String colourName = "";
		
		// For all characters in the colour name
		for (int i = 0; i < string.length(); i++)
		{
			// If the char is first in the name
			if(i == 0)
			{
				// Char toUpperCase
				colourName += Character.toUpperCase(string.charAt(i));
			}
			// If char is after an underscore
			else if(string.charAt(i - 1) == '_') 
			{
				// Char toUpperCase
				colourName += Character.toUpperCase(string.charAt(i));
			}
			// Else
			else 
			{
				// Char toLowerCase
				colourName += Character.toLowerCase(string.charAt(i));
			}
		}
		
		// Returns resultant string
		return colourName;
	}
}
