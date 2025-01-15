package com.example.journal.ApiResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Component
public class WeatherApi{
    public Request request;
    public Location location;
    public Current current;

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    public class Current{
        @JsonProperty("observation_time")
        public String observationTime;

        public String getObservationTime() {
            return observationTime;
        }

        public void setObservationTime(String observationTime) {
            this.observationTime = observationTime;
        }

        public int getTemperature() {
            return temperature;
        }

        public void setTemperature(int temperature) {
            this.temperature = temperature;
        }

        public int getWeatherCode() {
            return weatherCode;
        }

        public void setWeatherCode(int weatherCode) {
            this.weatherCode = weatherCode;
        }

        public ArrayList<String> getWeatherIcons() {
            return weatherIcons;
        }

        public void setWeatherIcons(ArrayList<String> weatherIcons) {
            this.weatherIcons = weatherIcons;
        }

        public ArrayList<String> getWeatherDescriptions() {
            return weatherDescriptions;
        }

        public void setWeatherDescriptions(ArrayList<String> weatherDescriptions) {
            this.weatherDescriptions = weatherDescriptions;
        }

        public int getWindSpeed() {
            return windSpeed;
        }

        public void setWindSpeed(int windSpeed) {
            this.windSpeed = windSpeed;
        }

        public int getWindDegree() {
            return windDegree;
        }

        public void setWindDegree(int windDegree) {
            this.windDegree = windDegree;
        }

        public String getWindDir() {
            return windDir;
        }

        public void setWindDir(String windDir) {
            this.windDir = windDir;
        }

        public int getPressure() {
            return pressure;
        }

        public void setPressure(int pressure) {
            this.pressure = pressure;
        }

        public int getPrecip() {
            return precip;
        }

        public void setPrecip(int precip) {
            this.precip = precip;
        }

        public int getHumidity() {
            return humidity;
        }

        public void setHumidity(int humidity) {
            this.humidity = humidity;
        }

        public int getCloudcover() {
            return cloudcover;
        }

        public void setCloudcover(int cloudcover) {
            this.cloudcover = cloudcover;
        }

        public int getFeelslike() {
            return feelslike;
        }

        public void setFeelslike(int feelslike) {
            this.feelslike = feelslike;
        }

        public int getUvIndex() {
            return uvIndex;
        }

        public void setUvIndex(int uvIndex) {
            this.uvIndex = uvIndex;
        }

        public int getVisibility() {
            return visibility;
        }

        public void setVisibility(int visibility) {
            this.visibility = visibility;
        }

        public String getIsDay() {
            return isDay;
        }

        public void setIsDay(String isDay) {
            this.isDay = isDay;
        }

        public int temperature;

        @JsonProperty("weather_code")
        public int weatherCode;

        @JsonProperty("weather_icons")
        public ArrayList<String> weatherIcons;

        @JsonProperty("weather_descriptions")
        public ArrayList<String> weatherDescriptions;

        @JsonProperty("wind_speed")
        public int windSpeed;

        @JsonProperty("wind_degree")
        public int windDegree;

        @JsonProperty("wind_dir")
        public String windDir;

        public int pressure;

        public int precip;

        public int humidity;

        public int cloudcover;

        public int feelslike;

        @JsonProperty("uv_index")
        public int uvIndex;

        public int visibility;

        @JsonProperty("is_day")
        public String isDay;
    }

    public class Location{
        public String name;

        public String country;

        public String region;

        public String lat;

        public String lon;

        @JsonProperty("timezone_id")
        public String timezoneId;

        public String localtime;

        @JsonProperty("localtime_epoch")
        public int localtimeEpoch;

        @JsonProperty("utc_offset")
        public String utcOffset;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLon() {
            return lon;
        }

        public void setLon(String lon) {
            this.lon = lon;
        }

        public String getTimezoneId() {
            return timezoneId;
        }

        public void setTimezoneId(String timezoneId) {
            this.timezoneId = timezoneId;
        }

        public String getLocaltime() {
            return localtime;
        }

        public void setLocaltime(String localtime) {
            this.localtime = localtime;
        }

        public int getLocaltimeEpoch() {
            return localtimeEpoch;
        }

        public void setLocaltimeEpoch(int localtimeEpoch) {
            this.localtimeEpoch = localtimeEpoch;
        }

        public String getUtcOffset() {
            return utcOffset;
        }

        public void setUtcOffset(String utcOffset) {
            this.utcOffset = utcOffset;
        }
    }

    public class Request{
        public String type;

        public String query;

        public String language;

        public String unit;

        public String getType() {
            return type;
        }

        public String getQuery() {
            return query;
        }

        public void setQuery(String query) {
            this.query = query;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}

