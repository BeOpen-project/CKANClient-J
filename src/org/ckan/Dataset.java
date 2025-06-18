package org.ckan;

import java.util.List;
import java.util.ArrayList;

/**
 * Represents a CKAN Dataset (previously a Package)
 *
 * @author Ross Jones <ross.jones@okfn.org>
 * @version 1.7
 * @since 2012-05-01
 */
public class Dataset {

    public Dataset() {
    }

    public class Response {
        public boolean success;
        public Dataset result;
    }

    public class SearchResponse {
        public boolean success;
        public SearchResults result;
    }

    public class IDListResponse {
        public boolean success;
        public String[] result;
    }

    /**
     * Represents the results of a search on a CKAN instance, and shows the
     * count and provides a list of dataset objects which match the term.
     *
     * @author Ross Jones <ross.jones@okfn.org>
     * @version 1.7
     * @since 2012-05-01
     */
    public class SearchResults {
        // {"count": 4, "search_facets": {}, "facets": {}, "results":

        public int count;
        public List<Dataset> results;
    }

    public class FirstSynchResults {
        public boolean success;
        public List<Dataset> result;
    }

    private String id;
    private String revision_id;
    private String name;
    private String title;
    private String author;
    private String author_email;
    private String maintainer;
    private String maintainer_email;
    private String license_id;
    private String notes;
    private String url;
    private String version;
    private String state;
    private String type;
    private String owner_org;
    private String log_message;
    // Dovrebbe essere public;
    private Boolean privat;
    private List<Resource> resources;
    private List<Tag> tags;
    private String tag_string;
    private List<Extra> extras;
    private List<Relationship> relationships_as_object;
    private List<Relationship> relationships_as_subject;
    private List<Group> groups;
    private String license;
    private String license_title;
    private String license_url;
    private String metadata_created;
    private String metadata_modified;
    private String download_url;
    private String creator_user_id;
    private int num_resources;
    private int num_tags;
    private boolean isopen;
    private Group organization;
    // private String ckan_url;

    // DCAT-AP 3.0.0 fields
    private List<String> applicable_legislation;
    private String availability;
    private List<String> conforms_to;
    private String frequency;
    private List<String> has_version;
    private String hvd_category;// List<String>
    private List<String> was_generated_by;
    private String identifier;
    private List<String> is_referenced_by;
    private String issued;
    private String modified;
    private String provenance;
    private String spatial_resolution_in_meters;
    private String temporal_resolution;
    private String uri;
    private String version_notes;
    private String access_rights;
    private List<String> language;
    private List<String> documentation;
    private List<String> theme;
    // DCAT-AP v3.0.0 relationship
    private List<QualifiedRelation> qualified_relation;
    private List<SpatialCoverage> spatial_coverage;
    private List<TemporalCoverage> temporal_coverage;

    

    public List<SpatialCoverage> getSpatial_coverage() {
        return spatial_coverage;
    }

    public void setSpatial_coverage(List<SpatialCoverage> spatial_coverage) {
        this.spatial_coverage = spatial_coverage;
    }

    public List<TemporalCoverage> getTemporal_coverage() {
        return temporal_coverage;
    }

    public void setTemporal_coverage(List<TemporalCoverage> temporal_coverage) {
        this.temporal_coverage = temporal_coverage;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setRevision_id(String revision_id) {
        this.revision_id = revision_id;
    }

    public String getRevision_id() {
        return revision_id;
    }

    public void setMaintainer(String maintainer) {
        this.maintainer = maintainer;
    }

    public String getMaintainer() {
        return maintainer;
    }

    public void setMaintainer_email(String maintainer_email) {
        this.maintainer_email = maintainer_email;
    }

    public String getMaintainer_email() {
        return maintainer_email;
    }

    public void setLicense_id(String license_id) {
        this.license_id = license_id;
    }

    public String getLicense_id() {
        return license_id;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense_title(String license_title) {
        this.license_title = license_title;
    }

    public String getLicense_title() {
        return license_title;
    }

    public void setLicense_url(String license_url) {
        this.license_url = license_url;
    }

    public String getLicense_url() {
        return license_url;
    }

    public void setMetadata_created(String metadata_created) {
        this.metadata_created = metadata_created;
    }

    public String getMetadata_created() {
        return metadata_created;
    }

    public void setMetadata_modified(String metadata_modified) {
        this.metadata_modified = metadata_modified;
    }

    public String getMetadata_modified() {
        return metadata_modified;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor_email(String author_email) {
        this.author_email = author_email;
    }

    public String getAuthor_email() {
        return author_email;
    }

    public void setDownload_url(String download_url) {
        this.download_url = download_url;
    }

    public String getDownload_url() {
        return download_url;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getNotes() {
        return notes;
    }

    public void setIsopen(boolean isopen) {
        this.isopen = isopen;
    }

    public boolean isIsopen() {
        return isopen;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    // public void setCkan_url(String ckan_url) {
    // this.ckan_url = ckan_url;
    // }
    //
    // public String getCkan_url() {
    // return ckan_url;
    // }

    public List<Extra> getExtras() {
        if (extras == null)
            return new ArrayList<Extra>();
        else
            return extras;
    }

    public void setExtras(List<Extra> extras) {
        this.extras = extras;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    public String getOwner_org() {
        return owner_org;
    }

    public void setOwner_org(String owner_org) {
        this.owner_org = owner_org;
    }

    public String getLog_message() {
        return log_message;
    }

    public void setLog_message(String log_message) {
        this.log_message = log_message;
    }

    public Boolean getPriv() {
        return privat;
    }

    public void setPriv(Boolean priv) {
        this.privat = priv;
    }

    public String getTag_string() {
        return tag_string;
    }

    public void setTag_string(String tag_string) {
        this.tag_string = tag_string;
    }

    public List<Relationship> getRelationships_as_object() {
        return relationships_as_object;
    }

    public void setRelationships_as_object(List<Relationship> relationships_as_object) {
        this.relationships_as_object = relationships_as_object;
    }

    public List<Relationship> getRelationships_as_subject() {
        return relationships_as_subject;
    }

    public void setRelationships_as_subject(List<Relationship> relationships_as_subject) {
        this.relationships_as_subject = relationships_as_subject;
    }

    public String getCreator_user_id() {
        return creator_user_id;
    }

    public void setCreator_user_id(String creator_user_id) {
        this.creator_user_id = creator_user_id;
    }

    public int getNum_resources() {
        return num_resources;
    }

    public void setNum_resources(int num_resources) {
        this.num_resources = num_resources;
    }

    public int getNum_tags() {
        return num_tags;
    }

    public void setNum_tags(int num_tags) {
        this.num_tags = num_tags;
    }

    public Group getOrganization() {
        return organization;
    }

    public void setOrganization(Group organization) {
        this.organization = organization;
    }

    public List<String> getApplicable_legislation() {
        return applicable_legislation;
    }

    public void setApplicable_legislation(List<String> applicable_legislation) {
        this.applicable_legislation = applicable_legislation;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public List<String> getConforms_to() {
        return conforms_to;
    }

    public void setConforms_to(List<String> conforms_to) {
        this.conforms_to = conforms_to;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public List<String> getHas_version() {
        return has_version;
    }

    public void setHas_version(List<String> has_version) {
        this.has_version = has_version;
    }

    public String getHvd_category() {
        return hvd_category;
    }

    public void setHvd_category(String hvd_category) {
        this.hvd_category = hvd_category;
    }

    public List<String> getWas_generated_by() {
        return was_generated_by;
    }

    public void setWas_generated_by(List<String> was_generated_by) {
        this.was_generated_by = was_generated_by;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public List<String> getIs_referenced_by() {
        return is_referenced_by;
    }

    public void setIs_referenced_by(List<String> is_referenced_by) {
        this.is_referenced_by = is_referenced_by;
    }

    public String getIssued() {
        return issued;
    }

    public void setIssued(String issued) {
        this.issued = issued;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getProvenance() {
        return provenance;
    }

    public void setProvenance(String provenance) {
        this.provenance = provenance;
    }

    public String getSpatial_resolution_in_meters() {
        return spatial_resolution_in_meters;
    }

    public void setSpatial_resolution_in_meters(String spatial_resolution_in_meters) {
        this.spatial_resolution_in_meters = spatial_resolution_in_meters;
    }

    public String getTemporal_resolution() {
        return temporal_resolution;
    }

    public void setTemporal_resolution(String temporal_resolution) {
        this.temporal_resolution = temporal_resolution;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getVersion_notes() {
        return version_notes;
    }

    public void setVersion_notes(String version_notes) {
        this.version_notes = version_notes;
    }

    public String getAccess_rights() {
        return access_rights;
    }

    public void setAccess_rights(String access_rights) {
        this.access_rights = access_rights;
    }

    public List<String> getLanguage() {
        return language;
    }

    public void setLanguage(List<String> language) {
        this.language = language;
    }

    public List<String> getDocumentation() {
        return documentation;
    }

    public void setDocumentation(List<String> documentation) {
        this.documentation = documentation;
    }

    public List<String> getTheme() {
        return theme;
    }

    public void setTheme(List<String> theme) {
        this.theme = theme;
    }

    public List<QualifiedRelation> getQualified_relation() {
        return qualified_relation;
    }

    public void setQualified_relation(List<QualifiedRelation> qualified_relation) {
        this.qualified_relation = qualified_relation;
    }

    public String toString() {
        return "<Dataset:" + this.getName() + " ," + this.getTitle() + "," + this.getAuthor() + ", " + this.getUrl()
                + ">";
    }
}
