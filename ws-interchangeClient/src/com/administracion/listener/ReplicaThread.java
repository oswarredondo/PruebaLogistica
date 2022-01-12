/**
 * 
 */
package com.administracion.listener;

import com.debug.utils.DebugLog;
import com.ws.replica.dao.SistemaDao;
import com.ws.replica.info.ReplicaInfo;

/**
 * @author Adrian Morales Ruaro
 * 
 */
public class ReplicaThread implements Runnable {

	private boolean deten_replica = false;
	private long delay = 10000;
	private long delay_plus = 0;
	
	ReplicaInfo replicaInfo = null;
	private String db = "TRANSPORTE";
	String hilo="";

	/**
	 * 
	 */
	public ReplicaThread(String label, int d, String db) {
		debug("Verificando informacion para replicacion");
		this.db = db;
	}
	
	public ReplicaThread(String label, int d, String db,long delay_plus, String hilo ) {
		debug("Verificando informacion para replicacion");
		this.db = db;
		this.delay_plus = delay_plus;
		this.hilo = hilo;
	}

	/**
	 * Manda un mensaje a la bitacora, como debug
	 */
	private void debug(String mensaje) {
		DebugLog.debug(this.getClass(), mensaje);
	}// fin de debug

	@Override
	public void run() {
		
		
		
		SistemaDao daoSistema = new SistemaDao(this.db);
		String s_delay = null;
		String s_deten_replica = null;

		replicaInfo = new ReplicaInfo(this.db);
		try {
			for (;;) {
				//Espera unos segundos antes de inicializar
				Thread.currentThread().sleep(delay_plus);
				debug("Ejecutando proceso "+this.hilo );
				
				s_delay = daoSistema.getValorPropiedad("INFOINTERCHANGECTE",
						"WS.replica.delay.miliseconds");
			
				if (s_delay == null) {
					s_delay = "10000";
				}

				try {
					if (Long.parseLong(s_delay)!=delay){
						debug("Se cambio tiempo de espera de "+delay + " a "+Long.parseLong(s_delay) );
					}
					delay = Long.parseLong(s_delay) + this.delay_plus;
					if (delay < 10000) {
						delay = 10000;
					}
				} catch (Exception e) {
					delay = 10000;
				}
				s_deten_replica = daoSistema.getValorPropiedad("INFOINTERCHANGECTE",
						"WS.replica.deten.replica");
				try {
					deten_replica = Boolean.parseBoolean(s_deten_replica);
				
				} catch (Exception e) {
					deten_replica=false;
				}
				//Verifica si la replicacion esta detenida
				if (!deten_replica){
					//Inicia la replicacion 
					replicaInfo.enviaInformacion(this.hilo);

				}else{
					debug("Replicacion se encuentra en estado DETENIDO");
				}
				// Verifica si la variable de
				Thread.currentThread().sleep(delay);
			}

		} catch (InterruptedException ie) {
			debug("Error en thread de replicacion:" + ie.getMessage());
		}

	}

	

	/**
	 * @return the delay
	 */
	public long getDelay() {
		return delay;
	}

	/**
	 * @param delay
	 *            the delay to set
	 */
	public void setDelay(long delay) {
		this.delay = delay;
	}

	/**
	 * @return the replicaInfo
	 */
	public ReplicaInfo getReplicaInfo() {
		return replicaInfo;
	}

	/**
	 * @param replicaInfo
	 *            the replicaInfo to set
	 */
	public void setReplicaInfo(ReplicaInfo replicaInfo) {
		this.replicaInfo = replicaInfo;
	}

	/**
	 * @return the db
	 */
	public String getDb() {
		return db;
	}

	/**
	 * @param db
	 *            the db to set
	 */
	public void setDb(String db) {
		this.db = db;
	}

	/**
	 * @return the deten_replica
	 */
	public boolean isDeten_replica() {
		return deten_replica;
	}

	/**
	 * @param deten_replica the deten_replica to set
	 */
	public void setDeten_replica(boolean deten_replica) {
		this.deten_replica = deten_replica;
	}

}
