/**
 * 
 */
package com.ws.test;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

import com.ws.interchange.InterchangeInfoService;
import com.ws.interchange.InterchangeSEI;
import com.ws.replica.info.ReplicaInfo;

/**
 * @author Adrian Morales Ruaro
 *
 */
public class TestWS {
	private static final QName SERVICE_NAME = new QName("http://interchange.ws.com/", "InterchangeInfoService");

	/**
	 * 
	 */
	public TestWS() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//ReplicaInfo replica = new ReplicaInfo();
		// replica.enviaInformacion("");
		pruebanviainfo();

	}

	public static void pruebanviainfo() {
		URL wsdlURL = InterchangeInfoService.WSDL_LOCATION;
		String urlws = "http://chazam.dyndns.org:22080/ws-interchange/services/interchangeinfo?wsdl";
		//URL wsdlURL = null;
		try {
			wsdlURL = new URL(urlws);
		} catch (MalformedURLException e) {
			java.util.logging.Logger.getLogger(InterchangeInfoService.class.getName()).log(java.util.logging.Level.INFO,
					"Can not initialize the default wsdl from {0}", urlws);
		}
/*
		if (args.length > 0 && args[0] != null && !"".equals(args[0])) {
			File wsdlFile = new File(args[0]);
			try {
				if (wsdlFile.exists()) {
					wsdlURL = wsdlFile.toURI().toURL();
				} else {
					wsdlURL = new URL(args[0]);
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
*/
		InterchangeInfoService ss = new InterchangeInfoService(wsdlURL, SERVICE_NAME);
		InterchangeSEI port = ss.getInterchangeInfoPort();

		{
			System.out.println("Invoking isCorrectServer...");
			java.lang.String _isCorrectServer_arg0 = "_isCorrectServer_arg02050874662";
			boolean _isCorrectServer__return = port.isCorrectServer(_isCorrectServer_arg0);
			System.out.println("isCorrectServer.result=" + _isCorrectServer__return);

		}

		{
			System.out.println("Invoking procesa...");
			java.util.List<java.lang.String> registros = new java.util.ArrayList<java.lang.String>();

			java.lang.String _procesa_arg0Val1 = "20|0010011010D0000006918|1111111||201309021230|MEX|MEX|111111111111";
			registros.add(_procesa_arg0Val1);

			java.util.List<java.lang.String> configuracion = new java.util.ArrayList<java.lang.String>();
			configuracion.add("MEXICO");
			configuracion.add("MEXSERV");
			configuracion.add("0000");
			configuracion.add("0000vmmcnps.txgs");
			configuracion.add("TRANSPORTE");

			java.util.List<java.lang.String> _procesa__return = port.procesa(registros, configuracion);
			System.out.println("procesa.result=" + _procesa__return);

		}

	

	}

}
