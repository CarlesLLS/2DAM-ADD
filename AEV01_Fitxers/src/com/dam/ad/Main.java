package com.dam.ad;

import java.io.File;
import java.util.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String direntrada = "";
		
		int selector;
		
		
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Introduzca el directorio donde desea hacer acciones:");
		direntrada = teclado.nextLine();
		
		File directorio = new File(direntrada);
		
		
		System.out.println("Introduzca lo que quiere hacer:");
		System.out.println("1.Mostrar Informacion del fichero o directorio que seleccione.");
		System.out.println("2.Crear Carpeta.");
		System.out.println("3.Crear Fichero.");
		System.out.println("4.Eliminar Fichero.");
		System.out.println("5.Renombrar Fichero / Carpeta.");
		selector = teclado.nextInt();
		teclado.nextLine();
		
		if(selector >= 1 & selector <= 5)
		{
			try {
				if(selector == 1)
				{
					mostrarInfo(directorio);
				}
				if(selector == 2)
				{
					crearCarpeta(directorio);
				}
				if(selector == 3)
				{
					crearFichero(directorio);
				}
				if(selector == 4)
				{
					eliminarFichero(directorio);
				}
				if(selector == 5)
				{
					renombrarFichero(directorio);
				}

			} catch(Exception e) {

			    System.out.println("ERROR: El archivo o directorio seleccionado no existe");

			}
		}
		
		
	}
	
	public static void crearCarpeta(File directorio) 
	{
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Introduzca el nombre que quiere ponerle a la carpeta.");
		String nomcarp = "";
		nomcarp = teclado.nextLine();
		File nuevacarpeta = new File(directorio, nomcarp);
		
		if(nuevacarpeta.mkdir())
		{
			System.out.println("Carpeta creada correctamente: " + nuevacarpeta.getAbsolutePath());
		}
		else
		{
			System.out.println("La carpeta ya existe en este directorio.");
		}
	}
	
	public static void mostrarInfo(File directorio)
	{
		Scanner teclado = new Scanner(System.in);
		
		long ms = directorio.lastModified();
		Date fecha = new Date(ms);
		
		System.out.println("Introduzca la ruta del directorio o fichero.");
		String dirinfo = "";
		dirinfo = teclado.nextLine();
		
		File info = new File(directorio,dirinfo);
		
		if(directorio.isDirectory())
		{
			System.out.println("-Es un directorio.");
		}
		if(directorio.isFile())
		{
			System.out.println("-Es un archivo.");
		}
		System.out.println("Nombre: " + info.getName());
		System.out.println("Ruta Completa: " + info.getPath());
		System.out.println("Visibilidad del directorio: " + info.isHidden());
		System.out.println("Última modificación: " + fecha);
		System.out.println("El archivo pesa " + info.length() + " Bytes.");
		System.out.println("Espacio usable: " + info.getUsableSpace());
		System.out.println("Espacio total: " + info.getTotalSpace());
		System.out.println("Cantidad de elementos que contiene: " + info.list().length);
	}
	
	public static void eliminarFichero(File directorio)
	{
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Introduzca la ruta del fichero que desea eliminar.");
        String dirfichero = teclado.nextLine();
        File ficheroEliminar = new File(directorio,dirfichero);

        if (ficheroEliminar.exists() && ficheroEliminar.isFile()) 
        {
            if (ficheroEliminar.delete()) 
            {
                System.out.println("Fichero eliminado correctamente.");
            } else 
            {
                System.out.println("No se pudo eliminar el fichero.");
            }
        } 
        else 
        {
            System.out.println("El fichero no existe o no es un fichero.");
        }
	}
	
	public static void renombrarFichero(File directorio)
	{
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Introduzca la ruta del fichero o carpeta que desea renombrar.");
        String dirrenombrar = teclado.nextLine();
        File ficheroRenombrar = new File(dirrenombrar);

        if (ficheroRenombrar.exists()) 
        {
          System.out.println("Introduzca el nuevo nombre.");
          String nuevonombre = teclado.nextLine();
          File nuevoarchivo = new File(ficheroRenombrar.getParent(), nuevonombre);

            if (ficheroRenombrar.renameTo(nuevoarchivo)) 
            {
                System.out.println("Renombrado correctamente a: " + nuevoarchivo.getAbsolutePath());
            } 
            else 
            {
                System.out.println("No se pudo renombrar el fichero o carpeta.");
            }
        }
        else 
        {
            System.out.println("El fichero o carpeta no existe.");
        }
	}
	public static void crearFichero(File directorio)
	{
		
		try 
		{
			Scanner teclado = new Scanner(System.in);
			
			System.out.println("Introduzca el nombre que quiere ponerle al fichero.");
			String nomfichero = "";
			nomfichero = teclado.nextLine();
			File nuevofichero = new File(directorio, nomfichero);
			
			
			if (nuevofichero.createNewFile()) 
			{
	            System.out.println("Fichero creado correctamente: " + nuevofichero.getAbsolutePath());
	        } 
			else 
	        {
	            System.out.println("El fichero ya existe o no se pudo crear.");
	        }
		}catch(Exception e) 
		{

		    System.out.println("ERROR: El archivo o directorio seleccionado no existe");

		}
	}
	
}
