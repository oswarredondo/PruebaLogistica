/*!
 * Ext JS Library 4.0
 * Copyright(c) 2006-2011 Sencha Inc.
 * licensing@sencha.com
 * http://www.sencha.com/license
 */

Ext.define('MyDesktop.Settings', {
    extend: 'Ext.window.Window',

    uses: [
        'Ext.tree.Panel',
        'Ext.tree.View',
        'Ext.form.field.Checkbox',
        'Ext.layout.container.Anchor',
        'Ext.layout.container.Border',

        'Ext.ux.desktop.Wallpaper',

        'MyDesktop.WallpaperModel'
    ],

    layout: 'anchor',
    title: 'Configurar Wallpaper',
    modal: true,
    width: 800,
    height: 480,
    border: false,

    initComponent: function () {
        var me = this;
        this.title = 'Configurar Wallpaper. Wallpaper configurado:' + me.getTextOfWallpaper(wallpaper_default_windows);
        me.selected = me.desktop.getWallpaper();
        me.stretch = me.desktop.wallpaper.stretch;

        me.preview = Ext.create('widget.wallpaper');
        me.preview.setWallpaper(me.selected);
        me.tree = me.createTree();

        me.buttons = [
            { text: 'Ajusta', handler: me.onOK, scope: me },
            { text: 'Cancelar', handler: me.close, scope: me }
        ];

        me.items = [
            {
                anchor: '0 -30',
                border: false,
                layout: 'border',
                items: [
                    me.tree,
                    {
                        xtype: 'panel',
                        title: 'Previo',
                        region: 'center',
                        layout: 'fit',
                        items: [ me.preview ]
                    }
                ]
            },
            {
                xtype: 'checkbox',
                boxLabel: 'Stretch to fit',
                checked: me.stretch,
                readOnly:true,
                listeners: {
                    change: function (comp) {
                        me.stretch = comp.checked;
                    }
                }
            }
        ];

        me.callParent();
    },

    createTree : function() {
        var me = this;

        function child (img) {
            return { img: img, text: me.getTextOfWallpaper(img), iconCls: '', leaf: true };
        }

		//TODO:Obtener los datos de wallpapers de la base de datos
        var tree = new Ext.tree.Panel({
            title: 'Desktop Background',
            rootVisible: false,
            lines: false,
            autoScroll: true,
            width: 300,
            region: 'west',
            split: true,
            minWidth: 100,
            listeners: {
                afterrender: { fn: this.setInitialSelection, delay: 100 },
                select: this.onSelect,
                scope: this
            },
            store: new Ext.data.TreeStore({
                model: 'MyDesktop.WallpaperModel',
                root: {
                    text:'Wallpaper',
                    expanded: true,
                    children:treeImages 
                }
            })
        });

        return tree;
    },

    getTextOfWallpaper: function (path) {
        var text = path, slash = path.lastIndexOf('/');
        if (slash >= 0) {
            text = text.substring(slash+1);
        }
        var dot = text.lastIndexOf('.');
        text = Ext.String.capitalize(text.substring(0, dot));
        text = text.replace(/[-]/g, ' ');
        return text;
    },

    onOK: function () {
        var me = this;
        if (me.selected) {
            me.desktop.setWallpaper(me.selected, me.stretch);
            var text = me.selected, slash = me.selected.lastIndexOf('/');
            if (slash >= 0) {
                text = text.substring(slash+1);
            }
            
            //Actualiza el wallpaper del usuario
            wallpaper_default_windows = text;
            var conn = new Ext.data.Connection();
   			conn.request({
   				url: '../catalogo/usuario/updatewallpaper' ,
   				params:{numcliente:cliente_usuario_windows,  login:login_usuario_windows, wallpaper:text},
   				success: function(response, opts) {
   					
   				},
   				failure: function(response, opts) {
   					var obj = Ext.decode(response.responseText);
   					Ext.Msg.alert('Error',obj.message);
   				}
   			});
   			
        }
        me.destroy();
		
		//TODO:Ajustar y enviar nuevo wallpaper del usuario
    },

    onSelect: function (tree, record) {
        var me = this;

        if (record.data.img) {
            me.selected = '../resources/wallpapers/' + record.data.img;
        } else {
            me.selected = Ext.BLANK_IMAGE_URL;
        }
        me.title = "Vista Previa:" + this.getTextOfWallpaper(me.selected);
        me.preview.setWallpaper(me.selected);
    },

    setInitialSelection: function () {
        var s = this.desktop.getWallpaper();
        if (s) {
            var path = '../resources/wallpapers/' + this.getTextOfWallpaper(s);
            this.tree.selectPath(path, 'text');
        }
    }
});
