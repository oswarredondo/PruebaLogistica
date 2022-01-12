Ext.define('MyDesktop.objetos.TextAreaUpperCase', {
    extend: 'Ext.form.field.TextArea',
    alias: 'widget.myUpperCaseTextArea',
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