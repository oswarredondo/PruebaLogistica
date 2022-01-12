/*!
 * Admninistracion de movimientos de caja
 */

Ext.define('MyDesktop.ViewMovimientosCaja', {
	extend: 'Ext.ux.desktop.Module',

	requires: [
		'Ext.tab.Panel'
	],

	id: 'movimientos-caja-win',

	init: function() {
		this.launcher = {
			text: 'Movimientos de Caja',
			iconCls: 'catalogos_blue'
		}
	},
	grid_operacion: undefined,
	myScope: undefined,

	createWindow: function() {

		var desktop = this.app.getDesktop();
		var win = desktop.getWindow(this.id);
		this.myScope = this;

		this.grid_operacion = new MyDesktop.grid.GridMovimientosCaja({ id: this.id + 'grid', isConsulta: false });
		this.grid_operacion.loadInfo();
		if (!win) {
			win = desktop.createWindow({

				id: this.id,
				title: 'Movimientos Caja',
				iconCls: 'catalogos_blue',
				//animCollapse:false,
				border: false,
				constrainHeader: false,
				closable: true,
				closeAction: 'hide',
				width: 600,
				minWidth: 350,
				height: 500,
				layout: 'fit',
				items: [
					this.grid_operacion
				]

			});
		}
		return win;
	}
});
