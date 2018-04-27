package com.zona.payment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

//author : hitesh gupta
//this is demo
public class ZonaPyamentClient {
	
	public static void main(String ar[])
	{
		
		
		ZonaPyamentClient payment= new ZonaPyamentClient();
		//payment.invoiceSearch();
		payment.createOrder();
		//payment.paymentVerification();
		
		
	}

	private void createOrder()
	{

    	try{
    	
    		String prodURL="https://merch-prod.snd.payu.com/api/v2_1/orders";
    		
    	URL url = new URL(prodURL);
    	
    	//URLConnection connection = url.openConnection();
    	HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    	System.out.println("connection is "+ connection);
        connection.setDoOutput(true);
       
        connection.setRequestProperty("Content-Type", "application/json");
       
        connection.setRequestProperty("Authorization", "Bearer d9a4536e-62ba-4f60-8017-6053211d3f47");
        connection.setInstanceFollowRedirects(false);
        connection.setConnectTimeout(50000);
        connection.setReadTimeout(50000);
        connection.setRequestMethod("POST");
        JSONObject	 obj = new JSONObject();
        obj.put("notifyUrl","https://your.eshop.com/notify");
obj.put("merchantPosId","300746");
obj.put("description","Laptop");
obj.put("currencyCode","PLN");
obj.put("customerIp","127.0.0.1");
obj.put("totalAmount","15000");
obj.put("extOrderId","t4yqmvc762ghelqsdfn3s8c");
        



JSONObject obj1 = new JSONObject();
obj1.put("name","Laptop");
obj1.put("unitPrice","15000");
obj1.put("quantity","1");

JSONArray ja = new JSONArray();
ja.put(obj1);


obj.put("products", ja);

JSONObject	 buyer = new JSONObject();
buyer.put("email", "john.doe@example.com");
buyer.put("firstName", "hitesh");
buyer.put("lastName", "gupta");

obj.put("buyer",buyer);
    	OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
    	out.write(obj.toString());
    	out.close();
    	System.out.println("payment verfication json object value is"+obj.toString());
    	String string = "";
    	BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
    	StringBuilder builder = new StringBuilder();
    	String line = null;
		while ((line = in.readLine()) != null) {
			builder.append(line);
		}
		System.out.println(" payment verfication  Data Received: " + builder.toString());
		
		
		in.close();
	
    	}
     	
    	catch(JSONException json){
    		System.out.println("json error ");
    		json.printStackTrace();
    		}
    	
    	catch(IOException ioe){
    		System.out.println("IO error ");	
    		ioe.printStackTrace();
    	}
    	catch(Exception e){
    		System.out.println("Exception error ");	
    		e.printStackTrace();
    	}
		
		
		
		
		
		
	}
	private void paymentVerification()
	{
		

    	try{
    	
    		String prodURL="https://www.zonapagos.com/api_verificar_pagoV3/api/verificar_pago_v3";
    		String testingURL="https://www.zonapagosdemo.com/api_verificar_pagoV3/api/verificar_pago_v3";
    	URL url = new URL(prodURL);
    	
    	//URLConnection connection = url.openConnection();
    	HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    	System.out.println("connection is "+ connection);
        connection.setDoOutput(true);
       
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setConnectTimeout(50000);
        connection.setReadTimeout(50000);
        connection.setRequestMethod("POST");
        JSONObject jsonObject = new JSONObject(); 
        jsonObject.put("str_id_pago","abcei");
        jsonObject.put("int_id_tienda","1000");
        jsonObject.put("str_id_clave","TgfdZ435");
        
    
    	OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
    	out.write(jsonObject.toString());
    	out.close();
    	System.out.println("payment verfication json object value is"+jsonObject.toString());
    	String string = "";
    	BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
    	StringBuilder builder = new StringBuilder();
    	String line = null;
		while ((line = in.readLine()) != null) {
			builder.append(line);
		}
		System.out.println(" payment verfication  Data Received: " + builder.toString());
		
		
		in.close();
	
    	}
     	
    	catch(JSONException json){
    		System.out.println("json error ");
    		json.printStackTrace();
    		}
    	
    	catch(IOException ioe){
    		System.out.println("IO error ");	
    		ioe.printStackTrace();
    	}
    	catch(Exception e){
    		System.out.println("Exception error ");	
    		e.printStackTrace();
    	}
    	
	}



		

	private void sendPaymentRequest() {
	
    	 	
    
    	try{
    		
    		String prodURL="https://www.zonapagos.com/api_inicio_pago/api/inicio_pagoV2";
    		String testingURL="https://www.zonapagosdemo.com/api_inicio_pago/api/inicio_pagoV2";
    	URL url = new URL(prodURL);
    	
    	//URLConnection connection = url.openConnection();
    	HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    	System.out.println("connection is "+ connection);
        connection.setDoOutput(true);
       
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setConnectTimeout(500000);
        connection.setReadTimeout(500000);
        connection.setRequestMethod("POST");
        JSONObject jsonObject = new JSONObject(); 
        jsonObject.put("id_tienda","180");
        jsonObject.put("clave","TgfdZ435");
        jsonObject.put("total_con_iva","10000");
        jsonObject.put("valor_iva","0");
        jsonObject.put("id_pago","363466"); 
        jsonObject.put("descripcion_pago","This is a test");
        jsonObject.put("email","soporte@zonavirtual.com");
        jsonObject.put("id_cliente","123");
        jsonObject.put("tipo_id","1");
        jsonObject.put("nombre_cliente","Soporte");
        jsonObject.put("apellido_cliente","Zona Virtual");
        jsonObject.put("telefono_cliente","4449662");
        jsonObject.put("info_opcional1","1");
        jsonObject.put("info_opcional2","2");
        jsonObject.put("info_opcional3","3");
        jsonObject.put("codigo_servicio_principal","2701");
        jsonObject.put("lista_codigos_servicio_multicredito","NULL");
        jsonObject.put("lista_nit_codigos_servicio_multicredito","NULL");
        jsonObject.put("lista_valores_con_iva","NULL");
        jsonObject.put("lista_valores_iva","NULL");
        jsonObject.put("total_codigos_servicio","0");
    
    	OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
    	out.write(jsonObject.toString());
    	out.close();
    	System.out.println("json object value is"+jsonObject.toString());
    	String string = "";
    	BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
    	StringBuilder builder = new StringBuilder();
    	String line = null;
		while ((line = in.readLine()) != null) {
			builder.append(line);
		}
		System.out.println("Data Received: " + builder.toString());
		
		
		in.close();
	
    	}
     	
    	catch(JSONException json){
    		System.out.println("json error ");
    		json.printStackTrace();
    		}
    	
    	catch(IOException ioe){
    		System.out.println("IO error ");	
    		ioe.printStackTrace();
    	}
    	catch(Exception e){
    		System.out.println("Exception error ");	
    		e.printStackTrace();
    	}
    	
	}

	
	
	private void invoiceSearch() {
		
	 	
	    
    	try{
    		
    		String prodURL="https://www.zonapagos.com/api_inicio_pago/api/inicio_pagoV2";
    		String testingURL="https://test.payumoney.com/payment/op/v1/invoices/search";
    	URL url = new URL(testingURL);
    	
    	//URLConnection connection = url.openConnection();
    	HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    	System.out.println("connection is "+ connection);
        connection.setDoOutput(true);
       
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setConnectTimeout(500000);
        connection.setReadTimeout(500000);
        connection.setRequestMethod("POST");
        JSONObject jsonObject = new JSONObject(); 
        
        jsonObject.put("invoiceDescription","Rent for January");
        jsonObject.put("invoiceNumber","INV12345678");
        jsonObject.put("source","API_INT_INVOICE");
        jsonObject.put("status","ACTIVE");
        jsonObject.put("tinyUrl","www.pmny.com/txnID");
        jsonObject.put("to","2017-10-26T12:34:28Z");
        jsonObject.put("from","2017-10-26T12:34:28Z");
        OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
    	out.write(jsonObject.toString());
    	out.close();
    	System.out.println("json object value is"+jsonObject.toString());
    	String string = "";
    	BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
    	StringBuilder builder = new StringBuilder();
    	String line = null;
		while ((line = in.readLine()) != null) {
			builder.append(line);
		}
		System.out.println("Data Received: " + builder.toString());
		
		
		in.close();
	
    	}
     	
    	catch(JSONException json){
    		System.out.println("json error ");
    		json.printStackTrace();
    		}
    	
    	catch(IOException ioe){
    		System.out.println("IO error ");	
    		ioe.printStackTrace();
    	}
    	catch(Exception e){
    		System.out.println("Exception error ");	
    		e.printStackTrace();
    	}
    	
	}

	
	 
}
