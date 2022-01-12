/*!
 * Ext JS Library 4.0
 * Copyright(c) 2006-2011 Sencha Inc.
 * licensing@sencha.com
 * http://www.sencha.com/license
 */

Ext.define('MyDesktop.App', {
    extend: 'Ext.ux.desktop.App',
  
    requires: [
               'Ext.tip.*',
               'Ext.Button',
               'Ext.window.MessageBox',
               
        'Ext.window.MessageBox',

        'Ext.ux.desktop.ShortcutModel',
		'MyDesktop.objetos.TextFieldUpperCase',
		'MyDesktop.objetos.TextAreaUpperCase',
		'MyDesktop.objetos.EmailTextField',
        'MyDesktop.SystemStatus',
        'MyDesktop.objetos.GoogleMapsObject',

		//Store utilitarios
		"MyDesktop.store.StoreTiposBusquedaClientes",
		"MyDesktop.store.StoreTiposBusquedaContactos",
		"MyDesktop.store.StoreTiposBusquedaTarifas",
		'MyDesktop.store.StoreTiposBusquedaDescuentos',
		'MyDesktop.store.StoreTiposBusquedaCotizacion',
		'MyDesktop.store.StoreTiposBusquedaCuentasClientes',
		'MyDesktop.store.StoreTiposPerfiles',
		'MyDesktop.store.StoreNivelUsuario',
		'MyDesktop.store.StoreSINO',
		'MyDesktop.store.StoreVisibilidad',
		'MyDesktop.store.StoreTipoIncremento',
		'MyDesktop.store.StoreClasificacionCliente',
		
		"MyDesktop.store.StoreTiposPersona",
		'MyDesktop.store.StoreTipoCliente',
		"MyDesktop.store.StorePromotores",
		'MyDesktop.store.StoreTiposDescuento',
		'MyDesktop.store.StoreTiposTareasEstatus',
		'MyDesktop.store.StoreTiposImportaciaTareas',
		'MyDesktop.store.StoreTiposTareas',
		'MyDesktop.store.StoreTiposProblemaAgenda',
		'MyDesktop.store.StoreTipoSolucionAgenda',
		'MyDesktop.store.StoreTipoEstatusAgenda',
		'MyDesktop.store.StoreTiposBusquedaOR',

		//Forms
		"MyDesktop.view.FormClientes",
		"MyDesktop.view.FormCotizacion",
		"MyDesktop.view.FormDireccionCliente",
		"MyDesktop.view.FormContacto",
		"MyDesktop.view.FormConvenio",
		'MyDesktop.view.FormTarifas',
		"MyDesktop.view.FormDescuento", //Actualiza
		'MyDesktop.view.FormPerfil',
		'MyDesktop.view.FormUsuarios',
		'MyDesktop.view.FormUsuariosSesion',
		'MyDesktop.view.FormPasswordUsuario',
		'MyDesktop.view.FormTarifasRangoZona',
		'MyDesktop.view.FormLocalizacion',
		'MyDesktop.view.FormUploadAttachment',
		'MyDesktop.form.FormUploadAttachmentAgenda',
		'MyDesktop.view.FormCuentaCliente',
		'MyDesktop.view.FormDetalleCotizacion',
		'MyDesktop.view.FormFirmasAutorizacionCotizacion',
		'MyDesktop.view.FormDireccionRevision',
		'MyDesktop.view.FormTarea',	
		'MyDesktop.view.FormSolicitarDescuentoTarea',
		'MyDesktop.form.FormConvenioDescuentoFact',
		
		//Modelos de datos
		'MyDesktop.models.ModeloCPs',
		'MyDesktop.models.ModeloDireccion',
		'MyDesktop.models.ModeloDataItemMenu',
		'MyDesktop.models.WallpaperModel',
		'MyDesktop.WindowsMenuPrincipal',
		'MyDesktop.WindowsUtilitaria',
		'MyDesktop.models.ModeloContactos',
		'MyDesktop.models.ModeloClientes',
		'MyDesktop.models.ModeloConvenios',
		'MyDesktop.models.ModeloCondicionPago',
		'MyDesktop.models.ModeloOficinaControl',
		'MyDesktop.models.ModeloPoblacionPagadera',
		'MyDesktop.models.ModeloMetodoPago',
		'MyDesktop.models.ModeloFormaPago',
		'MyDesktop.models.ModeloUnidadAdministrativa',
		'MyDesktop.models.ModeloTipoContrato',
		'MyDesktop.models.ModeloServicio',
		'MyDesktop.models.ModeloClienteLicitacion',
		'MyDesktop.models.ModeloCondicionPago',
		'MyDesktop.models.ModeloDescuentos',
		'MyDesktop.models.ModeloTarifas',
		'MyDesktop.models.ModeloTarifasAdicional',
		'MyDesktop.models.ModeloModalidadDescuento',
		'MyDesktop.models.ModeloLocalizacion',
		'MyDesktop.models.ModeloAdicionales',
		'MyDesktop.models.ModeloGrupoCliente',
		'MyDesktop.models.ModeloOrdenServicioFolios',
		'MyDesktop.models.ModeloCampos',
		'MyDesktop.models.ModeloRegistros',
		'MyDesktop.models.ModeloDataObject',
		'MyDesktop.models.ModeloOrganizacion',
		'MyDesktop.models.ModeloEntidad',
		'MyDesktop.models.ModeloPerfil',
		'MyDesktop.models.ModeloDataUsuario',
		'MyDesktop.models.ModeloAttachment',
		'MyDesktop.models.ModeloPesos',
		'MyDesktop.models.ModeloDetalleConvenio',
		'MyDesktop.models.ModeloPlaza',
		'MyDesktop.models.ModeloUnidadAdministrativa',
		'MyDesktop.models.ModeloAgrupamiento',
		'MyDesktop.models.ModeloParametrosConfiguracion',
		'MyDesktop.models.ModeloTareas',
		'MyDesktop.models.ModeloClavesExcepcion',
		'MyDesktop.models.ModeloNivelPuestoUsuario',
		'MyDesktop.models.ModeloClientesRFCs',
		'MyDesktop.models.ModeloUsuarioConvenioFolio',
		'MyDesktop.models.ModeloMaterialEmpaque',
		'MyDesktop.models.ModeloDescuentoRangoFactura',
		'MyDesktop.models.ModeloDocumento',
		'MyDesktop.store.StoreDocumento',

		//Stores
		'MyDesktop.store.StorePlaza',
		'MyDesktop.store.StoreCodigoPostal',
		'MyDesktop.store.StoreDireccion',
		'MyDesktop.store.StoreDireccionClienteConsulta',
		'MyDesktop.store.StoreOpcionesMenu',
		'MyDesktop.store.StoreContacto',
		'MyDesktop.store.StoreClientes',
		'MyDesktop.store.StoreConvenios',
		"MyDesktop.store.StoreClienteLicitacion",
		"MyDesktop.store.StoreCondicionPago",
		"MyDesktop.store.StoreFormaPago",
		"MyDesktop.store.StoreMetodoPago",
		"MyDesktop.store.StoreOficinaControl",
		"MyDesktop.store.StorePoblacionPagadera",
		"MyDesktop.store.StoreServicio",
		"MyDesktop.store.StoreTipoContrato",
		"MyDesktop.store.StoreUnidadAdministrativa",
		'MyDesktop.store.StoreDescuentos',
		'MyDesktop.store.StoreTarifas',
		'MyDesktop.store.StoreTarifasAdicional',
		'MyDesktop.store.StoreTarifaPeso',
		'MyDesktop.store.StoreTarifaServicioZona',
		'MyDesktop.store.StoreTarifaRangoEnvios',
		
		'MyDesktop.store.StoreDescuentosTipoDetalle',
		'MyDesktop.store.StoreLocalizacion',
		'MyDesktop.store.StoreAdicionales',
		'MyDesktop.store.StoreGrupoCliente',
		'MyDesktop.store.StoreDescuentos',
		'MyDesktop.store.StoreOrdenServicio',
		'MyDesktop.store.StoreCampos',
		'MyDesktop.store.StoreRegistros',
		'MyDesktop.store.StorePerfil',
		'MyDesktop.store.StoreEntidad',
		'MyDesktop.store.StoreOrganizacion',
		'MyDesktop.store.StoreDataObject',
		'MyDesktop.store.StorePerfil',
		'MyDesktop.store.StoreHistoria',
		'MyDesktop.store.StoreAttachment',
		'MyDesktop.store.StoreDetalleConvenio',
		'MyDesktop.store.StoreUnidadAdministrativa',
		'MyDesktop.store.StoreAgrupamiento',
		'MyDesktop.store.StoreParametrosConfiguracion',
		'MyDesktop.store.StoreTareas',
		'MyDesktop.store.StoreTiposTareasAmbito',
		'MyDesktop.store.StoreAgrupacionesUsuario',
		'MyDesktop.store.StoreClavesExcepcion',
		'MyDesktop.store.StoreNivelPuestoUsuario',
		'MyDesktop.store.StoreClientesRFCs',
		'MyDesktop.store.StoreBancos',
		'MyDesktop.store.StoreUsuarioConvenioFolio',
		'MyDesktop.store.StoreTipoAdicional',
		'MyDesktop.store.StoreMaterialEmpaque',
		'MyDesktop.store.StoreDescuentoRangoFactura',
		'MyDesktop.store.StoreHistoriaEnvio',
		
		//Grid
		'MyDesktop.view.GridUsuariosDisponiblesTarea',
		'MyDesktop.view.GridAttachment',
		'MyDesktop.view.GridHistoria',
		'MyDesktop.view.GridConsultaCPs',
		'MyDesktop.view.GridConsultaDireccionesCliente',
		'MyDesktop.view.GridDirecciones',
		"MyDesktop.view.GridContactos",
		'MyDesktop.view.GridClientes',
		'MyDesktop.view.GridCuentasClientes',
		"MyDesktop.view.GridConvenios",
		"MyDesktop.view.GridCotizacionesPreConvenios",
		"MyDesktop.view.GridTarifas",
		'MyDesktop.view.GridTarifaPeso',
		'MyDesktop.view.GridTarifasServicioZona',
		'MyDesktop.view.GridTarifasRangoEnvios',
		'MyDesktop.view.GridTarifaAdicional',
		'MyDesktop.view.GridDescuentos',
		'MyDesktop.view.GridDescuentosTipoDetalle', 
		'MyDesktop.view.GridUtilitarioDescuentos',
		'MyDesktop.view.GridLocalizacion',
		'MyDesktop.view.GridFormaPago',
		'MyDesktop.view.GridAdicional',
		'MyDesktop.view.GridPoblacionPago',
		'MyDesktop.view.GridMetodoPago',
		'MyDesktop.view.GridCondicionPago',
		'MyDesktop.view.GridServicio',
		'MyDesktop.view.GridGrupoCliente',
		'MyDesktop.view.GridOficinaControl',
		'MyDesktop.view.GridOrdenServicio',
		'MyDesktop.view.GridCampos',
		'MyDesktop.view.GridRegistros',
		'MyDesktop.view.GridEntidad',
		'MyDesktop.view.GridOrganizacion',
		'MyDesktop.view.GridPerfiles',
		'MyDesktop.view.GridUsuarios',
		'MyDesktop.view.GridCotizacionDetalle',
		'MyDesktop.view.GridUnidadAdministrativa',
		'MyDesktop.view.GridParametrosConfiguracion',
		'MyDesktop.view.GridAdministracionTarea',
		'MyDesktop.view.GridTareaNotificacionAlertSolicitudsUsuario',
		'MyDesktop.view.GridAgrupacionUsuario',
		'MyDesktop.view.GridUsuariosMismoAgrupamiento',
		'MyDesktop.view.GridClavesExcepcion',
		'MyDesktop.view.GridDatosAgrupamiento',
		'MyDesktop.view.GridNivelPuesto',
		'MyDesktop.view.GridClientesRFCs',
		'MyDesktop.grid.GridUsuariosConvenio',
		'MyDesktop.grid.GridUsuariosPDV',
		'MyDesktop.grid.GridMaterialEmpaque',
		'MyDesktop.grid.GridDescuentoFactura',
		'MyDesktop.grid.GridConsultaEtiquetas',
		'MyDesktop.grid.GridHistoriaEnvio',
		  'MyDesktop.grid.GridNotasAttachment',
		  'MyDesktop.models.ModeloFolios',
		  'MyDesktop.store.StoreTipoManejoImpresion',
		  'MyDesktop.view.GridManejoFolios',

		//Vistas
		'MyDesktop.ViewConfiguracionMenu',
		"MyDesktop.ViewClientes",
		'MyDesktop.ViewCuentasClientes',
		'MyDesktop.ViewTarifas',
		//"MyDesktop.view.GridTarifasRango",
		//"MyDesktop.view.GridTarifasRangoZona",
		'MyDesktop.ViewDescuentos',
		'MyDesktop.ViewCotizacionesPreConvenio',
		'MyDesktop.ViewFormasPago',
		'MyDesktop.ViewAdicionales',
		'MyDesktop.ViewMetodoPago',
		'MyDesktop.ViewPoblacionPago',
		'MyDesktop.ViewCondicionPago',
		'MyDesktop.ViewServicios',
		'MyDesktop.ViewGrupoCliente',
		'MyDesktop.ViewOficinaControl',
		'MyDesktop.ViewOrdenServicio',
		'MyDesktop.ViewCampos',
		'MyDesktop.ViewRegistros',
		'MyDesktop.ViewEntidad',
		'MyDesktop.ViewPerfiles',
		'MyDesktop.ViewUsuarios',
		'MyDesktop.ViewDescuentoDetalleTipo',
		'MyDesktop.ViewPassword',
		'MyDesktop.ViewConvenio',
		'MyDesktop.ViewUnidadAdministrativa',
		'MyDesktop.ViewParametrosConfiguracion',
		'MyDesktop.ViewAdministracionTareas',
		'MyDesktop.ViewAgrupamientos',
		'MyDesktop.ViewPuestosUsuarios',
		'MyDesktop.ViewClientesFacturacion',
		'MyDesktop.ViewAdminOrdenesRecoleccion',
		'MyDesktop.ViewAdminManifiestoOrdenesRecoleccion',
		'MyDesktop.ViewTareasPendientes',
		'MyDesktop.ViewAgendaOR',
		
		//RECOLECCIONES
		'MyDesktop.form.FormDatosOrdenRecolecion',
		'MyDesktop.form.FormDatosOrdenRecolecionEsporadica',
		'MyDesktop.form.FormReasignarRuta',
		'MyDesktop.grid.GridDiasProgramados',
		'MyDesktop.grid.GridFrecuenciasEntrega',
		'MyDesktop.grid.GridRecoleccionProgramada',
		'MyDesktop.models.ModeloDiasProgramados',
		'MyDesktop.models.ModeloFrecuenciasEntrega',
		'MyDesktop.models.ModeloLogHistoria',
		'MyDesktop.models.ModeloRecolecciones',
		'MyDesktop.store.StoreDiasMes',
		'MyDesktop.store.StoreDiasProgramados',
		'MyDesktop.store.StoreDiasSemana',
		'MyDesktop.store.StoreFrecuenciasEntrega',
		'MyDesktop.store.StoreRecolecciones',
		'MyDesktop.store.StoreTipoBusquedaRecoleccion',
		'MyDesktop.store.StoreTipoRecoleccion',
		'MyDesktop.store.StoreTiposEmpaque',
		'MyDesktop.store.StoreTiposEmpaque',
		'MyDesktop.grid.GridHistoriaRecoleccion',
		'MyDesktop.grid.GridDireccionRecoleccion',
		'MyDesktop.grid.GridRecoleccionEsporadica',
		'MyDesktop.form.FormDatosOrdenObjeto',
		'MyDesktop.store.StoreTipoRecoleccionEsporadica',
		'MyDesktop.store.StoreTipoRecoleccionEsporadica',
		'MyDesktop.grid.GridTipoEmpaque',
		'MyDesktop.form.FormDiaSemana',
		'MyDesktop.form.FormDiaMes',
		'MyDesktop.grid.GridPlazaRecoleccion',
		'MyDesktop.form.FormManifiestosFramedPanels',
		'MyDesktop.grid.GridRutaRecoleccion',
		'MyDesktop.models.ModeloAgendaOR',
		'MyDesktop.store.StoreAgendaOR',
	  	'MyDesktop.form.FormAgregaAgendaOR',
	  	'MyDesktop.form.FormAsignarAgendaOR',
		'MyDesktop.form.FormCierreAgendaOR',
		'MyDesktop.grid.GridAgendaOR'

    ],
	myscope:undefined,
    init: function() {
       
        this.callParent();
		this.myscope=this;
		 var bodyElement = Ext.getBody();
		  bodyElement.setStyle({
			  'background-color':'#FFFFFF',
			  'height': '100%',
			   'background': '#34495e',
			   'background': 'url(../resources/css_menu/images/desktopgreenenvia1.jpg) no-repeat center center fixed',
			    '-webkit-background-size': 'cover',
			    '-moz-background-size': 'cover',
			    '-o-background-size': 'cover',
			    'background-size': 'cover'

		  });
		
		
		
    },

    getModules : function(){
        return [
          
			// new MyDesktop.VideoWindow(),
		    //new MyDesktop.WindowsMenuPrincipal(),
		    new  MyDesktop.ViewFormasPago(),
			new MyDesktop.ViewClientes(),
			new MyDesktop.ViewTarifas(),
			new MyDesktop.ViewDescuentos(),
			new MyDesktop.ViewCotizacionesPreConvenio(),
			new MyDesktop.ViewAdicionales(),
			new MyDesktop.ViewMetodoPago(),
			new MyDesktop.ViewPoblacionPago(),
			new MyDesktop.ViewCondicionPago(),
			new MyDesktop.ViewServicios(),
			new MyDesktop.ViewGrupoCliente(),
			new MyDesktop.ViewOficinaControl(),
			new MyDesktop.ViewOrdenServicio(),
			new MyDesktop.ViewCampos(),
			new MyDesktop.ViewRegistros(),
			new MyDesktop.ViewEntidad(),
			new MyDesktop.ViewPerfiles(),
			new MyDesktop.ViewUsuarios(),
			new MyDesktop.ViewDescuentoDetalleTipo(),
			new MyDesktop.ViewPassword(),
			new MyDesktop.ViewCuentasClientes(),
			new MyDesktop.ViewConvenio(),
			new MyDesktop.ViewConfiguracionMenu(),
			new MyDesktop.ViewUnidadAdministrativa(),
			new MyDesktop.ViewParametrosConfiguracion(),
			new MyDesktop.ViewAdministracionTareas(),
			new MyDesktop.ViewAgrupamientos(),
			new MyDesktop.ViewPuestosUsuarios(),
			new MyDesktop.ViewClientesFacturacion(),
			new MyDesktop.ViewAdminOrdenesRecoleccion(),
			new MyDesktop.ViewAdminManifiestoOrdenesRecoleccion(),
			new MyDesktop.ViewTareasPendientes(),    
			new MyDesktop.ViewAgendaOR()

        ];
    },

    getDesktopConfig: function () {
        var me = this, ret = me.callParent();

        return Ext.apply(ret, {
            cls: 'ux-desktop-black',

            contextMenuItems: [
                { text: 'Change Settings', handler: me.onSettings, scope: me }
            ],
			wallpaper: '../resources/css_menu/images/'+ wallpapers_own,
            wallpaperStretch: wallpaperStretch_own

          
        });
    },

    // config for the start menu
    getStartConfig : function() {
        var me = this, ret = me.callParent();

        return Ext.apply(ret, {
            title: 'Usuario Datos',
            iconCls: 'user',
            height: 300,
            toolConfig: {
                width: 100,
                items: [
                    {
                        text:'Ajustes',
                        iconCls:'setting_blue',
                        handler: me.onSettings,
                        scope: me
                    },
                    '-',
                    {
                        text:'Salir',
                        iconCls:'out_blue',
                        handler: me.onLogout,
                        scope: me
                    }
                ]
            }
        });
    },

    getTaskbarConfig: function () {
        var ret = this.callParent();

        return Ext.apply(ret, {
            quickStart: [
              //  { name: 'Accordion Window', iconCls: 'accordion', module: 'acc-win' },
              // { name: 'Grid Window', iconCls: 'icon-grid', module: 'grid-win' }
            ],
            trayItems: [
                { xtype: 'trayclock', flex: 1 }
            ]
        });
    },

    onLogout: function () {
        Ext.Msg.confirm('Cerrar', 'Desea salir de la aplicacion ahora?', function(btn){
        	if ((btn=='yes') || (btn=='si')){
        		var myMask = new Ext.LoadMask(Ext.getBody(), {msg:"Cerrando Sesion de usuario espere"});
        		myMask.show();
        		
        		document.location.href ='../';
        		return;
        	}
        	
        	
        });
    },
	
	openWindowsOpcionMenu: function (obj) {
		var id_win = obj.id.replace('_item','');
		//alert('openWindowsOpcionMenu:' + id_win);
        var me = this;
        var module =  this.getModule(id_win);
        	//if (!me.desktop.onShortcutButtonClick(id_win)){
        		if ((id_win==undefined) || (id_win=='')){
        			mensajeAlert('Identificador de Opcion no ha sido cargado a la sesion[' + id_win+ ']');
        			return;
        		}
        		win = this.createWindow(module);
        	//}
		
	},
	
	openWindowsOpcionMenuId: function (id_win) {
		var me = this;
		var id_win = id_win.replace('_item','');
		//alert('openWindowsOpcionMenuId:' + id_win);
		//if (!me.desktop.onShortcutButtonClick(id_win)){
			var module =  this.getModule(id_win);
			if ((module==undefined) || (module=='')){
				mensajeAlert('Identificador de Opcion no ha sido cargado a la sesion[' + id_win+ ']');
				return;
			}
			
			win = this.createWindowReturn(module);
		
			return win
		//}
		
		
	
	},
	
	openModule: function (id_win) {
		var me = this;
		var id_win = id_win.replace('_item','');
		//alert('openModule:' + id_win);
		//if (!me.desktop.onShortcutButtonClick(id_win)){
			var module =  this.getModule(id_win);
			if ((module==undefined) || (module=='')){
				mensajeAlert('Identificador de Opcion no ha sido cargado a la sesion[' + id_win+ ']');
				return undefined;
			}
			
			return module;
		//}
		
		
	
	},
	
	openWindowsMenu: function (app,usuario) {

		
		
		
		
	},

    onSettings: function () {
        var dlg = new MyDesktop.Settings({
            desktop: myDesktopApp.desktop
        });
        dlg.show();
    }
});
