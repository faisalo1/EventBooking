package eventbooking.controller;

import com.calendarfx.model.Calendar;
import com.calendarfx.model.CalendarEvent;
import com.calendarfx.model.CalendarSource;
import com.calendarfx.model.Entry;
import com.calendarfx.view.CalendarView;
import com.calendarfx.view.DateControl;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.util.Callback;

public class TimetableController implements Initializable {


    private CalendarView calendarView;

    @FXML
    private GridPane pnlHost;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
         loadCalendar();
    }

    private void loadCalendar() {
        calendarView = new CalendarView();
        calendarView.setRequestedTime(LocalTime.now());
        calendarView.setShowAddCalendarButton(false);
        calendarView.setShowSourceTray(false);
        calendarView.setShowSourceTrayButton(false);
        CalendarSource myCalendarSource = calendarView.getCalendarSources().get(0);
        Calendar eventCalendar = myCalendarSource.getCalendars().get(0);
        eventCalendar.setReadOnly(true);
        Entry entry = new Entry();
        entry.setFullDay(true);
        entry.setTitle("Kalyaanam");
        entry.setInterval(LocalDate.of(2019, Month.MAY, 5));
        eventCalendar.addEntry(entry);
        eventCalendar.addEventHandler(new EventHandler<CalendarEvent>() {
            @Override
            public void handle(CalendarEvent event) {
                if(event.isEntryRemoved()){
                    
                }
            }
        });
        calendarView.showMonthPage();
        pnlHost.getChildren().add(calendarView);
    }


}
