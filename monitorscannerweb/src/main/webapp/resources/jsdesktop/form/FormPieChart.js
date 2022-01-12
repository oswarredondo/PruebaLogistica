
Ext.define('MyDesktop.form.FormPieChart', {
    extend: 'Ext.Panel',
    xtype: 'basic-pie',
    requires: [
               'Ext.chart.*',
               'Ext.data.JsonStore',
               'Ext.layout.container.Fit', 
               'Ext.window.MessageBox'
           ],

    grid:undefined,
    url:undefined,
    titulo:'',
    width: 700,
    tipoconsulta:undefined,
    initComponent: function() {
    	var me = this;

    	
    	
    	this.myDataStore = Ext.create('MyDesktop.store.StorePieChart',
				{baseParams:{tipoconsulta:this.tipoconsulta}});
			this.myDataStore.getProxy().setExtraParam("tipoconsulta", this.tipoconsulta);
			

        me.items = [{
            xtype: 'chart',
            width: '100%',
            height: 350,
            padding: '1 0 0 0',
           // style: 'background: #fff',
            animate: true,
            shadow: false,
            store: this.myDataStore,
            insetPadding: 10,
            legend: {
                field: 'registro',
                //position: 'bottom',
                position: 'right',
                boxStrokeWidth: 0,
                labelFont: '12px Helvetica'
            },
            items: [{
                type  : 'text',
                text  : me.titulo,
                font  : '22px Helvetica',
                width : 100,
                height: 30,
                x : 40, //the sprite x position
                y : 12  //the sprite y position
            }/*, {
                type: 'text',
                text: 'Data: IDC Predictions - 2017',
                font: '10px Helvetica',
                x: 12,
                y: 380
            }, {
                type: 'text',
                text: 'Source: Internet',
                font: '10px Helvetica',
                x: 12,
                y: 390
            }*/],
            series: [{
                type: 'pie',
                angleField: 'data1',
                
                donut: 20,
                label: {
                    field: 'registro',
                    //display: 'outside',
                    calloutLine: true,
                    display: 'rotate',
                    contrast: true,
                    font: '12px Arial'
                },
                showInLegend: true,
                highlight: {
                   // fill: '#000',
                    'stroke-width': 2,
                    stroke: '#ccc'
                },
               
                tips: {
                    trackMouse: true,
                   // style: 'background: #FFF',
                    height: 20,
                    width : 250,
                    renderer: function(storeItem, item) {
                        this.setTitle(storeItem.get('registro') + ': ' + storeItem.get('data1') + '');
                    }
                }
            }]
        }];

        this.callParent();
    },
    recargar:function(){
    	 this.myDataStore.reload();
    }
});