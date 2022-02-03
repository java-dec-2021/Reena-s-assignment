package com.reena.restAPI.controllers;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@Controller
public class HomeController {
	
	@GetMapping("/{search}")
	public String index(@PathVariable("search") String search, Model model) throws UnirestException {
//		String apiUrl="https://datausa.io/api/data?drilldowns=Nation&measures=Population";
		String apiUrl="http://www.omdbapi.com/?i=tt3896198&apikey=YOURAPIKEY&s="+ search;
		HttpResponse<com.mashape.unirest.http.JsonNode> jsonResponse=Unirest.get(apiUrl).asJson();
		JSONObject obj=jsonResponse.getBody().getObject();
		JSONArray jArray=obj.getJSONArray("Search");
		ArrayList<JSONObject> results=new ArrayList<JSONObject>();
		for(int i=0; i<jArray.length();i++) {
			results.add(jArray.getJSONObject(i));
		}
		model.addAttribute("results",results);
		System.out.println(obj.toString());
		return "index.jsp";
	}

	
}
