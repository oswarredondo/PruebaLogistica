/*!
 * Ext JS Library 4.0
 * Copyright(c) 2006-2011 Sencha Inc.
 * licensing@sencha.com
 * http://www.sencha.com/license
 */

Ext.define('MyDesktop.ViewConsultaDocumentosEtiquetas', {
    extend: 'Ext.ux.desktop.Module',
    requires: [
        'Ext.tab.Panel'
    ],
    id:'consulta-etiquetas-win',
    init : function(){
        this.launcher = {
            text: 'Consulta de Etiquetas',
            iconCls:'opcion_consultaetiqueta'
        }
    },
    grid:undefined,
	myScope:undefined,
	organizacioncombo:undefined,
	entidadcombo:undefined,
	grid_perfiles:undefined,
	createWindow : function(parametros){
	
        var desktop = this.app.getDesktop();
        var win = desktop.getWindow(this.id);
		this.myScope=this;
		var scope= this;
		

		this.grid= new MyDesktop.grid.GridConsultaEtiquetas({id:'id_cuentas_cliente_admin', 
			identidad:this.identidad, idorganizacion:this.idorganizcion,layout:'fit'});
		 if (parametros!=undefined){
   		  	scope.realizaBusqueda(parametros.patron,parametros.idbusqueda);
   	  	}else{
   	  		scope.grid.getStore().removeAll( true );
   	  		scope.grid.getStore().reload(
					{
						params:{
							tipobusqueda:999999, 
							tipoDocumento:'ETIQU',
							start:0
							
						},
						callback:function(r,options,success){
						 }	  
					});
   	  	}
		 
		
		
			
        if(!win){

        	  win = desktop.createWindow({
        		id: this.id,
                title:'Consulta Etiquetas',
                iconCls: 'opcion_consultaetiqueta',
                closable: true,
                closeAction: 'hide',
                width: 1200,
                height:500,
                border:true,
                layout:'fit',
                defaults: {
                    labelWidth: 100
                },
                minWidth: 600,
				maximizable:true,
                layout: {
                    type: 'fit',
                    padding: 5
                },
  				items:[this.grid],
  				listeners:{
  					afterrender:function( obj, eOpts ){
  						scope.grid.getStore().removeAll( true );
  						scope.grid.getStore().reload(
	  								{
	  									params:{
	  										tipobusqueda:999999, 
	  										tipoDocumento:'ETIQU',
	  										start:0
	  										
	  									},
	  									callback:function(r,options,success){
	  									 }	  
	  								});
  					}
  					
  				}
  				
            });
        }
       
       
        win.show();  
        
       
        
        return win;
    },
    realizaBusqueda:function(patron,idbusqueda){
    	this.grid.busquedaCorta(patron,idbusqueda);
    	this.grid.busquedaCorta(patron,idbusqueda);
    	this.grid.busquedaCorta(patron,idbusqueda);
    }
});
