Ext.define('MyDesktop.objetos.EmailTextField', {
    extend: 'Ext.form.field.TextArea',
    alias: 'widget.myEmailTextField',
    regex: /^(([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5}){1,25})+([;,](([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5}){1,25})+)*$/,
    initComponent: function() {
        this.callParent(arguments);
    },
    listeners: {
        change: function (obj, newValue) {
           // console.log(newValue);
           // obj.setRawValue(newValue.toUpperCase());
        }
     }
});