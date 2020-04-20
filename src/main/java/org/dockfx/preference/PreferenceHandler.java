package org.dockfx.preference;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.dockfx.ContentHolder;
import org.dockfx.DockPane;

/**
 * This class supports the ability to persist (and load) the {@link DockPane} preference using different {@link InputStream} and {@link OutputStream}s. 
 * A default methods for {@link FileOutputStream} and 
 * 
 * @author ben-kemister
 * @since 21 April 2020
 *
 */
public class PreferenceHandler {
	
	private static final Logger LOGGER = Logger.getLogger(PreferenceHandler.class.getName());
	
	private String preferenceFilePath;

	public PreferenceHandler(String preferenceFilePath) {
		this.preferenceFilePath = preferenceFilePath;
	}
	
	
	public PreferenceHandler() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void savePreferences(HashMap<String, ContentHolder> contents, String filePath) {
		
		try ( FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
			savePreferences(contents, fileOutputStream);
		}
		catch (FileNotFoundException e)
		{
			LOGGER.log(Level.WARNING, "Could not save preferences to {0}", filePath);
		} catch (IOException e1) {
			LOGGER.log(Level.WARNING, "Error closing FileOutputStream");
		}
	}
	
	
	public void savePreferences(HashMap<String, ContentHolder> contents, OutputStream outputStream) {
		
		try (
				XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(outputStream)))
		{
			encoder.writeObject(contents);
		}
	}
	
	
	public Map<String, ContentHolder> getPreferences(String filePath) {
		
		Map<String, ContentHolder> contents = null;

	    try ( FileInputStream fileInputStream = new FileInputStream(filePath) ) {
	      contents = getPreferences(fileInputStream);
	    }
		catch (NullPointerException e) {
			LOGGER.log(Level.WARNING, "Null filepath, cannot load preferences");
		} catch (FileNotFoundException e) {
			LOGGER.log(Level.WARNING, "No preferences found at {0}", filePath);
		} catch (ArrayIndexOutOfBoundsException e) {
			LOGGER.log(Level.WARNING, "Could not retrieve any preferences from {0}", filePath);
		} catch (ClassCastException e) {
			LOGGER.log(Level.WARNING, "Could not load preferences in correct format from {0} ", filePath);
		} catch (IOException e) {
			LOGGER.log(Level.WARNING, "Error closing FileInputStream");
		}
	    return contents;
	}
	
	
	@SuppressWarnings("unchecked")
	public Map<String, ContentHolder> getPreferences(InputStream inputStream) {
		
		HashMap<String, ContentHolder> contents = null;

	    try (
	        XMLDecoder decoder =
	                           new XMLDecoder(new BufferedInputStream(inputStream), Thread.currentThread().getContextClassLoader()))
	    {
	      contents = (HashMap<String, ContentHolder>) decoder.readObject();
	    }
	    return contents;
	}
	

}
