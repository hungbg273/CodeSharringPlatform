package platform;

import com.fasterxml.jackson.annotation.JsonFormat;


import java.time.LocalDateTime;

public class Code {
    private String code;
    @JsonFormat(pattern = "yyyy/MM/dd hh:mm:ss")
    private LocalDateTime date;

    Code(){
        this.code = "";
        this.date = LocalDateTime.now();
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
