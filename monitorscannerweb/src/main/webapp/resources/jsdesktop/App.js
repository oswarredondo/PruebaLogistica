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
               'Ext.chart.*',
               
        'Ext.window.MessageBox',
        //Objetos
        'Ext.ux.desktop.ShortcutModel',
		'MyDesktop.objetos.TextFieldUpperCase',
		'MyDesktop.objetos.TextAreaUpperCase',
		'MyDesktop.objetos.EmailTextField',

    	//Modelos de datos
		'MyDesktop.models.ModeloUsuario',
		
		'MyDesktop.models.ModeloMovimientosHistoria',

		'MyDesktop.models.ModeloDocumento',
	    'MyDesktop.models.ModeloLogHistoria'  ,
		'MyDesktop.models.ModeloAttachment',
		'MyDesktop.models.ModeloIReportWeb', 
		'MyDesktop.models.ModeloItemExtJS',
		'MyDesktop.models.ModeloDataItemMenu',
		'MyDesktop.models.ModeloParametrosConfiguracion',
		
		//Store utilitarios
	
		'MyDesktop.store.StoreSINO',
		'MyDesktop.store.StoreVisibilidad',
		
		'MyDesktop.store.StoreHistoria' ,
		'MyDesktop.store.StoreAttachment',
		'MyDesktop.store.StoreTiposBusquedaDocumentoEtiquetas',
		'MyDesktop.store.StoreUsuario',
		'MyDesktop.store.StoreMovimientosHistoria',
		'MyDesktop.store.StoreDocumento',
		'MyDesktop.store.StoreIReporteWeb',
		'MyDesktop.store.StoreTiposBusquedaDocumentoEtiquetasShort',
		'MyDesktop.store.StoreOpcionesMenu',
		'MyDesktop.store.StoreParametrosConfiguracion',

		//Forms
		'MyDesktop.form.FormPasswordUsuario',
		'MyDesktop.form.FormBusquedaEnvio',
		'MyDesktop.form.FormUploadAttachment',
		'MyDesktop.form.FormPropiedadesReporte',
		
				
		//Grid
		'MyDesktop.grid.GridMovimientosHistoria',
		'MyDesktop.grid.GridConsultaCPs',
		'MyDesktop.grid.GridConsultaEtiquetas',
		'MyDesktop.grid.GridReenvioUnigisEtiquetas',

		'MyDesktop.grid.GridHistoria',
		'MyDesktop.grid.GridAttachment',
		'MyDesktop.grid.GridIReportWeb', 
		
        //Grid para historial de movimientos procesados
        'MyDesktop.grid.GridLogRegistrosProcesados',
        'MyDesktop.form.PanelGraficoResumenPlazas',
        'MyDesktop.models.ModeloRegistrosProcesados',
        'MyDesktop.models.ModeloPieChart',
        'MyDesktop.store.StoreRegistrosProcesados',
        'MyDesktop.store.StorePieChart',
        'MyDesktop.form.FormBarChart',
        'MyDesktop.form.FormPieChart',
        'MyDesktop.grid.GridRegistrosProcesados',
        'MyDesktop.form.FormMonitorFramedPanels',
        'MyDesktop.grid.GridManifiestoEntradas',
        'MyDesktop.grid.GridManifiestoMovLocal',
        
        'MyDesktop.ViewMonitorRegistrosProcesados',
        'MyDesktop.models.ModeloTransportista',
        'MyDesktop.store.StoreTransportista',
        'MyDesktop.grid.GridCatalogoTransportista',
        'MyDesktop.grid.GridManifiestoFXC',
    	'MyDesktop.grid.GridRecoleccionesRealizadasRuta',
		//Vistas
		//'MyDesktop.ViewManifiestoDocumentoEtiqueta',
		//'MyDesktop.ViewManifiestoMovimientoSalidasFXC',
		//'MyDesktop.ViewManifiestoMovimientoSalidas',
		//'MyDesktop.ViewManifiestoMovimientoLocal',
		//'MyDesktop.ViewManifiestoEntregasLocales',
		'MyDesktop.ViewManifiestoMovimientos',
		
		'MyDesktop.ViewPassword',
		'MyDesktop.ViewIReport',
		'MyDesktop.ViewConsultaDocumentosEtiquetas',
		'MyDesktop.ViewRutaManifiesto',
		'MyDesktop.grid.GridRutaManifiesto',
		'MyDesktop.grid.GridTiempoEntregaCO',
		'MyDesktop.grid.GridMedicionPendientesCO',
		
		//CAMBIO INDICADORES
		'MyDesktop.ViewIndicadores',
		'MyDesktop.grid.GridMedicionGarantiasCliente',
		'MyDesktop.grid.GridMedicionCumplimientoGarantias',
		'MyDesktop.grid.GridMedicionCumplimientoGarantiasCO',
		'MyDesktop.grid.GridTiempoCrossDock',
		'MyDesktop.grid.GridDemoraIngresoCOFinal',
		'MyDesktop.grid.GridDesgloceCumplimientoDias',
		'MyDesktop.grid.GridDesgloceCumplimientoDiasTotal',
		'MyDesktop.grid.GridMedicionIntentosEntrega',

		'MyDesktop.ViewRotuladorEtiquetas',

		//Panel
		'Ext.ux.IFrame',
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
			   'background': 'url(../resources/css_menu/images/desktopgreenenvia1.jpg) no-repeat center center fixed',
			    '-webkit-background-size': 'cover',
			    '-moz-background-size': 'cover',
			    '-o-background-size': 'cover',
			    'background-size': 'cover'

		  });
		
    },

    getModules : function(){
        return [
              
                new MyDesktop.ViewPassword(),
                new MyDesktop.ViewIReport(),
                new MyDesktop.ViewConsultaDocumentosEtiquetas(),
                new MyDesktop.ViewRutaManifiesto(),
                //Manifiestos
               // new MyDesktop.ViewManifiestoMovimientoSalidasFXC(),
               // new MyDesktop.ViewManifiestoMovimientoSalidas(),
               // new MyDesktop.ViewManifiestoMovimientoLocal(),
               // new MyDesktop.ViewManifiestoEntregasLocales(),
              //  new MyDesktop.ViewManifiestoMovimientoEntradas(),
                new MyDesktop.ViewManifiestoMovimientos(),
                
                new MyDesktop.ViewMonitorRegistrosProcesados(),

                new MyDesktop.ViewIndicadores(),
                
                new MyDesktop.ViewRotuladorEtiquetas


               
        ];
    },

    getDesktopConfig: function () {
        var me = this, ret = me.callParent();

        return Ext.apply(ret, {
            //cls: 'ux-desktop-black',

            contextMenuItems: [
                { text: 'Cambio de configuracion', handler: me.onSettings, scope: me }
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
                /*combo_tipos_busqueda_short,
                { xtype:'myUpperCaseTextField',labelWidth:60, id:'id_guia_buscar' },
                {  xtype: 'button', iconCls:'buscar_blue', tooltip:'Rastrear envio',
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
                					{patron:patron,idbusqueda:idbusqueda, });
                			
                			
                    		//module.realizaBusqueda(patron,idbusqueda)
                    		
                    		
                		}
                		
                		
                	}
                },
               {xtype:'tbseparator'},
                {  xtype: 'button', iconCls:'wallpaper_blue', tooltip:'Monitor de Registros',
                	handler:function(o,e){

                		
                		var module = myscope.openModule('monitor-procesamiento-win');

                		if (module!=undefined){
                			var win = myscope.createWindow(module);
                			//win.show();   

                		}
                		
                		
                	}
                },
                {xtype:'tbseparator'},
                {  xtype: 'button', iconCls:'appointment_blue', tooltip:'Administracion de Manifiestos',
                	handler:function(o,e){

                		
                		var module = myscope.openModule('manifiesto-movimientos-operativos-win');

                		if (module!=undefined){
                			var win = myscope.createWindow(module);
                			//win.show();   

                		}
                		
                		
                	}
                },*/
               
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
        Ext.Msg.confirm('Cerrar Sesión', 'Desea salir ahora?', function(btn){
        	if ((btn=='yes') || (btn=='si')){
        		var myMask = new Ext.LoadMask(Ext.getBody(), {msg:"Cerrando Sesión de usuario espere"});
        		myMask.show();
        		
        		document.location.href ='../';
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
