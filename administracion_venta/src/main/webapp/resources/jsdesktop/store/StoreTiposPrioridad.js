
Ext.define('MyDesktop.store.StoreTiposPrioridad', {
    extend: 'Ext.data.Store',
	fields: ['idtipo'],
	data : [
			{"idtipo":"URGENTE"},
			{"idtipo":"ALTO"},
			{"idtipo":"MEDIA"},
			{"idtipo":"BAJO"}
		]
});