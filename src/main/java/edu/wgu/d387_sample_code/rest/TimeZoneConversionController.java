package edu.wgu.d387_sample_code.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.wgu.d387_sample_code.TimeConversion;

@RestController
public class TimeZoneConversionController {

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/api/time-conversion")
    public TimeConversionResponse getTimeConversions() {
        String time = TimeConversion.convertTime();
        return new TimeConversionResponse(time);
    }

    private static class TimeConversionResponse {
        private final String time;

        public TimeConversionResponse(String convertedTimes) {
            this.time = convertedTimes;
        }

        public String getConvertedTimes() {
            return time;
        }
    }
}
