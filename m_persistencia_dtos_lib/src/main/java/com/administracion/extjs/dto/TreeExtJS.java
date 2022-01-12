/**
 * 
 */
package com.administracion.extjs.dto;

/**
 * @author aruaro
 *
 */
public class TreeExtJS {

    String id = null;
    String text = null;
    boolean leaf = false;
   // String cls = null;
    String iconCls=null;
    
    public TreeExtJS() {
	// TODO Auto-generated constructor stub
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the leaf
     */
    public boolean isLeaf() {
        return leaf;
    }

    /**
     * @param leaf the leaf to set
     */
    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    /**
     * @return the cls
     */
  //  public String getCls() {
    //      return cls;
    //}

    /**
     * @param cls the cls to set
     */
    //public void setCls(String cls) {
    //    this.cls = cls;
    // }

    /**
     * @return the iconCls
     */
    public String getIconCls() {
        return iconCls;
    }

    /**
     * @param iconCls the iconCls to set
     */
    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

}
