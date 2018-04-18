package sampleJava;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

//this is use for send payment request
public class Pay {

	public static void main(String ar[]) 
	{
		
		Pay p = new Pay();
		
		try {
			p.createPayment();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}

	private void createPayment() throws JSONException, IOException {
		
try{
		JSONObject jsonRequest = new JSONObject();
		jsonRequest.put("currency", "COP");
		jsonRequest.put("amount", 60000);
		jsonRequest.put("statement_soft_descriptor", "abc-chekc");
	

		OkHttpClient client = new OkHttpClient();
		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, jsonRequest.toString());
		Request request = new Request.Builder()
		.url("https://api.paymentsos.com/payments/")
		.post(body)
		.addHeader("Content-Type", "application/json")
		  .addHeader("app_id", "com")
		  .addHeader("private_key", "7bf41ed5")
		  .addHeader("x-payments-os-env", "test")
		.build();

		Response response = client.newCall(request).execute();
		
		System.out.println("request value is ");
	System.out.println("response is " + response.body().string());
		// TODO Auto-generated method stub
}catch(Exception e){
	
	e.printStackTrace();
	
	
}
	}

}
