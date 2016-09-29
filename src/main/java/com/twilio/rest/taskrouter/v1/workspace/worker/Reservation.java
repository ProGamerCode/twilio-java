/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.rest.taskrouter.v1.workspace.worker;

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
public class Reservation extends Resource {
    private static final long serialVersionUID = 183495073541563L;

    public enum Status {
        PENDING("pending"),
        ACCEPTED("accepted"),
        REJECTED("rejected"),
        TIMEOUT("timeout"),
        CANCELED("canceled"),
        RESCINDED("rescinded");
    
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
     * Create a ReservationReader to execute read.
     * 
     * @param workspaceSid The workspace_sid
     * @param workerSid The worker_sid
     * @return ReservationReader capable of executing the read
     */
    public static ReservationReader reader(final String workspaceSid, 
                                           final String workerSid) {
        return new ReservationReader(workspaceSid, workerSid);
    }

    /**
     * Create a ReservationFetcher to execute fetch.
     * 
     * @param workspaceSid The workspace_sid
     * @param workerSid The worker_sid
     * @param sid The sid
     * @return ReservationFetcher capable of executing the fetch
     */
    public static ReservationFetcher fetcher(final String workspaceSid, 
                                             final String workerSid, 
                                             final String sid) {
        return new ReservationFetcher(workspaceSid, workerSid, sid);
    }

    /**
     * Create a ReservationUpdater to execute update.
     * 
     * @param workspaceSid The workspace_sid
     * @param workerSid The worker_sid
     * @param sid The sid
     * @return ReservationUpdater capable of executing the update
     */
    public static ReservationUpdater updater(final String workspaceSid, 
                                             final String workerSid, 
                                             final String sid) {
        return new ReservationUpdater(workspaceSid, workerSid, sid);
    }

    /**
     * Converts a JSON String into a Reservation object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Reservation object represented by the provided JSON
     */
    public static Reservation fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Reservation.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Reservation object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Reservation object represented by the provided JSON
     */
    public static Reservation fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Reservation.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;
    private final Reservation.Status reservationStatus;
    private final String sid;
    private final String taskSid;
    private final String workerName;
    private final String workerSid;
    private final String workspaceSid;

    @JsonCreator
    private Reservation(@JsonProperty("account_sid")
                        final String accountSid, 
                        @JsonProperty("date_created")
                        final String dateCreated, 
                        @JsonProperty("date_updated")
                        final String dateUpdated, 
                        @JsonProperty("reservation_status")
                        final Reservation.Status reservationStatus, 
                        @JsonProperty("sid")
                        final String sid, 
                        @JsonProperty("task_sid")
                        final String taskSid, 
                        @JsonProperty("worker_name")
                        final String workerName, 
                        @JsonProperty("worker_sid")
                        final String workerSid, 
                        @JsonProperty("workspace_sid")
                        final String workspaceSid) {
        this.accountSid = accountSid;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.reservationStatus = reservationStatus;
        this.sid = sid;
        this.taskSid = taskSid;
        this.workerName = workerName;
        this.workerSid = workerSid;
        this.workspaceSid = workspaceSid;
    }

    /**
     * Returns The The account_sid.
     * 
     * @return The account_sid
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The The date_created.
     * 
     * @return The date_created
     */
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The The date_updated.
     * 
     * @return The date_updated
     */
    public final DateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Returns The The reservation_status.
     * 
     * @return The reservation_status
     */
    public final Reservation.Status getReservationStatus() {
        return this.reservationStatus;
    }

    /**
     * Returns The The sid.
     * 
     * @return The sid
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The The task_sid.
     * 
     * @return The task_sid
     */
    public final String getTaskSid() {
        return this.taskSid;
    }

    /**
     * Returns The The worker_name.
     * 
     * @return The worker_name
     */
    public final String getWorkerName() {
        return this.workerName;
    }

    /**
     * Returns The The worker_sid.
     * 
     * @return The worker_sid
     */
    public final String getWorkerSid() {
        return this.workerSid;
    }

    /**
     * Returns The The workspace_sid.
     * 
     * @return The workspace_sid
     */
    public final String getWorkspaceSid() {
        return this.workspaceSid;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        Reservation other = (Reservation) o;
        
        return Objects.equals(accountSid, other.accountSid) && 
               Objects.equals(dateCreated, other.dateCreated) && 
               Objects.equals(dateUpdated, other.dateUpdated) && 
               Objects.equals(reservationStatus, other.reservationStatus) && 
               Objects.equals(sid, other.sid) && 
               Objects.equals(taskSid, other.taskSid) && 
               Objects.equals(workerName, other.workerName) && 
               Objects.equals(workerSid, other.workerSid) && 
               Objects.equals(workspaceSid, other.workspaceSid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            dateCreated,
                            dateUpdated,
                            reservationStatus,
                            sid,
                            taskSid,
                            workerName,
                            workerSid,
                            workspaceSid);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("accountSid", accountSid)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .add("reservationStatus", reservationStatus)
                          .add("sid", sid)
                          .add("taskSid", taskSid)
                          .add("workerName", workerName)
                          .add("workerSid", workerSid)
                          .add("workspaceSid", workspaceSid)
                          .toString();
    }
}