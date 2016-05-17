package br.univel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class TesteLeitura {
	
	public static void main(String[] args) throws JAXBException {
		
		String xml = null;
		try {
			FileReader fr = new FileReader("arq.xml");
			BufferedReader br = new BufferedReader(fr);
			
			StringBuilder sb = new StringBuilder();
			String line = null;
			
			while((line = br.readLine()) != null){
				sb.append(line).append("\n");
			}
			
			xml = sb.toString();
			
			br.close();
			fr.close();
			
			StringReader in = new StringReader(xml);
			
			JAXBContext context = JAXBContext.newInstance(Cliente.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			Cliente cli = (Cliente) unmarshaller.unmarshal(in);
			System.out.println(cli.getId());
			System.out.println(cli.getNome());			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
