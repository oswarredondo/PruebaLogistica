/*!
 * Administracicion de tarifas
 */

Ext.define('MyDesktop.ViewTemplateEtiqueta', {
    extend: 'Ext.ux.desktop.Module',

    requires: [
        'Ext.tab.Panel'
    ],

    id:'template-etiqueta-win',

    init : function(){
        this.launcher = {
            text: 'Wizard Template',
            iconCls:'template_blue'
        }
    },
	grid_operacion:undefined,
	grid_detalle:undefined,
	myScope:undefined,
	
	createWindow : function(){
	
        var desktop = this.app.getDesktop();
        var win = desktop.getWindow(this.id);
		this.myScope= this;
		var scope=this;
		
		
		this.grid_detalle = new MyDesktop.grid.GridTemplateEtiquetasDetalle({ layout: 'fit'}); 
		this.grid_operacion = new MyDesktop.grid.GridTemplateEtiquetas({ layout: 'fit',main_detalle:this.grid_detalle}); 
		
		//Carga los datos del idtemplate
		this.grid_operacion.getSelectionModel().on('selectionchange', function(sm, selectedRecord) {
			
			scope.actualizaDatosDertalle(scope.grid_operacion, scope.grid_detalle);

		},this);
		 
		this.grid_operacion.getSelectionModel().on('selected', function(sm, selectedRecord) {
			scope.actualizaDatosDertalle(scope.grid_operacion, scope.grid_detalle);

			
		},this);
		
		var main_previo = new Ext.Panel({
			region:'center',		
			layout:'fit',
			border:false,
			buttons:[
			      {text:'Vista Previa', iconCls:'view_blue', handler:function(){
			    	
			    	  scope.vistaPrevia(main_previo,scope.grid_operacion);
			    	  
			      	} 
			      }
			      ],
			title: 'Visor/Vista Previa',
            collapsible: false,
            margins: '5 0 0 0'
		});
		
		//var formpropiedades = new MyDesktop.form.FormPropiedadesTemplateLineaEtiq({});
		if(!win){
				win = desktop.createWindow({
				
                id: this.id,
                title:'Template Etiquetas',
                iconCls: 'campos_blue',
                //animCollapse:false,
                border:false,
                constrainHeader:false,
                closable: true,
                closeAction: 'hide',
                width: 600,
                minWidth: 350,
                height: 500,
                layout: 'border',
                bodyBorder: false,
            	maximized :true,
				maximizable:false,
                defaults: {
                    collapsible: true,
                    split: true//,
                    //bodyPadding: 15
                },
                items: [{
                    title: 'Detalle Template',
                    region: 'south',
                    layout: 'fit',
                    height: 250,
                    minHeight: 250,
                    layout: 'fit',
                    maxHeight: 450,
                    items:[this.grid_detalle]
                   
                },{
                    title:'Templates',
                    region:'west',
                    floatable: false,
                    margins: '5 0 0 0',
                    width: 580,
                    layout: 'fit',
                    minWidth: 580,
                    maxWidth: 580,
                    items:[this.grid_operacion]
                },
               /* {
                    title:  'Propiedades' ,
                    region:'east',
                    floatable: false,
                    margins: '5 0 0 0',
                    width: 350,
                    minWidth: 350,
                    maxWidth: 350,
                    layout: 'fit',
                    items:[formpropiedades]
                },*/
                /*{
                    title: 'Visor/Vista Previa',
                    collapsible: false,
                    region: 'center',
                    margins: '5 0 0 0'
                }*/
                main_previo]
				
            });
        }
        return win;
    },
    
    actualizaDatosDertalle:function(grid, grid_detalle){
    	var rows =  grid.getSelectionModel().getSelection();
    	if(rows.length <=0){
			return;
		}
    	
    	this.grid_detalle.setIdTemplate(rows[0].get('idregistro'),rows[0].get('idtemplate'));
		this.grid_detalle.buscar(rows[0].get('idtemplate'), rows[0].get('idregistro'));
    
    },
		
		
		
	vistaPrevia:function(main_previo,grid){
		
		var rows =  grid.getSelectionModel().getSelection();
	
		if(rows.length <=0){
			mensajeAlert("Seleccione los registros que desea visualizar");
			return;
		}
		var selectedRecord = rows[0];
		//Limpia el frame
		var el = Ext.get(Ext.DomQuery.select('.x-panel-body',main_previo.el.dom)[0]);
		while (el.dom.childNodes[0]){			
			el.dom.removeChild(el.dom.childNodes[0]);	
		}
		el.createChild({
			tag:'iframe', 
			src:'./template_etiquetas/viewPDFArchivo?idregistro='+selectedRecord.get('idregistro'),
			style:'border:none;width:100%;height:100%;'
		});
	}
});
