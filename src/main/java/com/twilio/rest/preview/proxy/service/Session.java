/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.preview.proxy.service;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
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
import java.net.URI;
import java.util.Map;
import java.util.Objects;

/**
 * PLEASE NOTE that this class contains preview products that are subject to
 * change. Use them with caution. If you currently do not have developer preview
 * access, please contact help@twilio.com.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Session extends Resource {
    private static final long serialVersionUID = 239445933669161L;

    public enum Status {
        IN_PROGESS("in-progess"),
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
            return Promoter.enumFromString(value, Status.values());
        }
    }

    /**
     * Create a SessionFetcher to execute fetch.
     * 
     * @param pathServiceSid Service Sid.
     * @param pathSid A string that uniquely identifies this Session.
     * @return SessionFetcher capable of executing the fetch
     */
    public static SessionFetcher fetcher(final String pathServiceSid, 
                                         final String pathSid) {
        return new SessionFetcher(pathServiceSid, pathSid);
    }

    /**
     * Create a SessionReader to execute read.
     * 
     * @param pathServiceSid Service Sid.
     * @return SessionReader capable of executing the read
     */
    public static SessionReader reader(final String pathServiceSid) {
        return new SessionReader(pathServiceSid);
    }

    /**
     * Create a SessionCreator to execute create.
     * 
     * @param pathServiceSid Service Sid.
     * @return SessionCreator capable of executing the create
     */
    public static SessionCreator creator(final String pathServiceSid) {
        return new SessionCreator(pathServiceSid);
    }

    /**
     * Create a SessionDeleter to execute delete.
     * 
     * @param pathServiceSid Service Sid.
     * @param pathSid A string that uniquely identifies this Session.
     * @return SessionDeleter capable of executing the delete
     */
    public static SessionDeleter deleter(final String pathServiceSid, 
                                         final String pathSid) {
        return new SessionDeleter(pathServiceSid, pathSid);
    }

    /**
     * Create a SessionUpdater to execute update.
     * 
     * @param pathServiceSid Service Sid.
     * @param pathSid A string that uniquely identifies this Session.
     * @return SessionUpdater capable of executing the update
     */
    public static SessionUpdater updater(final String pathServiceSid, 
                                         final String pathSid) {
        return new SessionUpdater(pathServiceSid, pathSid);
    }

    /**
     * Converts a JSON String into a Session object using the provided ObjectMapper.
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Session object represented by the provided JSON
     */
    public static Session fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Session.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Session object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Session object represented by the provided JSON
     */
    public static Session fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Session.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String serviceSid;
    private final String accountSid;
    private final String uniqueName;
    private final Integer ttl;
    private final Session.Status status;
    private final DateTime startTime;
    private final DateTime endTime;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;
    private final URI url;
    private final Map<String, String> links;

    @JsonCreator
    private Session(@JsonProperty("sid")
                    final String sid, 
                    @JsonProperty("service_sid")
                    final String serviceSid, 
                    @JsonProperty("account_sid")
                    final String accountSid, 
                    @JsonProperty("unique_name")
                    final String uniqueName, 
                    @JsonProperty("ttl")
                    final Integer ttl, 
                    @JsonProperty("status")
                    final Session.Status status, 
                    @JsonProperty("start_time")
                    final String startTime, 
                    @JsonProperty("end_time")
                    final String endTime, 
                    @JsonProperty("date_created")
                    final String dateCreated, 
                    @JsonProperty("date_updated")
                    final String dateUpdated, 
                    @JsonProperty("url")
                    final URI url, 
                    @JsonProperty("links")
                    final Map<String, String> links) {
        this.sid = sid;
        this.serviceSid = serviceSid;
        this.accountSid = accountSid;
        this.uniqueName = uniqueName;
        this.ttl = ttl;
        this.status = status;
        this.startTime = DateConverter.iso8601DateTimeFromString(startTime);
        this.endTime = DateConverter.iso8601DateTimeFromString(endTime);
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.url = url;
        this.links = links;
    }

    /**
     * Returns The A string that uniquely identifies this Session..
     * 
     * @return A string that uniquely identifies this Session.
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The Service Sid..
     * 
     * @return Service Sid.
     */
    public final String getServiceSid() {
        return this.serviceSid;
    }

    /**
     * Returns The Account Sid..
     * 
     * @return Account Sid.
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The A unique, developer assigned name of this Session..
     * 
     * @return A unique, developer assigned name of this Session.
     */
    public final String getUniqueName() {
        return this.uniqueName;
    }

    /**
     * Returns The How long will this session stay open, in seconds..
     * 
     * @return How long will this session stay open, in seconds.
     */
    public final Integer getTtl() {
        return this.ttl;
    }

    /**
     * Returns The The Status of this Session.
     * 
     * @return The Status of this Session
     */
    public final Session.Status getStatus() {
        return this.status;
    }

    /**
     * Returns The The date this Session was started.
     * 
     * @return The date this Session was started
     */
    public final DateTime getStartTime() {
        return this.startTime;
    }

    /**
     * Returns The The date this Session was ended.
     * 
     * @return The date this Session was ended
     */
    public final DateTime getEndTime() {
        return this.endTime;
    }

    /**
     * Returns The The date this Session was created.
     * 
     * @return The date this Session was created
     */
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The The date this Session was updated.
     * 
     * @return The date this Session was updated
     */
    public final DateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Returns The The URL of this Session..
     * 
     * @return The URL of this Session.
     */
    public final URI getUrl() {
        return this.url;
    }

    /**
     * Returns The Nested resource URLs..
     * 
     * @return Nested resource URLs.
     */
    public final Map<String, String> getLinks() {
        return this.links;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Session other = (Session) o;

        return Objects.equals(sid, other.sid) && 
               Objects.equals(serviceSid, other.serviceSid) && 
               Objects.equals(accountSid, other.accountSid) && 
               Objects.equals(uniqueName, other.uniqueName) && 
               Objects.equals(ttl, other.ttl) && 
               Objects.equals(status, other.status) && 
               Objects.equals(startTime, other.startTime) && 
               Objects.equals(endTime, other.endTime) && 
               Objects.equals(dateCreated, other.dateCreated) && 
               Objects.equals(dateUpdated, other.dateUpdated) && 
               Objects.equals(url, other.url) && 
               Objects.equals(links, other.links);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid,
                            serviceSid,
                            accountSid,
                            uniqueName,
                            ttl,
                            status,
                            startTime,
                            endTime,
                            dateCreated,
                            dateUpdated,
                            url,
                            links);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("sid", sid)
                          .add("serviceSid", serviceSid)
                          .add("accountSid", accountSid)
                          .add("uniqueName", uniqueName)
                          .add("ttl", ttl)
                          .add("status", status)
                          .add("startTime", startTime)
                          .add("endTime", endTime)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .add("url", url)
                          .add("links", links)
                          .toString();
    }
}