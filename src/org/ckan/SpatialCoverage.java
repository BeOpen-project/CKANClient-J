package org.ckan;

/**
 * Represents a tag
 *
 * @author      Ross Jones <ross.jones@okfn.org>
 * @version     1.7
 * @since       2012-05-01
 */
public class SpatialCoverage {
    
    private String bbox;
    
    private String centroid;
    
    private String geom;
    
    private String text;
    
    private String uri;

    public String getBbox() { return bbox; }
    public void setBbox(String v) { bbox = v; }

    public String getCentroid() { return centroid; }
    public void setCentroid(String d) { centroid = d; }

    public String getGeom() { return geom; }
    public void setGeom(String n) { geom = n; }

    public String getText() { return text; }
    public void setText(String v) { text = v; }

    public String getUri() { return uri; }
    public void setUri(String v) { uri = v; }

    public SpatialCoverage() {}

}