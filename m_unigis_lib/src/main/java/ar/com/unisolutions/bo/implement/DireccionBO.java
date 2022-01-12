package ar.com.unisolutions.bo.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.text.Normalizer;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.impl.nio.conn.PoolingNHttpClientConnectionManager;
import org.apache.http.impl.nio.reactor.DefaultConnectingIOReactor;
import org.apache.http.impl.nio.reactor.IOReactorConfig;
import org.apache.http.nio.reactor.ConnectingIOReactor;
import org.apache.http.nio.reactor.IOReactorException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonArray;
import com.innovargia.rotulacion.dtos.EtiquetaRotulacionDTO;
import com.innovargia.salesmanager.dtos.RemDes;

import ar.com.unisolutions.bo.IDireccioneBO;
import ar.com.unisolutions.dao.IDireccionDAO;
import ar.com.unisolutions.dto.Direccion;

@Service
public class DireccionBO implements IDireccioneBO {

    @Autowired
    IDireccionDAO iDireccionDAO;

    @Override
    public Direccion getDireccionDescripcion(int codigoPostal) throws Exception {

	return iDireccionDAO.getDireccionDescripcion(codigoPostal);
    }

    @Override
    public String getDirection(EtiquetaRotulacionDTO etiquetaRotulacionDTO) throws Exception {
	return iDireccionDAO.getDirection(etiquetaRotulacionDTO);
    }

    @Override
    public String getSistemaEnvio(String idguia) throws Exception {

	return iDireccionDAO.getSistemaEnvio(idguia);
    }

    @Override
    public String getLatLng(String direccion, String idRemDes) throws UnsupportedOperationException, InterruptedException, ExecutionException, IOException{

	return getLatLongFromAddress(direccion, idRemDes);
    }

    @Override
    public List<RemDes> getDireccionRemDes(String uuid) throws Exception {

	return iDireccionDAO.getDireccionRemDes(uuid);

    }

    @Override
    public int getReexpedicion(String codigoPostal) throws Exception {

	return iDireccionDAO.getReexpedicion(codigoPostal);
    }

    public String getLatLongFromAddress(String direccion, String idRemDes) throws InterruptedException, ExecutionException, UnsupportedOperationException, IOException{

	direccion = stripAccents(direccion);
	direccion = direccion.replace(" ", "+");

	String uri = "https://maps.google.com/maps/api/geocode/json?&key=AIzaSyCgJUPDYjYGP3QhoAIrF33H82O3vB_0_9o&address="
		+ direccion + "&sensor=false";

	double lng = 0;
	double lat = 0;

        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(90000)
                .setSocketTimeout(90000)
                .setConnectionRequestTimeout(60000)
                .build();

        // Configurar hilo io
        IOReactorConfig ioReactorConfig = IOReactorConfig.custom().
                setIoThreadCount(Runtime.getRuntime().availableProcessors())
                .setSoKeepAlive(true)
                .build();
        
        // Establecer el tamaño del grupo de conexiones
        ConnectingIOReactor ioReactor=null;
        
        try {
            
            ioReactor = new DefaultConnectingIOReactor(ioReactorConfig);
            
        } catch (IOReactorException e) {
            
            e.printStackTrace();
            
        }
        
        PoolingNHttpClientConnectionManager connManager = new PoolingNHttpClientConnectionManager(ioReactor);
        connManager.setMaxTotal(100);
        connManager.setDefaultMaxPerRoute(1000);

        final CloseableHttpAsyncClient httpClient = HttpAsyncClients.custom().
                setConnectionManager(connManager)
                .setDefaultRequestConfig(requestConfig)
                .build();
        
	//CloseableHttpAsyncClient httpClient = HttpAsyncClients.createDefault();

	httpClient.start();

	HttpGet request = new HttpGet(uri);

	Future<HttpResponse> future = httpClient.execute(request, null);

	HttpResponse httpResponse = future.get();

	if (httpResponse.getStatusLine().getStatusCode() == 200) {

	    BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));

	    String inputLine;
	    
	    StringBuilder response = new StringBuilder();

	    while ((inputLine = reader.readLine()) != null) {

		response.append(inputLine);

	    }

	    reader.close();

	    // print result
	    System.out.println(response.toString());

	    try {

		JSONObject jsonObject = new JSONObject(response.toString());

		if (!jsonObject.getJSONArray("results").isNull(0)) {

		    lng = ((JSONArray) jsonObject.get("results")).getJSONObject(0).getJSONObject("geometry")
			    .getJSONObject("location").getDouble("lng");

		    lat = ((JSONArray) jsonObject.get("results")).getJSONObject(0).getJSONObject("geometry")
			    .getJSONObject("location").getDouble("lat");

		    iDireccionDAO.setLatLng(lat + "", lng + "", idRemDes);

		}

	    } catch (Exception e) {

		httpClient.close();
		
		System.out.println(e.getMessage());

	    }finally {
		
		httpClient.close();
		
	    }

	}

	//httpClient.close();h
	return lat + "," + lng;

    }

    public static String stripAccents(String s) {
	s = Normalizer.normalize(s, Normalizer.Form.NFD);
	s = s.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
	return s;
    }
}
