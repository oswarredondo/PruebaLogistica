Ext.define('MyDesktop.form.PanelGraficoResumenPlazas', {
	extend: 'Ext.panel.Panel',
    xtype: 'panelGraficoResumenPlazas-form',
    requires: [
               'Ext.chart.*',
               'Ext.layout.container.Fit',
               'Ext.window.MessageBox',
               'Ext.toolbar.TextItem',
               'Ext.menu.Menu'
           ],

	store: undefined,
	chart:undefined,
	initComponent: function () {
		var myscope = this;
		this.store = Ext.create('Ext.data.JsonStore', {
		        fields: ['name', 'data1', 'data2', 'data3', 'data4', 'data5', 'data6', 'data7', 'data9', 'data9'],
		        data: generateData()
		    });
		  
		  var donut = false;
		  this.chart = Ext.create('Ext.chart.Chart', {
	            xtype: 'chart',
	            animate: true,
	            store: this.store,
	            shadow: true,
	            legend: {
	                position: 'right'
	            },
	            insetPadding: 60,
	            //theme: 'Base:gradients',
	            series: [{
	                type: 'pie',
	                field: 'data1',
	                showInLegend: true,
	                donut: donut,
	                tips: {
	                  trackMouse: true,
	                  width: 140,
	                  height: 28,
	                  renderer: function(storeItem, item) {
	                    //calculate percentage.
	                    var total = 0;
	                    myscope.store.each(function(rec) {
	                        total += rec.get('data1');
	                    });
	                    this.setTitle(storeItem.get('name') + ': ' + Math.round(storeItem.get('data1') / total * 100) + '%');
	                  }
	                },
	                highlight: {
	                  segment: {
	                    margin: 20
	                  }
	                },
	                label: {
	                    field: 'name',
	                    display: 'rotate',
	                    contrast: true,
	                    font: '18px Arial'
	                }
	            }]
	        });
			
			
		this.items= [
		             this.chart
		];
		

		  //Inicia el grafico de datos
		//this.store.loadData(generateData(6, 20));
		 
		   
		myscope.actualizar();
		
	  
		this.callParent();
		
	},
	
	actualizar:function(){
		this.store.loadData(generateData(6, 20));
	},
	showPanel:function(){
		this.alignTo(
	                document.body,
	                't-t',
	                [
	                    //left, top
	                   200,90
	                    /*(Ext.getScrollbarSize().width + 4) * (Ext.rootHierarchyState.rtl ? 1 : -1),
	                    -(document.body.scrollTop || document.documentElement.scrollTop)*/
	                ]
	            );
		
		  this.show();
	}
	
	
});