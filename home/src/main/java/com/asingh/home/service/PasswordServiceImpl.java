package com.asingh.home.service;

import java.util.Hashtable;

import org.springframework.stereotype.Component;

@Component
public class PasswordServiceImpl implements PasswordService{

	public String generatePass(String input) {
		Hashtable<String,String> output = new Hashtable<String,String>();

		int i = 0;
		for (char c : input.toCharArray()){
			int times = 1;
			String temp = input.substring(i+1);
			i ++;
			for (int z = 0; z <= temp.length()-1; z++){
				if(temp.charAt(z) == c){
					times ++;
				}
			}

			if(!output.containsKey(String.valueOf(c))){
				output.put(String.valueOf(c),String.valueOf(times));
			}
		}

		return refineOutput(output);
	}

	private String refineOutput(Hashtable<String,String> input){
		StringBuilder output = new StringBuilder();
		for(Object key : input.keySet()){
			output.append(String.valueOf(key));
			output.append(String.valueOf(input.get(key)));
		}
		return output.toString();

	}

}
