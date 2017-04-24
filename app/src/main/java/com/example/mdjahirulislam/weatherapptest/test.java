package com.example.mdjahirulislam.weatherapptest;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mdjahirulislam on 19/04/17.
 */

public class test {


    /**
     * query : {"count":1,"created":"2017-04-19T15:34:40Z","lang":"en-us","results":{"channel":{"units":{},"title":"Yahoo! Weather - Nome, AK, US","link":"http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-2460286/","description":"Yahoo! Weather for Nome, AK, US","language":"en-us","lastBuildDate":"Wed, 19 Apr 2017 07:34 AM AKDT","ttl":"60","location":{},"wind":{},"atmosphere":{},"astronomy":{},"image":{},"item":{"title":"Conditions for Nome, AK, US at 06:00 AM AKDT","lat":"64.499474","long":"-165.405792","link":"http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-2460286/","pubDate":"Wed, 19 Apr 2017 06:00 AM AKDT","condition":{"code":"31","date":"Wed, 19 Apr 2017 06:00 AM AKDT","temp":"24","text":"Clear"},"forecast":[{"code":"32","date":"19 Apr 2017","day":"Wed","high":"38","low":"24","text":"Sunny"},{"code":"32","date":"20 Apr 2017","day":"Thu","high":"34","low":"25","text":"Sunny"},{"code":"30","date":"21 Apr 2017","day":"Fri","high":"37","low":"25","text":"Partly Cloudy"},{"code":"28","date":"22 Apr 2017","day":"Sat","high":"38","low":"27","text":"Mostly Cloudy"},{"code":"28","date":"23 Apr 2017","day":"Sun","high":"41","low":"28","text":"Mostly Cloudy"},{"code":"26","date":"24 Apr 2017","day":"Mon","high":"38","low":"34","text":"Cloudy"},{"code":"26","date":"25 Apr 2017","day":"Tue","high":"42","low":"36","text":"Cloudy"},{"code":"26","date":"26 Apr 2017","day":"Wed","high":"39","low":"36","text":"Cloudy"},{"code":"28","date":"27 Apr 2017","day":"Thu","high":"39","low":"33","text":"Mostly Cloudy"},{"code":"28","date":"28 Apr 2017","day":"Fri","high":"34","low":"21","text":"Mostly Cloudy"}],"description":"<![CDATA[<img src=\"http://l.yimg.com/a/i/us/we/52/31.gif\"/>\n<BR />\n<b>Current Conditions:<\/b>\n<BR />Clear\n<BR />\n<BR />\n<b>Forecast:<\/b>\n<BR /> Wed - Sunny. High: 38Low: 24\n<BR /> Thu - Sunny. High: 34Low: 25\n<BR /> Fri - Partly Cloudy. High: 37Low: 25\n<BR /> Sat - Mostly Cloudy. High: 38Low: 27\n<BR /> Sun - Mostly Cloudy. High: 41Low: 28\n<BR />\n<BR />\n<a href=\"http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-2460286/\">Full Forecast at Yahoo! Weather<\/a>\n<BR />\n<BR />\n(provided by <a href=\"http://www.weather.com\" >The Weather Channel<\/a>)\n<BR />\n]]>","guid":{"isPermaLink":"false"}}}}}
     */

    private QueryBean query;

    public QueryBean getQuery() {
        return query;
    }

    public void setQuery(QueryBean query) {
        this.query = query;
    }

    public static class QueryBean {
        /**
         * count : 1
         * created : 2017-04-19T15:34:40Z
         * lang : en-us
         * results : {"channel":{"units":{},"title":"Yahoo! Weather - Nome, AK, US","link":"http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-2460286/","description":"Yahoo! Weather for Nome, AK, US","language":"en-us","lastBuildDate":"Wed, 19 Apr 2017 07:34 AM AKDT","ttl":"60","location":{},"wind":{},"atmosphere":{},"astronomy":{},"image":{},"item":{"title":"Conditions for Nome, AK, US at 06:00 AM AKDT","lat":"64.499474","long":"-165.405792","link":"http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-2460286/","pubDate":"Wed, 19 Apr 2017 06:00 AM AKDT","condition":{"code":"31","date":"Wed, 19 Apr 2017 06:00 AM AKDT","temp":"24","text":"Clear"},"forecast":[{"code":"32","date":"19 Apr 2017","day":"Wed","high":"38","low":"24","text":"Sunny"},{"code":"32","date":"20 Apr 2017","day":"Thu","high":"34","low":"25","text":"Sunny"},{"code":"30","date":"21 Apr 2017","day":"Fri","high":"37","low":"25","text":"Partly Cloudy"},{"code":"28","date":"22 Apr 2017","day":"Sat","high":"38","low":"27","text":"Mostly Cloudy"},{"code":"28","date":"23 Apr 2017","day":"Sun","high":"41","low":"28","text":"Mostly Cloudy"},{"code":"26","date":"24 Apr 2017","day":"Mon","high":"38","low":"34","text":"Cloudy"},{"code":"26","date":"25 Apr 2017","day":"Tue","high":"42","low":"36","text":"Cloudy"},{"code":"26","date":"26 Apr 2017","day":"Wed","high":"39","low":"36","text":"Cloudy"},{"code":"28","date":"27 Apr 2017","day":"Thu","high":"39","low":"33","text":"Mostly Cloudy"},{"code":"28","date":"28 Apr 2017","day":"Fri","high":"34","low":"21","text":"Mostly Cloudy"}],"description":"<![CDATA[<img src=\"http://l.yimg.com/a/i/us/we/52/31.gif\"/>\n<BR />\n<b>Current Conditions:<\/b>\n<BR />Clear\n<BR />\n<BR />\n<b>Forecast:<\/b>\n<BR /> Wed - Sunny. High: 38Low: 24\n<BR /> Thu - Sunny. High: 34Low: 25\n<BR /> Fri - Partly Cloudy. High: 37Low: 25\n<BR /> Sat - Mostly Cloudy. High: 38Low: 27\n<BR /> Sun - Mostly Cloudy. High: 41Low: 28\n<BR />\n<BR />\n<a href=\"http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-2460286/\">Full Forecast at Yahoo! Weather<\/a>\n<BR />\n<BR />\n(provided by <a href=\"http://www.weather.com\" >The Weather Channel<\/a>)\n<BR />\n]]>","guid":{"isPermaLink":"false"}}}}
         */

        private int count;
        private String created;
        private String lang;
        private ResultsBean results;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        public String getLang() {
            return lang;
        }

        public void setLang(String lang) {
            this.lang = lang;
        }

        public ResultsBean getResults() {
            return results;
        }

        public void setResults(ResultsBean results) {
            this.results = results;
        }

        public static class ResultsBean {
            /**
             * channel : {"units":{},"title":"Yahoo! Weather - Nome, AK, US","link":"http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-2460286/","description":"Yahoo! Weather for Nome, AK, US","language":"en-us","lastBuildDate":"Wed, 19 Apr 2017 07:34 AM AKDT","ttl":"60","location":{},"wind":{},"atmosphere":{},"astronomy":{},"image":{},"item":{"title":"Conditions for Nome, AK, US at 06:00 AM AKDT","lat":"64.499474","long":"-165.405792","link":"http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-2460286/","pubDate":"Wed, 19 Apr 2017 06:00 AM AKDT","condition":{"code":"31","date":"Wed, 19 Apr 2017 06:00 AM AKDT","temp":"24","text":"Clear"},"forecast":[{"code":"32","date":"19 Apr 2017","day":"Wed","high":"38","low":"24","text":"Sunny"},{"code":"32","date":"20 Apr 2017","day":"Thu","high":"34","low":"25","text":"Sunny"},{"code":"30","date":"21 Apr 2017","day":"Fri","high":"37","low":"25","text":"Partly Cloudy"},{"code":"28","date":"22 Apr 2017","day":"Sat","high":"38","low":"27","text":"Mostly Cloudy"},{"code":"28","date":"23 Apr 2017","day":"Sun","high":"41","low":"28","text":"Mostly Cloudy"},{"code":"26","date":"24 Apr 2017","day":"Mon","high":"38","low":"34","text":"Cloudy"},{"code":"26","date":"25 Apr 2017","day":"Tue","high":"42","low":"36","text":"Cloudy"},{"code":"26","date":"26 Apr 2017","day":"Wed","high":"39","low":"36","text":"Cloudy"},{"code":"28","date":"27 Apr 2017","day":"Thu","high":"39","low":"33","text":"Mostly Cloudy"},{"code":"28","date":"28 Apr 2017","day":"Fri","high":"34","low":"21","text":"Mostly Cloudy"}],"description":"<![CDATA[<img src=\"http://l.yimg.com/a/i/us/we/52/31.gif\"/>\n<BR />\n<b>Current Conditions:<\/b>\n<BR />Clear\n<BR />\n<BR />\n<b>Forecast:<\/b>\n<BR /> Wed - Sunny. High: 38Low: 24\n<BR /> Thu - Sunny. High: 34Low: 25\n<BR /> Fri - Partly Cloudy. High: 37Low: 25\n<BR /> Sat - Mostly Cloudy. High: 38Low: 27\n<BR /> Sun - Mostly Cloudy. High: 41Low: 28\n<BR />\n<BR />\n<a href=\"http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-2460286/\">Full Forecast at Yahoo! Weather<\/a>\n<BR />\n<BR />\n(provided by <a href=\"http://www.weather.com\" >The Weather Channel<\/a>)\n<BR />\n]]>","guid":{"isPermaLink":"false"}}}
             */

            private ChannelBean channel;

            public ChannelBean getChannel() {
                return channel;
            }

            public void setChannel(ChannelBean channel) {
                this.channel = channel;
            }

            public static class ChannelBean {
                /**
                 * units : {}
                 * title : Yahoo! Weather - Nome, AK, US
                 * link : http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-2460286/
                 * description : Yahoo! Weather for Nome, AK, US
                 * language : en-us
                 * lastBuildDate : Wed, 19 Apr 2017 07:34 AM AKDT
                 * ttl : 60
                 * location : {}
                 * wind : {}
                 * atmosphere : {}
                 * astronomy : {}
                 * image : {}
                 * item : {"title":"Conditions for Nome, AK, US at 06:00 AM AKDT","lat":"64.499474","long":"-165.405792","link":"http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-2460286/","pubDate":"Wed, 19 Apr 2017 06:00 AM AKDT","condition":{"code":"31","date":"Wed, 19 Apr 2017 06:00 AM AKDT","temp":"24","text":"Clear"},"forecast":[{"code":"32","date":"19 Apr 2017","day":"Wed","high":"38","low":"24","text":"Sunny"},{"code":"32","date":"20 Apr 2017","day":"Thu","high":"34","low":"25","text":"Sunny"},{"code":"30","date":"21 Apr 2017","day":"Fri","high":"37","low":"25","text":"Partly Cloudy"},{"code":"28","date":"22 Apr 2017","day":"Sat","high":"38","low":"27","text":"Mostly Cloudy"},{"code":"28","date":"23 Apr 2017","day":"Sun","high":"41","low":"28","text":"Mostly Cloudy"},{"code":"26","date":"24 Apr 2017","day":"Mon","high":"38","low":"34","text":"Cloudy"},{"code":"26","date":"25 Apr 2017","day":"Tue","high":"42","low":"36","text":"Cloudy"},{"code":"26","date":"26 Apr 2017","day":"Wed","high":"39","low":"36","text":"Cloudy"},{"code":"28","date":"27 Apr 2017","day":"Thu","high":"39","low":"33","text":"Mostly Cloudy"},{"code":"28","date":"28 Apr 2017","day":"Fri","high":"34","low":"21","text":"Mostly Cloudy"}],"description":"<![CDATA[<img src=\"http://l.yimg.com/a/i/us/we/52/31.gif\"/>\n<BR />\n<b>Current Conditions:<\/b>\n<BR />Clear\n<BR />\n<BR />\n<b>Forecast:<\/b>\n<BR /> Wed - Sunny. High: 38Low: 24\n<BR /> Thu - Sunny. High: 34Low: 25\n<BR /> Fri - Partly Cloudy. High: 37Low: 25\n<BR /> Sat - Mostly Cloudy. High: 38Low: 27\n<BR /> Sun - Mostly Cloudy. High: 41Low: 28\n<BR />\n<BR />\n<a href=\"http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-2460286/\">Full Forecast at Yahoo! Weather<\/a>\n<BR />\n<BR />\n(provided by <a href=\"http://www.weather.com\" >The Weather Channel<\/a>)\n<BR />\n]]>","guid":{"isPermaLink":"false"}}
                 */

                private UnitsBean units;
                private String title;
                private String link;
                private String description;
                private String language;
                private String lastBuildDate;
                private String ttl;
                private LocationBean location;
                private WindBean wind;
                private AtmosphereBean atmosphere;
                private AstronomyBean astronomy;
                private ImageBean image;
                private ItemBean item;

                public UnitsBean getUnits() {
                    return units;
                }

                public void setUnits(UnitsBean units) {
                    this.units = units;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getLink() {
                    return link;
                }

                public void setLink(String link) {
                    this.link = link;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public String getLanguage() {
                    return language;
                }

                public void setLanguage(String language) {
                    this.language = language;
                }

                public String getLastBuildDate() {
                    return lastBuildDate;
                }

                public void setLastBuildDate(String lastBuildDate) {
                    this.lastBuildDate = lastBuildDate;
                }

                public String getTtl() {
                    return ttl;
                }

                public void setTtl(String ttl) {
                    this.ttl = ttl;
                }

                public LocationBean getLocation() {
                    return location;
                }

                public void setLocation(LocationBean location) {
                    this.location = location;
                }

                public WindBean getWind() {
                    return wind;
                }

                public void setWind(WindBean wind) {
                    this.wind = wind;
                }

                public AtmosphereBean getAtmosphere() {
                    return atmosphere;
                }

                public void setAtmosphere(AtmosphereBean atmosphere) {
                    this.atmosphere = atmosphere;
                }

                public AstronomyBean getAstronomy() {
                    return astronomy;
                }

                public void setAstronomy(AstronomyBean astronomy) {
                    this.astronomy = astronomy;
                }

                public ImageBean getImage() {
                    return image;
                }

                public void setImage(ImageBean image) {
                    this.image = image;
                }

                public ItemBean getItem() {
                    return item;
                }

                public void setItem(ItemBean item) {
                    this.item = item;
                }

                public static class UnitsBean {
                }

                public static class LocationBean {
                }

                public static class WindBean {
                }

                public static class AtmosphereBean {
                }

                public static class AstronomyBean {
                }

                public static class ImageBean {
                }

                public static class ItemBean {
                    /**
                     * title : Conditions for Nome, AK, US at 06:00 AM AKDT
                     * lat : 64.499474
                     * long : -165.405792
                     * link : http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-2460286/
                     * pubDate : Wed, 19 Apr 2017 06:00 AM AKDT
                     * condition : {"code":"31","date":"Wed, 19 Apr 2017 06:00 AM AKDT","temp":"24","text":"Clear"}
                     * forecast : [{"code":"32","date":"19 Apr 2017","day":"Wed","high":"38","low":"24","text":"Sunny"},{"code":"32","date":"20 Apr 2017","day":"Thu","high":"34","low":"25","text":"Sunny"},{"code":"30","date":"21 Apr 2017","day":"Fri","high":"37","low":"25","text":"Partly Cloudy"},{"code":"28","date":"22 Apr 2017","day":"Sat","high":"38","low":"27","text":"Mostly Cloudy"},{"code":"28","date":"23 Apr 2017","day":"Sun","high":"41","low":"28","text":"Mostly Cloudy"},{"code":"26","date":"24 Apr 2017","day":"Mon","high":"38","low":"34","text":"Cloudy"},{"code":"26","date":"25 Apr 2017","day":"Tue","high":"42","low":"36","text":"Cloudy"},{"code":"26","date":"26 Apr 2017","day":"Wed","high":"39","low":"36","text":"Cloudy"},{"code":"28","date":"27 Apr 2017","day":"Thu","high":"39","low":"33","text":"Mostly Cloudy"},{"code":"28","date":"28 Apr 2017","day":"Fri","high":"34","low":"21","text":"Mostly Cloudy"}]
                     * description : <![CDATA[<img src="http://l.yimg.com/a/i/us/we/52/31.gif"/>
                     <BR />
                     <b>Current Conditions:</b>
                     <BR />Clear
                     <BR />
                     <BR />
                     <b>Forecast:</b>
                     <BR /> Wed - Sunny. High: 38Low: 24
                     <BR /> Thu - Sunny. High: 34Low: 25
                     <BR /> Fri - Partly Cloudy. High: 37Low: 25
                     <BR /> Sat - Mostly Cloudy. High: 38Low: 27
                     <BR /> Sun - Mostly Cloudy. High: 41Low: 28
                     <BR />
                     <BR />
                     <a href="http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-2460286/">Full Forecast at Yahoo! Weather</a>
                     <BR />
                     <BR />
                     (provided by <a href="http://www.weather.com" >The Weather Channel</a>)
                     <BR />
                     ]]>
                     * guid : {"isPermaLink":"false"}
                     */

                    private String title;
                    private String lat;
                    @SerializedName("long")
                    private String longX;
                    private String link;
                    private String pubDate;
                    private ConditionBean condition;
                    private String description;
                    private GuidBean guid;
                    private List<ForecastBean> forecast;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getLat() {
                        return lat;
                    }

                    public void setLat(String lat) {
                        this.lat = lat;
                    }

                    public String getLongX() {
                        return longX;
                    }

                    public void setLongX(String longX) {
                        this.longX = longX;
                    }

                    public String getLink() {
                        return link;
                    }

                    public void setLink(String link) {
                        this.link = link;
                    }

                    public String getPubDate() {
                        return pubDate;
                    }

                    public void setPubDate(String pubDate) {
                        this.pubDate = pubDate;
                    }

                    public ConditionBean getCondition() {
                        return condition;
                    }

                    public void setCondition(ConditionBean condition) {
                        this.condition = condition;
                    }

                    public String getDescription() {
                        return description;
                    }

                    public void setDescription(String description) {
                        this.description = description;
                    }

                    public GuidBean getGuid() {
                        return guid;
                    }

                    public void setGuid(GuidBean guid) {
                        this.guid = guid;
                    }

                    public List<ForecastBean> getForecast() {
                        return forecast;
                    }

                    public void setForecast(List<ForecastBean> forecast) {
                        this.forecast = forecast;
                    }

                    public static class ConditionBean {
                        /**
                         * code : 31
                         * date : Wed, 19 Apr 2017 06:00 AM AKDT
                         * temp : 24
                         * text : Clear
                         */

                        private String code;
                        private String date;
                        private String temp;
                        private String text;

                        public String getCode() {
                            return code;
                        }

                        public void setCode(String code) {
                            this.code = code;
                        }

                        public String getDate() {
                            return date;
                        }

                        public void setDate(String date) {
                            this.date = date;
                        }

                        public String getTemp() {
                            return temp;
                        }

                        public void setTemp(String temp) {
                            this.temp = temp;
                        }

                        public String getText() {
                            return text;
                        }

                        public void setText(String text) {
                            this.text = text;
                        }
                    }

                    public static class GuidBean {
                        /**
                         * isPermaLink : false
                         */

                        private String isPermaLink;

                        public String getIsPermaLink() {
                            return isPermaLink;
                        }

                        public void setIsPermaLink(String isPermaLink) {
                            this.isPermaLink = isPermaLink;
                        }
                    }

                    public static class ForecastBean {
                        /**
                         * code : 32
                         * date : 19 Apr 2017
                         * day : Wed
                         * high : 38
                         * low : 24
                         * text : Sunny
                         */

                        private String code;
                        private String date;
                        private String day;
                        private String high;
                        private String low;
                        private String text;

                        public String getCode() {
                            return code;
                        }

                        public void setCode(String code) {
                            this.code = code;
                        }

                        public String getDate() {
                            return date;
                        }

                        public void setDate(String date) {
                            this.date = date;
                        }

                        public String getDay() {
                            return day;
                        }

                        public void setDay(String day) {
                            this.day = day;
                        }

                        public String getHigh() {
                            return high;
                        }

                        public void setHigh(String high) {
                            this.high = high;
                        }

                        public String getLow() {
                            return low;
                        }

                        public void setLow(String low) {
                            this.low = low;
                        }

                        public String getText() {
                            return text;
                        }

                        public void setText(String text) {
                            this.text = text;
                        }
                    }
                }
            }
        }
    }
}
