Ext.define('MyDesktop.view.FormSendMail', { extend: 'Ext.form.Panel',    xtype: 'send-mail-form',    frame: false,    width: 400,    layout: {        type: 'vbox',        align: 'stretch'  // Child items are stretched to full width    },    border: false,    bodyPadding: 10,    fieldDefaults: {        labelWidth: 55,        anchor: '100%'    },    plain: true,    border: 0,    bodyPadding: 5,	//myscope:undefined,	operacion:undefined,	idconvenio:undefined,	idcotizacion:undefined,	idcliente:undefined,	url_sender:undefined,	subject:undefined,	sender:undefined,	main_win:undefined,	initComponent: function () {				var myscope=this;			if (this.sender==undefined){this.sender='';}		if (this.subject==undefined){this.subject='';}		if (this.idconvenio==undefined){this.idconvenio='';}		if (this.idcotizacion==undefined){this.idcotizacion='';}		if (this.idcliente==undefined){this.idcliente='';}		this.items= [		             {xtype:'hidden', name:'idconvenio', value:this.idconvenio},		             {xtype:'hidden', name:'idcotizacion', value:this.idcotizacion},		             {xtype:'hidden', name:'idcliente', value:this.idcliente},		             { 		                 xtype: 'myEmailTextField',		                 fieldLabel: 'Para:',		                 name: 'para', 		             	height: 40,		                 allowBlanks:false,		                 value:this.sender		             },		             { 		                 xtype: 'myEmailTextField',		                 fieldLabel: 'CC',		                 name: 'concopia',		                 height: 40,		                 allowBlanks:false,		                 value:this.sender		             },		             {		                 xtype: 'textfield',		                 fieldLabel: 'Tema',		                 allowBlanks:false,		                 name: 'subject',		                 value:this.subject		             }, {		                 xtype: 'textarea',		                 fieldLabel: 'Mensaje',		                 hideLabel: true,		                 allowBlanks:false,		                 name: 'body',		                 style: 'margin:0', // Remove default margin		                 flex: 1  // Take up all *remaining* vertical space		             }		];		this.buttons= [				{ hidden: this.showReadOnly, text: 'Salvar', iconCls:'activo',handler:function() {						var form = this.up('form').getForm();						if (form.isValid()) {							if (myscope.url_sender==undefined){								alertMsg('Error','No se ha defindo la accion a seguir');								return;							}														var myMask = new Ext.LoadMask(Ext.getBody(), {msg:"Agregando información espere..."});							myMask.show();							//Envia el correo							form.submit({								clientValidation: true,								url: myscope.url_sender,								success: function(form, action) {									myMask.hide( );									myMask.disable();									alertMsg('Confirmaci�n',action.result.message);												},								failure: function(form, action) {									myMask.hide( );									myMask.disable();																		alertMsg('Error' , action.result.message);								}							});																			}else{							alertMsg('Verifique' ,'Complete los campos requeridos.');						}					}			}//,		];			this.callParent();			}});