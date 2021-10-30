package br.com.estudo.api.model;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CustomDateDeserializer extends JsonDeserializer<Date> {

    @Override
    public Date deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext) throws IOException, JsonProcessingException {
    	//TODO: depende das configurações do usuário
    	String str = paramJsonParser.getText().trim();
    	SimpleDateFormat easyFormatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        SimpleDateFormat systemUsformatter = new SimpleDateFormat("MMM d, yyyy h:mm:ss aaa", Locale.US);
        SimpleDateFormat systemBrFormatter = new SimpleDateFormat("MMM d, yyyy h:mm:ss aaa");
        try {
            return easyFormatter.parse(str);
        } catch (ParseException e) {}
        try {
            return systemUsformatter.parse(str);
        } catch (ParseException e) {}
        try {
            return systemBrFormatter.parse(str);
        } catch (ParseException e) {}
        try {
        	return paramDeserializationContext.parseDate(str);
        } catch (Exception e) {}
        
        return new Date(); 
    }

}
