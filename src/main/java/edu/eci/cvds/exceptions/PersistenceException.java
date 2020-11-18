package edu.eci.cvds.exceptions;

/**
 *
 * @author Daniel Ducuara - Miguel Rodríguez - James Torres
 */
public class PersistenceException extends Exception
{
    public PersistenceException(String message, Throwable cause) 
    {
        super(message, cause);
    }
	public PersistenceException(String message) {
    }
}
