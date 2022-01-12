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
        //Objetos
        'Ext.ux.desktop.ShortcutModel',
		'MyDesktop.objetos.TextFieldUpperCase',
		'MyDesktop.objetos.TextAreaUpperCase',
		'MyDesktop.objetos.EmailTextField',
        'MyDesktop.SystemStatus',
        
    	//Modelos de datos
		'MyDesktop.models.ModeloUsuario',
		'MyDesktop.models.ModeloTareas',
		'MyDesktop.models.ModeloDataItemMenu',
		'MyDesktop.models.ModeloNivelPuestoUsuario',
		'MyDesktop.models.ModeloParametrosConfiguracion',
		'MyDesktop.models.ModeloAdicionales',
		'MyDesktop.models.ModeloPaquete',
		'MyDesktop.models.ModeloMovimientosHistoria',
		'MyDesktop.models.ModeloMovimientosCaja',
		'MyDesktop.models.ModeloFoliosServicios',
		'MyDesktop.models.ModeloFrecuenciasEntrega',
		
		'MyDesktop.models.ModeloCPs',
		'MyDesktop.models.ModeloCarteraDirecciones',
		'MyDesktop.models.ModeloOficinas',
		'MyDesktop.models.ModeloDocumento',
		'MyDesktop.models.ModeloSetRotulacionEtiquetas',
		'MyDesktop.models.ModeloEtiquetaRotulada',
		'MyDesktop.models.ModeloOficinasReceptorasPDV',
	    'MyDesktop.models.ModeloLogHistoria'  ,
		'MyDesktop.models.ModeloAttachment',
		'MyDesktop.models.ModeloEtiquetasTemplate',
		'MyDesktop.models.ModeloRemitente',
		'MyDesktop.models.ModeloDestinatario',
		'MyDesktop.models.ModeloReimpresionEtiqueta',
		'MyDesktop.models.ModeloTransportista',
		'MyDesktop.models.ModeloIReportWeb', 
		'MyDesktop.models.ModeloItemExtJS',
		'MyDesktop.models.ModeloPlaza',
		'MyDesktop.models.ModeloFacturaResumen',
		'MyDesktop.store.StoreFacturaResumen',
		'MyDesktop.grid.GridFacturaResumen',
		'MyDesktop.store.StoreMeses',
		
		
		//Store utilitarios
		'MyDesktop.store.StoreClientes',
		'MyDesktop.models.ModeloClientes',
		'MyDesktop.grid.GridClientes',
		'MyDesktop.store.StoreFoliosServicios',
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
		"MyDesktop.store.StoreTiposPersona",
		'MyDesktop.store.StoreTiposDescuento',
		'MyDesktop.store.StoreTiposEmpaques',
		'MyDesktop.store.StoreTiposBusquedaPaquetes',
		'MyDesktop.store.StoreTiposMovimientosCaja',
		'MyDesktop.store.StoreTiposRotulo',
		'MyDesktop.store.StoreTiposEntregaTerritorio',
		'MyDesktop.store.StoreTiposImpresionFormato',
		'MyDesktop.store.StoreEtiquetasObservacionContenido',
		'MyDesktop.store.StoreEtiquetasRotularImportar',
		'MyDesktop.store.StoreHistoria' ,
		'MyDesktop.store.StoreAttachment',
		'MyDesktop.store.StoreTemplateRotacion',
		'MyDesktop.store.StoreTemplateFont',
		'MyDesktop.store.StoreTemplateBaseLine',
		'MyDesktop.store.StoreTemplateTipoObjeto',
		'MyDesktop.store.StoreTemplateCampoDisponible',
		'MyDesktop.store.StoreEtiquetasTemplateDetalle',
		'MyDesktop.store.StoreEtiquetasTemplate',
		'MyDesktop.store.StoreTiposBusquedaDocumentoEtiquetas',
		'MyDesktop.store.StoreTipoLeyendaAcuse',
		'MyDesktop.store.StoreTiposBusquedaRemDes',
		'MyDesktop.store.StoreTiposModalidadCarteraRemDes',
		
		

		//Stores
		'MyDesktop.store.StoreUsuario',
		'MyDesktop.store.StoreParametrosConfiguracion',
		'MyDesktop.store.StorePaqueteDimensiones',
		'MyDesktop.store.StoreMovimientosCaja',

		'MyDesktop.store.StoreOpcionesMenu',
		//'MyDesktop.store.StoreParametrosConfiguracion',
		'MyDesktop.store.StoreTareas',
		'MyDesktop.store.StoreAdicionales',
		'MyDesktop.store.StoreMovimientosHistoria',
		'MyDesktop.store.StoreMovimientosCaja',
		'MyDesktop.store.StoreFrecuenciasEntrega',
		
		'MyDesktop.store.StoreCarteraDirecciones',
		'MyDesktop.store.StoreOficinas',
		'MyDesktop.store.StoreCodigoPostal',
		'MyDesktop.store.StoreDocumento',
		'MyDesktop.store.StoreTipoDireccionCartera',
		'MyDesktop.store.StoreSetRotulacionEtiquetas',
		'MyDesktop.store.StoreEtiquetasRotuladas',
		'MyDesktop.store.StoreOficinasReceptorasPDVs',
		'MyDesktop.store.StoreEtiquetasMedidas',
		'MyDesktop.store.StoreReimpresionEtiqueta',
		'MyDesktop.store.StoreTransportista',
		'MyDesktop.store.StoreIReporteWeb',
		'MyDesktop.store.StoreTiposBusquedaDocumentoEtiquetasShort',
		'MyDesktop.store.StorePlaza',
		'MyDesktop.store.StoreUnigisReenvioDocumento',
	
		
				

		//Forms
		'MyDesktop.form.FormPasswordUsuario',
		'MyDesktop.form.FormSolicitarDescuentoTarea',
		'MyDesktop.form.FormTarea',
		'MyDesktop.form.FormUsuariosSesion',
		'MyDesktop.form.FormVentaMostrador',
		'MyDesktop.form.FormBusquedaEnvio',
		'MyDesktop.form.FormMovimientoCaja',
		'MyDesktop.form.FormConfirmacionOcurre',
		'MyDesktop.form.FormDevolucionOcurre',
		'MyDesktop.form.FormReporteDevoluciones',
		'MyDesktop.form.FormPropiedadesEtiquetas',
		'MyDesktop.form.FormDatosClienteDireccion',
		'MyDesktop.form.FormDatosEtiqueta',
		'MyDesktop.form.FormCarteraDirecciones',
		'MyDesktop.form.FormUploadAttachment',
		'MyDesktop.form.FormCitaEnvio',
		'MyDesktop.form.FormPropiedadesTemplateLineaEtiq',
		'MyDesktop.form.FormTemplateEtiqueta',
		'MyDesktop.form.FormPropiedadesReporte',
		
				
		//Grid
		'MyDesktop.grid.GridTareaNotificacionAlertSolicitudsUsuario',
		'MyDesktop.grid.GridAdicional',
		'MyDesktop.grid.GridPaquetesDimensiones',
		'MyDesktop.grid.GridGuiasPaquetes',
		'MyDesktop.grid.GridMovimientosHistoria',
		'MyDesktop.grid.GridOficinasReceptoras',
		'MyDesktop.grid.GridConsultaCPs',
		'MyDesktop.grid.GridConsultaEtiquetas',
		'MyDesktop.grid.GridMovimientosCaja',
		'MyDesktop.grid.GridPaquetesOcurre',
		'MyDesktop.grid.GridEtiquetasConfiguradas',
		'MyDesktop.grid.GridFoliosServicios',
		'MyDesktop.grid.GridFrecuenciasEntrega',
		
		'MyDesktop.grid.GridCarteraDirecciones',
		'MyDesktop.grid.GridOficinasReceptoras',
		'MyDesktop.grid.GridMedidasPesoEtiquetas',
		'MyDesktop.grid.GridSeguroAmparadoEtiquetas',
		'MyDesktop.grid.GridCODCobroAmparadoEtiquetas',
		'MyDesktop.grid.GridManifiestoDocumentoEtiquetas',
		'MyDesktop.grid.GridCatalogoUsuarios',
		'MyDesktop.grid.GridCatalogoTransportista',
		'MyDesktop.grid.GridSetRotulacionEtiquetas',
		'MyDesktop.grid.GridObservacionContenidoEtiquetas',
		'MyDesktop.grid.GridImportarRotualcion',
		'MyDesktop.grid.GridHistoria',
		'MyDesktop.grid.GridAttachment',
		'MyDesktop.grid.GridTemplateEtiquetas',
		'MyDesktop.grid.GridTemplateEtiquetasDetalle',
		'MyDesktop.grid.GridReimpresionEtiquetas',
		'MyDesktop.grid.GridCarteraDireccionesAdmin',
		'MyDesktop.grid.GridIReportWeb', 
		'MyDesktop.store.StoreFacturaAdicionalEspecial',
		'MyDesktop.grid.GridFacturaAdicionalEspecial',
		'MyDesktop.grid.GridReenvioUnigisEtiquetas',

		//Vistas
		'MyDesktop.ViewConfiguracionMenu',
		'MyDesktop.ViewMovimientosCaja',
		'MyDesktop.ViewPaquetesOcurres',
		'MyDesktop.ViewRotuladorEtiquetas',
		'MyDesktop.ViewManifiestoDocumentoEtiqueta',
		'MyDesktop.ViewPassword',
		'MyDesktop.ViewCarteraDireccionesCliente',
		'MyDesktop.ViewConsultaDocumentosEtiquetas',
		'MyDesktop.ViewTemplateEtiqueta',
		'MyDesktop.ViewOficinaControl',
		'MyDesktop.ViewIReport',
		'MyDesktop.ViewCotizacionEnvios',
		//Reenvio Unigis
		'MyDesktop.ViewReenvioEtiquetas',
		'MyDesktop.ViewDocumentadorEtiquetas',
		
		'MyDesktop.ViewFacturaResumen',
		
		//Cotizacion
		'MyDesktop.models.ModeloCotizacion',
		'MyDesktop.store.StoreCotizacion',
		'MyDesktop.grid.GridCotizacion',
		'MyDesktop.grid.GridCamposDisponibles',
		'MyDesktop.ViewCrearCCP',
		'MyDesktop.form.FormCrearCCP',
		'MyDesktop.grid.GridCartaPorte',
		
		//Panel
		//'MyDesktop.form.PanelRotularEtiqueta'
		'MyDesktop.form.IReportFramedPanels'
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
			   'background': 'url(./resources/css_menu/images/desktopgreenenvia1.jpg) no-repeat center center fixed',
			    '-webkit-background-size': 'cover',
			    '-moz-background-size': 'cover',
			    '-o-background-size': 'cover',
			    'background-size': 'cover'

		  });
		
    },

    getModules : function(){
        return [
                new MyDesktop.ViewMovimientosCaja(),
                new MyDesktop.ViewPaquetesOcurres(),
                new MyDesktop.ViewRotuladorEtiquetas(),
                new MyDesktop.ViewManifiestoDocumentoEtiqueta(),
                new MyDesktop.ViewPassword(),
                new MyDesktop.ViewCarteraDireccionesCliente(),
                new MyDesktop.ViewConsultaDocumentosEtiquetas(),
                new MyDesktop.ViewTemplateEtiqueta(),
                new MyDesktop.ViewOficinaControl(),
                new MyDesktop.ViewIReport(),
                new MyDesktop.ViewCotizacionEnvios(),
                new MyDesktop.ViewFacturaResumen(),
                new MyDesktop.ViewReenvioEtiquetas(),
                new MyDesktop.ViewDocumentadorEtiquetas(),
                new MyDesktop.ViewCrearCCP()
              
                
               
        ];
    },

    getDesktopConfig: function () {
        var me = this, ret = me.callParent();

        return Ext.apply(ret, {
            //cls: 'ux-desktop-black',

            contextMenuItems: [
                { text: 'Cambio de configuración', handler: me.onSettings, scope: me }
            ],
           
            
            wallpaper: './resources/css_menu/images/'+ wallpapers_own,
            wallpaperStretch: wallpaperStretch_own

          
        });
    },

    // config for the start menu
    getStartConfig : function() {
        var me = this, ret = me.callParent();

        return Ext.apply(ret, {
            title: 'Usuario Datos',
            iconCls: 'ux-user-icon',
            height: 400/*,
            toolConfig: {
                width: 200,
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
            }*/
        });
    },

    getTaskbarConfig: function () {
        var ret = this.callParent();

       // return Ext.apply(ret, {
       //     quickStart: [  
            //Menus de la parte derecha inferior
             /*{ name: 'Checando Sesión', iconCls: 'accordion', module: 'rotulador-config-etiquetas-win' },
             { name: 'Grid Window', iconCls: 'icon-grid', module: 'manifiesto-documento-etiqueta-win' }*/
        //    ],
         //   trayItems: [
          //              { xtype: 'trayclock', flex: 1 }
              
           // ]
       // });
        
        var myscope = this;
		var combo_tipos_busqueda_short = Ext.create('Ext.form.ComboBox', {
			fieldLabel: '',
			id:'combo_busqueda_shor',
			disabled: false,
			editable:false,
			forceSelection:true,
			store: Ext.create('MyDesktop.store.StoreTiposBusquedaDocumentoEtiquetasShort',{}) ,
			queryMode: 'local',
			emptyText: 'Seleccione Tipo',
			displayField: 'descripcion',
			valueField: 'idtipo',
				value:'1'
		});
		
		var tip = Ext.create('Ext.tip.ToolTip', {
		    target: 'clearButton',
		    html: 'este es el usuario'
		});
        return Ext.apply(ret, {
            quickStart: [
            // { xtype:'textfield',name: 'Checando Sesión', iconCls: 'accordion', module: 'acc-win' }
              // { name: 'Grid Window', iconCls: 'icon-grid', module: 'grid-win' }
            ],
            trayItems: [
                combo_tipos_busqueda_short,
                { xtype:'myUpperCaseTextField',labelWidth:60, id:'id_guia_buscar' },
                {  xtype: 'button', iconCls:'buscar_blue', 
                	handler:function(o,e){
                		var patron = Ext.getCmp('id_guia_buscar').getValue();
                		var idbusqueda = Ext.getCmp('combo_busqueda_shor').getValue();
                		if (patron==''){
                			mensajeAlert('Capture el dato a buscar.');
                			return;
                		}
                		
                		var module = myscope.openModule('consulta-etiquetas-win_item');

                		if (module!=undefined){
                			var win = myscope.createWindowConfig(module,
                					{patron:patron,idbusqueda:idbusqueda});
                			win.show();
                			
                    		//module.realizaBusqueda(patron,idbusqueda)
                    		
                    		
                		}
                		
                		
                	}
                },
               
                { xtype: 'trayclock', flex: 1 }
            ]
        });
    },
    
    openModule: function (id_win) {
		var me = this;
		var id_win = id_win.replace('_item','');
		//if (!me.desktop.onShortcutButtonClick(id_win)){
			var module =  this.getModule(id_win);
			if ((module==undefined) || (module=='')){
				mensajeAlert('Opción no autorizada[' + id_win+ ']');
				return undefined;
			}
			
			return module;
		//}
		
		
	
	},

    onLogout: function () {
        Ext.Msg.confirm('Cerrar Sesion', 'Desea salir de la aplicación ahora?', function(btn){
        	if ((btn=='yes') || (btn=='si')){
        		var myMask = new Ext.LoadMask(Ext.getBody(), {msg:"Cerrando Sesion de usuario espere"});
        		myMask.show();
        		
        		document.location.href ='./';
        		return;
        	}
        	
        	
        });
    },
	
	openWindowsOpcionMenu: function (obj) {
		var arr = obj.id.split("_");
		var id_win = arr[0];//obj.id.replace('_item','');
		
        var me = this;
        var module =  this.getModule(id_win);
        	//if (!me.desktop.onShortcutButtonClick(id_win)){
        		if ((id_win==undefined) || (id_win=='')){
        			mensajeAlert('Opcion seleccionada no es validad[' + id_win+ ']');
        			return;
        		}
        		win = this.createWindow(module);
        	//}
		
	},
	
	openWindowsOpcionMenuId: function (id_win) {
		var me = this;
		var id_win = id_win.replace('_item','');
		//if (!me.desktop.onShortcutButtonClick(id_win)){
			var module =  this.getModule(id_win);
			if ((module==undefined) || (module=='')){
				mensajeAlert('Opcion seleccionada no es validad[' + id_win+ ']');
				return;
			}
			win = this.createWindow(module);
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
