package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ClientWriter {
	/**
	 * Ajoute un client à un fichier client client.txt
	 *
	 * @param client
	 */
	public static void writeUser( Client client ) {
		HashMap< String, String > hashMapClient = new HashMap<>();
		hashMapClient.put( "Num_client", String.valueOf( client.getNumeroClient() ) );
		hashMapClient.put( "Nom", client.getNom() );
		hashMapClient.put( "Prenom", client.getPrenom() );
		hashMapClient.put( "Age", String.valueOf( client.getAge() ) );

		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter( new FileWriter( "sauvegarde/client.txt", true ) );

			for ( Map.Entry< String, String > entry : hashMapClient.entrySet() ) {
				writer.write( entry.getKey() + " : " + entry.getValue() );
				writer.newLine();
			}
			writer.newLine();
			System.out.println( "ecriture du client" );
		} catch ( IOException e ) {
			e.printStackTrace();
		} finally {
			if ( writer != null ) {
				try {
					writer.close();
				} catch ( IOException e ) {
					e.printStackTrace();
				}
			}
		}
	}
}
