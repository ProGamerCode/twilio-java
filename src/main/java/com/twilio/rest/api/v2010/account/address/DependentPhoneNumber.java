/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.api.v2010.account.address;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.base.Resource;
import com.twilio.converter.Converter;
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

@JsonIgnoreProperties(ignoreUnknown = true)
public class DependentPhoneNumber extends Resource {
    private static final long serialVersionUID = 25853317680371L;

    public enum AddressRequirement {
        NONE("none"),
        ANY("any"),
        LOCAL("local"),
        FOREIGN("foreign");

        private final String value;

        private AddressRequirement(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a AddressRequirement from a string.
         * @param value string value
         * @return generated AddressRequirement
         */
        @JsonCreator
        public static AddressRequirement forValue(final String value) {
            return Promoter.enumFromString(value, AddressRequirement.values());
        }
    }

    public enum EmergencyStatus {
        ACTIVE("Active"),
        INACTIVE("Inactive");

        private final String value;

        private EmergencyStatus(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a EmergencyStatus from a string.
         * @param value string value
         * @return generated EmergencyStatus
         */
        @JsonCreator
        public static EmergencyStatus forValue(final String value) {
            return Promoter.enumFromString(value, EmergencyStatus.values());
        }
    }

    /**
     * Create a DependentPhoneNumberReader to execute read.
     * 
     * @param pathAccountSid The account_sid
     * @param pathAddressSid The address_sid
     * @return DependentPhoneNumberReader capable of executing the read
     */
    public static DependentPhoneNumberReader reader(final String pathAccountSid, 
                                                    final String pathAddressSid) {
        return new DependentPhoneNumberReader(pathAccountSid, pathAddressSid);
    }

    /**
     * Create a DependentPhoneNumberReader to execute read.
     * 
     * @param pathAddressSid The address_sid
     * @return DependentPhoneNumberReader capable of executing the read
     */
    public static DependentPhoneNumberReader reader(final String pathAddressSid) {
        return new DependentPhoneNumberReader(pathAddressSid);
    }

    /**
     * Converts a JSON String into a DependentPhoneNumber object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return DependentPhoneNumber object represented by the provided JSON
     */
    public static DependentPhoneNumber fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, DependentPhoneNumber.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a DependentPhoneNumber object using the
     * provided ObjectMapper.
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return DependentPhoneNumber object represented by the provided JSON
     */
    public static DependentPhoneNumber fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, DependentPhoneNumber.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String accountSid;
    private final com.twilio.type.PhoneNumber friendlyName;
    private final com.twilio.type.PhoneNumber phoneNumber;
    private final URI voiceUrl;
    private final HttpMethod voiceMethod;
    private final HttpMethod voiceFallbackMethod;
    private final URI voiceFallbackUrl;
    private final Boolean voiceCallerIdLookup;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;
    private final HttpMethod smsFallbackMethod;
    private final URI smsFallbackUrl;
    private final HttpMethod smsMethod;
    private final URI smsUrl;
    private final DependentPhoneNumber.AddressRequirement addressRequirements;
    private final Map<String, Object> capabilities;
    private final URI statusCallback;
    private final HttpMethod statusCallbackMethod;
    private final String apiVersion;
    private final String smsApplicationSid;
    private final String voiceApplicationSid;
    private final String trunkSid;
    private final DependentPhoneNumber.EmergencyStatus emergencyStatus;
    private final String emergencyAddressSid;
    private final String uri;

    @JsonCreator
    private DependentPhoneNumber(@JsonProperty("sid")
                                 final String sid, 
                                 @JsonProperty("account_sid")
                                 final String accountSid, 
                                 @JsonProperty("friendly_name")
                                 final com.twilio.type.PhoneNumber friendlyName, 
                                 @JsonProperty("phone_number")
                                 final com.twilio.type.PhoneNumber phoneNumber, 
                                 @JsonProperty("voice_url")
                                 final URI voiceUrl, 
                                 @JsonProperty("voice_method")
                                 final HttpMethod voiceMethod, 
                                 @JsonProperty("voice_fallback_method")
                                 final HttpMethod voiceFallbackMethod, 
                                 @JsonProperty("voice_fallback_url")
                                 final URI voiceFallbackUrl, 
                                 @JsonProperty("voice_caller_id_lookup")
                                 final Boolean voiceCallerIdLookup, 
                                 @JsonProperty("date_created")
                                 final String dateCreated, 
                                 @JsonProperty("date_updated")
                                 final String dateUpdated, 
                                 @JsonProperty("sms_fallback_method")
                                 final HttpMethod smsFallbackMethod, 
                                 @JsonProperty("sms_fallback_url")
                                 final URI smsFallbackUrl, 
                                 @JsonProperty("sms_method")
                                 final HttpMethod smsMethod, 
                                 @JsonProperty("sms_url")
                                 final URI smsUrl, 
                                 @JsonProperty("address_requirements")
                                 final DependentPhoneNumber.AddressRequirement addressRequirements, 
                                 @JsonProperty("capabilities")
                                 final Map<String, Object> capabilities, 
                                 @JsonProperty("status_callback")
                                 final URI statusCallback, 
                                 @JsonProperty("status_callback_method")
                                 final HttpMethod statusCallbackMethod, 
                                 @JsonProperty("api_version")
                                 final String apiVersion, 
                                 @JsonProperty("sms_application_sid")
                                 final String smsApplicationSid, 
                                 @JsonProperty("voice_application_sid")
                                 final String voiceApplicationSid, 
                                 @JsonProperty("trunk_sid")
                                 final String trunkSid, 
                                 @JsonProperty("emergency_status")
                                 final DependentPhoneNumber.EmergencyStatus emergencyStatus, 
                                 @JsonProperty("emergency_address_sid")
                                 final String emergencyAddressSid, 
                                 @JsonProperty("uri")
                                 final String uri) {
        this.sid = sid;
        this.accountSid = accountSid;
        this.friendlyName = friendlyName;
        this.phoneNumber = phoneNumber;
        this.voiceUrl = voiceUrl;
        this.voiceMethod = voiceMethod;
        this.voiceFallbackMethod = voiceFallbackMethod;
        this.voiceFallbackUrl = voiceFallbackUrl;
        this.voiceCallerIdLookup = voiceCallerIdLookup;
        this.dateCreated = DateConverter.rfc2822DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.rfc2822DateTimeFromString(dateUpdated);
        this.smsFallbackMethod = smsFallbackMethod;
        this.smsFallbackUrl = smsFallbackUrl;
        this.smsMethod = smsMethod;
        this.smsUrl = smsUrl;
        this.addressRequirements = addressRequirements;
        this.capabilities = capabilities;
        this.statusCallback = statusCallback;
        this.statusCallbackMethod = statusCallbackMethod;
        this.apiVersion = apiVersion;
        this.smsApplicationSid = smsApplicationSid;
        this.voiceApplicationSid = voiceApplicationSid;
        this.trunkSid = trunkSid;
        this.emergencyStatus = emergencyStatus;
        this.emergencyAddressSid = emergencyAddressSid;
        this.uri = uri;
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
     * Returns The The account_sid.
     * 
     * @return The account_sid
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The The friendly_name.
     * 
     * @return The friendly_name
     */
    public final com.twilio.type.PhoneNumber getFriendlyName() {
        return this.friendlyName;
    }

    /**
     * Returns The The phone_number.
     * 
     * @return The phone_number
     */
    public final com.twilio.type.PhoneNumber getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Returns The The voice_url.
     * 
     * @return The voice_url
     */
    public final URI getVoiceUrl() {
        return this.voiceUrl;
    }

    /**
     * Returns The The voice_method.
     * 
     * @return The voice_method
     */
    public final HttpMethod getVoiceMethod() {
        return this.voiceMethod;
    }

    /**
     * Returns The The voice_fallback_method.
     * 
     * @return The voice_fallback_method
     */
    public final HttpMethod getVoiceFallbackMethod() {
        return this.voiceFallbackMethod;
    }

    /**
     * Returns The The voice_fallback_url.
     * 
     * @return The voice_fallback_url
     */
    public final URI getVoiceFallbackUrl() {
        return this.voiceFallbackUrl;
    }

    /**
     * Returns The The voice_caller_id_lookup.
     * 
     * @return The voice_caller_id_lookup
     */
    public final Boolean getVoiceCallerIdLookup() {
        return this.voiceCallerIdLookup;
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
     * Returns The The sms_fallback_method.
     * 
     * @return The sms_fallback_method
     */
    public final HttpMethod getSmsFallbackMethod() {
        return this.smsFallbackMethod;
    }

    /**
     * Returns The The sms_fallback_url.
     * 
     * @return The sms_fallback_url
     */
    public final URI getSmsFallbackUrl() {
        return this.smsFallbackUrl;
    }

    /**
     * Returns The The sms_method.
     * 
     * @return The sms_method
     */
    public final HttpMethod getSmsMethod() {
        return this.smsMethod;
    }

    /**
     * Returns The The sms_url.
     * 
     * @return The sms_url
     */
    public final URI getSmsUrl() {
        return this.smsUrl;
    }

    /**
     * Returns The The address_requirements.
     * 
     * @return The address_requirements
     */
    public final DependentPhoneNumber.AddressRequirement getAddressRequirements() {
        return this.addressRequirements;
    }

    /**
     * Returns The The capabilities.
     * 
     * @return The capabilities
     */
    public final Map<String, Object> getCapabilities() {
        return this.capabilities;
    }

    /**
     * Returns The The status_callback.
     * 
     * @return The status_callback
     */
    public final URI getStatusCallback() {
        return this.statusCallback;
    }

    /**
     * Returns The The status_callback_method.
     * 
     * @return The status_callback_method
     */
    public final HttpMethod getStatusCallbackMethod() {
        return this.statusCallbackMethod;
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
     * Returns The The sms_application_sid.
     * 
     * @return The sms_application_sid
     */
    public final String getSmsApplicationSid() {
        return this.smsApplicationSid;
    }

    /**
     * Returns The The voice_application_sid.
     * 
     * @return The voice_application_sid
     */
    public final String getVoiceApplicationSid() {
        return this.voiceApplicationSid;
    }

    /**
     * Returns The The trunk_sid.
     * 
     * @return The trunk_sid
     */
    public final String getTrunkSid() {
        return this.trunkSid;
    }

    /**
     * Returns The The emergency_status.
     * 
     * @return The emergency_status
     */
    public final DependentPhoneNumber.EmergencyStatus getEmergencyStatus() {
        return this.emergencyStatus;
    }

    /**
     * Returns The The emergency_address_sid.
     * 
     * @return The emergency_address_sid
     */
    public final String getEmergencyAddressSid() {
        return this.emergencyAddressSid;
    }

    /**
     * Returns The The uri.
     * 
     * @return The uri
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

        DependentPhoneNumber other = (DependentPhoneNumber) o;

        return Objects.equals(sid, other.sid) && 
               Objects.equals(accountSid, other.accountSid) && 
               Objects.equals(friendlyName, other.friendlyName) && 
               Objects.equals(phoneNumber, other.phoneNumber) && 
               Objects.equals(voiceUrl, other.voiceUrl) && 
               Objects.equals(voiceMethod, other.voiceMethod) && 
               Objects.equals(voiceFallbackMethod, other.voiceFallbackMethod) && 
               Objects.equals(voiceFallbackUrl, other.voiceFallbackUrl) && 
               Objects.equals(voiceCallerIdLookup, other.voiceCallerIdLookup) && 
               Objects.equals(dateCreated, other.dateCreated) && 
               Objects.equals(dateUpdated, other.dateUpdated) && 
               Objects.equals(smsFallbackMethod, other.smsFallbackMethod) && 
               Objects.equals(smsFallbackUrl, other.smsFallbackUrl) && 
               Objects.equals(smsMethod, other.smsMethod) && 
               Objects.equals(smsUrl, other.smsUrl) && 
               Objects.equals(addressRequirements, other.addressRequirements) && 
               Objects.equals(capabilities, other.capabilities) && 
               Objects.equals(statusCallback, other.statusCallback) && 
               Objects.equals(statusCallbackMethod, other.statusCallbackMethod) && 
               Objects.equals(apiVersion, other.apiVersion) && 
               Objects.equals(smsApplicationSid, other.smsApplicationSid) && 
               Objects.equals(voiceApplicationSid, other.voiceApplicationSid) && 
               Objects.equals(trunkSid, other.trunkSid) && 
               Objects.equals(emergencyStatus, other.emergencyStatus) && 
               Objects.equals(emergencyAddressSid, other.emergencyAddressSid) && 
               Objects.equals(uri, other.uri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid,
                            accountSid,
                            friendlyName,
                            phoneNumber,
                            voiceUrl,
                            voiceMethod,
                            voiceFallbackMethod,
                            voiceFallbackUrl,
                            voiceCallerIdLookup,
                            dateCreated,
                            dateUpdated,
                            smsFallbackMethod,
                            smsFallbackUrl,
                            smsMethod,
                            smsUrl,
                            addressRequirements,
                            capabilities,
                            statusCallback,
                            statusCallbackMethod,
                            apiVersion,
                            smsApplicationSid,
                            voiceApplicationSid,
                            trunkSid,
                            emergencyStatus,
                            emergencyAddressSid,
                            uri);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("sid", sid)
                          .add("accountSid", accountSid)
                          .add("friendlyName", friendlyName)
                          .add("phoneNumber", phoneNumber)
                          .add("voiceUrl", voiceUrl)
                          .add("voiceMethod", voiceMethod)
                          .add("voiceFallbackMethod", voiceFallbackMethod)
                          .add("voiceFallbackUrl", voiceFallbackUrl)
                          .add("voiceCallerIdLookup", voiceCallerIdLookup)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .add("smsFallbackMethod", smsFallbackMethod)
                          .add("smsFallbackUrl", smsFallbackUrl)
                          .add("smsMethod", smsMethod)
                          .add("smsUrl", smsUrl)
                          .add("addressRequirements", addressRequirements)
                          .add("capabilities", capabilities)
                          .add("statusCallback", statusCallback)
                          .add("statusCallbackMethod", statusCallbackMethod)
                          .add("apiVersion", apiVersion)
                          .add("smsApplicationSid", smsApplicationSid)
                          .add("voiceApplicationSid", voiceApplicationSid)
                          .add("trunkSid", trunkSid)
                          .add("emergencyStatus", emergencyStatus)
                          .add("emergencyAddressSid", emergencyAddressSid)
                          .add("uri", uri)
                          .toString();
    }
}