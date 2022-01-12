/**
 * 
 */
package com.innovargia.salesmanager.bo.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.rpc.holders.StringHolder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.administracion.consecutivos.bo.AdminConsecutivosBO;
import com.administracion.dto.Factura;
import com.administracion.idao.IConexionDAOJDBC;
import com.administracion.idao.IParamsSistemaDAO;
import com.administracion.jasperreport.IPrintReport;
import com.administracion.jasperreport.utils.ConstantesIReport;
import com.innovargia.administracion.dto.LineaFacturaSAP;
import com.innovargia.administracion.dto.MaterialEspecialFactura;
import com.innovargia.salesmanager.dtos.CuentasDTO;
import com.innovargia.salesmanager.dtos.MetaDatoCatalogoDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.ibo.IFacturaResumenBO;
import com.innovargia.salesmanager.ibo.IMaterialEspcialFacturaBO;
import com.innovargia.salesmanager.idao.IFacturaResumenDAO;
import com.innovargia.salesmanager.idao.IMaterialEspcialFacturaDAO;
import com.innovargia.utils.UtilsStrings;
import com.servicio.constantes.ConstantesGenerales;

import mc_style.functions.soap.sap.document.sap_com.ZwsvtaslogisticaLocator;
import mc_style.functions.soap.sap.document.sap_com.holders.TableOfTlineHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.TableOfZsdVovPedidoHolder;

/**
 * @author aruaro
 * 
 */
@Service
public class MaterialEspecialFacturaBO implements IMaterialEspcialFacturaBO {

	
	private static final Logger logger = LoggerFactory.getLogger(MaterialEspecialFacturaBO.class);

	@Autowired
	IMaterialEspcialFacturaDAO iMaterialEspcialFacturaDAO;

	@Override
	public int insert(MaterialEspecialFactura obj) throws Exception {
		// TODO Auto-generated method stub
		return iMaterialEspcialFacturaDAO.insert(obj);
	}

	@Override
	public void update(MaterialEspecialFactura obj) throws Exception {
		iMaterialEspcialFacturaDAO.update(obj);
		
	}

	@Override
	public void delete(MaterialEspecialFactura obj) throws Exception {
		iMaterialEspcialFacturaDAO.delete(obj);
	}

	@Override
	public void deleteAll(MaterialEspecialFactura obj) throws Exception {
		iMaterialEspcialFacturaDAO.deleteAll(obj);
		
	}

	@Override
	public List<MaterialEspecialFactura> getRegistros(MaterialEspecialFactura obj) throws Exception {
		return iMaterialEspcialFacturaDAO.getRegistros(obj);
	}

	@Override
	public List<MaterialEspecialFactura> getRegistrosNoIncluidos(MaterialEspecialFactura obj) throws Exception {
		// TODO Auto-generated method stub
		return iMaterialEspcialFacturaDAO.getRegistrosNoIncluidos(obj);
	}

	

}
