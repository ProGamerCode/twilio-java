/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.rest.api.v2010.account;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import org.joda.time.DateTime;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Conference extends Resource {
    private static final long serialVersionUID = 42097688383145L;

    public enum Status {
        INIT("init"),
        IN_PROGRESS("in-progress"),
        COMPLETED("completed");
    
        private final String value;
        
        private Status(final String value) {
            this.value = value;
        }
        
        public String toString() {
            return value;
        }
        
        /**
         * Generate a Status from a string.
         * @param value string value
         * @return generated Status
         */
        @JsonCreator
        public static Status forValue(final String value) {
            String normalized = value.replace("-", "_").toUpperCase();
            try {
                return Status.valueOf(normalized);
            } catch (RuntimeException e) {
        
                // Don't blow up of value does not exist
                return null;
            }
        }
    }

    /**
     * Create a ConferenceFetcher to execute fetch.
     * 
     * @param accountSid The account_sid
     * @param sid Fetch by unique conference Sid
     * @return ConferenceFetcher capable of executing the fetch
     */
    public static ConferenceFetcher fetcher(final String accountSid, 
                                            final String sid) {
        return new ConferenceFetcher(accountSid, sid);
    }

    /**
     * Create a ConferenceFetcher to execute fetch.
     * 
     * @param sid Fetch by unique conference Sid
     * @return ConferenceFetcher capable of executing the fetch
     */
    public static ConferenceFetcher fetcher(final String sid) {
        return new ConferenceFetcher(sid);
    }

    /**
     * Create a ConferenceReader to execute read.
     * 
     * @param accountSid The account_sid
     * @return ConferenceReader capable of executing the read
     */
    public static ConferenceReader reader(final String accountSid) {
        return new ConferenceReader(accountSid);
    }

    /**
     * Create a ConferenceReader to execute read.
     * 
     * @return ConferenceReader capable of executing the read
     */
    public static ConferenceReader reader() {
        return new ConferenceReader();
    }

    /**
     * Converts a JSON String into a Conference object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Conference object represented by the provided JSON
     */
    public static Conference fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Conference.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Conference object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Conference object represented by the provided JSON
     */
    public static Conference fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Conference.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;
    private final String apiVersion;
    private final String friendlyName;
    private final String sid;
    private final Conference.Status status;
    private final String uri;

    @JsonCreator
    private Conference(@JsonProperty("account_sid")
                       final String accountSid, 
                       @JsonProperty("date_created")
                       final String dateCreated, 
                       @JsonProperty("date_updated")
                       final String dateUpdated, 
                       @JsonProperty("api_version")
                       final String apiVersion, 
                       @JsonProperty("friendly_name")
                       final String friendlyName, 
                       @JsonProperty("sid")
                       final String sid, 
                       @JsonProperty("status")
                       final Conference.Status status, 
                       @JsonProperty("uri")
                       final String uri) {
        this.accountSid = accountSid;
        this.dateCreated = DateConverter.rfc2822DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.rfc2822DateTimeFromString(dateUpdated);
        this.apiVersion = apiVersion;
        this.friendlyName = friendlyName;
        this.sid = sid;
        this.status = status;
        this.uri = uri;
    }

    /**
     * Returns The The unique sid that identifies this account.
     * 
     * @return The unique sid that identifies this account
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The The date this resource was created.
     * 
     * @return The date this resource was created
     */
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The The date this resource was last updated.
     * 
     * @return The date this resource was last updated
     */
    public final DateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Returns The The api_version.
     * 
     * @return The api_version
     */
    public final String getApiVersion() {
        return this.apiVersion;
    }

    /**
     * Returns The A human readable description of this resource.
     * 
     * @return A human readable description of this resource
     */
    public final String getFriendlyName() {
        return this.friendlyName;
    }

    /**
     * Returns The A string that uniquely identifies this conference.
     * 
     * @return A string that uniquely identifies this conference
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The The status of the conference.
     * 
     * @return The status of the conference
     */
    public final Conference.Status getStatus() {
        return this.status;
    }

    /**
     * Returns The The URI for this resource.
     * 
     * @return The URI for this resource
     */
    public final String getUri() {
        return this.uri;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        Conference other = (Conference) o;
        
        return Objects.equals(accountSid, other.accountSid) && 
               Objects.equals(dateCreated, other.dateCreated) && 
               Objects.equals(dateUpdated, other.dateUpdated) && 
               Objects.equals(apiVersion, other.apiVersion) && 
               Objects.equals(friendlyName, other.friendlyName) && 
               Objects.equals(sid, other.sid) && 
               Objects.equals(status, other.status) && 
               Objects.equals(uri, other.uri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            dateCreated,
                            dateUpdated,
                            apiVersion,
                            friendlyName,
                            sid,
                            status,
                            uri);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("accountSid", accountSid)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .add("apiVersion", apiVersion)
                          .add("friendlyName", friendlyName)
                          .add("sid", sid)
                          .add("status", status)
                          .add("uri", uri)
                          .toString();
    }
}