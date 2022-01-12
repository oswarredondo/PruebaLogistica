Ext.define('MyDesktop.objetos.TextFieldUpperCase', {
    extend: 'Ext.form.field.Text',
    alias: 'widget.myUpperCaseTextField',
	fieldStyle: {
        textTransform: "uppercase"
    },
    initComponent: function() {
        this.callParent(arguments);
    },
    listeners: {
        change: function (obj, newValue) {
           // console.log(newValue);
            obj.setRawValue(newValue.toUpperCase());
        }
     }
});