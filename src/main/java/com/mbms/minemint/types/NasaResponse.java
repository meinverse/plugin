package com.mbms.minemint.types;


import com.google.api.client.util.Key;

// Json response preview:
// {
//        "copyright": "Xiaohan Wang",
//        "date": "2022-03-13",
//        "explanation": "Why would the sky glow like a giant repeating rainbow?  Airglow.  Now air glows all of the time, but it is usually hard to see. A disturbance however -- like an approaching storm -- may cause noticeable rippling in the Earth's atmosphere. These gravity waves are oscillations in air analogous to those created when a rock is thrown in calm water.  Red airglow likely originates from OH molecules about 87-kilometers high, excited by ultraviolet light from the Sun, while orange and green airglow is likely caused by sodium and oxygen atoms slightly higher up.  While driving near Keluke Lake in Qinghai Provence in China a few years ago, the photographer originally noticed mainly the impressive central band of the Milky Way Galaxy.  Stopping to photograph it, surprisingly, the resulting sensitive camera image showed airglow bands to be quite prominent and span the entire sky. The featured image has been digitally enhanced to make the colors more vibrant.",
//        "hdurl": "https://apod.nasa.gov/apod/image/2203/AirglowRings_Wang_3887.jpg",
//        "media_type": "image",
//        "service_version": "v1",
//        "title": "Colorful Airglow Bands Surround Milky Way",
//        "url": "https://apod.nasa.gov/apod/image/2203/AirglowRings_Wang_1080.jpg"
//}
public class NasaResponse {
    @Key
    private String copyright;
    @Key
    private String date;
    @Key
    private String explanation;
    @Key
    private String hdurl;
    @Key
    private String media_type;
    @Key
    private String service_version;
    @Key
    private String title;
    @Key
    private String url;

    public String getCopyright() {
        return copyright;
    }

    public String getDate() {
        return date;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getHdurl() {
        return hdurl;
    }

    public String getMedia_type() {
        return media_type;
    }

    public String getService_version() {
        return service_version;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }
}
