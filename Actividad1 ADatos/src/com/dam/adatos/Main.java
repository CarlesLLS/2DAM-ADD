package com.dam.adatos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.DirectoryStream.Filter;
import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Scanner teclado = new Scanner (System.in);
		
		
		String directorio = "";
		
		/*
		System.out.println("Introduzca un dirctorio.");
		directorio = teclado.nextLine();
		
		
		File nombredirectorio = new File(directorio);
		
		if(nombredirectorio.exists())
		{
		System.out.println("El directorio existe y da esta informacion:");
		System.out.println(nombredirectorio.getName());
		
		
		System.out.println(nombredirectorio.exists());
		System.out.println(nombredirectorio.isAbsolute());
		System.out.println(nombredirectorio.isDirectory());
		System.out.println(nombredirectorio.isFile());
		System.out.println(nombredirectorio.canExecute());
		System.out.println(nombredirectorio.canRead());
		System.out.println(nombredirectorio.canWrite());
		}
		else
		{
			System.out.println("El directorio no existe.");
		}
		
		int cantidadext = 0;
		
		System.out.println("Introduzca la cantidad de extensiones que quiere poner en el programa:");
		cantidadext = teclado.nextInt();
		
		for(int i = 0; i>=cantidadext; i++)
		{
		
		System.out.println("Ponga una extension del archivo que quiere ");
		Filtro filtro = new Filtro(teclado.next());
		
		File file = new File(directorio);
		
		String comparador = ".";
		
		if(filtro.equals(comparador))
		{
			File miFichero = new File(directorio);	
			
			File [] ficheros = miFichero.listFiles();
			
			for (File f: ficheros) 
			{
				System.out.println(f.getName());
			}
		}
		else
		{
			for(File archivo : file.listFiles())
			{
				if(filtro.accept(archivo))
				{
					System.out.println(archivo.getName());
				}
			}
		}
		}
	*/
		
	String Original = "";
	String Copia = "";
	
	System.out.println("Dime el directorio donde esta el archivo:");
	Original = teclado.nextLine();
	File dirOriginal = new File(Original);
	
	
	System.out.println("Dime un nombre para la copia del archivo:");
	Copia = teclado.nextLine();
	File dirCopia = new File(Copia);
	
	
	try(
			BufferedReader leer = new BufferedReader(new FileReader(Original));
			BufferedWriter escribir = new BufferedWriter(new FileWriter(Copia));
		){
			String linea;
			
			while((linea = leer.readLine()) != null)
			{
				System.out.println(linea);
				
				escribir.write(linea);
				escribir.newLine();
			}
			System.out.println("Completada la copia");
		 }catch(IOException e)
		{
			System.out.println("Ocurrio un error en la linea: " + e.getMessage()); 
			e.printStackTrace();
		}
		  if(dirOriginal.delete())
		  {
			  System.out.println("El archivo se ha borrado.");
		  }
		  else
		  {
			  System.out.println("El archivo no se ha borrado.");
		  }
	
	
	
        }	
}
