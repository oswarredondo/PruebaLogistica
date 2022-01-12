/**
* Grid para la consulta de historia o mivimientos
* de un pedido, guia, solicitud, etc
*/
Ext.define('MyDesktop.grid.GridCarteraDirecciones', {
	extend: 'Ext.grid.Panel',
	requires: [
		'Ext.grid.column.Action',
		'Ext.grid.plugin.CellEditing',
		'Ext.form.field.Text',
		'Ext.toolbar.TextItem'
	],
	stateful: true,
	collapsible: false,
	multiSelect: true,
	stateId: 'stateGridCarteraDirecciones',

	viewConfig: {
		stripeRows: true,
		enableTextSelection: true
	},
	idfolio: '',
	url: '',
	isConsulta: true,
	mainwindow: undefined,
	fields: undefined,
	/* CAMBIO UNIGIS IDREMDES */
	idremdes_field: '',
	razonsocial_field: '',
	numeroint_field: '',
	atencion_field: '',
	numeroext_field: '',
	cp_field: '',
	colonia_field: '',
	municipio_field: '',
	estado_field: '',
	telefono_field: '',
	numcelular_field: '',
	correoe_field: '',
	ciudad_field: '',
	calle_field: '',
	rfc_field: '',

	scope_win: undefined,
	constructor: function(config) {
		//Configura las propiedades
		this.callParent(arguments);
		this.initConfig(config);
		return this;
	},

	tipo_str: undefined,
	patron_busqueda: undefined,
	tipo: undefined,
	initComponent: function(config) {
		
		this.loadMask = true;
		this.store = Ext.create('MyDesktop.store.StoreCarteraDirecciones', {
			baseParams: {
				tipo_str: this.tipo_str, patron_busqueda: this.patron_busqueda, tipo: this.tipo
			}

		});

		this.selType = 'checkboxmodel';
		var sm = Ext.create('Ext.selection.CheckboxModel', { mode: 'SINGLE' });
		this.selModel = sm;

		//this.store = Ext.create('com.pickin.stCPsPrueba',{baseParams:{cp:this.cp,colonia:this.colonia,municipio:this.municipio}});
		this.store.getProxy().setExtraParam("tipo_str", this.tipo_str);
		this.store.getProxy().setExtraParam("patron_busqueda", this.patron_busqueda);
		this.store.getProxy().setExtraParam("tipo", this.tipo);

		this.columns = [
			/* CAMBIO UNIGIS IDREMDES */
			{ header: 'idremdes', width: 150, sortable: true, hidden: true, dataIndex: 'idRmDes' },
			{ header: 'Razon Social', width: 150, sortable: true, hidden: false, dataIndex: 'razonSocial' },
			{ header: 'Atención', width: 150, sortable: true, hidden: false, dataIndex: 'atencion' },
			{ header: 'Calle', width: 150, sortable: true, hidden: false, dataIndex: 'calle' },
			{ header: '#Interior', width: 100, sortable: true, hidden: false, dataIndex: 'numinterior' },
			{ header: '#Exterior', width: 100, sortable: true, hidden: false, dataIndex: 'numexterior' },
			{ header: 'Colonia', width: 150, sortable: true, hidden: false, dataIndex: 'colonia' },
			{ header: 'Ciudad', width: 150, sortable: true, hidden: false, dataIndex: 'ciudad' },
			{ header: 'Municipio', width: 150, sortable: true, hidden: false, dataIndex: 'municipio' },
			{ header: 'Estado', width: 150, sortable: true, hidden: false, dataIndex: 'estado' },
			{ header: 'C.P', width: 70, sortable: true, hidden: false, dataIndex: 'cp' },
			{ header: 'Telefono', width: 150, sortable: true, hidden: false, dataIndex: 'telefono' },
			{ header: 'Celular', width: 150, sortable: true, hidden: false, dataIndex: 'numcelular' },
			{ header: 'Correo', width: 150, sortable: true, hidden: false, dataIndex: 'correoe' }
		];

		if (!this.isConsulta) {
			
			this.bbar = [
				{ text: 'Agregar', iconCls: 'agregar', handler: this.agregar, scope: this },
				{ xtype: 'tbfill' },
				{ xtype: 'tbseparator' },
				{ text: 'Modificar', iconCls: 'editar', handler: this.modificar, scope: this},
				{ xtype: 'tbseparator' },
				{ text: 'Borrar', iconCls: 'borrar', handler: this.eliminar, scope: this}
			];
			
		}

		this.listeners = {
			//itemclick: this.selectRegistro
		};
		this.callParent(arguments);

		//Carga los datos despues de haber definido el grdi
		this.on('afterlayout', this.loadStore, this, {
			delay: 1,
			single: true
		});
	},
	agregar: function() {

		//Crea una forma de clientes para agregar los datos
		var forma_agregar = Ext.create('MyDesktop.form.FormCarteraDirecciones',
				{id:'agregar_cliente',operacion:'insert', main_grid:this}); 
		
		var main_window = Ext.create('widget.window', {
			title: "Agregar Datos Dirección",
			iconCls: 'agregar',
			width: 400,
			height: 500,
			modal:true,
			plain: true,
			headerPosition: 'right',
			layout: 'fit',
			items: forma_agregar
			
		});
		main_window.show();
		forma_agregar.setMainWindow(main_window);
	},
	modificar: function() {
		
		var rows = this.getSelectionModel().getSelection();
		
		if (rows.length <= 0) {
			mensajeAlert("Debe de Seleccionar solo un registro para modificar");
			return;
		}
		
		if (rows.length > 1) {
			mensajeAlert("Seleccione solamente un registro a modificar");
			return;
		}

		//Crea una forma de clientes para agregar los datos
		var forma_modificar = Ext.create('MyDesktop.form.FormCarteraDirecciones', {
			operacion: 'update', main_grid: this
		});
		forma_modificar.updateCampos(rows[0]);
		setValorFormaField('_csrf', forma_modificar, vt);
		var main_window = Ext.create('widget.window', {

			title: "Modificar Datos Direccion",
			width: 400,
			iconCls: 'editar',
			height: 530,
			modal: true,
			plain: true,
			headerPosition: 'right',
			layout: 'fit',
			items: forma_modificar

		});
		forma_modificar.setMainWindow(main_window);
		//forma_modificar.setIdCliente(rows[0].get('idAutonumerico'));
		main_window.show();

	},


	eliminar: function() {

		var rows =  this.getView().getSelectionModel().getSelection();
     	if(rows.length <=0){
     		mensajeAlert("Debe de Seleccionar solo un registro para eliminar");
     		return;
     	}
		if(rows.length >1){
     		mensajeAlert("Seleccione solamente un registro a eliminar");
     		return;
     	}
		var myscope = this;
		 Ext.MessageBox.confirm('Confirmacion', '¿Desea borrar los registros seleccionados?', function(id, text){
	       		if ( (id === 'yes')  || (id === 'si') || (id === 'y' ) || (id === 's' ) ){ 
	       			if(rows.length === 0){  //step 3
	       				return ;
	       			}
	       			//deleteSyncStore(myscope,myscope.getView().getStore(),rows );
	       			var conn = new Ext.data.Connection();
				   	conn.request({
				   				scope:myscope, 
									method:'POST',
									defaultHeaders:{'_csrf_header':hv,"_csrf":vt },
									params:{idregistro: rows[0].get("idregistro"), "_csrf":vt},
								url: './rotular_etiquetas/carteraremdes/delete' ,
								success: function(response, opts) {
									myscope.reloadInfo();
								},
								failure: function(response, opts) {
					       			if (response.responseText!=undefined){
					       				var obj = Ext.decode(response.responseText);
					       				if (obj.message!=undefined){
					       					mensajeAlert(obj.message);
						       			}
						       		}
				       			
								}
				   		});  
	       			
	       			
	       		}
	       	 },myscope);
	       	 
	},

	loadInfo: function() {
		this.getView().getStore().load();

	},
	reloadInfo: function() {
		this.getView().getStore().reload();

	},
	getRowsSelected: function() {
		return this.getView().getSelectionModel().getSelection();
	},

	selectRegistro: function() {

		//TODO: Verificar que actualice info
		var fields = this.form.getFields();

		//var row = this.getStore().getAt(rowIndex);this.getView().getSelectionModel().getSelection()
		
		var row = this.getView().getSelectionModel().getSelection();
		
		row = row[0];

		/* CAMBIO UNIGIS IDREMDES */
		if (this.idremdes_field != undefined) {
			setValueFormField(this.idremdes_field, fields, row.get('idRmDes'));
		}
		if (this.razonsocial_field != undefined) {
			setValueFormField(this.razonsocial_field, fields, row.get('razonSocial'));
		}
		if (this.numeroint_field != undefined) {
			setValueFormField(this.numeroint_field, fields, row.get('numinterior'));
		}
		if (this.atencion_field != undefined) {
			setValueFormField(this.atencion_field, fields, row.get('atencion'));
		}

		if (this.numeroext_field != undefined) {
			setValueFormField(this.numeroext_field, fields, row.get('numexterior'));
		}

		if (this.cp_field != undefined) {
			setValueFormField(this.cp_field, fields, row.get('cp'));
		}

		if (this.colonia_field != undefined) {
			setValueFormField(this.colonia_field, fields, row.get('colonia'));
		}
		if (this.municipio_field != undefined) {
			setValueFormField(this.municipio_field, fields, row.get('municipio'));
		}

		if (this.estado_field != undefined) {
			setValueFormField(this.estado_field, fields, row.get('estado'));
		}

		if (this.telefono_field != undefined) {
			setValueFormField(this.telefono_field, fields, row.get('telefono'));
		}

		if (this.numcelular_field != undefined) {
			setValueFormField(this.numcelular_field, fields, row.get('numcelular'));
		}


		if (this.correoe_field != undefined) {
			setValueFormField(this.correoe_field, fields, row.get('correoe'));
		}

		if (this.ciudad_field != undefined) {
			setValueFormField(this.ciudad_field, fields, row.get('ciudad'));
		}

		if (this.calle_field != undefined) {
			setValueFormField(this.calle_field, fields, row.get('calle'));
		}

		if (this.rfc_field != undefined) {
			setValueFormField(this.rfc_field, fields, row.get('rfc'));
		}



		if (this.mainwindow != undefined) {
			this.mainwindow.close();
		}
	},

	setScopeWin: function(win) {
		this.mainwindow = win;
	},

	filtraInfo:function(){
		
		this.getView().getStore().load();

	}

});

