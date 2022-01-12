function menuprincipal(id_panel, dock_pos, largo_boton,tipo_menu){
	
	return Ext.create('Ext.toolbar.Toolbar', {
	    cls: 'encabezado_menu',
	    
	    items: [
					{
						   // text: 'Paste',
						    scale: 'large',
						  //  iconAlign: 'top',
						  //  scale: 'large',
						    dock: dock_pos,
						    iconCls: 'icono_menu', 
						    enableOverflow: true,
						    hidden:(tipo_menu=='left'?true:false),
						    tooltip:'Men� de Opciones',
						    handler:function(){
						    	
						    	var ishidden = Ext.getCmp('menu_principal_consulta'+id_panel ).isHidden( );
						    	if (ishidden){
						    		Ext.getCmp('menu_principal_consulta'+id_panel ).show();
							    	Ext.getCmp('menu_principal'+id_panel ).show();
							    	//Ext.getCmp('menu_principal_datosusuario').show();
							    	Ext.getCmp('menu_principal_utilerias'+id_panel ).show();
							    	
							    	 
							    	
						    	}else{
						    		Ext.getCmp('menu_principal_consulta'+id_panel ).hide();
							    	Ext.getCmp('menu_principal'+id_panel ).hide();
							    	//Ext.getCmp('menu_principal_datosusuario').hide();
							    	Ext.getCmp('menu_principal_utilerias'+id_panel ).hide();
						    	}
						    	
						    }
					
						},
						
					{
						xtype: 'buttongroup',
						title: 'Administraci�n',
						columns: 2,
						id:'menu_principal'+id_panel,
						hidden:true,
						defaults: {
							scale: 'small'
						},
					 height: 90,
					 listeners: {
					     'show':   {
					        fn:   function(menu) {
					                  menu.getEl().slideIn('t', {
					                      easing: 'easeOut',
					                      duration: 1000
					                  });
					        }
					     },
					     'hide':   {
						           fn:   function(menu) {
						                     menu.getEl().slideOut('t', {
						                         easing: 'easeOut',
						                         duration: 1000,
						                         remove: true,
						                         useDisplay: false
						                     });
						           }
						        }
					  },
					  items: getMenuAdministracion(id_panel,largo_boton) 
					},
					{
						xtype: 'buttongroup',
						title: 'Consultas',
						id:'menu_principal_consulta'+id_panel ,
						hidden:true,
						columns: 3,
						defaults: {
							scale: 'small'
						},
						 listeners: {
						        'show':   {
						           fn:   function(menu) {
						                     menu.getEl().slideIn('t', {
						                         easing: 'easeOut',
						                         duration: 1000
						                     });
						           }
						        },
						        'hide':   {
							           fn:   function(menu) {
							        	  
							                     menu.getEl().slideOut('t', {
							                         easing: 'easeOut',
							                         duration: 1000,
							                         remove: true,
							                         useDisplay: false
							                     });
							           }
							        }
						     },
						 height: 90,
						items: menuConsulta(id_panel,largo_boton) 
					},
					'->',
					{
						xtype: 'buttongroup',
						title: 'Utilerias',
						columns: 2,
						hidden:true,
						id:'menu_principal_utilerias'+id_panel,
						defaults: {
							scale: 'small'
						},
						height: 90,
						 listeners: {
						     'show':   {
						        fn:   function(menu) {
						                  menu.getEl().slideIn('t', {
						                      easing: 'easeOut',
						                      duration: 1000
						                  });
						        }
						     },
						     'hide':   {
							           fn:   function(menu) {
							                     menu.getEl().slideOut('t', {
							                         easing: 'easeOut',
							                         duration: 1000,
							                         remove: true,
							                         useDisplay: false
							                     });
							           }
							        }
						  }, 
						items: getMenuUtilerias(id_panel,largo_boton)
					},
					{
						xtype: 'buttongroup',
						title: 'Datos del Usuario <b>'+datosUsuario.nombre_usuario_windows+'</b>',
						id:'menu_principal_datosusuario'+id_panel,
						hidden:(id_panel=='lateral'?true:false),
						columns: 2,
						defaults: {
							scale: 'small'
						},
						 height: 90,
						items: [
						    {xtype:'label', html:'<b>Cte.SIPA:</b>' + datosUsuario.cliente_usuario_windows},  
						    {xtype:'label', html:'<b>Plaza:</b>' + datosUsuario.plaza_usuario},
						    {xtype:'label', html:'<b>Oficina:</b>' + datosUsuario.oficina_usuario},
						    {xtype:'label', html:'<b>Puesto:</b>' + datosUsuario.descripcionpuesto}
						]
					}	
	    ]
	});
	
}

function getContainerMenu(id_panel, dock_pos, largo_boton) {
	var arr_opciones= [];
	var index =0;
	store_administracion.each(function(record){
		arr_opciones[index++] =  { 
				id:record.get('windowId') + "_" + record.get('idopcion') + '_tree', 
				iconCls:record.get('iconCls'),
				text: record.get('descripcion_opcion'), tooltip:record.get('tooltip'),
				leaf: true };
		
	});
	
	//Datos de utilerias
	/*arr_opciones[index++] =  { 
			id:'consultacps_tree', 
			text: 'Consulta CPs', tooltip:'Consulta CPs', 
			iconCls:'search_blue',
			leaf: true
	};
	
	arr_opciones[index++] =  { 
			id:'cambiar-password-win_item_tree', 
			text: 'Contrase�a', tooltip:'Cambio de contrase�a', 
			iconCls:'opcion_password',
			leaf: true
	};
	arr_opciones[index++] =  { 
			id:'cerrarsesion_win_item_tree', 
			text: 'Salir', tooltip:'Cerrar Sesión', 
			iconCls:'opcion_salir',
			leaf: true
	};
	*/
	
	
	
	  var store = Ext.create('Ext.data.TreeStore', {
          root: {
          	expanded: true,
            children: arr_opciones 
          }
      });

      var arbol = Ext.create('Ext.tree.Panel', {
          title: 'Men� de Opciones',
          iconCls:'icono_menuarbol',
          width: 200,
          height: 150,
          store: store,
          rootVisible: false,
          layout: 'fit',
          listeners: {
        	  itemclick: function(s,r) {
        		  openOpcion( r.data.id);
                  
        	  }
          }
      });
      
      return arbol;

}


function openOpcion(id) {
	var arr = id.split("_");
	if (arr[0] == 'consultacps'){
		windowsConsultaCPS();
	}else if (arr[0] == 'cerrarsesion'){
		myDesktopApp.onLogout();
	}else{
		myDesktopApp.openWindowsOpcionMenuId(arr[0]);
	}
	
}
function openOpcionBtn(obj) {
	openOpcion(obj.id);
	
	
	
}


//////////// MENU CONSULTA 
function menuConsulta(id_panel,largo_boton){
	
	var arr_opciones= [];
	var index =0;
	var id_btn = "";
	store_administracion.each(function(record){
		 id_btn = record.get('windowId') + "_" + record.get('idopcion') + '_bar';
		if (record.get('menupadre') =='C' ){
			arr_opciones[index++] = 
			{
					xtype: 'button',
					id:id_btn,
					text:  record.get('descripcion_opcion'),
					iconCls: record.get('iconCls'),  
					width:largo_boton,
					tooltip:record.get('tooltip'),
					handler:openOpcionBtn, 
					disabled:checkEnable( record.get('windowId'))
					
				};

		}
		
	});
	if (arr_opciones.length<=0){
		arr_opciones[index++] = {xtype: 'button',id:'btnhiddenC1',width:largo_boton,disabled:true};
		arr_opciones[index++] = {xtype: 'button',id:'btnhiddenC2',width:largo_boton,disabled:true};
		arr_opciones[index++] = {xtype: 'button',id:'btnhiddenC3',width:largo_boton,disabled:true};
	}
	return arr_opciones;

}

function getMenuAdministracion(id_panel,largo_boton){
	
	var arr_opciones= [];
	var index =0;
	var id_btn = "";
	store_administracion.each(function(record){
		 id_btn = record.get('windowId') + "_" + record.get('idopcion') + '_bar';
		if (record.get('menupadre') =='A' ){
			arr_opciones[index++] = 
			{
					xtype: 'button',
					id:id_btn,
					text:  record.get('descripcion_opcion'),
					iconCls: record.get('iconCls'),  
					width:largo_boton,
					tooltip:record.get('tooltip'),
					handler:openOpcionBtn, 
					disabled:checkEnable( record.get('windowId'))
					
				};

		}
		
	});
	
	if (arr_opciones.length<=0){
		arr_opciones[index++] = {xtype: 'button',id:'btnhiddenA1',width:largo_boton,disabled:true};
		arr_opciones[index++] = {xtype: 'button',id:'btnhiddenA2',width:largo_boton,disabled:true};
		arr_opciones[index++] = {xtype: 'button',id:'btnhiddenA3',width:largo_boton,disabled:true};
	}
	return arr_opciones;
	
	/*return [
		{
			text: 'Etiquetas',
			iconCls: 'opcion_consultaetiqueta',
			id:'consulta-etiquetas-win_item'+id_panel,
			width:largo_boton,
			tooltip:'Consulta Etiquetas (ALT+E)'//,
			//disabled:checkEnable('consulta-etiquetas-win'),
			//handler:app.openWindowsOpcionMenu, scope:app
		},
		{
			
			text : "Oficinas",
			width:largo_boton,
			tooltip : 'Consulta Oficinas (ALT+O)',
			iconCls : 'opcion_carteraclientes',
			id:'consulta-oficinas-win_item'+id_panel,
			scope:this//,
			//disabled:checkEnable('consulta-oficinas-win'),
			//handler : this.openWindowsOpcionMenu, scope:app
		} ,
		{
			text : 'Consulta CPs',
			iconCls : 'search_blue',
			width:largo_boton,
			handler :function(){
				windowsConsultaCPS();
			},
			tooltip : 'Consulta de Colonias y Codigos Postales'
		},
		{
			text: 'Templates',
			iconCls: 'template_blue',
			id:'template-etiqueta-win_item'+id_panel,
			tooltip : 'Administraci�n de templates (ALT+T)',
			width:largo_boton//,
			//disabled:checkEnable('template-etiqueta-win'),
			//handler:app.openWindowsOpcionMenu, scope:app
		},
		{
			text: 'Reportes',
			iconCls: 'template_blue',
			id:'ireport-web-win_item'+id_panel,
			tooltip : 'Reportes existentes IReportWeb (ALT+R)',
			width:largo_boton//,
			//disabled:checkEnable('ireport-web-win'),
			//handler:app.openWindowsOpcionMenu, scope:app
		}

	];*/
}

function getMenuUtilerias(id_panel,largo_boton){
	
	var arr_opciones= [];
	var index =0;
	var id_btn = "";
	store_administracion.each(function(record){
		 id_btn = record.get('windowId') + "_" + record.get('idopcion') + '_bar';
		if (record.get('menupadre') =='U' ){
			arr_opciones[index++] = 
			{
					xtype: 'button',
					id:id_btn,
					text:  record.get('descripcion_opcion'),
					iconCls: record.get('iconCls'),  
					width:largo_boton,
					tooltip:record.get('tooltip'),
					handler:openOpcionBtn,
					disabled:checkEnable( record.get('windowId'))
					
				};

		}
		
	});
	
	if (arr_opciones.length<=0){
		arr_opciones[index++] = {xtype: 'button',id:'btnhiddenA1',width:largo_boton,disabled:true};
		arr_opciones[index++] = {xtype: 'button',id:'btnhiddenA2',width:largo_boton,disabled:true};
		arr_opciones[index++] = {xtype: 'button',id:'btnhiddenA3',width:largo_boton,disabled:true};
	}
	return arr_opciones;


	/*return [
			{text: 'Consulta CPs',iconCls: 'search_blue',
				width:largo_boton,id:'consultacps_item'+id_panel,
				handler:openOpcionBtn
			},
			{text: 'Contrase�a',iconCls: 'opcion_password',
				width:largo_boton,id:'cambiar-password-win_item'+id_panel,
				handler:openOpcionBtn,
			},
			{text: 'Salir',iconCls: 'opcion_salir',
				width:largo_boton,id:'cerrarsesion_item'+id_panel,
				tooltip : 'Cerrar Sesión',
				handler:openOpcionBtn
			}
		];*/
}

            
				