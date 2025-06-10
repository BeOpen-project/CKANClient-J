package org.ckan;

import java.util.List;

public class AccessService {

    public AccessService() {
    }

    private String access_rights;
    private String endpoint_description;
    private List<String> endpoint_url;
    private List<String> serves_dataset;
    private String title;
    private String uri;

    public String getAccess_rights() {
        return access_rights;
    }

    public void setAccess_rights(String access_rights) {
        this.access_rights = access_rights;
    }

    public String getEndpoint_description() {
        return endpoint_description;
    }

    public void setEndpoint_description(String endpoint_description) {
        this.endpoint_description = endpoint_description;
    }

    public List<String> getEndpoint_url() {
        return endpoint_url;
    }

    public void setEndpoint_url(List<String> endpoint_url) {
        this.endpoint_url = endpoint_url;
    }

    public List<String> getServes_dataset() {
        return serves_dataset;
    }

    public void setServes_dataset(List<String> serves_dataset) {
        this.serves_dataset = serves_dataset;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
