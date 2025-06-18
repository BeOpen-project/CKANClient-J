package org.ckan;

/**
 * Represents a tag
 *
 * @author      Ross Jones <ross.jones@okfn.org>
 * @version     1.7
 * @since       2012-05-01
 */
public class TemporalCoverage {
	private String end;
    private String start;

    public String getEnd() { return end; }
    public void setEnd(String v) { end = v; }

    public String getStart() { return start; }
    public void setStart(String d) { start = d; }

    public TemporalCoverage() {}

}