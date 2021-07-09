package fr.eni.projetenchereeni.message;

import java.util.ResourceBundle;

public class LecteurMessage {
private static ResourceBundle rb;
	
	static
	{
		try
		{
			rb = ResourceBundle.getBundle("fr.eni.message.messages_erreur");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	

		
	
	
	String getMessageErreur(int code);
	{
		String message="";
		try
		{
			if(rb!=null)
			{
				message = rb.getString(String.valueOf(code));
			}
			else
			{
				message="Probl�me � la lecture du fichier contenant les messages";
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			message="Une erreur inconnue est survenue";
		}
		System.out.println("message="+message);
		return message;
	}
	}

	public static String getMessageErreur(Integer code) {
		// TODO Auto-generated method stub
		return null;
	}
}
