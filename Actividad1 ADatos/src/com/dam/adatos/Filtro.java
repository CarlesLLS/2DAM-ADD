package com.dam.adatos;

import java.io.File;

public class Filtro {
	
	private String extension;
	
	public Filtro (String extension)
	{
		this.extension = extension;
	}

	public boolean accept(File file)
	{
		if(file.getName().endsWith(extension))
		{
			return true;
		}
		return false;
	}

}
