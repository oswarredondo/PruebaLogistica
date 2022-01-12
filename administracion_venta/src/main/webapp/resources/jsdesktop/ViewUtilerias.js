/*!
 * Administracicion de tarifas
 */

Ext.define('MyDesktop.ViewTarifas', {
    extend: 'Ext.ux.desktop.Module',

    requires: [
        'Ext.tab.Panel'
    ],

    id:'utilerias-win',

    init : function(){
        this.launcher = {
            text: 'Utilerias',
            iconCls:'utilerias_win'
        }
    },
	grid_tarifas:undefined,
	grid_rangos_volumen:undefined,
	myScope:undefined,
	
	createWindow : function(){
	
        var desktop = this.app.getDesktop();
        var win = desktop.getWindow(this.id);
		
        var tab = Ext.widget('tabpanel', {
            xtype: 'plain-tabs',
            width: 400,
            height: 300,
            plain: true,
            defaults: {
                bodyPadding: 10,
                autoScroll: true
            },
            items: [{
                title: 'Active Tab',
                html: KitchenSink.DummyText.longText
            }, {
                title: 'Inactive Tab',
                html: KitchenSink.DummyText.extraLongText
            }, {
                title: 'Disabled Tab',
                disabled: true
            }]
        });
        return win;
    },
	agregar:function(){
		this.grid_tarifas.agregar();
	},
	modificar:function(){
		this.grid_tarifas.modificar();
	},
	eliminar:function(){
		this.grid_tarifas.eliminar();
	},
	showDetails:function(){
		this.grid_tarifas.showDetails();
	}
});
