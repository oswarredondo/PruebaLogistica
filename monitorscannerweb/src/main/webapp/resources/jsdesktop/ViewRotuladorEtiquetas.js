Ext.define('MyDesktop.ViewRotuladorEtiquetas', {
    extend: 'Ext.ux.desktop.Module',

    requires: [
        'Ext.tab.Panel'
    ],

    id:'rotulador-etiquetas-win',

    init : function(){
        this.launcher = {
            text: 'Configuración de Etiquetas',
            iconCls:'opcion_consultaetiqueta'
        }
    },
	grid_clientes:undefined,
	grid_contactos:undefined,
    grid_convenios:undefined,
	grid_localizacion:undefined,
	//grid_usuarios:undefined,
	myScope:undefined,
	grid_etiquetas:undefined,
	autoScroll:true,
	grid_etiquetas:undefined,
	
	createWindow : function(){
	
      
		this.myScope=this;
		
		this.uuid =  generateUUID();

		this.myscope=this;
		var myscope = this;
		myscope.grid_etiquetas= new MyDesktop.grid.GridReenvioUnigisEtiquetas({id:'id_cuentas_cliente_admin', 
			identidad:this.identidad, idorganizacion:this.idorganizcion,layout:'fit'})
	
		
	    var desktop = this.app.getDesktop();
	    
	    var win = desktop.getWindow(this.id);
	  
		if(!win){


			win = desktop.createWindow({
				
                id: myscope.id,
                title: 'Reenvio de datos a Unigis',
                iconCls: 'upload32x32',
                border:false,
                constrainHeader:false,
                closable: true,
                closeAction: 'hide',
                width: 1200,
            	maximized :true,
				maximizable:false,
				layout: 'fit',
				
				items:[
				       this.grid_etiquetas
				]

			});	
        }
		
      
        
        return win;
    }
});
