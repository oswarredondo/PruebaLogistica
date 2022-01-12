 /**
 * Grid para la consulta de historia o mivimientos
 * de un pedido, guia, solicitud, etc
 */
Ext.define('MyDesktop.grid.GridOficinasReceptoras', {
   // extend: 'Ext.ux.LiveSearchGridPanel',
	extend: 'Ext.grid.Panel',
    requires: [
               'Ext.grid.column.Action',
               'Ext.grid.plugin.CellEditing',
               'Ext.form.field.Text',
               'Ext.toolbar.TextItem',
               'Ext.ux.grid.FiltersFeature'
           ],
           stateful: true,
           collapsible: false,
           multiSelect: true,
           stateId: 'stateGridOficinasReceptoras',

           viewConfig: {
               stripeRows: true,
               enableTextSelection: true
           },
	idfolio:'',
	url:'',
	fields:undefined,
	calle_field: '',
	numero_field: '',
	colonia_field: '',
	municipio_field: '',
	cp_field: '',
	estado_field: '',
	telefono_field: '',
	ciudad_field:'',
	idoficina_field:'',
	scope_win:undefined,
	constructor: function(config) {
		 //Configura las propiedades
		 this.callParent(arguments);
	     this.initConfig(config);
	     return this;
	},
	initComponent: function(config) {

		  // configure whether filter query is encoded or not (initially)
	    var encode = false;
	    
	    // configure whether filtering is performed locally or remotely (initially)
	    var local = true;
	    
		var sm = Ext.create('Ext.selection.CheckboxModel',{mode : 'SINGLE'});
		this.selModel= sm;
		this.loadMask=true;
		
		var filters = {
		        ftype: 'filters',
		        // encode and local configuration options defined previously for easier reuse
		        encode: encode, // json encode the filter query
		        local: local,   // defaults to false (remote filtering)

		        // Filters are most naturally placed in the column definition, but can also be
		        // added here.
		        filters: [{
		            type: 'boolean',
		            dataIndex: 'visible'
		        }]
		    };
		 this.features= [filters];
		this.store = Ext.create('MyDesktop.store.StoreOficinasReceptorasPDVs',{});
        this.columns = [
			{ header   : 'Id',  width    : 70, sortable : true, hidden:true, dataIndex: 'idoficina' ,menuDisabled: false  },
			
			{header   : 'Encargado',  width    : 180, sortable : true, hidden:true, dataIndex: 'encargado' ,menuDisabled: false  },
			{header   : 'Oficina',  width    : 180, sortable : true, hidden:false, dataIndex: 'nombre' ,menuDisabled: false  },

			{ header   : 'Dirección',  width    : 200, sortable : true, hidden:false, dataIndex: 'calle' ,menuDisabled: false,
				renderer:this.renderDireccion, filter: {type: 'string'}
			},
			//{ header   : 'Numero',  width    : 80, sortable : true, hidden:false, dataIndex: 'numero' ,menuDisabled: false  },
			{ header   : 'C.P',  width    : 80, sortable : true, hidden:false, dataIndex: 'cp' ,menuDisabled: false,
				filter: {type: 'string'}
			},
			{header   : 'Colonia',  width    : 150, sortable : true, hidden:false, dataIndex: 'colonia' ,menuDisabled: false,
				 filter: {type: 'string'}
			},
			{header   : 'Municipio',  width    : 150, sortable : true, hidden:false, dataIndex: 'municipio' ,menuDisabled: false,
				filter: {type: 'string'}
			},
			{header   : 'Estado',  width    : 150, sortable : true, hidden:false, dataIndex: 'estado' ,menuDisabled: false,
				filter: {type: 'string'},
			},
				 
				 { header   : 'Horario',  width    : 200, sortable : true, hidden:false, dataIndex: 'horarios' ,menuDisabled: false,
				filter: {type: 'string'}
				},
				{ header   : 'Telefono',  width    : 200, sortable : true, hidden:false, dataIndex: 'telefono' ,menuDisabled: false  }	 

		];
        this.listeners={
				itemclick:this.selectRegistro
			};
        this.callParent(arguments);  

     
        
		//Carga los datos despues de haber definido el grdi
        /*this.on('afterlayout', this.loadStore, this, {
            delay: 1,
            single: true
        });*/
	},
	getRowsSelected:function(){
		return this.getView().getSelectionModel().getSelection();
	},
	renderDireccion:function (value, metaData, record, rowIndex, colIndex,
			store) {
		return record.get('calle') + " " + record.get('numero' );
		
	},
	selectRegistro:function (dv, record, item, rowIndex, e){
		
		
		//TODO: Verificar que actualice info
		var fields = this.form.getFields( ) ;
		
        var row = this.getStore().getAt(rowIndex);
		if (this.cp_field!=undefined){
			//Ext.getCmp(this.cp_field).setValue(row.get('cp'));
			setValueFormField(this.cp_field,fields,row.get('cp'));
		}
		if (this.calle_field!=undefined){
			//Ext.getCmp(this.ciudad_field).setValue(row.get('calle'));
			setValueFormField(this.calle_field,fields,row.get('calle'));
		}
	
		if (this.colonia_field!=undefined){
			//Ext.getCmp(this.colonia_field).setValue(row.get('colonia'));
			setValueFormField(this.colonia_field,fields,row.get('colonia'));
		}
	
		if (this.municipio_field!=undefined){
			//Ext.getCmp(this.municipio_field).setValue(row.get('municipio'));
			setValueFormField(this.municipio_field,fields,row.get('municipio'));
		}

		if (this.estado_field!=undefined){
			//Ext.getCmp(this.estado_field).setValue(row.get('estado'));
			setValueFormField(this.estado_field,fields,row.get('estado'));
		}
		
		if (this.ciudad_field!=undefined){
			//Ext.getCmp(this.ciudad_field).setValue(row.get('ciudad'));
			setValueFormField(this.ciudad_field,fields,row.get('ciudad'));
		}
		if (this.telefono_field!=undefined){
			//Ext.getCmp(this.telefono_field).setValue(row.get('ciudad'));
			setValueFormField(this.telefono_field,fields,row.get('ciudad'));
		}
		if (this.numero_field!=undefined){
			//Ext.getCmp(this.numero_field).setValue(row.get('numero'));
			setValueFormField(this.numero_field,fields,row.get('numero'));
		}
		if (this.idoficina_field!=undefined){
			//Ext.getCmp(this.idoficina_field).setValue(row.get('idoficina'));
			setValueFormField(this.idoficina_field,fields,row.get('idoficina'));
		}
		
		
		if (this.scope_win!=undefined){
			this.scope_win.close();
		}
    },
    setScopeWin:function(w){
    	this.scope_win=  w;
    }

});

