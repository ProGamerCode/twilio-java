/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.rest.taskrouter.v1.workspace.taskqueue;

import com.twilio.base.Fetcher;
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

public class TaskQueueStatisticsFetcher extends Fetcher<TaskQueueStatistics> {
    private final String workspaceSid;
    private final String taskQueueSid;
    private DateTime endDate;
    private String friendlyName;
    private Integer minutes;
    private DateTime startDate;

    /**
     * Construct a new TaskQueueStatisticsFetcher.
     * 
     * @param workspaceSid The workspace_sid
     * @param taskQueueSid The task_queue_sid
     */
    public TaskQueueStatisticsFetcher(final String workspaceSid, 
                                      final String taskQueueSid) {
        this.workspaceSid = workspaceSid;
        this.taskQueueSid = taskQueueSid;
    }

    /**
     * The end_date.
     * 
     * @param endDate The end_date
     * @return this
     */
    public TaskQueueStatisticsFetcher setEndDate(final DateTime endDate) {
        this.endDate = endDate;
        return this;
    }

    /**
     * The friendly_name.
     * 
     * @param friendlyName The friendly_name
     * @return this
     */
    public TaskQueueStatisticsFetcher setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    /**
     * The minutes.
     * 
     * @param minutes The minutes
     * @return this
     */
    public TaskQueueStatisticsFetcher setMinutes(final Integer minutes) {
        this.minutes = minutes;
        return this;
    }

    /**
     * The start_date.
     * 
     * @param startDate The start_date
     * @return this
     */
    public TaskQueueStatisticsFetcher setStartDate(final DateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the fetch.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Fetched TaskQueueStatistics
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public TaskQueueStatistics fetch(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            Domains.TASKROUTER.toString(),
            "/v1/Workspaces/" + this.workspaceSid + "/TaskQueues/" + this.taskQueueSid + "/Statistics",
            client.getRegion()
        );
        
        addQueryParams(request);
        Response response = client.request(request);
        
        if (response == null) {
            throw new ApiConnectionException("TaskQueueStatistics fetch failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
        
            throw new ApiException(
                restException.getMessage(),
                restException.getCode(),
                restException.getMoreInfo(),
                restException.getStatus(),
                null
            );
        }
        
        return TaskQueueStatistics.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested query string arguments to the Request.
     * 
     * @param request Request to add query string arguments to
     */
    private void addQueryParams(final Request request) {
        if (endDate != null) {
            request.addQueryParam("EndDate", endDate.toString());
        }
        
        if (friendlyName != null) {
            request.addQueryParam("FriendlyName", friendlyName);
        }
        
        if (minutes != null) {
            request.addQueryParam("Minutes", minutes.toString());
        }
        
        if (startDate != null) {
            request.addQueryParam("StartDate", startDate.toString());
        }
    }
}